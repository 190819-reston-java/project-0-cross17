package com.revature.controller;

//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;

public class LoginScreen extends BalanceReturn {
	
	//move values to an arraylist
	private static String correctUsername = "thisisausername";
	private static String correctPassword = "pass";
	
//	private static Scanner sc = new Scanner(System.in);

	
	public static void firstScreen() {
//		l.info("App started successfully");
		System.out.println("");
		System.out.println("Welcome to this ATM!");
		System.out.println("");
		System.out.println("If you have an account with us press '1' to proceed to login screen. If not, please press '2' to create an account.");
		System.out.println("Press 'e' to exit ATM");
//		l.warn("Inputting a non-numeric character will result in an invalid input.");
		l.trace("trace"); l.info("test2"); l.warn("test3");
		String loginDecision = sc.next();
		
		System.out.println("");
		
		switch(loginDecision) {
		case "1":
			login();
			break;
		case "2":
			NewUser.newUser();
			break;
		case "e":
			System.exit(0);
			break;
		default:
			System.out.println("Invalid input. Please try again.");
			firstScreen();
		}
	}
	
	
	public static void login() {
		
		//List<String> usernameList = new ArrayList<String>();
		//probably an interface
//		List<String> usernameList = new ArrayList<String>();
		
		
		System.out.println("Please enter username in line below: ");
		String username = sc.next();
		System.out.println("");
		
		if(username.equals(correctUsername)) {
//			System.out.println(Hello, users name); add option to tell user hello by their preferred name
			System.out.println("Please enter password below: ");
			String password = sc.next();
			System.out.println("");
			
			//make password a separate method so it can be called in the event of a incorrect password
			
			if(password.equals(correctPassword)) {
				l.info("User Successfully signed on.");
				mainMenu();
			}else {
				System.out.println("Incorrect Username/Password Combination. Please try again.");
				login();
			}
		}else {
			System.out.println("Username not found. Please try again.");
			login();
		}
	}

}
