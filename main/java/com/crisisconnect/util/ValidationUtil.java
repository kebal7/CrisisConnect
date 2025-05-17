package com.crisisconnect.util;


/**
* @author Kebal Badal LMU ID: 23048668
*/

/**
 * ValidationUtil provides utility methods for validating user input data such as
 * text fields, numbers, email addresses, passwords, and more. These
 * methods are typically used during user registration or form submissions to ensure
 * data integrity and consistency.
 *
 * It includes common validations like checking for alphabetic characters,
 * numeric-only strings, alphanumeric values, valid email formats, password
 * complexity, and phone number format (e.g., Nepali numbers).
 *
 * All methods are static and can be used directly without creating an instance of this class.
 */

public class ValidationUtil {

    /**
     * Validates if the provided text contains only letters and whitespace characters.
     * 
     * @param text The text to be validated.
     * @return True if the text contains only letters and whitespace, false otherwise.
     */
    public static boolean isTextOnly(String text) {
        return text.matches("[a-zA-Z\\s]+"); // Match letters and whitespace only
    }

    /**
     * Validates if the provided text contains only digits (0-9).
     * 
     * @param text The text to be validated.
     * @return True if the text contains only digits, false otherwise.
     */
    public static boolean isNumbersOnly(String text) {
        return text.matches("\\d+"); // Match digits only
    }

    /**
     * Validates if the provided text is alphanumeric, containing only letters and digits.
     * 
     * @param text The text to be validated.
     * @return True if the text is alphanumeric, false otherwise.
     */
    public static boolean isAlphanumeric(String text) {
        return text.matches("[a-zA-Z0-9]+"); // Match letters and digits only
    }

    /**
     * Validates if the provided text is a valid email address format.
     * 
     * @param email The email address to be validated.
     * @return True if the email address has a valid format, false otherwise.
     */
    public static boolean isEmail(String email) {
        return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,}$"); // Match standard email pattern
    }

    /**
     * Validates if the provided text contains no special characters other than letters, digits, and whitespace.
     * 
     * @param text The text to be validated.     
     * @return True if the text contains no special characters, false otherwise.
     */
    public static boolean hasNoSpecialCharacters(String text) {
        return text.matches("[a-zA-Z0-9\\s]+"); // Match only letters, digits, and whitespace
    }

    /**
     * Validates if the provided password meets complexity requirements:
     * - Contains at least one uppercase letter (A-Z)
     * - Contains at least one lowercase letter (a-z)
     * - Contains at least one digit (0-9)
     * - Contains at least one symbol (@$!%*?&).
     * 
     * @param password The password to be validated.
     * @return True if the password meets complexity requirements, false otherwise.
     */
    public static boolean isValidPassword(String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]*$"); // No length validation
    }

    /**
     * Validates if the provided text has the specified length.
     * 
     * @param text The text to be validated.
     * @param length The expected length of the text.
     * @return True if the text has the specified length, false otherwise.
     */
    public static boolean hasLength(String text, int length) {
        return text.length() == length;
    }
    
    /**
     * Validates if the provided phone number is valid according to Nepali mobile number format.
     * Nepali mobile numbers typically start with 97 or 98 and are 10 digits long.
     * 
     * @param phone The phone number to be validated.
     * @return True if the phone number is valid (starts with 97 or 98 and has 10 digits), false otherwise.
     */
    public static boolean isValidPhoneNumber(String phone) {
        return phone.matches("^(97|98)\\d{8}$");
    }
    
    /**
     * Checks if two password strings match exactly.
     *
     * @param password1 The first password.
     * @param password2 The second password (e.g., confirm password).
     * @return true if both passwords match, false otherwise.
     */
    public static boolean doPasswordsMatch(String password1, String password2) {
        return password1 != null && password1.equals(password2);
    }
    
    /**
     * Checks if the given string is null or empty.
     *
     * @param value The string to check.
     * @return true if the string is null or empty, false otherwise.
     */
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}