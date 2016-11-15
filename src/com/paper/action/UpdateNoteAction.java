package com.paper.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateNoteAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	String update=null;
	Connection conn = com.paper.db.DbConn.getConn();

	public String getType() {
		return update;
	}
	public void setType(String update) {
		System.out.println(update);
		this.update=update;
	}
	public String update() throws SQLException {
		String str[]=null;
		str=update.split(",");
		System.out.println(str[0]+"///");
		System.out.println(str[1]+"+++");
		try{
			
			
			String sql = "update papernote set text=? where id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,str[1]);
			pStmt.setString (2,str[0]);
			pStmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return "success";
	
}
}