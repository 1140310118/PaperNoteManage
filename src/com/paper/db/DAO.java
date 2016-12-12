package com.paper.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO {
	Connection conn = null; // 连接对象
	Statement stmt = null; // 语句对象
	ResultSet rs = null; // 数据集对象
	/*
	 * 用于处理中文乱码 String URL
	 * ="jdbc:mysql://localhost:3306/papermanage?useUnicode=true&characterEncoding=UTF-8";
	 */
	String URL = "jdbc:mysql://localhost:3306/papermanage";
	String USER = "root"; // 数据库用户名
	String PASS = "112122"; // 数据库密码

	public DAO() {
		
//		String initSql = "create database papermanage if not exist;";
//		executeUpdate(initSql);
//		initSql = "use papermanage;";
//		executeUpdate(initSql);
//		initSql = "create table paper if not exist values();";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 2.获得数据库连接
			conn = DriverManager.getConnection(URL, USER, PASS);
			// 判断数据库是否连接成功
			if (conn != null) {
				System.out.println("MySql数据库连接成功");
			} else {
				System.out.println("MySql数据库连接失败");
			}
			// 3.创建语句对象
			stmt = conn.createStatement();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			conn = null;
		}
	}
	
	public ResultSet executeQuery(String sql) {
		try {
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			rs = null;
		}
		return rs;
	}

	public int executeUpdate(String sql) {
		try {
			stmt.executeUpdate(sql);
			return 0;
		} catch (Exception e) {
		}
		return -1;
	}

}
