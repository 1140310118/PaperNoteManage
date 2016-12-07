package com.paper.action;

import java.sql.ResultSet;

import com.paper.db.DAO;

public class ReadSituationAction {
	// 表名
	String userTable = "user";
	String paperTable = "paper";
	private DAO dao = new DAO();

	public String changeReadSituation(String paperNickName, String paperReadSituation) {
		// UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
		// 0 未阅读；1 已粗读；2已精读。
		String sql = "UPDATE paper SET paperReadSituation = " + paperReadSituation + "WHERE paperNickName = "
				+ paperNickName;
		ResultSet rS = dao.executeQuery(sql);
		if(rS != null)
			return "changeReadSituationsuccess";
		return "changeReadSituationfail";
	}
}
