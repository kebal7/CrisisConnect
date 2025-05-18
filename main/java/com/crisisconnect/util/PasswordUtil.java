package com.crisisconnect.util;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
* @author Kebal Badal LMU ID: 23048668
*/

/**
 * PasswordUtil provides utility methods for handling password-related operations such as
 * hashing, salting, and verification. It is designed to enhance password security and integrity
 * in applications where user authentication is required.
 *
 */

public class PasswordUtil {
	private static final String ENCRYPT_ALGO = "AES/GCM/NoPadding";

    private static final int TAG_LENGTH_BIT = 128; // must be one of {128, 120, 112, 104, 96}
    private static final int IV_LENGTH_BYTE = 12;
    private static final int SALT_LENGTH_BYTE = 16;
    private static final Charset UTF_8 = StandardCharsets.UTF_8;
   
    /**
     * Generates a secure random byte array of the specified length.
     * Typically used to generate IVs or salts.
     *
     * @param numBytes The length of the random byte array.
     * @return A securely generated random byte array.
     */
    
    public static byte[] getRandomNonce(int numBytes) {
        byte[] nonce = new byte[numBytes];
        new SecureRandom().nextBytes(nonce);
        return nonce;
    }

    /**
     * Generates a random AES secret key of the specified size (e.g., 128, 192, 256 bits).
     *
     * @param keysize The desired key size in bits.
     * @return A randomly generated AES SecretKey.
     * @throws NoSuchAlgorithmException If AES algorithm is not available.
     */

    // AES secret key
    public static SecretKey getAESKey(int keysize) throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(keysize, SecureRandom.getInstanceStrong());
        return keyGen.generateKey();
    }

    /**
     * Derives an AES key from a password using PBKDF2 with HMAC SHA-256.
     *
     * @param password The password to derive the key from.
     * @param salt     The cryptographic salt.
     * @return The derived AES SecretKey, or null if an error occurs.
     */

    
    // Password derived AES 256 bits secret key
    public static SecretKey getAESKeyFromPassword(char[] password, byte[] salt){
           	try {
           		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
           		// iterationCount = 65536
           		// keyLength = 256
           		KeySpec spec = new PBEKeySpec(password, salt, 65536, 256);
           		SecretKey secret = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
           		return secret;
       		} catch (NoSuchAlgorithmException ex) {
       			Logger.getLogger(PasswordUtil.class.getName()).log(Level.SEVERE, null, ex);
           	} catch (InvalidKeySpecException ex) {
           		Logger.getLogger(PasswordUtil.class.getName()).log(Level.SEVERE, null, ex);
           	}
       		return null;
    }


    /**
     * Encrypts the given password using AES-GCM with a derived key based on the provided username.
     * The result is a Base64-encoded string that contains IV + salt + encrypted content.
     *
     * @param username The username used as the password key for deriving the AES key.
     * @param password The password to encrypt.
     * @return A Base64-encoded string of encrypted password including IV and salt, or null if an error occurs.
     */

    
    // return a base64 encoded AES encrypted text
    public static String encrypt(String username, String password){
    	try {
		    // 16 bytes salt
		    byte[] salt = getRandomNonce(SALT_LENGTH_BYTE);
		
		    // GCM recommended 12 bytes iv?
		    byte[] iv = getRandomNonce(IV_LENGTH_BYTE);
		
		    // secret key from password
		    SecretKey aesKeyFromPassword = getAESKeyFromPassword(username.toCharArray(), salt);
		
		    Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);
		
		    // ASE-GCM needs GCMParameterSpec
		    cipher.init(Cipher.ENCRYPT_MODE, aesKeyFromPassword, new GCMParameterSpec(TAG_LENGTH_BIT, iv));
		
		    byte[] cipherText = cipher.doFinal(password.getBytes());
		
		    // prefix IV and Salt to cipher text
		    byte[] cipherTextWithIvSalt = ByteBuffer.allocate(iv.length + salt.length + cipherText.length)
		            .put(iv)
		            .put(salt)
		            .put(cipherText)
		            .array();
		
		    // string representation, base64, send this string to other for decryption.
		    return Base64.getEncoder().encodeToString(cipherTextWithIvSalt);
    	}catch(Exception ex) {
    		return null;
    	}

    }

    
    /**
     * Decrypts the Base64-encoded encrypted password using AES-GCM and the provided username.
     * Extracts the IV and salt from the encoded data and derives the key for decryption.
     *
     * @param encryptedPassword The Base64-encoded string containing IV + salt + ciphertext.
     * @param username          The username used to derive the original encryption key.
     * @return The decrypted plain text password, or null if decryption fails.
     */

    public static String decrypt(String encryptedPassword, String username) {
		try {
			byte[] decode = Base64.getDecoder().decode(encryptedPassword.getBytes(UTF_8));
	
			// get back the iv and salt from the cipher text
			ByteBuffer bb = ByteBuffer.wrap(decode);
	
			byte[] iv = new byte[IV_LENGTH_BYTE];
			bb.get(iv);
	
			byte[] salt = new byte[SALT_LENGTH_BYTE];
			bb.get(salt);
	
			byte[] cipherText = new byte[bb.remaining()];
			bb.get(cipherText);
	
			// get back the aes key from the same password and salt
			SecretKey aesKeyFromPassword = PasswordUtil.getAESKeyFromPassword(username.toCharArray(), salt);
	
			Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);
	
			cipher.init(Cipher.DECRYPT_MODE, aesKeyFromPassword, new GCMParameterSpec(TAG_LENGTH_BIT, iv));
	
			byte[] plainText = cipher.doFinal(cipherText);
		
			return new String(plainText, UTF_8);
		}catch(Exception ex) {
			return null;
		}

	}
 
}