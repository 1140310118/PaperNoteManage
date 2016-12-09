package com.paper.action.small;

import com.paper.action.ReadSituationAction;
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
	
	// for 修改论文的阅读情况
	private String modifyPaperName = null;
	public String getModifyPaperName() {
		return modifyPaperName;
	}
	public void setModifyPaperName(String modifyPaperName) {
		this.modifyPaperName = modifyPaperName;
	}

	private String readSituation = null;
	
	
	public String getReadSituation() {
		return readSituation;
	}
	public void setReadSituation(String readSituation) {
		this.readSituation = readSituation;
	}

	
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
    public String showLogList(){

		getAllPaperExistedByEmail();
    	return "success";
    }
    
	public String paperManage() throws Exception{
		// 删除 修改 显示所有论文
		// 删除论文
		if (deletePaperNickName!=null){
			System.out.println("FROM FileListAction>> 删除的文件："+deletePaperNickName);
			deletePaperByNickname(deletePaperNickName);
		}
		// 修改论文
		if (updatePaperFlag!="false"){
			System.out.println("FROM FileListAction>> 修改论文信息");
			updatePaper(updatedPaper);
		}
		// 修改阅读情况
		if (readSituation!=null){
			ReadSituationAction rsa=new ReadSituationAction();
			System.out.println("FROM FileListAction>> 修改论文 "+modifyPaperName+" 的阅读情况为 "+readSituation);
			rsa.changeReadSituation(modifyPaperName,readSituation);
		}
		// 获得所有论文
		getAllPaperExistedByEmail();
		return "success";
	} 

	private void updatePaper(Paper paper) {
		try{
			String sql = "update paper set paperOrigin=?,paperRemark=?,uploadDate=?,paperExteriorURL=? where paperNickName=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,paper.paperOrigin);
			//pStmt.setString(2,paper.paperWebFilePath);
			pStmt.setString(2,paper.paperRemark);
			pStmt.setString(3,paper.uploadDate);
			pStmt.setString(4,paper.paperExteriorURL);
			pStmt.setString(5,paper.paperNickName);
			pStmt.executeUpdate();
			System.out.println("From FileAction>> "+pStmt.toString());
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
