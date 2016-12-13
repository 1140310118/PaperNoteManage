package com.paper.action;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.paper.db.DAO;

public class FindLocationAction {
	private DAO dao = new DAO();
	
//	public static void main(String[] args) throws SQLException {
//		FindLocationAction find = new FindLocationAction();
//		// 测试通过
//		System.out.println("FindLocationAction: "+find.findLocation("zorenv@163.com","Lab1"));
//	}
	
	public String findLocation(String userEmail, String paperNickName) throws SQLException{
		String paperWebFilePath = "";
		String sql = "SELECT paperWebFilePath FROM paper WHERE paperNickName = " + "'" + paperNickName + "' AND paperUserEmail = '" + userEmail + "'";
		System.out.println(sql); 
		ResultSet rS = dao.executeQuery(sql);
		System.out.println(rS);
		while (rS.next()) {
			paperWebFilePath = rS.getString(1);
		}
		System.out.println(paperWebFilePath);
		return paperWebFilePath;
	}
	
	public String findLocation2(String userEmail, String paperID) throws SQLException{
		String paperWebFilePath = "";
		String sql = "SELECT paperWebFilePath FROM paper WHERE paperID = " + "'" + paperID + "' AND paperUserEmail = '" + userEmail + "'";
		System.out.println(sql); 
		ResultSet rS = dao.executeQuery(sql);
		System.out.println(rS);
		while (rS.next()) {
			paperWebFilePath = rS.getString(1);
		}
		System.out.println(paperWebFilePath);
		return paperWebFilePath;
	}
	
	public String findNamebyID(String userEmail, String paperID) throws SQLException{
		String paperNickName = "";
		String sql = "SELECT paperNickName FROM paper WHERE paperID = " + "'" + paperID + "' AND paperUserEmail = '" + userEmail + "'";
		System.out.println(sql); 
		ResultSet rS = dao.executeQuery(sql);
		System.out.println(rS);
		while (rS.next()) {
			paperNickName = rS.getString(1);
		}
		System.out.println(paperNickName);
		return paperNickName;
	}
}
