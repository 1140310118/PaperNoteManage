package tmp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateNote extends ActionSupport {
	String update=null;
	Connection conn = base.db.DbConn.getConn();

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
			
			String sql = "update paper set paperOrigin=?,paperWebFilePath=?,paperRemark=?,uploadDate=? where paperNickName=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,str[1]);
			pStmt.setString(2,str[2]);
			pStmt.setString(3,str[3]);
			pStmt.setString(4,str[4]);
			pStmt.setString (6,str[0]);
			pStmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return "success";
	
}
}