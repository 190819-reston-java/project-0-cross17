package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.controller.NewUser;
//import com.revature.model.Player;
import com.revature.model.UserInfo;
import com.revature.utils.Close;
import com.revature.utils.ConnectionUtil;

public class BankDAO implements BankDbDAO {

	@Override
	public UserInfo getUserInfo(int id) {
		UserInfo user = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			final String query = "SELECT * FROM bankdatabase;";
			
			try (PreparedStatement stmt = conn.prepareStatement(query)){
				stmt.setInt(1, id);
				if(stmt.execute()) {
					try (ResultSet rs = stmt.getResultSet()) {
						if(rs.next()) {
							user = createUserFromRS(rs);
						}
					}
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	private UserInfo createUserFromRS(ResultSet rs) throws SQLException {
		return new UserInfo(
				rs.getInt("id"),
				rs.getString("username"),
				rs.getString("password"),
				rs.getInt("balance")
				);
	}

	@Override
	public UserInfo getUserInfo(String username) {
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		UserInfo user = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			stmt = conn.prepareStatement("SELECT * FROM p0db;");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<UserInfo> getUsersInfo() {

		Statement stmt = null;
		ResultSet resultSet = null;
		Connection conn = null;
		
		//list to return
		List<UserInfo> users = new ArrayList<UserInfo>();
		
		try {
			conn = ConnectionUtil.getConnection();
			
			
//			String query = "SELECT * FROM bankdatabase;";
			
			stmt = conn.createStatement();
			
			resultSet = stmt.executeQuery("SELECT * FROM bankdatabase;");
//			resultSet = stmt.executeQuery();
			
			while (resultSet.next()) {
				//At each row in the ResultSet, do the following:
				users.add(new UserInfo(
						resultSet.getInt("id"),
						resultSet.getString("user_name"),
						resultSet.getString("password"),
						resultSet.getDouble("balance")
						));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Close.close(resultSet);
			Close.close(stmt);
			Close.close(conn);
		}
		return users;
	}

	@Override
	
	
	public boolean addUser(UserInfo u) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		final String query = "INSERT INTO bankdatabase (id, user_name, password, balance) VALUES (DEFAULT, ?, ?, ?);";
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, u.getUsername());
			stmt.setString(2, u.getPassword());
			stmt.setDouble(3, u.getBalance());
			stmt.execute();
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
//			Close.close(stmt);
			Close.close(conn);
		}
		
		return true;
	}
	
	
	@Override
	public boolean addPassword(UserInfo u) {

		Connection conn = null;
		PreparedStatement stmt = null;
		
//		final String query = "UPDATE bankdatabase SET password = ?, balance = ? WHERE password = password;";
		final String query = "INSERT INTO bankdatabase (id, user_name, password, balance) VALUES (DEFAULT, ?, ?, ?);";
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, u.getUsername());
			stmt.setString(2, u.getPassword());
			stmt.setDouble(3, u.getBalance());
			stmt.execute();
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			Close.close(stmt);
			Close.close(conn);
		}
		
		return true;
		
	}

	
	@Override
	public boolean Balance(UserInfo u) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String query = "UPDATE bankdatabase (balance) SET balance = ?;";
		
		try {
			
		conn = ConnectionUtil.getConnection();
		stmt = conn.prepareStatement(query);
		stmt.setDouble(1, u.getBalance());
		stmt.execute();
		
		
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	@Override
	public UserInfo getBalance() {
		ResultSet resultSet = null;
		
		PreparedStatement stmt = null;
		
		UserInfo user = null;
		
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			stmt = conn.prepareStatement("SELECT balance FROM bankdatabase;");
			
			//try to execute SQL query
			if(stmt.execute()) {
				//get the ResultSet
				resultSet = stmt.getResultSet();
				//check for a single
				if(resultSet.next()) {
					user = new UserInfo(
							resultSet.getDouble("balance")
							);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Close.close(resultSet);
			Close.close(stmt);
		}
		return user;
	}
	
	
}
