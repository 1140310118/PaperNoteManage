package com.paper.action;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.paper.model.Book;


public class BookOper {
	public List<Book> selectByType(String type) {
	
		Connection conn = com.paper.db.DbConn.getConn();
		java.sql.PreparedStatement pstmt = null;

		java.sql.ResultSet rs = null;
		List<Book> data = new ArrayList<Book>();
		try {
			pstmt = conn.prepareStatement("select id, text from papernote where name=?");
			pstmt.setString(1, type);
			rs = pstmt.executeQuery();
			//Book book = new Book();
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt(1));
				book.setText(rs.getString(2));

				data.add(book);
				
			}
			

			
		} catch (SQLException e) {
			System.out.println("flase");
			e.printStackTrace();
			// TODO Auto-generated catch block e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block e.printStackTrace();
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block e.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block e.printStackTrace();
				}
		}
		return data;
	}
	
	public List<Book> selectByid(int id) {
		
		Connection conn = com.paper.db.DbConn.getConn();
		java.sql.PreparedStatement pstmt = null;

		java.sql.ResultSet rs = null;
		List<Book> data = new ArrayList<Book>();
		try {
			pstmt = conn.prepareStatement("select id, name, text from papernote where id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			//Book book = new Book();
			while (rs.next()) {
				Book book = new Book();
				book.setType(rs.getString(2));
				book.setText(rs.getString(3));
				book.setId(rs.getInt(1));
				data.add(book);
				
			}
			

			
		} catch (SQLException e) {
			System.out.println("flase");
			e.printStackTrace();
			// TODO Auto-generated catch block e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block e.printStackTrace();
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block e.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block e.printStackTrace();
				}
		}
		return data;
	}
	public int update(int id,String name,String text){
		int jg=0;
		//Connection conn = DB.createConn();
		Connection conn = com.paper.db.DbConn.getConn();
		java.sql.PreparedStatement pstmt = null;
		//java.sql.ResultSet rs = null;
		try{
			//System.out.println(title_id+"***");
		pstmt = conn.prepareStatement("update papernote set name=?, text=? where id=?");
		
		pstmt.setString(1, name);
		pstmt.setString(2, text);
		pstmt.setInt(3, id);
		
		jg = pstmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block e.printStackTrace();
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block e.printStackTrace();
				}
	}
		return jg;
	}
	public int deleteByType(String text){
	int jg=0;
	//Connection conn = DB.createConn();
	Connection conn = com.paper.db.DbConn.getConn();
	java.sql.PreparedStatement pstmt = null;
	//java.sql.ResultSet rs = null;
	try{
		//System.out.println(title_id+"***");
	pstmt = conn.prepareStatement("delete from papernote where text=?");
	
	pstmt.setString(1, text);
	jg = pstmt.executeUpdate();
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block e.printStackTrace();
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block e.printStackTrace();
			}
}
	return jg;
}
	
	
}