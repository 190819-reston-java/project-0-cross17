package com.revature.exception;

public class InsufficientFundsException extends RuntimeException {
	
	public InsufficientFundsException() {
		this("Insufficient funds. This would leave the account with a negative balance. Exiting.");
	}

	public InsufficientFundsException(String message) {
		super(message);
	}



}
