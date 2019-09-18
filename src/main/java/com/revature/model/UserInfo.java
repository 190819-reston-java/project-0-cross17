package com.revature.model;

import java.text.NumberFormat;

public class UserInfo {
	
	int id;
	String username;
	String password;
	static double balance;
	
	
	
	public UserInfo(int id, String username, String password, double balance) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.balance = balance;		
	}
	
	public UserInfo(String username, String password, double balance) {
		super();
		this.username = username;
		this.password = password;
		this.balance = balance;		
	}
	
	public UserInfo(String username, String password) {
		super();
		this.username = username;
		this.password = password;	
	}
	
	public UserInfo(String username, double balance) {
		super();
		this.username = username;
		this.balance = balance;		
	}
	
	public UserInfo() {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.balance = balance;		
	}
	
	public UserInfo(double balance) {
		super();
		this.username = username;
		this.balance = balance;		
	}
	
	public UserInfo(int balance) {
		super();
		this.username = username;
		this.balance = balance;		
	}
	
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}




	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", username=" + username + ", password=" + password + ", balance=" + balance
				+ "]";
	}
	
	
	
//	@Override
//	public String toString() {
//		return "Your balance is: " + mFormat.format(balance) + ".";
//	}
	
	
	
	
	
	

	

	
	
	

}
