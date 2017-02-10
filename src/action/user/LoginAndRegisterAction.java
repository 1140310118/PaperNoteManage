package action.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import base.model.User;


public class LoginAndRegisterAction extends ActionSupport {
	// 表名
	private static final long serialVersionUID = 1L;
	private String email = null; 
	private String password = null; 
	private String nickName = null;


	ActionContext actionContext = ActionContext.getContext();
	Map<String, Object> session = actionContext.getSession();
	private String relogin = "false";

	public void login() throws SQLException, IOException {
		User _user = new User(email,password);
		String nickName = _user.isExisted();
		if (nickName!=null){
			session.put("USER_Nickname", nickName);
			session.put("USER_Email", email);
			sendJson("1");
			System.out.println("action.user.java>> 登录密码正确。用户名："+ nickName);
		}
		else{
			sendJson("");
			System.out.println("action.user.java>> 登录密码错误。");
		}
	}
	
	public void logout(){
		session.remove("USER_Nickname");
		session.remove("USER_Email");
	}
	
	public String excute(){
		return "success";
	}
	
	public String register() throws SQLException {
		if (email != null) {
			User _user = new User(email,password,nickName);
			boolean insert_success_flag=_user.insertUser();
			if (insert_success_flag) {
				return "registersuccess";
			}
		}
		return "registererror";
	}
	
	public void isEmailExisted() throws SQLException, IOException{
		boolean isEmailExisted_flag = false;
		System.out.println("email:"+email);
		if (email!=null){
			User _user = new User(email);
			isEmailExisted_flag=_user.isEmailExisted();
			System.out.println("FROM com.paper.user.LoginAndRegisterAction.java>> isEmailExisted_flag:"+isEmailExisted_flag);
		}
		if (isEmailExisted_flag){
			sendJson("1");
		}
		else{
			sendJson("");
		}
	}
	
	private void sendJson(String jsonString) throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		/* 
	     * 在调用getWriter之前未设置编码(既调用setContentType或者setCharacterEncoding方法设置编码), 
	     * HttpServletResponse则会返回一个用默认的编码(既ISO-8859-1)编码的PrintWriter实例。这样就会 
	     * 造成中文乱码。而且设置编码时必须在调用getWriter之前设置,不然是无效的。 
	     * */  
		response.setContentType("text/html;charset=utf-8");  
	    //response.setCharacterEncoding("UTF-8");  
	    PrintWriter out = response.getWriter();  
	    //JSON在传递过程中是普通字符串形式传递的，这里简单拼接一个做测试  
	    out.println(jsonString);  
	    out.flush();  
	    out.close();
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRelogin() {
		return relogin;
	}

	public void setRelogin(String relogin) {
		this.relogin = relogin;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}