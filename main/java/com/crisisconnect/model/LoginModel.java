package com.crisisconnect.model;

/**
* @author Kebal Badal LMU ID: 23048668
*/

/**
 * The LoginModel class represents the credentials required for user login in the system.
 * It stores the username and password of a user.
 * This model can be used to validate user credentials and manage login sessions.
 * 
 */
public class LoginModel {
	private String username;
	private String password;
	
    /**
     * Constructor to initialize LoginModel with username and password.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     */
	
	public LoginModel(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
    /**
     * Gets the username.
     *
     * @return The username of the user.
     */
	public String getUsername() {
		return username;
	}
	
    /**
     * Sets the username.
     *
     * @param username The username to set.
     */

	public void setUsername(String username) {
		this.username = username;
	}
	
    /**
     * Gets the password.
     *
     * @return The password of the user.
     */
	
	public String getPassword() {
		return password;
	}
	
    /**
     * Sets the password.
     *
     * @param password The password to set.
     */

	public void setPassword(String password) {
		this.password = password;
	}
}
