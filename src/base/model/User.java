package base.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import base.db.DAO;

public class User {
	public  String email;
	private String password;
	private String nickname;
	private String MaxpaperID;
	private String lastReadPaper;
	private DAO dao = new DAO();
	
	public User(String email) {
		// TODO Auto-generated constructor stub
		this.email=email;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String email, String password) {
		this.email=email;
		this.password=password;
	}

	public User(String email, String password, String nickName) {
		this.email=email;
		this.password=password;
		this.nickname=nickName;
	}

	public String ToSelectSql() {
		String sql="select * from user " 
				+"where email='" + this.email + "' "
				+"and password ='" + this.password
				+ "'";
		return sql;
	}
	
	public String ToEmailSelectSql() {
		String sql="select * from user " 
				+"where email='" + this.email 
				+ "'";
		return sql;
	}
	
	public boolean isExisted() throws SQLException{
		String sql=this.ToSelectSql();
		ResultSet rS = this.dao.executeQuery(sql);
		while (rS.next()) {
			return true;
		}
		return false;
	}
	
	public boolean isEmailExisted() throws SQLException{
		String sql=this.ToEmailSelectSql();
		ResultSet rS = this.dao.executeQuery(sql);
		while (rS.next()) {
			return true;
		}
		return false;
	}
	
	public boolean insertUser(){
		String sql=this.ToInsertSql();
		int i = dao.executeUpdate(sql);
		if (i > -1){
			return true;
		}else{
			return false;
		}
	}
	
	public String ToInsertSql() {
		String sql = "insert into user " 
				+ "(email,password,nickname,MaxpaperID) values('" 
				+ this.email + 	"','" 
				+ this.password+"','" 
				+ this.nickname+"','"
				+ "1"
				+ "')";
		return sql;
	}
	public String getMaxpaperID() {
		return MaxpaperID;
	}

	public void setMaxpaperID(String maxpaperID) {
		MaxpaperID = maxpaperID;
	}

	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastReadPaper() {
		return lastReadPaper;
	}

	public void setLastReadPaper(String lastReadPaper) {
		this.lastReadPaper = lastReadPaper;
	}
}
