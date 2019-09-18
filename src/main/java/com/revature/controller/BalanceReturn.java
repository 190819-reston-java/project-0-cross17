//RENAME TO ATM APP

package com.revature.controller;

import java.text.NumberFormat;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.repository.BankDAO;
import com.revature.repository.BankDbDAO;
import com.revature.model.UserInfo;

public class BalanceReturn {
	
	protected static Scanner sc = new Scanner(System.in);
	
	protected static NumberFormat mFormat = NumberFormat.getCurrencyInstance();
	
//	static double userBalance;
	
	public static Logger l = Logger.getLogger(BalanceReturn.class);
	
//	balance = 
	
	public static void main (String[] args) {
		LoginScreen.firstScreen();
		
	}
//		static String username = LoginScreen.retrieveUsername();
	protected static void mainMenu() {
		BankDbDAO DAO = new BankDAO();
		String password;
		double balance;
		
	//move balance amount to own class and start menu with deposit/withdraw/check balance options
	//update menu
	//add Login option
		
		System.out.println("");
		System.out.println("Welcome to the virtual ATM!");
		System.out.println("");
		System.out.println("Would you like to make a deposit or a withdrawal? Press '1' for withdrawal, '2' for deposit, or '3' to view balance; then please press 'Enter'.");
		System.out.println("Press 'e' to logout & exit application.");
		
		String depositWithdrawal = sc.next();
		
		switch(depositWithdrawal.toLowerCase()) {
		case "1":
			
			Withdraw.withdrawal();
			break;
		case "2":
			
			Withdraw.deposit();
			break;
		case "3":
			
			Withdraw.balance();
			break;
		case "e":
			System.out.println("Logging out & exiting application. Thank you, have a nice day!");
			l.info("User logged off.");
			System.exit(0);
			break;
//		case "c":
//			NewUser.newUser();
//			break;
		default:
			System.out.println("Invalid input. Exiting ATM. Thank you for your patronage!");
		}
	}
	

}
