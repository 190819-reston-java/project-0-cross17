package com.revature.controller;

import java.util.InputMismatchException;

import com.revature.exception.InsufficientFundsException;
import com.revature.exception.NegativeDepositAmount;
import com.revature.model.UserInfo;
import com.revature.repository.BankDAO;
import com.revature.repository.BankDbDAO;

public class Withdraw extends BalanceReturn {
	
	static int id;
	static double balance;
	static String username;
	static String password;
	
	
	

	
	protected static double withdrawal() {
		UserInfo u = new UserInfo();
		BankDbDAO b = new BankDAO(); 
		double s;	
		
		s = u.getBalance();
		
		try {
		System.out.print("Please enter a valid withdrawal amount: $");
		double withdrawalAmount = sc.nextDouble();
		System.out.println("");
		
		System.out.println("You entered: " + mFormat.format(withdrawalAmount) + " is this correct?");
		System.out.println("Press 'y' to verify or 'n' to deny.");
		String correctAmount = sc.next();
		System.out.println("");
		
		switch (correctAmount.toLowerCase()) {
		case "y":
			if(withdrawalAmount > s) {
				System.out.println("Unfortunately this would leave a negative balance. This action is not possible.");
				System.out.println("");
				
				l.error("User Cause a 'InsufficientFundsException'.");
				throw new InsufficientFundsException();
			}else if(withdrawalAmount < 0) {
				System.out.println("Cannot input negative numbers. Returning to main menu");
				mainMenu();
				
			}else {
				double postWithdrawal = s - withdrawalAmount;
				balance = postWithdrawal;
				
				System.out.println("Your new balance is " + mFormat.format(balance));
				u.setBalance(balance);
				
				for(UserInfo i : b.getUsersInfo()) {
					i.setBalance(balance);
					b.updateBalance(i);
				}

			mainMenu();
			}
			break;
		case "n":
			withdrawal();
			break;
		}
		
		}catch (InputMismatchException e) {
			System.out.println("This input returns a: " + e + ". Please only input numbers. Logging out & exiting.");
			System.exit(0);
			}
		
		return 0;
	}

	protected static double deposit() {
		double s;
		UserInfo u = new UserInfo();
		BankDbDAO b = new BankDAO(); 
		
		s = u.getBalance();
		
		try {
		System.out.print("How much would you like to deposit?: $");
		double depositAmount = sc.nextDouble();
		System.out.println("");
		
		System.out.println("You entered: " + mFormat.format(depositAmount) + " is this correct?");
		System.out.println("Press 'y' to verify or 'n' to deny.");
		String correctAmount = sc.next();
		System.out.println("");
		
		
		switch (correctAmount.toLowerCase()) {
		case "y":
			if(depositAmount > 0) {
				double postDeposit = s + depositAmount; 
				
				System.out.println("Thank you for the deposit! Your new balance is: " + mFormat.format(postDeposit) + ". Returning to main menu.");
				balance = postDeposit;
				System.out.println("");
				
				l.info("Users new balance after deposit is " + mFormat.format(balance));
				u.setBalance(balance);
				
				for(UserInfo i : b.getUsersInfo()) {
					i.setBalance(balance);
					b.updateBalance(i);
				}
				
				mainMenu();
				
			}else if (depositAmount < 0) {
				l.error("User Caused a 'NegativeDepositAmount' exception");
				throw new NegativeDepositAmount();
			}else {
				System.out.println("Invalid input. Returning to main menu");
				mainMenu();
			}
			break;
		case "n":
			deposit();
			break;
		}
		
		}catch (InputMismatchException e) {
			System.out.println("This input returns a: " + e + ". Please only input numbers. Logging out & exiting.");
			
		}
		
		return 0;
		
	}

	protected static void balance() {

		UserInfo u = new UserInfo();
		double s;
	
		s = u.getBalance();
			
		
		System.out.println("Your balance is " + mFormat.format(s) + ".");
		
		System.out.println("Would you like to exit or go back to the main menu? Press 'e' to exit or 'm' for menu.");
		System.out.println("");
		
		String exitOrMenu = sc.next();
		
		switch(exitOrMenu.toLowerCase()) {
		case "e":
			System.out.println("Thank you for using this ATM! Click out of window to close.");
			
			System.exit(0);
			break;
		case "m":
			
			mainMenu();
			break;
		default :
			System.out.println("Invalid input. Returning to menu. Thank you for your patronage!");
			mainMenu();
		}

		
	}

}
