package com.revature.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
private static Connection conn = null;
	
	public static Connection getConnection() {
		try {
			//We'll write some boilerplater to work with properties
			Properties props = new Properties();
			//the following lines just ensure we find connection.properties regardless of how our project is built:
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			props.load(loader.getResourceAsStream("connection.properties"));
			
			String url = props.getProperty("url");
			String username = props.getProperty("username");
			String password = props.getProperty("password");
			
			//how to actually make connections is jdbc
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("--Checked--");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
