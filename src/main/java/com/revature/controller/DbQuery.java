package com.revature.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.revature.model.UserInfo;
import com.revature.repository.BankDbDAO;
import com.revature.utils.ConnectionUtil;

public class DbQuery implements BankDbDAO {



	@Override
	public UserInfo getUserInfo(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo getUserInfo(String username) {
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
	public boolean Balance(UserInfo u) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		conn = ConnectionUtil.getConnection();
		
		String query = "SELECT * FROM bankdatabase;";
		
		try {
			stmt = conn.prepareStatement(query);
			stmt.setDouble(1, u.getBalance());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public UserInfo getBalance() {
		// TODO Auto-generated method stub
		return null;
	}

}
