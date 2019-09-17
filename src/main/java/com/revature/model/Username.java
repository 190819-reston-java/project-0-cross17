package com.revature.model;

import com.revature.repository.BankDAO;
import com.revature.repository.BankDbDAO;

public class Username {
	
	String username;

	public Username(String username) {
		super();
		this.username = username;
	}

	@Override
	public String toString() {
		return "Username [username=" + username + "]";
	}
	
	
	
	BankDbDAO DAO = new BankDAO();
	
}
