package com.paper.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.paper.db.DAO;

public class ReadSituationAction {
	// 表名
	String userTable = "user";
	String paperTable = "paper";
	private DAO dao = new DAO();

	// private addlog add = new addlog();

	public static void main(String[] args) throws SQLException {
		ReadSituationAction read = new ReadSituationAction();
		// System.out.println("ReadSituationAction: " +
		// read.changeReadSituation("zorenv@163.com", "Lab1", "99"));
		// updateLastPaper测试通过
		// read.updateLastPaper("zorenv@163.com", "L");
		//
		System.out.println(read.getLastPaper("zorenv@163.com"));
	}

	public String changeReadSituation(String userEmail, String paperNickName, String paperReadSituation)
			throws SQLException {

		// UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
		// 0 未阅读；1 已粗读；2已精读。
		addlog add = new addlog();
		String sql = "UPDATE paper SET paperReadSituation = " + paperReadSituation + " WHERE paperNickName = '"
				+ paperNickName + "' AND paperUserEmail = '" + userEmail + "'";
		System.out.println(sql);
		int rS = dao.executeUpdate(sql);
		String sql2 = "select paperWebFilePath from paper where paperNickName = '" + paperNickName + "'";
		ResultSet rS2 = dao.executeQuery(sql2);
		while (rS2.next()) {
			String path = rS2.getString(1);
			path = path.substring(0, path.length() - 4);
			add.addreadlog(path, paperReadSituation);
		}

		if (rS != -1) {
			System.out.println("FROM ReadSituation: 修改论文阅读情况成功！");

			return "changeReadSituationsuccess";
		}
		System.out.println("FROM ReadSituation: 修改论文阅读情况失败！");
		return "changeReadSituationfail";
	}

	public void updateLastPaper(String userEmail, String paperNickName) {
		String sql = "UPDATE user SET lastReadPaper = '" + paperNickName + "' WHERE email = '" + userEmail + "'";
		System.out.println("ReadSituationAction: " + sql);
		int rS = dao.executeUpdate(sql);
	}

	public String getLastPaper(String userEmail) throws SQLException {
		String sql = "SELECT lastReadPaper FROM user WHERE email = '" + userEmail + "'";
		System.out.println("ReadSituationAction: " + sql);
		ResultSet rS = dao.executeQuery(sql);
		String lastReadPaper = null;
		// if (rS != null) {
		while (rS.next()) {
			lastReadPaper = rS.getString(1);
			System.out.println("ReadSituationAction: lastReadPaper: " + lastReadPaper);
		}
		// } else {
		if (lastReadPaper == null || lastReadPaper.equals("")) {
			sql = "SELECT * FROM paper WHERE paperUserEmail = '" + userEmail + "'";
			System.out.println(sql);
			ResultSet rS2 = dao.executeQuery(sql);
			rS2.next();
			lastReadPaper = rS2.getString("paperNickName");
		}
		// }
		return lastReadPaper;
	}
}
