package com.crisisconnect.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.crisisconnect.config.DbConfig;
import com.crisisconnect.model.UserModel;

public class ProfileUpdateService {
	private Connection dbConn;
	
	public ProfileUpdateService() {
		try {
			this.dbConn = DbConfig.getDbConnection();
		}catch(SQLException | ClassNotFoundException ex) {
			System.err.println("Database connection error:"+ ex.getMessage());
			ex.printStackTrace();
		}
	}
	
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
	
	public int updateUser(UserModel user, String username) throws ClassNotFoundException {
		String query_update_user = "UPDATE users SET full_Name = ?, email = ?, password = ?, phone_number = ?, dob = ?, address = ? WHERE username = ?";
		try {
			PreparedStatement stmt = dbConn.prepareStatement(query_update_user);
			
		    stmt.setString(1, user.getFullName());
		    stmt.setString(2, user.getEmail());
		    stmt.setString(3, user.getPassword());
		    stmt.setString(4, user.getPhoneNumber());
		    stmt.setString(5, user.getDateOfBirth());
		    stmt.setString(6, user.getAddress());
		    
		    stmt.setString(7, username);
		    
			// Execute the update statement and store the number of affected rows
			int result = stmt.executeUpdate();

			// Check if the update was successful (i.e., at least one row affected)
			if (result > 0) {
				return 1; // Update successful
			} else {
				return 0; // Update failed (no rows affected)
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1; // Internal error
		}
	}
}
