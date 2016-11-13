package com.paper.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AddNote {
	String writer_name=null;
	Connection conn = com.paper.db.DbConn.getConn();
	public String add_start() {
		return "success";
}
	public String getType() {
		return writer_name;
	}
	public void setType(String writer_name) {
		this.writer_name=writer_name;
	}
	public String add() throws SQLException {
		//String str[]=null;
		String str[]=null;
		str=writer_name.split(",");
		System.out.println(str[0]+"///");
		System.out.println(str[1]+"+++");
		try{
			
			String sql = "insert into papernote ( name,text ) value (?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,str[0]);
			pStmt.setString (2,str[1]);
			pStmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return "success";
}
}