package com.paper.model;

public class User {
	public String email;
	private String password;
	private String nickname;
	private String MaxpaperID;
	public String getMaxpaperID() {
		return MaxpaperID;
	}
	public void setMaxpaperID(String maxpaperID) {
		MaxpaperID = maxpaperID;
	}
	/**
	 * @return the password
	 */
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
	
	public String ToSelectSql() {
		String sql="select * from user " 
				+"where email='" + this.email + "' "
				+"and password ='" + this.password
				+ "'";
		return sql;
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
}
