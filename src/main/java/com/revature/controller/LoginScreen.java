package com.revature.controller;

import com.revature.repository.BankDAO;
import com.revature.repository.BankDbDAO;
import com.revature.model.UserInfo;

//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;

public class LoginScreen extends BalanceReturn {
	
	public static void main (String [] args) {
		login();
	}

	
	public static void firstScreen() {
//		l.info("App started successfully");
		System.out.println("");
		System.out.println("Welcome to this ATM!");
		System.out.println("");
		System.out.println("If you have an account with us press '1' to proceed to login screen. If not, please press '2' to create an account.");
		System.out.println("Press 'e' to exit ATM");
//		l.warn("Inputting a non-numeric character will result in an invalid input.");

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
		BankDbDAO DAO = new BankDAO();
		
		//List<String> usernameList = new ArrayList<String>();
		//probably an interface
//		List<String> usernameList = new ArrayList<String>();
		
		
		System.out.println("Please enter username in line below: ");
		String username = sc.next();
		System.out.println("");
		
		//write a for loop to loop through database to find username. Then have it loop through to find password. If they are both associated with the same id number login*
		//write a sysout for incorrect username*
		//add switch statement to exit program 
		
		
		for(UserInfo u : DAO.getUsersInfo()) {
			
			if (u.getUsername().equals(username)) {
				System.out.println("");
				System.out.println("Please enter password below: ");
				String password = sc.next();
				System.out.println("");
				
				for (UserInfo i : DAO.getUsersInfo()) {
					if (i.getPassword().equals(password)) {
						mainMenu();
					}
					
				}
			} 
			
		}
		
	}

}
