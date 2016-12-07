package com.paper.action;

import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;
import com.paper.db.DAO;
import com.paper.model.Paper;

public class CatalogAction extends ActionSupport {
	// 表名
	String userTable = "user";
	String paperTable = "paper";
	private DAO dao = new DAO();
	private Paper paper = new Paper();
	
//	public static void main(String[] args) {
//		String sql = "UPDATE " + paperTable + " SET paperPID = 2 WHERE paperID = 0";
//		System.out.println(sql);
//		ResultSet rS = dao.executeQuery(sql);
//	}
	
	public String changePID(){
		//更改PID，实现拖拽功能
		//UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
		String sql = "UPDATE " + paperTable + " SET paperPID = " + this.paper.getPaperPID() + " WHERE paperID = " + this.paper.getPaperID();
		System.out.println(sql);
		ResultSet rS = dao.executeQuery(sql);
		if(rS != null)
			return "changePIDsuccess";
		return "changePIDfail";
	}
	
	public String deletePID(){
		
		String sql = "UPDATE " + paperTable + " SET paperPID = " + this.paper.getPaperPID() + " WHERE paperID = " + this.paper.getPaperID();
		System.out.println(sql);
		ResultSet rS = dao.executeQuery(sql);
		if(rS != null)
			return "deletePIDsuccess";
		return "deletePIDfail";
	}
}
