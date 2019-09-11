//RENAME TO ATM APP

package com.revature.controller;

import java.text.NumberFormat;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class BalanceReturn {
	
	protected static Scanner sc = new Scanner(System.in);
	
	static NumberFormat mFormat = NumberFormat.getCurrencyInstance();
	
//	static double userBalance;
	
	public static Logger l = Logger.getLogger(BalanceReturn.class);
	
//	balance = 
	
	public static void main (String[] args) {
		LoginScreen.firstScreen();
//		mainMenu();
	}
	
	protected static void mainMenu() {
	//move balance amount to own class and start menu with deposit/withdraw/check balance options
	//update menu
	//add Login option
		
		System.out.println("");
		System.out.println("Welcome to the virtual ATM!");
		System.out.println("");
		System.out.println("Would you like to make a deposit or a withdrawl? Press '1' for withdrawl, '2' for deposit, or '3' to view balance; then please press 'Enter'.");
		System.out.println("Press 'c' to create a new account, or 'e' to logout & exit application.");
		
		String depositWithdrawl = sc.next();
		
		switch(depositWithdrawl.toLowerCase()) {
		case "1":
			//System.out.println("This is a withdrawl");
			Withdraw.withdrawl();
			break;
		case "2":
			//System.out.println("This is a deposit");
			Withdraw.deposit();
			break;
		case "3":
			//System.out.println("this is to check balance.");
			Withdraw.balance();
			break;
		case "e":
			System.out.println("Logging out & exiting application. Thank you, have a nice day!");
			l.info("User logged off.");
			System.exit(0);
			break;
		case "c":
			NewUser.newUser();
			break;
		default:
			System.out.println("Invalid input. Exiting ATM. Thank you for your patronage!");
		}
	}
	

}
