package com.revature.repository;

import java.util.List;

import com.revature.model.UserInfo;

public interface BankDbDAO {
	
	UserInfo getUserInfo(int id);
	UserInfo getUserInfo(String username);
	boolean updateBalance(UserInfo u);
	UserInfo getBalance(String username);
	List<UserInfo> getUsersInfo();
	boolean addUser(UserInfo u);
	boolean addPassword(UserInfo u);

}
