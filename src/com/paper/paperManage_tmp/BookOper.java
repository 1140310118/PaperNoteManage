package com.paper.paperManage_tmp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.paper.model.Paper;


public class BookOper {
	public List<Paper> selectByType(String type) {
	
		Connection conn = com.paper.db.DbConn.getConn();
		System.out.println(conn);
		java.sql.PreparedStatement pstmt = null;

		java.sql.ResultSet rs = null;
		List<Paper> data = new ArrayList<Paper>();
		try {
			pstmt = conn.prepareStatement("select paperNickName, paperOrigin, paperWebFilePath, paperExteriorURL, paperRemark, uploadDate, paperUserEmail, paperID, paperReadSituation  from paper where paperUserEmail=? AND (paperWebFilePath != \"\" OR paperExteriorURL != \"\") AND paperIsDeleted = 0");
			pstmt.setString(1, type);
			System.out.println(pstmt.toString());
			
			rs = pstmt.executeQuery();
			System.out.println(pstmt.toString());
			System.out.println("rs:"+rs);
			//Book book = new Book();
			while (rs.next()) {
				Paper book = new Paper();
				book.setPaperNickName(rs.getString(1));
				book.setPaperOrigin(rs.getString(2));
				book.setPaperWebFilePath(rs.getString(3));
				book.setPaperExteriorURL(rs.getString(4));
				book.setPaperRemark(rs.getString(5));
				book.setUploadDate(rs.getString(6));
				book.setPaperUserEmail(rs.getString(7));
				book.setPaperID(rs.getString(8));
				book.setPaperReadSituation(rs.getString(9));
				data.add(book);	
				//System.out.println(" :"+book.toString());
//				book.show();
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
	
	public List<Paper> selectByid(String type) {
		
		Connection conn = com.paper.db.DbConn.getConn();
		java.sql.PreparedStatement pstmt = null;

		java.sql.ResultSet rs = null;
		List<Paper> data = new ArrayList<Paper>();
		try {
			pstmt = conn.prepareStatement("select paperNickName, paperOrigin, paperWebFilePath, paperRemark, uploadDate, paperUserEmail  from paper where paperNickName=?");
			pstmt.setString(1, type);
			rs = pstmt.executeQuery();
			//Book book = new Book();
			while (rs.next()) {
				Paper book = new Paper();
				book.setPaperNickName(rs.getString(1));
				book.setPaperOrigin(rs.getString(2));
				book.setPaperWebFilePath(rs.getString(3));
				book.setPaperRemark(rs.getString(4));
				book.setUploadDate(rs.getString(5));
				book.setPaperUserEmail(rs.getString(6));
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
//	public int update(int id,String name,String text){
//		int jg=0;
//		//Connection conn = DB.createConn();
//		Connection conn = db.DbConn.getConn();
//		java.sql.PreparedStatement pstmt = null;
//		//java.sql.ResultSet rs = null;
//		try{
//			//System.out.println(title_id+"***");
//		pstmt = conn.prepareStatement("update papernote set name=?, text=? where id=?");
//		
//		pstmt.setString(1, name);
//		pstmt.setString(2, text);
//		pstmt.setInt(3, id);
//		
//		jg = pstmt.executeUpdate();
//		}
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//		finally {
//			if (pstmt != null)
//				try {
//					pstmt.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block e.printStackTrace();
//				}
//			if (conn != null)
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block e.printStackTrace();
//				}
//	}
//		return jg;
//	}
	public int deleteByType(String type){
	int jg=0;
	//Connection conn = DB.createConn();
	Connection conn = com.paper.db.DbConn.getConn();
	java.sql.PreparedStatement pstmt = null;
	//java.sql.ResultSet rs = null;
	try{
		//System.out.println(title_id+"***");
	pstmt = conn.prepareStatement("delete from paper where paperNickName=?");
	
	pstmt.setString(1, type);
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