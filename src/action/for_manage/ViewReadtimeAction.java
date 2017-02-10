package action.for_manage;

import java.io.File;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import method.general.FileOp;

public class ViewReadtimeAction extends ActionSupport
{
	public String readtimeContent = null;
	public String filePath = null;
	private static final long serialVersionUID = 1L;
	
	ActionContext actionContext = ActionContext.getContext();
	Map session = actionContext.getSession();
	private String userEmail = (String) session.get("USER_Email");
	
	public String getReadtimeContent() {
		return readtimeContent;
	}
	public void setReadtimeContent(String readtimeContent) {
		this.readtimeContent = readtimeContent;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String showReadtime(){
		filePath = getWebrootPath()+userEmail+"/Readtime.txt";
		File file = new File(filePath);
		readtimeContent = FileOp.getFileString(file);
		System.out.println("FROM ViewLogAction>> "+filePath+":"+readtimeContent);
		return "success";
	}
	
	private String getWebrootPath(){
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

}
