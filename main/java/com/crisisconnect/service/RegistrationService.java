package com.crisisconnect.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crisisconnect.config.DbConfig;
import com.crisisconnect.model.UserModel;

/**
* @author Kebal Badal LMU ID: 23048668
*/

/**
 * Service class responsible for user registration and validation processes.
 * Handles database connection and operations related to inserting a new user
 * and checking uniqueness of username, email, and phone number.
 */

public class RegistrationService {
	private Connection dbConn;
	
	/**
	 * Constructor to initialize the database connection.
	 */
	
	public RegistrationService() {
		try {
			this.dbConn = DbConfig.getDbConnection();
		}catch(SQLException | ClassNotFoundException ex) {
			System.err.println("Database connection error:"+ ex.getMessage());
			ex.printStackTrace();
		}
	}
	

	/**
	 * Returns the active database connection.
	 * If connection is null, attempts to establish a new one.
	 *
	 * @return Connection object
	 */
	
	public Connection getDbConn() {
		if(dbConn == null) {
			try {
				this.dbConn = DbConfig.getDbConnection();
			}catch(SQLException | ClassNotFoundException ex) {
				System.err.println("Database connection error:"+ ex.getMessage());
				ex.printStackTrace();
			}
		}
		return dbConn;
	}
	
	/**
	 * Registers a new user in the database using the provided user model.
	 *
	 * @param user The UserModel object containing registration data
	 * @return 1 if registration is successful, 0 if failed, -1 if internal error
	 * @throws ClassNotFoundException if database driver is not found
	 */


	public int registerUser(UserModel user) throws ClassNotFoundException {
		
		try {
			
			String query_register_user = "INSERT INTO users("
					+ "username, full_name, user_type, password, email, phone_number, dob, address, image_path) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement stmt = dbConn.prepareStatement(query_register_user);

			// Set the user information in the prepared statement
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getFullName());
			stmt.setString(3, user.getUserType());
			stmt.setString(4, user.getPassword());
			stmt.setString(5, user.getEmail());
			stmt.setString(6, user.getPhoneNumber());
			stmt.setString(7, user.getDateOfBirth());
			stmt.setString(8, user.getAddress());
			stmt.setString(9, user.getImagePath());


			// Execute the update statement and store the number of affected rows
			int result = stmt.executeUpdate();

			// Check if the update was successful (i.e., at least one row affected)
			if (result > 0) {
				return 1; // Registration successful
			} else {
				return 0; // Registration failed (no rows affected)
			}

		} catch (SQLException ex) {
			// Print the stack trace for debugging purposes
			ex.printStackTrace();
			return -1; // Internal error
		}
	}
	
	/**
	 * Checks whether a given username is unique (not already present in the database).
	 *
	 * @param formUserName The username to check
	 * @return 1 if unique, 0 if already exists, -1 if internal error
	 */
	
	public int isUniqueUsername(String formUserName) {
		String query_get_username = "SELECT username FROM users WHERE username = ?";
		
		try {
			PreparedStatement stmt = dbConn.prepareStatement(query_get_username);
			stmt.setString(1, formUserName);
			
			ResultSet result = stmt.executeQuery();
			
			if(result.next()) {
				return 0; //return 0 username is matched
			}else {
				return 1; //return 1 is username is unmatched in database ==>> unique
			}
			
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return -1; //return -1 if internal error
		}
	}
	
	/**
	 * Checks whether a given email is unique (not already present in the database).
	 *
	 * @param formEmail The email to check
	 * @return 1 if unique, 0 if already exists, -1 if internal error
	 */
	
	public int isUniqueEmail(String formEmail) {
		String query_get_username = "SELECT username FROM users WHERE email = ?";
		
		try {
			PreparedStatement stmt = dbConn.prepareStatement(query_get_username);
			stmt.setString(1, formEmail);
			
			ResultSet result = stmt.executeQuery();
			
			if(result.next()) {
				return 0; //return 0 email is matched
			}else {
				return 1; //return 1 is email is unmatched in database ==>> unique
			}
			
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return -1; //return -1 if internal error
		}
	}
	
	/**
	 * Checks whether a given phone number is unique (not already present in the database).
	 *
	 * @param formPhoneNo The phone number to check
	 * @return 1 if unique, 0 if already exists, -1 if internal error
	 */
	
	public int isUniquePhoneNo(String formPhoneNo) {
		String query_get_username = "SELECT username FROM users WHERE phone_number = ?";
		
		try {
			PreparedStatement stmt = dbConn.prepareStatement(query_get_username);
			stmt.setString(1, formPhoneNo);
			
			ResultSet result = stmt.executeQuery();
			
			if(result.next()) {
				return 0; //return 0 email is matched
			}else {
				return 1; //return 1 is email is unmatched in database ==>> unique
			}
			
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return -1; //return -1 if internal error
		}
	}
}
