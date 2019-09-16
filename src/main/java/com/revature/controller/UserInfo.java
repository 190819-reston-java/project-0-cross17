package com.revature.controller;

public abstract class UserInfo {
	
	String username;
	String password;
	double balance;

	
	
	
	public UserInfo(String username, String password, double balance) {
		super();
		this.username = username;
		this.password = password;
		this.balance = balance;
	}
//	
//	public UserInfo(String username, String password) {
//		this(username, password, 0);
//	}
//	
//	public UserInfo(String username) {
//		this(username, "Account creation incomplete. Please enter a password");
//	}






	public static void main(String[] args) {

		

	}

}
