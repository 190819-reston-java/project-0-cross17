package com.revature;

import com.revature.controller.LoginScreen;

/** 
 * Create an instance of your controller and launch your application.
 * 
 * Try not to have any logic at all on this class.
 */
public class Main {

	public static void main(String[] args) {
		LoginScreen.login();
		
		//make login by if statements to match the username then the password. If both are correct go to main menu. *
		//log & create the exception about the Inputmismatch when inputting a letter in deposit or withdraw & if they input number that would the account to negative
		//figure out what to test
		//add the db
		
		
		/*
		 * Monday: Finish the exceptions & logging
		 *    exceptions: withdrawal greater than balance* or negative amount & deposit negative amount*
		 *    logging: new account creation*, successful log on*, deposits*, withdrawals*, sign offs*
		 * Tuesday: add tests, Implement the database 
		 *    tests: Connecting to db & if funds added to/removed from account
		 * Wednesday: add additional classes and do QOL work
		 * Thursday: total run-through, making small changes
		 * Friday:Enjoy weekend!
		 */

	}
}
