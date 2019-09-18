package com.revature.services;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.exception.UserNotFoundException;
import com.revature.mock.BankDbDAOMock;
import com.revature.service.UserService;

public class PasswordServiceTest {
	
private static UserService passwordService = null;
	
	@Before
	public void setUp() {
		passwordService = new UserService(new BankDbDAOMock());
	}
	
	@After
	public void tearDown() {
		passwordService = null;
	}
	
	
	
	@Test
	public void changePasswordUsingId() {
		passwordService.changeSelectedUser(1);
		assertTrue(passwordService
				.getSelectedUser()
				.getPassword()
				.equals("password"));
	}
	
	@Test (expected = UserNotFoundException.class)
	public void changePasswordWithInvalidId() {
		passwordService.changeSelectedUser(0);
	}

}
