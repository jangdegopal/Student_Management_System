package com.dollop.student.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/students";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final DbConnection INSTANCE = new DbConnection();
	
	private DbConnection() {
		if (INSTANCE != null)
			throw new RuntimeException("Use getConnection method");
	}
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
