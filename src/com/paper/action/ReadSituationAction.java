package com.paper.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.paper.db.DAO;

import com.paper.model.User;



public class ReadSituationAction {
	// 表名
	String userTable = "user";
	String paperTable = "paper";
	private DAO dao = new DAO();
	
	private addlog add = new addlog();
	


	public String changeReadSituation(String paperNickName, String paperReadSituation) throws SQLException {
		
		

		// UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
		// 0 未阅读；1 已粗读；2已精读。
		String sql = "UPDATE paper SET paperReadSituation = " + paperReadSituation + "WHERE paperNickName = "
				+ paperNickName;
		ResultSet rS = dao.executeQuery(sql);
		
		String sql2 = "select paperWebFilePath from paper where paperNickName = " + paperNickName;
		ResultSet rS2 = dao.executeQuery(sql2);
		String path = rS2.getString(1);
		path = path.substring(0, path.length()-4);
		add.addreadlog (path,paperReadSituation);
		if(rS != null)
			return "changeReadSituationsuccess";
		return "changeReadSituationfail";
	}
	
}
