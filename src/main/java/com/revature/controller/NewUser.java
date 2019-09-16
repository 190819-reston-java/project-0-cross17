package com.revature.controller;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.model.UserInfo;
import com.revature.repository.BankDAO;
import com.revature.repository.BankDbDAO;



public class NewUser extends BalanceReturn{
	
	static String username;
	String password;
	double balance;
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
	
	
	public static String newUser() {
		
		System.out.println("Thank you for choosing to bank with us!");
		System.out.print("Please enter the username you would like associated with this account: ");
		String username = sc.next();
		
		System.out.println("");
		
		//remove after database working
//		System.out.println(username);
		
//		BankDbDAO DAO = new BankDAO();
//		
//		DAO.addUser(new UserInfo(0, username, "?", 0));
//		
//		newUserPassword();
//		
//		return null;
//	}
//	
//	public static String newUserPassword() {
		System.out.print("Please enter the password you would like associated with this account: ");
		String password = sc.next();
		
		System.out.println("");
		
		//remove after database working
//		System.out.println(password);
		
		//userInfo.add(password);
		
//		BankDbDAO DAO = new BankDAO();
//		
//		DAO.addPassword(new UserInfo(0, "", password, 0));
//		
//		newUserBalance();
//
//		return null;
//	}
//	
//	public static double newUserBalance() {
		System.out.print("Enter initial deposit amount (must be above $100): ");
		Double balance = sc.nextDouble();
		//balance = mFormat.format(balance);
		
		//remove after database working
		System.out.println("The balance for this new account will be " + mFormat.format(balance) + ".");
		
		//userInfo.add(mFormat.format(balance));
		
		System.out.println("");
		System.out.println("One moment please.");
		System.out.println("");
		
		BankDbDAO DAO = new BankDAO();
		
//		DAO.addUser(new UserInfo(0, username, password, balance));
		if (DAO.addUser(new UserInfo(0, username, password, balance))) {
		l.info("Account successfully created!");
		
		BalanceReturn.mainMenu();
		}
		return null;
	}


}
