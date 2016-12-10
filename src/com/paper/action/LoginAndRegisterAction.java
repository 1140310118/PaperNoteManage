package com.paper.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.paper.model.*;
import com.paper.db.DAO;

public class LoginAndRegisterAction extends ActionSupport {
	// 表名
	String userTable = "user";
	String paperTable = "paper";
	private static final long serialVersionUID = 1L;
	private User user = new User();
	private DAO dao = new DAO();
	private String registeringFlag = "0";
	ActionContext actionContext = ActionContext.getContext();
	Map session = actionContext.getSession();
	private String relogin = "false";

	public String getRelogin() {
		return relogin;
	}

	public void setRelogin(String relogin) {
		this.relogin = relogin;
	}

	public String login() {
		String sql = this.user.ToSelectSql();
		System.out.println(sql);
		String USER_Nickname = "user_nickname";
		String USER_Email = "user_email";
		session.put("USER_Nickname", USER_Nickname);
		session.put("USER_Email", USER_Email);
		ResultSet rS = dao.executeQuery(sql);
		System.out.println(rS);

		if (relogin!="false"){
			return logout();
		}
		if (registeringFlag == "0") {
			System.out.println(rS);
			if (rS != null) {
				try {
					// if (rS.next()) {
					System.out.println("登陆成功");
					System.out.println(rS);
					while (rS.next()) {
						USER_Nickname = rS.getString(3);
						USER_Email = rS.getString(1);
						session.put("USER_Nickname", USER_Nickname);
						session.put("USER_Email", USER_Email);
					}
					if ((String) session.get("USER_Email")=="user_email"){
						return "loginerror";
					}
					return "loginsuccess";
				} catch (SQLException e) {
					e.printStackTrace();
					return "loginerror";
				}
			}
		}
		return "loginerror";

	}

	public String register() {
		// String sql = "insert into " + userTable + "(email,password,nickname)
		// values('" + getUser().getEmail() + "','" + getUser().getPassword()
		// + "','" + getUser().getNickname() + "')";

		System.out.println(user.email);
		if (user.email != null) {
			String sql = user.ToInsertSql();
			System.out.println(sql);
			int i = dao.executeUpdate(sql);
			if (i > -1) {
				return "registersuccess";
			}
		}
		return "registererror";
	}

	public String logout() {
		System.out.println("退出登录");
		
		session.remove("buser");
		session.remove("guser"); 
		session.remove("fuser");
		System.out.println("退出成功");
		return "logoutsuccess";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRegisteringFlag() {
		return registeringFlag;
	}

	public void setRegisteringFlag(String registeringFlag) {
		this.registeringFlag = registeringFlag;
	}

}