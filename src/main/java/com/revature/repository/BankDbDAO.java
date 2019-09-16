package com.revature.repository;

import java.util.List;

import com.revature.model.UserInfo;

public interface BankDbDAO {
	
	UserInfo getUserInfo(int id);
	UserInfo getUserInfo(String username);
//	UserInfo getUserInfo(String password);
	UserInfo getBalance();
	List<UserInfo> getUsersInfo();
	boolean addUser(UserInfo u);
	boolean addPassword(UserInfo u);
	boolean Balance(UserInfo u);
//	boolean login(UserInfo u);

}
