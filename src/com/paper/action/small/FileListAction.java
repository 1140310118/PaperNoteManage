package com.paper.action.small;

import com.paper.model.Paper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import com.paper.paperManage_tmp.BookOper;

public class FileListAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;


	private Paper paper=new Paper();
	private String deletePaperNickName = null;
	private Paper updatedPaper = new Paper();

	ActionContext actionContext = ActionContext.getContext();
	Map<String, Object> session = actionContext.getSession();
	private String userEmail = (String) session.get("USER_Email");
	private BookOper bo = new BookOper(); // 查询类

	Connection conn = com.paper.db.DbConn.getConn();
	private String updatePaperFlag = "false";
	
	public String getUpdatePaperFlag() {
		return updatePaperFlag;
	}
	public void setUpdatePaperFlag(String updatePaperFlag) {
		this.updatePaperFlag = updatePaperFlag;
	}
	public String getDeletePaperNickName() {
		return deletePaperNickName;
	}
	public void setDeletePaperNickName(String deletePaperNickName) {
		this.deletePaperNickName = deletePaperNickName;
	}	
	public Paper getUpdatedPaper() {
		return updatedPaper;
	}
	public void setUpdatedPaper(Paper updatedPaper) {
		this.updatedPaper = updatedPaper;
	}
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	
	public Paper getPaper()
	{
		return this.paper;
	}
	
	public void setPaper(Paper paper)
	{
		this.paper=paper;
	}
    
	public String paperManage() throws Exception{
		// 删除 修改 显示所有论文
		// 删除论文
		if (deletePaperNickName!=null){
			System.out.println("删除的文件："+deletePaperNickName);
			deletePaperByNickname(deletePaperNickName);
		}
		// 修改论文
		System.out.println("updatePaperFlag："+updatePaperFlag);
		if (updatePaperFlag!="false"){
			updatePaper(updatedPaper);
		}
		// 显示所有论文
		getAllPaperExistedByEmail();
		return "success";
	} 

	private void updatePaper(Paper paper) {
		try{
			
			String sql = "update paper set paperOrigin=?,paperWebFilePath=?,paperRemark=?,uploadDate=? where paperNickName=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,paper.paperOrigin);
			pStmt.setString(2,paper.paperWebFilePath);
			pStmt.setString(3,paper.paperRemark);
			pStmt.setString(4,paper.uploadDate);
			pStmt.setString(5,paper.paperNickName);
			pStmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	private void deletePaperByNickname(String dPaperNickName) {
		bo.deleteByType(dPaperNickName);
	}
	
	private void getAllPaperExistedByEmail() {
		System.out.println(userEmail);
		ActionContext.getContext().put("paperList", bo.selectByType(userEmail));
		}
}
