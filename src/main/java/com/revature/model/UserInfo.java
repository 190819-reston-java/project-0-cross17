package com.revature.model;

import java.text.NumberFormat;

public class UserInfo {
	
	int id;
	String username;
	String password;
	double balance;
	
	static NumberFormat mFormat = NumberFormat.getCurrencyInstance();
	
	
	
	public UserInfo(int id, String username, String password, double balance) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.balance = balance;		
	}
	
	public UserInfo (int id, double balance) {
		super();
		this.id = id;
		this.balance = balance;
	}
	
	public UserInfo(double balance) {
		super();
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
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "Your balance is: " + mFormat.format(balance) + ".";
	}
	
	
	
	

	

	
	
	

}
