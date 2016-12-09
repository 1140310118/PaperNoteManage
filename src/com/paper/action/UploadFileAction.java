package com.paper.action;

import com.opensymphony.xwork2.ModelDriven;
import com.paper.db.DAO;
import com.paper.model.Paper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.*;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.paper.model.file;

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
		
		System.out.println("userEmail:"+userEmail);
		
		String root = "d:\\upload\\"+userEmail+"\\";
		System.out.println("root:"+root);
//		File rootFile = new File(root);
//		if(!rootFile.exists())
//		{
//			rootFile.mkdir();
//		}
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
	
	//String root = "d:\\upload\\"+userEmail+"\\";
	
	ClassLoader classLoader = Thread.currentThread()  
            .getContextClassLoader();  
    if (classLoader == null) {  
        classLoader = ClassLoader.getSystemClassLoader();  
    }  
    java.net.URL url = classLoader.getResource("");  
    String ROOT_CLASS_PATH = url.getPath() + "/";  
    File rootFile = new File(ROOT_CLASS_PATH);  
    String WEB_INFO_DIRECTORY_PATH = rootFile.getParent() + "/";  
    File webInfoDir = new File(WEB_INFO_DIRECTORY_PATH);  
    String SERVLET_CONTEXT_PATH = webInfoDir.getParent() + "/"; 
    
    String root=SERVLET_CONTEXT_PATH+"file/"+userEmail+"/";
	System.out.println(">>>>>>>>>>>>>"+root);
	System.out.println("fileUpFlag="+fileUpFlag);
	if (newPaperFlag!="false"){
		System.out.println("新建文件");
		if (newPaperByURLFlag!="false")
		{
			System.out.println("新建文件 从URL");

			//insertNewPaper(paper.paperExteriorURL);

			//System.out.println(paper.paperExteriorURL.substring(0,6));
			if(paper.paperExteriorURL.length()>=7){
				if( !(paper.paperExteriorURL.substring(0,7).equals("http://")) ){
					paper.paperExteriorURL = "http://" + paper.paperExteriorURL;
				}
			}
			else{
				paper.paperExteriorURL = "http://" + paper.paperExteriorURL;
			}
			insertNewPaper(paper.paperExteriorURL);
			System.out.println(paper.paperExteriorURL);
			return "newPaperSuccess";
		}
		if (fileUpFlag!="false"){
			System.out.println("新建文件 从本地");
			String paperWebFilePath=fileUp(root);
			System.out.println(paperWebFilePath);
			insertNewPaper(paperWebFilePath);
			System.out.println("UploadFileAction>> newPaperLocalSuccess");
			return "newPaperSuccess";
		}
	}
	return "success";
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
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());
		
		System.out.println("194");
		File rootFile = new File(root);
		if(!rootFile.exists())
		{
			rootFile.mkdir();
		}

		//String root1 = root+(singleFile.getResumeFileName()).substring(0,(singleFile.getResumeFileName()).length()-4);
		String root1=root+this.paper.paperNickName;
		File rootFile1 = new File(root1);
		if(!rootFile1.exists())
		{
			rootFile1.mkdir();
			String filename3 = "log.txt";
			File path1 = new File(root1);
			File dir1=new File(path1,filename3);
			dir1.createNewFile();
			String shangchuan = root1+"\\"+"log.txt";
			FileWriter writer = new FileWriter(shangchuan, true);
			writer.write(date +"	"+ "上传系统" + "	" +"||"); 
			 writer.close();
			String root2=root1+"\\note\\";
			File rootFile2 = new File(root2);
			if(!rootFile2.exists())
			{
				rootFile2.mkdir();
				String filename2 = "note.config";
				File path = new File(root2);
				File dir=new File(path,filename2);
				dir.createNewFile();
			}
			
		}
		
		String filename = root1+"\\" + singleFile.getResumeFileName();

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
