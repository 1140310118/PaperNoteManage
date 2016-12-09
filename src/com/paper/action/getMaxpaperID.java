package com.paper.action;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.paper.db.DAO;

public class getMaxpaperID {
	private DAO dao = new DAO();

//	public static void main(String[] args) throws SQLException {
//		getMaxpaperID get = new getMaxpaperID();
//		System.out.println(get.getMaxpaperID());
//	}

	public String getMaxpaperID(String email) throws SQLException {
//		String sql = "SELECT MaxpaperID FROM User WHERE email = 'zorenv@163.com'";
		String sql = "SELECT MaxpaperID FROM User WHERE email = " + "'" + email + "'";
		String MaxpaperID = "";
		System.out.println(sql);
		ResultSet rS = dao.executeQuery(sql);
//		System.out.println(rS);
		while (rS.next()) {
			MaxpaperID = rS.getString(1);
		}
		System.out.println("旧的：" + MaxpaperID);
		int i = Integer.parseInt(MaxpaperID);
		i++;
		MaxpaperID = i+"";
		// UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
		String sql2 = "UPDATE User SET MaxpaperID = " + MaxpaperID + " WHERE email = " + "'" + email + "'";
		//String sql2 = "SELECT MaxpaperID FROM User WHERE email = 'zorenv@163.com'";		
		int rS2 = dao.executeUpdate(sql2);
		System.out.println(sql2);
		System.out.println("新的：" + MaxpaperID);

		if (rS2 > -1)
			return MaxpaperID;
		return "-1";
	}
}
