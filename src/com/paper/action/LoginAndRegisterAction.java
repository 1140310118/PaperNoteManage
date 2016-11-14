package com.paper.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.paper.model.*;
import com.paper.db.DAO;

public class LoginAndRegisterAction extends ActionSupport{
    //表名   
    String userTable = "user";  
    String paperTable = "paper";
	private static final long serialVersionUID = 1L;
	private User user = new User();
	private DAO dao = new DAO();
	private String registeringFlag = "0";
	//private static DAO dao = new DAO();//验证方法正确性

	/*
	 * 验证登陆方法正确性
	public static void main(String[] args){
		//String sql = "select * from " + userTable +" where email='" + getUser().getEmail() + "' and password ='" + getUser().getPassword()
		//		+ "'";
		String sql = "select * from user where email='zorenv@163.com' and password ='4321005'";
		ResultSet rS = dao.executeQuery(sql);
		System.out.println(rS);
		try {
			if (rS.next()) {
				//return "loginsuccess";
				System.out.println("user中有此用户");
			}
			//return "loginerror";
			//System.out.println("user中没有此用户");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//return "loginerror";
		}
	}
	*/
	
	/*
	 * 验证注册方法正确性
	public static void main(String[] args){
		//String sql = "insert into " + userTable + "(email,password,nickname) values('" + getUser().getEmail() + "','" + getUser().getPassword()
		//		+ "','" + getUser().getNickname() + "')";
		String sql = "insert into user(email,password,nickname) values('test@test.com','testpassword','testnickname')";
		int i = dao.executeUpdate(sql);
		if (i > -1) {
			//return "registersuccess";
			System.out.println("添加用户成功");
		}
		//return "registererror";	
		System.out.println("添加用户失败");
	}
	 */
	
	public String login() {
		String sql = this.user.ToSelectSql();
		//String sqlforNickname = this.user.ToSelectNickname();
		String USER_Nickname = "user_nickname";
		//String sql = "select * from " + userTable + " where email='zorenv@163.com' and password ='4321005'";
		ResultSet rS = dao.executeQuery(sql);
		//System.out.println(rS);
		//USER_Nickname = rS.getString(1);
		
		System.out.println(registeringFlag);
		if (registeringFlag=="0")
		{
			if (rS!=null){
				try {
					//if (rS.next()) {
//						System.out.println("登陆成功");
//						System.out.println(rS);
						while (rS.next()) {
							USER_Nickname = rS.getString(3);
							ActionContext actionContext = ActionContext.getContext();
							Map session = actionContext.getSession();
							session.put("USER_Nickname", USER_Nickname);
							//System.out.println(session.get(USER_Nickname));
						//}
						System.out.println(USER_Nickname);
						return "loginsuccess";
					}
					return "loginerror";
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "loginerror";
				}
			}
		}
		return "loginerror";
		
	}

	public String register() {
//		String sql = "insert into " + userTable + "(email,password,nickname) values('" + getUser().getEmail() + "','" + getUser().getPassword()
//				+ "','" + getUser().getNickname() + "')";

		System.out.println(user.email);
		if (user.email!=null){
			String sql = user.ToInsertSql();
			System.out.println(sql);
			int i = dao.executeUpdate(sql);
			if (i > -1) {
				return "registersuccess";
			}
		}
		return "registererror";
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