package method.general;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.db.DAO;

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
//		RecycleBinAction bin = new RecycleBinAction();
		// 1.显示回收站中论文测试通过
//		System.out.println("RecycleBinAction:" + bin.showRecycleBin("zorenv@163.com"));
		// 2.恢复paper测试通过
		
//		System.out.println("RecycleBinAction:" + bin.recoverPaper("zorenv@163.com","delete"));
		
		// 3.彻底删除paper测试通过
//		System.out.println("RecycleBinAction:" + bin.completelyRemovePaper("zorenv@163.com", "delete"));
		
		// 1.显示删除论文
//		System.out.println(bin.showRecycleBin());
//	}
	
	// 在回收站中显示论文
	public List<String> getRecycleBin(String userEmail) throws SQLException{
		String sql = "SELECT * FROM paper WHERE paperIsDeleted = 1 AND paperUserEmail = '" + userEmail + "'";
		String paper;
		System.out.println(sql);
		ResultSet rS = dao.executeQuery(sql);
		List<String> papers = new ArrayList<String>();
		while(rS.next()){
			paper = rS.getString("paperNickName");
			System.out.println(paper);
			papers.add(paper);
		}
		if (rS != null){
			System.out.println("FROM RecycleBin>> "+rS);
			System.out.println("FROM RecycleBin>> "+papers.toString());
			return papers;
		}
		return papers;
	}
	
	// 恢复论文
	public String recoverPaper(String userEmail, String paperNickName){
		// UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
		String sql = "UPDATE paper SET paperIsDeleted = 0 WHERE paperNickName = " + "'" + paperNickName + "' AND paperUserEmail = '" + userEmail + "'";
		System.out.println(sql);
		int i = dao.executeUpdate(sql);
		if(i > -1)
			return "recoverPapersuccess";
		return "recoverPaperfail";
	}

	// 彻底删除论文
	public String completelyRemovePaper(String userEmail, String paperNickName){
		// delete from 表名 where id=1;
		String sql = "DELETE FROM paper WHERE paperNickName = " + "'" + paperNickName + "' AND paperUserEmail = '" + userEmail + "'";
		System.out.println(sql);
		int i = dao.executeUpdate(sql);
		if(i > -1)
			return "completelyRemovePapersuccess";
		return "completelyRemovePaperfail";
	}
}
