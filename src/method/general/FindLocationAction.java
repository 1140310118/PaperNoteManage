package method.general;

import java.sql.ResultSet;
import java.sql.SQLException;

import base.db.DAO;

public class FindLocationAction {
	private DAO dao = new DAO();
	
//	public static void main(String[] args) throws SQLException {
//		FindLocationAction find = new FindLocationAction();
//		// 测试通过
//		System.out.println("FindLocationAction: "+find.findLocation("zorenv@163.com","Lab1"));
//	}
	
	public String findLocation(String userEmail, String paperNickName) throws SQLException{
		String paperWebFilePath = "";
		String sql = "SELECT paperWebFilePath FROM paper WHERE paperNickName = " + "'" + paperNickName + "' AND paperUserEmail = '" + userEmail + "'";
		System.out.println(sql); 
		ResultSet rS = dao.executeQuery(sql);
		System.out.println(rS);
		while (rS.next()) {
			paperWebFilePath = rS.getString(1);
		}
		System.out.println(paperWebFilePath);
		return paperWebFilePath;
	}
	
	public String findLocation2(String userEmail, String paperID) throws SQLException{
		String paperWebFilePath = "";
		String sql = "SELECT paperWebFilePath FROM paper WHERE paperID = " + "'" + paperID + "' AND paperUserEmail = '" + userEmail + "'";
		System.out.println("FLA>> sql:"+sql); 
		ResultSet rS = dao.executeQuery(sql);
		System.out.println("FROM FLA>> "+sql);
		while (rS.next()) {
			paperWebFilePath = rS.getString(1);
		}
		System.out.println(paperWebFilePath);
		return paperWebFilePath;
	}
	
	public String findNamebyID(String userEmail, String paperID) throws SQLException{
		String paperNickName = "";
		String sql = "SELECT paperNickName FROM paper WHERE paperID = " + "'" + paperID + "' AND paperUserEmail = '" + userEmail + "'";
		System.out.println(sql); 
		ResultSet rS = dao.executeQuery(sql);
		System.out.println(rS);
		while (rS.next()) {
			paperNickName = rS.getString(1);
		}
		System.out.println(paperNickName);
		return paperNickName;
	}

	public String findIDbyName(String userEmail, String paperNickName) throws SQLException {
		String paperID = "";
		String sql = "SELECT paperID FROM paper WHERE paperNickName = " + "'" + paperNickName + "' AND paperUserEmail = '" + userEmail + "'";
		System.out.println(sql); 
		ResultSet rS = dao.executeQuery(sql);
		System.out.println(rS);
		while (rS.next()) {
			paperID = rS.getString(1);
		}
		System.out.println(paperID);
		return paperID;
	}

	public String findLocation3(String userEmail, String paperNickName) throws SQLException {
		String paperExteriorURL = "";
		String sql = "SELECT paperExteriorURL FROM paper WHERE paperNickName = " + "'" + paperNickName + "' AND paperUserEmail = '" + userEmail + "'";
		System.out.println(sql); 
		ResultSet rS = dao.executeQuery(sql);
		System.out.println(rS);
		while (rS.next()) {
			paperExteriorURL = rS.getString(1);
		}
		System.out.println(paperExteriorURL);
		return paperExteriorURL;
	}
	public String findLocation4(String userEmail, String paperID) throws SQLException {
		String paperNickName = findNamebyID(userEmail,paperID);
		return userEmail+"/"+str2ascii(paperNickName)+"/url";
	}
	private String str2ascii(String s){
		return StringandACSII.showIntArray(StringandACSII.string2ASCII(s), "H");
	}
}
