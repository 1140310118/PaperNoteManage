package com.paper.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.mail.Session;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.paper.db.DAO;
import com.paper.model.Paper;
import com.paper.action.getMaxpaperID;

public class CatalogAction{
	// 表名
	String userTable = "user";
	String paperTable = "paper";
	private DAO dao = new DAO();
	private Paper paper = new Paper();
	ActionContext actionContext = ActionContext.getContext();
	// Map session = actionContext.getSession();

	// public static void main(String[] args) {
	// String sql = "UPDATE " + paperTable + " SET paperPID = 2 WHERE paperID =
	// 0";
	// System.out.println(sql);
	// ResultSet rS = dao.executeQuery(sql);
	// }
	public static void main(String[] args) throws SQLException {
		// 1.changeNode方法测试通过
		CatalogAction catalog = new CatalogAction();
		// System.out.println(catalog.changeNode("1","21"));

		// 3.createNode方法测试通过
		// System.out.println(catalog.createNode("1","机器学习"));

		// 4.showNode方法测试通过
		System.out.println(catalog.showNode());

	}

	// 拖拽节点
	public String changeNode(String id, String pid) {
		// 更改当前节点的PID，实现拖拽功能
		// UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
		String sql = "UPDATE " + paperTable + " SET paperPID = " + "'" + pid + "'" + " WHERE paperID = " + "'" + id
				+ "'";
		System.out.println(sql);
		int rS = dao.executeUpdate(sql);
		if (rS > -1)
			return "changeNodesuccess";
		return "changeNodefail";
	}

	// 删除节点
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

	// 新增节点
	public String createNode(String pid, String paperNickName) throws SQLException {
		// 1.当前节点生成一个id
		String paperID = "";
		// String email = "zorenv@163.com";
		String email = "";
		// email = (String) session.get("USER_Email");
		System.out.println(email);
		getMaxpaperID maxpaperID = new getMaxpaperID();
		paperID = maxpaperID.getMaxpaperID(email);
		System.out.println("新生成的paperID为：" + paperID);

		// 2.当前节点插入paper中
		// insert into t_user(id, username) values(10, "hehehe");
		String sql = "INSERT INTO paper(paperNickName, paperID, paperPID) VALUES(" + "'" + paperNickName + "'" + ", "
				+ "'" + paperID + "'" + ", " + "'" + pid + "'" + ")";
		System.out.println(sql);
		int rS = dao.executeUpdate(sql);
		if (rS > -1)
			return "createNodesuccess";
		return "createNodefail";

	}

	// 显示节点
	public String showNode() throws SQLException {
		// 生成zNodesList，用于前台显示分类文件目录
		String zNodesList = "";
		// 1.从mysql获得所有paper的paperNickName，paperID，paperPID
		String sql = "SELECT paperID, paperPID, paperNickName FROM paper";
		ResultSet rS = dao.executeQuery(sql);
		// System.out.println(rS);
		// rS.last();
		// int listLength = rS.getRow(); // 表格行数
		// System.out.println(listLength);
		
		// 2.用所有paper信息生成zNodesList
		while (rS.next()) {
			zNodesList += "{ id:" + rS.getString("paperID") + ", pId:" + rS.getString("paperPID") + ", name:"
					+ "\"" + rS.getString("paperNickName") + "\"" + "},";
		}

		return zNodesList;
	}
}
