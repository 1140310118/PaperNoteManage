package com.paper.action;

import java.sql.ResultSet;
import java.sql.SQLException;

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
		
		// 2.恢复paper测试通过
//		RecycleBinAction bin = new RecycleBinAction();
//		System.out.println(bin.recoverPaper("test"));
		
		// 3.彻底删除paper测试通过
//		System.out.println(bin.completelyRemovePaper("delete"));
		
		// 1.显示删除论文
//		System.out.println(bin.showRecycleBin());
//	}
	
	// 在回收站中显示论文
	public String showRecycleBin() throws SQLException{
		String sql = "SELECT * FROM paper WHERE paperIsDeleted = 1";
		String paper;
		System.out.println(sql);
		ResultSet rS = dao.executeQuery(sql);
		while(rS.next()){
			paper = rS.getString("paperNickName");
			System.out.println(paper);
		}
		if (rS != null)
			return "showRecycleBinsuccess";
		return "showRecycleBinfail";
	}
	
	// 恢复论文
	public String recoverPaper(String paperNickName){
		// UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
		String sql = "UPDATE paper SET paperIsDeleted = 0 WHERE paperNickName = " + "'" + paperNickName + "'";
		System.out.println(sql);
		int i = dao.executeUpdate(sql);
		if(i > -1)
			return "recoverPapersuccess";
		return "recoverPaperfail";
	}

	// 彻底删除论文
	public String completelyRemovePaper(String paperNickName){
		// delete from 表名 where id=1;
		String sql = "DELETE FROM paper WHERE paperNickName = " + "'" + paperNickName + "'";
		System.out.println(sql);
		int i = dao.executeUpdate(sql);
		if(i > -1)
			return "completelyRemovePapersuccess";
		return "completelyRemovePaperfail";
	}
}
