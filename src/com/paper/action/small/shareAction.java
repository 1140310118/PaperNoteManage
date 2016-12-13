package com.paper.action.small;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.paper.action.FileToZip;
import com.paper.action.FindLocationAction;
import com.paper.action.treetozip;

public class shareAction extends ActionSupport
{
	
	private static final long serialVersionUID = 1L;
	private String paperName=null;
	private String file = null;
	private String filePath = null;
	
	

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	private FindLocationAction fla = new FindLocationAction();
	
	// 获得用户email
	ActionContext actionContext = ActionContext.getContext();
	Map<String, Object> session = actionContext.getSession();
	private String userEmail = (String) session.get("USER_Email");
	
	

	public void get_share() throws IOException, SQLException{
		System.out.println("FROM SA>> "+paperName);
		String path = fla.findLocation(userEmail, paperName);
		path = path.substring(0,path.lastIndexOf("/"));
		String root = getWebrootPath();
		FileToZip ftz = new FileToZip();
		ftz.filezip(root+userEmail+"/"+"sharePaper.zip",root+path);
		String url = "sharePaper.zip";
		HttpServletResponse response=ServletActionContext.getResponse();
		/* 
	     * 在调用getWriter之前未设置编码(既调用setContentType或者setCharacterEncoding方法设置编码), 
	     * HttpServletResponse则会返回一个用默认的编码(既ISO-8859-1)编码的PrintWriter实例。这样就会 
	     * 造成中文乱码。而且设置编码时必须在调用getWriter之前设置,不然是无效的。 
	     * */  
		response.setContentType("text/html;charset=utf-8");  
	    //response.setCharacterEncoding("UTF-8");  
	    PrintWriter out = response.getWriter();  
	    //JSON在传递过程中是普通字符串形式传递的，这里简单拼接一个做测试  
	    String jsonString=url;
	    out.println(jsonString);  
	    out.flush();  
	    out.close();  
	}
	
	public String share(){
		return "success";
	}
	private static String getWebrootPath(){
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
	    
	    String root=SERVLET_CONTEXT_PATH+"file/";
		return root;
	}
	
	public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
}
