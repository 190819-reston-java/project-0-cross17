package com.revature.controller;

//import java.util.ArrayList;
//import java.util.Scanner;

public class NewUser extends BalanceReturn {
	
	String username;
	String password;
	double balance;
	
	//static Scanner sc = new Scanner(System.in);
	
//	static ArrayList<String> userInfo = new ArrayList<>();

	public static void main(String[] args) {
		newUser();
//		System.out.println(userInfo);
		//BalanceReturn.mainMenu();

		
	}
	
	public static String newUser() {
		System.out.println("Thank you for choosing to bank with us!");
		System.out.print("Please enter the username you would like associated with this account: ");
		String username = sc.next();
		
		System.out.println("");
		
		//remove after database working
		System.out.println(username);
		
		//userInfo.add(username);
		
		newUserPassword();
		
		return null;
	}
	
	public static String newUserPassword() {
		System.out.print("Please enter the password you would like associated with this account: ");
		String password = sc.next();
		
		System.out.println("");
		
		//remove after database working
		System.out.println(password);
		
		//userInfo.add(password);
		
		newUserBalance();

		return null;
	}
	
	public static double newUserBalance() {
		System.out.print("Enter initial deposit amount (must be above $100): ");
		Double balance = sc.nextDouble();
		//balance = mFormat.format(balance);
		
		//remove after database working
		System.out.println("The balance for this new account is " + balance + ".");
		
		//userInfo.add(mFormat.format(balance));
		l.info("Account successfully created!");
		mainMenu();
		
		return 0;
	}

}
