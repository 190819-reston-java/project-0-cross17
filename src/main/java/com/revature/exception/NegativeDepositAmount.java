package com.revature.exception;

public class NegativeDepositAmount extends RuntimeException {
	
	public NegativeDepositAmount() {
		this("Inputting a negative number no longer makes this a deposit. Exiting.");
	}
	
	public NegativeDepositAmount(String message) {
		super(message);
	}

}
