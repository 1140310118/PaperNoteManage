package com.paper.action;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;
import com.paper.model.*;
import com.paper.db.*;

public class LoginAndRegisterAction extends ActionSupport{
    //表名   
    String userTable = "user";  
    String paperTable = "paper";
	private static final long serialVersionUID = 1L;
	private User user;
	private DAO dao = new DAO();
 
	public String login() {
		String sql = "select * from " + userTable +" where email='" + getUser().getEmail() + "' and password ='" + getUser().getPassword()
				+ "'";
		ResultSet rS = dao.executeQuery(sql);
		try {
			if (rS.next()) {
				return "loginsuccess";
			}
			return "loginerror";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "loginerror";
		}
	}

	public String register() {
		String sql = "insert into " + userTable + "(email,password,nickname) values('" + getUser().getEmail() + "','" + getUser().getPassword()
				+ "','" + getUser().getNickname() + "')";
		int i = dao.executeUpdate(sql);
		if (i > -1) {
			return "registersuccess";
		}
		return "registererror";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}