package com.revature.mock;

import java.util.List;

import com.revature.model.UserInfo;
import com.revature.repository.BankDbDAO;

public class BankDbDAOMock implements BankDbDAO {

	@Override
	public UserInfo getUserInfo(int id) {
		if(id == 1) {
			return new UserInfo(0, "Default", "password", 0);
		}
		return null;
	}

	@Override
	public UserInfo getUserInfo(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateBalance(UserInfo u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserInfo getBalance(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfo> getUsersInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addUser(UserInfo u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPassword(UserInfo u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBalance(int i, String username, String password, double balance) {
		// TODO Auto-generated method stub
		return false;
	}

}
