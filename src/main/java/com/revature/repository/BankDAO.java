package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.controller.NewUser;
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return user;
			}catch(SQLException e) {
				e.printStackTrace();
			
			return user;
			}
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
		ResultSet resultSet = null;
		
		PreparedStatement statement = null;
		
		UserInfo user = null;
		
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			statement = conn.prepareStatement(
					"SELECT * FROM bankdatabase;");
			
			
			
			statement.setString(1, username);
			
			if(statement.execute()) {
				
				resultSet = statement.getResultSet();
				
				if(resultSet.next()) {
					user = new UserInfo(
							resultSet.getInt("id"),
							resultSet.getString("user_name"),
							resultSet.getString("password"),
							resultSet.getDouble("balance")
							);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Close.close(resultSet);
			Close.close(statement);
		}
		return user;
	}

	@Override
	public List<UserInfo> getUsersInfo() {

		Statement stmt = null;
		ResultSet resultSet = null;
		Connection conn = null;
		
		
		List<UserInfo> users = new ArrayList<UserInfo>();
		
		try {
			conn = ConnectionUtil.getConnection();
			
			stmt = conn.createStatement();
			
			resultSet = stmt.executeQuery("SELECT * FROM bankdatabase;");
			
			while (resultSet.next()) {
				
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
		
		final String query = "INSERT INTO bankdatabase VALUES (DEFAULT, ?, ?, ?);";
		
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
	public boolean updateBalance(UserInfo i) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		final String query = "UPDATE bankdatabase SET user_name = ?, password = ?, balance = ? WHERE id = ?;";
		
		try {
			conn = ConnectionUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, i.getUsername());
			stmt.setString(2, i.getPassword());
			stmt.setDouble(3,  i.getBalance());
			stmt.setInt(4, i.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			Close.close(stmt);
			Close.close(conn);
		}
		return true;
	}
		
	
	
	@Override
	public UserInfo getBalance(String username) {
		ResultSet resultSet = null;
		
		PreparedStatement stmt = null;
		
		UserInfo user = null;
		
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			stmt = conn.prepareStatement("SELECT * FROM bankdatabase WHERE user_name = ?;");
			
			stmt.setString(1, username);
			
			//try to execute SQL query
			if(stmt.execute()) {
				//get the ResultSet
				resultSet = stmt.getResultSet();
				//check for a single
				if(resultSet.next()) {
					return user = new UserInfo(
							resultSet.getInt("id"),
							resultSet.getString("username"),
							resultSet.getString("password"),
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

	@Override
	public boolean updateBalance(int i, String username, String password, double balance) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
