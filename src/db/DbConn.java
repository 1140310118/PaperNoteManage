package db;

import java.sql.*;

public class DbConn {
	public static Connection getConn() {

		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/paper", "root","123456");
		} catch (ClassNotFoundException e) {
			System.out.println("11111");
			// TODO Auto-generated catch block e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("22222");
			// TODO Auto-generated catch block e.printStackTrace();
		}
		return conn;
	}
}