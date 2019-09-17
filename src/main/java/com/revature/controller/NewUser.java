package com.revature.controller;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.model.UserInfo;
import com.revature.model.Username;
import com.revature.repository.BankDAO;
import com.revature.repository.BankDbDAO;



public class NewUser extends BalanceReturn{
	
	static String username;
	String password;
//	double balance;
	static String dbName;
	static String dbPass;
	static double dbBalance;
	
	static Scanner sc = new Scanner(System.in);
	public static Logger l = Logger.getLogger(BalanceReturn.class);
	
//	static ArrayList<String> userInfo = new ArrayList<>();

	public static void main(String[] args) {
		newUser();
//		System.out.println(userInfo);
		//BalanceReturn.mainMenu();
		
//		BankDAO.addUser(new UserInfo(0, "testU", "testP"));

		
	}
	
	
	public static double newUser() {
		BankDbDAO DAO = new BankDAO();
		UserInfo u = new UserInfo();
		
		
		System.out.println("Thank you for choosing to bank with us!");
		System.out.print("Please enter the username you would like associated with this account: ");
		String username = sc.next();
		u.setUsername(username);
		System.out.println(u.getUsername());
		
		System.out.println("");
		
		System.out.print("Please enter the password you would like associated with this account: ");
		String password = sc.next();
		u.setPassword(password);
		
		
		System.out.println("");
		
		System.out.print("Enter initial deposit amount (must be above $100): ");
		Double balance = sc.nextDouble();

		System.out.println("The balance for this new account will be " + mFormat.format(balance) + ".");
		u.setBalance(balance);
		
		
		System.out.println("");
		System.out.println("One moment please.");
		System.out.println("");
		
		if (DAO.addUser(new UserInfo(0, username, password, balance))) {
		l.info("Account successfully created!");
		
		UserInfo wUser = new UserInfo();
		wUser.setUsername(username);
		wUser.setPassword(password);
		wUser.setBalance(balance);
		
		
		
		
		
		BalanceReturn.mainMenu();
		}
		return balance;
	}
	
	public void setNewUser(double balance) {
		
		double newUser;
		newUser = balance;
		System.out.println(balance);
		
	}


}
