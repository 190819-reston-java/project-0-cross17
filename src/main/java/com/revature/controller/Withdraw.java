//CHANGE CLASS NAME TO depositWithdrawBalanceMenu & make applicable changes to BalanceReturn


package com.revature.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;

import com.revature.exception.InsufficientFundsException;
import com.revature.exception.NegativeDepositAmount;
import com.revature.model.UserInfo;
import com.revature.repository.BankDAO;
import com.revature.repository.BankDbDAO;
//import com.revature.repository.BankDAO;
//import com.revature.repository.BankDbDAO;
import com.revature.utils.Close;
import com.revature.utils.ConnectionUtil;

//import java.text.NumberFormat;
//import java.util.InputMismatchException;
//import java.util.Scanner;

public class Withdraw extends BalanceReturn {
	
	static double balance;
//	double b;
	
	public static void main(String[] args) {

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
				
				try {
					Connection conn = null;
					PreparedStatement stmt = null;
					
					String query = "UPDATE bankdatabase (balance) SET balance = ;";
					
					conn = ConnectionUtil.getConnection();
					stmt = conn.prepareStatement(query);
//					stmt.set
					
				}catch (SQLException e) {
					e.printStackTrace();
				}
				
				
				
				
				
				
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
		BankDbDAO DAO = new BankDAO();
		
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
		BankDbDAO b = new BankDAO();

		ResultSet resultSet = null;
		PreparedStatement stmt = null;
		Connection conn = null;
		UserInfo user;
		
		String query = "SELECT * FROM bankdatabase;";;
		
		try {
		
		conn = ConnectionUtil.getConnection();
		stmt = conn.prepareStatement(query);
		stmt.getResultSet();
		
		if(stmt.execute()) {
			
			resultSet = stmt.getResultSet();
			
			if(resultSet.next()) {
				user = new UserInfo (
						resultSet.getInt("id"),
						resultSet.getString("user_name"),
						resultSet.getString("password"),
						resultSet.getDouble("balance")
						);
			}
			System.out.println(b.getBalance());
		}
		
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
		
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close.close(resultSet);
			Close.close(stmt);
		}
	
		return balance;
		
	}

}
