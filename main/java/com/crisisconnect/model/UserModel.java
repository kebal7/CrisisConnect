package com.crisisconnect.model;

/**
* @author Kebal Badal LMU ID: 23048668
*/

/**
 * The {@code UserModel} class represents the details of a user within the
 * Crisis Connect system. It stores credentials and personal information
 * necessary for user identification, authentication, and communication.
 * This model supports both regular users and admin users.
 */

public class UserModel {
	private String username;
	private String fullName;
	private String userType;
	private String password;
	private String email;
	private String phoneNumber;
	private String dateOfBirth;
	private String address;
	private String imagePath;
	
    /**
     * Constructs a UserModel object with all user details.
     *
     * @param username The unique username of the user.
     * @param fullName The full name of the user.
     * @param userType The role or type of the user (e.g., admin, user).
     * @param password The password for user authentication.
     * @param email The user's email address.
     * @param phoneNumber The user's phone number.
     * @param dateOfBirth The date of birth of the user.
     * @param address The residential address of the user.
     * @param imagePath The path to the user's profile image.
     */
	
	public UserModel(String username, String fullName, String userType, String password, String email,
			String phoneNumber, String dateOfBirth, String address, String imagePath) {
		super();
		this.username = username;
		this.fullName = fullName;
		this.userType = userType;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.imagePath = imagePath;
	}

    /**
     * Gets the username of the user.
     *
     * @return The username.
     */

	public String getUsername() {
		return username;
	}


    /**
     * Sets the username of the user.
     *
     * @param username The username to set.
     */
	
	public void setUsername(String username) {
		this.username = username;
	}


    /**
     * Gets the full name of the user.
     *
     * @return The full name.
     */

	public String getFullName() {
		return fullName;
	}

    /**
     * Sets the full name of the user.
     *
     * @param fullName The full name to set.
     */
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

    /**
     * Gets the user type (e.g., admin, user).
     *
     * @return The user type.
     */
	
	public String getUserType() {
		return userType;
	}

    /**
     * Sets the user type.
     *
     * @param userType The user type to set.
     */

	public void setUserType(String userType) {
		this.userType = userType;
	}


    /**
     * Gets the password of the user.
     *
     * @return The password.
     */
	
	public String getPassword() {
		return password;
	}

    /**
     * Sets the password of the user.
     *
     * @param password The password to set.
     */
	
	public void setPassword(String password) {
		this.password = password;
	}

    /**
     * Gets the email of the user.
     *
     * @return The email address.
     */
	
	public String getEmail() {
		return email;
	}

    /**
     * Sets the email of the user.
     *
     * @param email The email address to set.
     */
	
	public void setEmail(String email) {
		this.email = email;
	}

    /**
     * Gets the phone number of the user.
     *
     * @return The phone number.
     */
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

    /**
     * Sets the phone number of the user.
     *
     * @param phoneNumber The phone number to set.
     */
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


    /**
     * Gets the date of birth of the user.
     *
     * @return The date of birth.
     */
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}

    /**
     * Sets the date of birth of the user.
     *
     * @param dateOfBirth The date of birth to set.
     */
	
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

    /**
     * Gets the address of the user.
     *
     * @return The address.
     */
	
	public String getAddress() {
		return address;
	}

    /**
     * Sets the address of the user.
     *
     * @param address The address to set.
     */
	
	public void setAddress(String address) {
		this.address = address;
	}

    /**
     * Gets the image path of the user's profile picture.
     *
     * @return The image path.
     */
	
	public String getImagePath() {
		return imagePath;
	}

    /**
     * Sets the image path of the user's profile picture.
     *
     * @param imagePath The image path to set.
     */
	
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
	
}
