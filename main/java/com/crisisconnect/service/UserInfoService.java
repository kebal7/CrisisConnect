package com.crisisconnect.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crisisconnect.config.DbConfig;
import com.crisisconnect.model.UserModel;

public class UserInfoService {
	private Connection dbConn;
	
	private UserModel user;
	
	public UserInfoService() {
		try {
			this.dbConn = DbConfig.getDbConnection();
		}catch(SQLException | ClassNotFoundException ex) {
			System.err.println("Database connection error:"+ ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	public int getUserInfo(String username) throws ClassNotFoundException{
		String query_user_info = "SELECT * FROM users WHERE username = ?";
		try {
			PreparedStatement stmt = dbConn.prepareStatement(query_user_info);
			stmt.setString(1, username);
			
			ResultSet result = stmt.executeQuery();
			if(result.next()) {
				String userNameDb = result.getString("username");
				String fullNameDb = result.getString("full_name");
				String userTypeDb = result.getString("user_type");
				String password = result.getString("password");
				String emailDb = result.getString("email");
				String phoneNumberDb = result.getString("phone_number");
				String dobDb = result.getString("dob");
				String address = result.getString("address");
				String image_path = result.getString("image_path");
				
				this.user = new UserModel(userNameDb, fullNameDb, userTypeDb, password, emailDb, phoneNumberDb, dobDb, address, image_path);
				return 1; // return 1 if success
			}else {
				return 0; // return 0 if user name unmatched
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1; //return -1 if sql error
		}
	}
	
	public UserModel getSessionUserMode() {
		if(this.user != null) {
			return this.user;
		}else {
			return null;
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
}
