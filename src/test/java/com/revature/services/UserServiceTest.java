package com.revature.services;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.exception.UserNotFoundException;
import com.revature.mock.BankDbDAOMock;
import com.revature.service.UserService;

public class UserServiceTest {
	
	private static UserService userService = null;
	
	@Before
	public void setUp() {
		userService = new UserService(new BankDbDAOMock());
	}
	
	@After
	public void tearDown() {
		userService = null;
	}
	
	@Test
	public void changeUserFromDefaultUsingId() {
		userService.changeSelectedUser(1);
		assertTrue(userService
				.getSelectedUser()
				.getUsername()
				.equals("Id1Get"));
	}
	
	@Test(expected = UserNotFoundException.class)
	public void changeUserWithBlankId() {
		userService.changeSelectedUser(0);
	}
	
	

}
