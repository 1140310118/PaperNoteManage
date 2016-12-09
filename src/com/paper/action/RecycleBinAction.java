package com.paper.action;

import java.sql.ResultSet;

import com.paper.db.DAO;

public class RecycleBinAction {
	// 表名
	String userTable = "user";
	String paperTable = "paper";
	private static DAO dao = new DAO();
	
//	public static void main(String[] args) throws SQLException {
//		String sql = "SELECT * FROM paper WHERE paperIsDeleted = 1";
//		System.out.println(sql);
//		ResultSet rS = dao.executeQuery(sql);
//		System.out.println(rS.next());
//	}
	
	public String showRecycleBin(){
		String sql = "SELECT * FROM paper WHERE paperIsDeleted = 1";
		System.out.println(sql);
		ResultSet rS = dao.executeQuery(sql);
		System.out.println(rS);
		if (rS != null)
			return "showRecycleBinsuccess";
		return "showRecycleBinfail";
	}

}
