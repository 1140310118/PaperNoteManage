package com.paper.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.paper.db.DAO;

public class ReadSituationAction {
	// 表名
	String userTable = "user";
	String paperTable = "paper";
	private DAO dao = new DAO();
	
	private addlog add = new addlog();

	public String changeReadSituation(String paperNickName, String paperReadSituation) throws SQLException {

		// UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
		// 0 未阅读；1 已粗读；2已精读。
		String sql = "UPDATE paper SET paperReadSituation = " + paperReadSituation + " WHERE paperNickName = '"
				+ paperNickName+"'";
		int rS = dao.executeUpdate(sql);
		String sql2 = "select paperWebFilePath from paper where paperNickName = " + paperNickName;
		ResultSet rS2 = dao.executeQuery(sql2);
		while (rS2.next()) {
		String path = rS2.getString(1);
		path = path.substring(0, path.length()-4);
		add.addreadlog (path,paperReadSituation);

		}

		if(rS != -1){
			System.out.println("FROM ReadSituation: 修改论文阅读情况成功！");

			return "changeReadSituationsuccess";
		}
		System.out.println("FROM ReadSituation: 修改论文阅读情况失败！");
		return "changeReadSituationfail";
	}
	
}
