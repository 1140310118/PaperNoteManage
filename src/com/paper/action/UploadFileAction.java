package com.paper.action;

import com.opensymphony.xwork2.ModelDriven;
import com.paper.db.DAO;
import com.paper.model.Paper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.*;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.paper.model.file;

public class UploadFileAction extends ActionSupport implements
		ModelDriven<file>
{
	private static final long serialVersionUID = 1L;
	private file singleFile = new file();
	private Paper paper=new Paper();
	private DAO dao = new DAO();
	private String userEmail = null;
	private String userEmailGetFlag = "false";//;(String) ServletActionContext.getRequest().getSession().getAttribute("USER_Email");;
	private String fileUpFlag;

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
	
    public void validate()
    {
    	String filename = singleFile.getResumeFileName();
    	//System.out.println( singleFile.getResumeFileName()+"3333");
    	if(filename == null)
    	{
    		addFieldError("resume", "璇蜂笂浼犳枃浠?");
    	}
    	  	
    }
    ////////////////////////////////////
	public String execute() throws Exception
	{
		// 所有论文 根据userEmail
		//
		System.out.println("userEmail:"+userEmail);
		if (userEmail!=null){
			userEmailGetFlag="true";
		}
		
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
		File rootFile = new File(root);
		if(!rootFile.exists())
		{
			rootFile.mkdir();
		}
		String filename = root + singleFile.getResumeFileName();		
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
//		System.out.println("反倒是"+filename);
		return filename;
	}

	public String getUserEmailGetFlag() {
		return userEmailGetFlag;
	}

	public void setUserEmailGetFlag(String userEmailGetFlag) {
		this.userEmailGetFlag = userEmailGetFlag;
	} 
}
