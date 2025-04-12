package com.crisisconnect.model;

public class UserModel {
	private String username;
	private String email;
	private String usertype;
	private String password;
	
	public UserModel(String username, String email, String usertype, String password) {
		this.username = username;
		this.email = email;
		this.usertype = usertype;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
