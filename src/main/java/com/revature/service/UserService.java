package com.revature.service;

import com.revature.exception.UserNotFoundException;
import com.revature.model.UserInfo;
import com.revature.repository.BankDbDAO;

public class UserService {
	
	private BankDbDAO BankDbDao;
	private UserInfo selectedUser;

	public UserService(BankDbDAO BankDbDao) {
		this.BankDbDao = BankDbDao;
		this.selectedUser = new UserInfo(0, "Default", "pass", 0);
	}
	
	public UserInfo getSelectedUser() {
		return selectedUser;
	}
	
	public void setSelectedUser(UserInfo selectedUser) {
		this.selectedUser = selectedUser;
	}
	
	public void changeSelectedUser(int userInput) {
		UserInfo candidateUser = BankDbDao.getUserInfo(userInput);
		if (candidateUser == null) {
			throw new UserNotFoundException();
		} else {
			setSelectedUser(candidateUser);
		}
	}

}
