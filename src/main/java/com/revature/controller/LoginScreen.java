package com.revature.controller;

import com.revature.repository.BankDAO;
import com.revature.repository.BankDbDAO;
import com.revature.model.UserInfo;

//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;

public class LoginScreen extends BalanceReturn {
	
//	public static void main (String [] args) {
//		login();
//	}

	
	public static void firstScreen() {
//		l.info("App started successfully");
		System.out.println("");
		System.out.println("Welcome to this ATM!");
		System.out.println("");
		System.out.println("Please press '1' to proceed to login screen. Press 'e' to exit ATM.");

		String loginDecision = sc.next();
		
		System.out.println("");
		
		switch(loginDecision) {
		case "1":
			login();
			break;
//		case "2":
//			NewUser.newUser();
//			break;
		case "e":
			System.exit(0);
			break;
		default:
			System.out.println("Invalid input. Please try again.");
			firstScreen();
		}
	}
	
	
	public static void login() {
		BankDbDAO DAO = new BankDAO();
		
		
		System.out.println("Please enter username in line below: ");
		String username = sc.next();
		System.out.println("");
//		thisUsername = username;
		
		
		for(UserInfo u : DAO.getUsersInfo()) {
			
			if (u.getUsername().equals(username)) {
				System.out.println("");
				u.setUsername(username);
				
				
				System.out.println("Please enter password below: ");
				String password = sc.next();
				System.out.println("");
				
				for (UserInfo i : DAO.getUsersInfo()) {
					System.out.println("");
					if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
//						System.out.println("Your current balance is " + mFormat.format(u.getBalance()));
						mainMenu();
						
//						System.out.println(s);
						
						
					}else {
						System.out.println("Unrecognized username/password combination. Returning to login screen.");
						login();
					}
					
				}
			}else {
				System.out.println("Unrecognized username. Returning to login screen.");
				login();
			}
			
		}
//		System.out.println(s);
	}


//	public static String retrieveUsername() {
//		thisUsername = username;
//		// TODO Auto-generated method stub
//		return thisUsername;
//	}
	
	

}
