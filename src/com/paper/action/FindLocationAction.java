package com.paper.action;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.paper.db.DAO;

public class FindLocationAction {
	private DAO dao = new DAO();
	
//	public static void main(String[] args) throws SQLException {
//		FindLocationAction find = new FindLocationAction();
//		System.out.println(find.findLocation("Lab1"));
//	}
	
	public String findLocation(String paperNickName) throws SQLException{
		String paperWebFilePath = "";
		String sql = "SELECT paperWebFilePath FROM paper WHERE paperNickName = " + "'" + paperNickName + "'";
		System.out.println(sql); 
		ResultSet rS = dao.executeQuery(sql);
		System.out.println(rS);
		while (rS.next()) {
			paperWebFilePath = rS.getString(1);
		}
		System.out.println(paperWebFilePath);
		return paperWebFilePath;
	}
}
