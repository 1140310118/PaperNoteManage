package com.paper.db;

import java.sql.*;

public class DbConn {
	public static Connection getConn() {

		Connection conn = null;
		try {
<<<<<<< HEAD
			Class.forName("com.mysql.jdbc.Driver");
=======
			Class.forName("com.mysql.jdbc.Driver");

>>>>>>> branch 'master' of https://github.com/zorenv/PaperNoteManage.git
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/papermanage", "root", "112122");
<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/zorenv/PaperNoteManage.git

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