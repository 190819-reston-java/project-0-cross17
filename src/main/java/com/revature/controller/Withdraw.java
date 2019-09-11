//CHANGE CLASS NAME TO depositWithdrawBalanceMenu & make applicable changes to BalanceReturn


package com.revature.controller;

import java.util.InputMismatchException;

import com.revature.exception.InsufficientFundsException;
import com.revature.exception.NegativeDepositAmount;

//import java.text.NumberFormat;
//import java.util.InputMismatchException;
//import java.util.Scanner;

public class Withdraw extends BalanceReturn {
	
	static double balance;
	double b;
	
	public static void main(String[] args) {
			deposit();
	}
	
	protected static double withdrawl() {
		
//		double balance = 0;
//		double b;
		
		try {
		System.out.print("Please enter a valid withdrawl amount: $");
		double withdrawlAmount = sc.nextDouble();
		System.out.println("");
		
		System.out.println("You entered: " + mFormat.format(withdrawlAmount) + " is this correct?");
		System.out.println("Press 'y' to verify or 'n' to deny.");
		
		String correctAmount = sc.next();
		switch (correctAmount.toLowerCase()) {
		case "y":
			if(withdrawlAmount > balance) {
//				System.out.println("Unfortunately this would leave a negative balance. This action is not possible. Returning to main menu.");
//				System.out.println("");
				
				throw new InsufficientFundsException();
			}else if(withdrawlAmount < 0) {
				System.out.println("Cannot input negative numbers. Returning to main menu");
				mainMenu();
				
			}else {
			double postWithdrawl = balance - withdrawlAmount; 
			
			System.out.println("Your new balance is: " + mFormat.format(postWithdrawl));
			balance = postWithdrawl;
			
			l.info("Users new balance after withdrawal is " + mFormat.format(balance));
			//remove or add if statement to exit or menu
			mainMenu();
			}
			break;
		case "n":
			withdrawl();
			break;
		}
			//add switch statement that if correct exits back to main menu *
			//add code that removes withdrawl from balance *
		
//		this is where the if statement was originally
		
		}catch (InputMismatchException e) {
			System.out.println("This input returns a: " + e + ". Please only input numbers. Logging out & exiting.");
//			System.exit(0);
			}
		
		return 0;
	}

	protected static double deposit() {
		
		try {
		System.out.print("How much would you like to deposit?: $");
		double depositAmount = sc.nextDouble();
		System.out.println("");
		
		
		
		System.out.println("You entered: " + mFormat.format(depositAmount) + " is this correct?");
		System.out.println("Press 'y' to verify or 'n' to deny.");
		
		String correctAmount = sc.next();
		switch (correctAmount.toLowerCase()) {
		case "y":
			if(depositAmount > balance) {
				double postDeposit = balance + depositAmount; 
				
				System.out.println("Thank you for the deposit! Your new balance is: " + mFormat.format(postDeposit) + ". Returning to main menu.");
				balance = postDeposit;
				l.info("Users new balance after deposit is " + mFormat.format(balance));
				mainMenu();
			}else if (depositAmount < 0) {
				throw new NegativeDepositAmount();
			}else {
				mainMenu();
			}
			break;
		case "n":
			deposit();
			break;
		}
		
		
//		if(depositAmount < 0) {
////			System.out.println("Inputting a negative number no longer makes this a deposit. Please try again.");
//			throw new NegativeDepositAmount();
//		}else {
//			System.out.println("Thank you for the deposit! Your new balance is: " + mFormat.format(postDeposit));
//			balance = postDeposit;
//			//remove after unit testing to see if the deposit amount remains after returning to main menu
//			mainMenu();
//		}
		}catch (InputMismatchException e) {
			System.out.println("This input returns a: " + e + ". Please only input numbers. Logging out & exiting.");
			
		}
		
		return 0;
		
	}

	protected static double balance() {
		
		System.out.println("Your balance is: " + mFormat.format(balance) + ".");
		System.out.println("");
		System.out.println("Would you like to exit or go back to the main menu? Press 'e' to exit or 'm' for menu.");
		
	String exitOrMenu = sc.next();
		
		switch(exitOrMenu.toLowerCase()) {
		case "e":
			System.out.println("Thank you for using this ATM! Click out of window to close.");
			//try to find way to close window upon exit
			System.exit(0);
			break;
		case "m":
			
			mainMenu();
			break;
		default :
			System.out.println("Invalid input. Returning to menu. Thank you for your patronage!");
			mainMenu();
		}
	
		return 0;
	}

}
