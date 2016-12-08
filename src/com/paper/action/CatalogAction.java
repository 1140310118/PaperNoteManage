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

	// public static void main(String[] args) {
	// String sql = "UPDATE " + paperTable + " SET paperPID = 2 WHERE paperID =
	// 0";
	// System.out.println(sql);
	// ResultSet rS = dao.executeQuery(sql);
	// }

	public String changeNode(String id, String pid) {
		// 更改当前节点的PID，实现拖拽功能
		// UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
		String sql = "UPDATE " + paperTable + " SET paperPID = " + pid + " WHERE paperID = " + id;
		System.out.println(sql);
		int rS = dao.executeUpdate(sql);
		if (rS != 0)
			return "changeNodesuccess";
		return "changeNodefail";
	}

	public String deleteNode(String id) {
		// 递归执行：
		// 1.删除当前节点
		// 2.删除以当前节点为父节点的节点
		// 直到当前节点没有儿子节点
		String sql = "UPDATE " + paperTable + " SET paperPID = " + this.paper.getPaperPID() + " WHERE paperID = "
				+ this.paper.getPaperID();
		System.out.println(sql);
		int rS = dao.executeUpdate(sql);
		if (rS != 0)
			return "deleteNodesuccess";
		return "deleteNodefail";
	}

	public String createNode(String pid, String paperNickName) {
		// insert into t_user(id, username) values(10, "hehehe");
		String sql = "INSERT INTO paper(paperNickName, paperPID) VALUES (" + paperNickName + ", " + pid + ")";
		ResultSet rS = dao.executeQuery(sql);
		if(rS != null)
			return "createNodesuccess";
		return "createNodefail";
		
	}
	
	public String showNode(){
		String zNodesList = "";
		
		return zNodesList;
	}
}
