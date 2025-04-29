package com.crisisconnect.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crisisconnect.config.DbConfig;
import com.crisisconnect.model.LoginModel;

public class LoginService {
	private Connection dbConn;

	public LoginService() {
		try {
			this.dbConn = DbConfig.getDbConnection();
		}catch(SQLException | ClassNotFoundException ex) {
			System.err.println("Database connection error:"+ ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	public int getUserLoginInfo(LoginModel loginModel) throws ClassNotFoundException {
		try {
			String query_login_user = "SELECT * FROM users WHERE username = ?";
			PreparedStatement stmt = dbConn.prepareStatement(query_login_user);

			stmt.setString(1, loginModel.getUsername());

			ResultSet result = stmt.executeQuery();

			if (result.next()) {
				String userDb = result.getString("username");
				String passwordDb = result.getString("password");

			
				if (userDb.equals(loginModel.getUsername()) && passwordDb.equals(loginModel.getPassword())) {
					// Login successful, return 1
					return 1;
				} else {
					// Username or password mismatch, return 0
					return 0;
				}
			} else {
				// Username not found in the database, return -1
				return -1;
			}

			// Catch SQLException and ClassNotFoundException if they occur
		} catch (SQLException ex) {
			// Print the stack trace for debugging purposes
			ex.printStackTrace();
			// Return -2 to indicate an internal error
			return -2;
		}
	}
	
	public String getUserRole(LoginModel loginModel) throws ClassNotFoundException{
		try {
			String user_role_query = "SELECT user_type FROM users WHERE username = ?";
			PreparedStatement stmt = dbConn.prepareStatement(user_role_query);
			
			stmt.setString(1, loginModel.getUsername());
			
			ResultSet result = stmt.executeQuery();
			
			if(result.next()) {
				return result.getString("user_type");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
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

}
