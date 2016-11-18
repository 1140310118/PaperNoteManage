package com.paper.action;

import com.opensymphony.xwork2.ModelDriven;
import com.paper.db.DAO;
import com.paper.model.Paper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.paper.model.file;
import com.paper.paperManage_tmp.BookOper;

public class UploadFileAction extends ActionSupport implements
		ModelDriven<file>
{
	private static final long serialVersionUID = 1L;
	private file singleFile = new file();
	private Paper paper=new Paper();
	private String fileUpFlag = "false";
	private String newPaperByURLFlag="false";
	
	public String getNewPaperByURLFlag() {
		return newPaperByURLFlag;
	}

	public void setNewPaperByURLFlag(String newPaperByURLFlag) {
		this.newPaperByURLFlag = newPaperByURLFlag;
	}

	//////
	//paperList
	private String deletePaperNickName = null;
	public String getDeletePaperNickName() {
		return deletePaperNickName;
	}

	public void setDeletePaperNickName(String deletePaperNickName) {
		this.deletePaperNickName = deletePaperNickName;
	}

	private String updatePaperFlag = "false";
	private Paper updatedPaper = new Paper();
	/////
	private String newPaperFlag = "false";
//	
	ActionContext actionContext = ActionContext.getContext();
	Map session = actionContext.getSession();
	private String userEmail = (String) session.get("USER_Email");
	private DAO dao = new DAO();
	// panwei
	private BookOper bo = new BookOper(); // 查询类

	
	Connection conn = com.paper.db.DbConn.getConn();
	public String getUpdatePaperFlag() {
		return updatePaperFlag;
	}

	public void setUpdatePaperFlag(String updatePaperFlag) {
		this.updatePaperFlag = updatePaperFlag;
	}

	public Paper getUpdatedPaper() {
		return updatedPaper;
	}

	public void setUpdatedPaper(Paper updatedPaper) {
		this.updatedPaper = updatedPaper;
	}
	
	public String getFileUpFlag() {
		return fileUpFlag;
	}

	public void setFileUpFlag(String fileUpFlag) {
		this.fileUpFlag = fileUpFlag;
	}
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public file getModel()
	{
		return singleFile;
	}
	
	public Paper getPaper()
	{
		return this.paper;
	}
	
	public void setPaper(Paper paper)
	{
		this.paper=paper;
	}
	
//	11/16 bug调试的 罪魁祸首
//    public void validate()
//    {
//    	String filename = singleFile.getResumeFileName();
//    	//System.out.println( singleFile.getResumeFileName()+"3333");
//    	if(filename == null)
//    	{
//    		addFieldError("resume", "璇蜂笂浼犳枃浠?");
//    	}
//    }
    
    ////////////////////////////////////
	public String execute() throws Exception
	{
		// 所有论文 根据userEmail
		//

//		System.out.println(session.get("USER_Nickname"));
		
		//System.out.println("userEmail:"+userEmail);

		String root = "d:\\upload\\";
		if (fileUpFlag!="false"){
			String paperWebFilePath=fileUp(root);
			insertNewPaper(paperWebFilePath);
		}
		else{
			insertNewPaper("");
		}
		return "success";
	} 
	////////////////////////////////////
	
////////////////////////////////////////	
///////////////////////////////////////
public String paperManage() throws Exception{
	
	// 所有论文 根据userEmail
	//
	System.out.println("userEmail:"+userEmail);
	
	System.out.println("updatePaperFlag："+updatePaperFlag);
	if (updatePaperFlag!="false"){
		updatePaper(updatedPaper);
	
	}
	
	
	if (deletePaperNickName!=null){
		System.out.println("删除的文件："+deletePaperNickName);
		deletePaperByNickname(deletePaperNickName);
	}
	
	
	String root = "d:\\upload\\";
	if (newPaperFlag!="false"){
		System.out.println("新建文件");
		if (newPaperByURLFlag!="false")
		{
			System.out.println("新建文件 从URL");

			//insertNewPaper(paper.paperExteriorURL);

			//System.out.println(paper.paperExteriorURL.substring(0,6));
			if( !(paper.paperExteriorURL.substring(0,7).equals("http://")) ){
				paper.paperExteriorURL = "http://" + paper.paperExteriorURL;
			}
			insertNewPaper(paper.paperExteriorURL);
			System.out.println(paper.paperExteriorURL);

		}
		if (fileUpFlag!="false"){
			System.out.println("新建文件 从本地");
			String paperWebFilePath=fileUp(root);
			System.out.println(paperWebFilePath);
			insertNewPaper(paperWebFilePath);
		}
		
	}

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
		pStmt.setString (5,paper.paperNickName);
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

////////////////////////////////////
////////////////////////////////////
	
	
	
	// 向数据库中插入 paper 对象	
	private void insertNewPaper(String paperWebFilePath) {
		String sql=this.paper.toInsertSql(paperWebFilePath);
		System.out.println(sql);
		//sql += " "
		int rs=dao.executeUpdate(sql);//"insert into paper values('fasfsdf','','null','null','null','null')");
		System.out.println(rs);
	}

	// 将文件上传到 root 目录	
	public String fileUp(String root) throws Exception
	{
		System.out.println("194");
		File rootFile = new File(root);
		if(!rootFile.exists())
		{
			rootFile.mkdir();
		}
		String filename = root + singleFile.getResumeFileName();
		System.out.println("filename:"+filename);
		FileInputStream fis = new FileInputStream(singleFile.getResume());
		FileOutputStream fos = new FileOutputStream(filename);
		byte[] buffer = new byte[8192];
		int n = 0;
		while((n = fis.read(buffer)) > 0)
		{
			fos.write(buffer, 0, n);
		}
		fos.close();
		fis.close();
		System.out.println( singleFile.getResumeFileName());
		System.out.println( singleFile.getResumeContentType());
		filename = filename.replaceAll("\\\\","/");
		System.out.println("反倒是"+filename);
		return filename;
	}

	

	public String getNewPaperFlag() {
		return newPaperFlag;
	}

	public void setNewPaperFlag(String newPaperFlag) {
		this.newPaperFlag = newPaperFlag;
	} 
}
