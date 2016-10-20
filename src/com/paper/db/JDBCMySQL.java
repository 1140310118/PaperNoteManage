package com.paper.db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;

public class JDBCMySQL {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1.加载驱动
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
			String sql = "select * from sample"; // sample是数据表名
			rs = stmt.executeQuery(sql);
			// 遍历获取数据表中的数据
//			while (rs.next()) {
//				System.out.println(rs.getInt("id") + "," + rs.getString("USER") + "," + rs.getString("PASS"));
//			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭资源
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
