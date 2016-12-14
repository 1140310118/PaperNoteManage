package testForJsp.action;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.paper.action.FindLocationAction;
import com.paper.action.ReadSituationAction;
import com.paper.action.addlog;

import base.translate;

public class NoteManage{
	
	//所有笔记
	private ArrayList<Note> notes=new ArrayList<Note>();
	
	//添加笔记
	private String addNoteFlag = "false";
	
	//修改笔记
	private String modifyNoteContent=new String(); //修改后的内容
	private String modifyNoteID = null;//待修改的笔记id
	//删除笔记
	private String deleteNoteID = null;
	private String paperID = null;
	public String getPaperID() {
		return paperID;
	}

	public void setPaperID(String paperID) {
		this.paperID = paperID;
	}

	//要翻译的单词
	private String wordT = null;
	

	//paperNickName
	private String paperNickName = null;
	// paperURL
	private String paperURL = null;
	public String getPaperURL() {
		return paperURL;
	}

	public void setPaperURL(String paperURL) {
		this.paperURL = paperURL;
	}

	public String getPaperNickName() {
		return paperNickName;
	}

	public void setPaperNickName(String paperNickName) {
		this.paperNickName = paperNickName;
	}

	ActionContext actionContext = ActionContext.getContext();
	Map session = actionContext.getSession();
	private String userEmail = (String) session.get("USER_Email");
	
	ReadSituationAction rsa = new ReadSituationAction();
	FindLocationAction fla = new FindLocationAction();

	
	private String paperWebFilePath = null;
	//private String tmpPath = null;
	//private String con = null;
	

	public String execute() throws IOException, SQLException{
		if(userEmail=="user_email" || userEmail=="" || userEmail==null){
			return "unLogin";
		}
		// 笔记的各种操作
		// 包括        从磁盘中获得用户的所有笔记，新建笔记，删除笔记，修改笔记
		paperNickName = rsa.getLastPaper(userEmail);
		
		FindLocationAction fla= new FindLocationAction();
		paperURL = fla.findLocation(userEmail, paperNickName);
		paperID = fla.findIDbyName(userEmail, paperNickName);
		return "success";
	}

	public String NoteOpeartion() throws IOException, SQLException {
		
		String root = getWebrootPath(); 
		paperWebFilePath = fla.findLocation2(userEmail, paperID);
		paperNickName = fla.findNamebyID(userEmail, paperID);
		String tmpPath="",con="";
		if(paperWebFilePath=="" || paperWebFilePath==null){
			paperWebFilePath = fla.findLocation4(userEmail, paperID);
			tmpPath = root + paperWebFilePath.substring(0,paperWebFilePath.lastIndexOf('/')+1)+"note";
			con = root + paperWebFilePath.substring(0,paperWebFilePath.lastIndexOf('/')+1)+"note/note.config";
		}else{
			tmpPath = root + paperWebFilePath.substring(0,paperWebFilePath.lastIndexOf('/')+1)+"note";
			con = root + paperWebFilePath.substring(0,paperWebFilePath.lastIndexOf('/')+1)+"note/note.config";
		}
		System.out.println("FROM NM>> paperWebFilePath:"+paperWebFilePath);
		
		
		//路径
		String paperPath = fla.findLocation(userEmail, paperNickName);
		if(paperPath!="" || paperPath==null){
			paperPath = fla.findLocation4(userEmail, paperID);
		}
		paperPath  = paperPath.substring(0,paperPath.lastIndexOf("/"));
		
		//System.out.println("FROM NM>> "+tmpPath+" "+con);
		// 获得所有笔记
		getAllExistedNotes(tmpPath,con);
		
		
		// 删除笔记
		if(deleteNoteID!=null){
			
			FindLocationAction fla = new FindLocationAction();
			addlog ag = new addlog();
			String path = getWebrootPath() + paperPath;
			System.out.println("FROM FLA>> "+path+" "+paperPath);
			ag.adddeletelog(path,deleteNoteID);
			
			deleteFile(deleteNoteID,tmpPath,con);
			System.out.println("被删除的笔记:"+deleteNoteID);
		}
		
		// 修改笔记
		System.out.println("修改笔记>> "+modifyNoteID);
		if(modifyNoteID!=null){
			
			FindLocationAction fla = new FindLocationAction();
			addlog ag = new addlog();
			String path = getWebrootPath() + paperPath;
			System.out.println("FROM FLA>> "+path+" "+paperPath);
			ag.addmonidfylog(path,modifyNoteID);
			
			writeFile(modifyNoteContent,modifyNoteID+".txt",tmpPath);
			System.out.println("被修改的笔记:"+modifyNoteID);
		}
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
	
	
	public void newNote() throws IOException, SQLException{
		String root = getWebrootPath(); 
		paperNickName = fla.findNamebyID(userEmail, paperID);
		String tmpPath="",con="";
		if(paperWebFilePath=="" || paperWebFilePath==null){
			paperWebFilePath = fla.findLocation4(userEmail, paperID);
			tmpPath = root + paperWebFilePath.substring(0,paperWebFilePath.lastIndexOf('/')+1)+"note";
			con = root + paperWebFilePath.substring(0,paperWebFilePath.lastIndexOf('/')+1)+"note/note.config";
		}else{
			tmpPath = root + paperWebFilePath.substring(0,paperWebFilePath.lastIndexOf('/')+1)+"note";
			con = root + paperWebFilePath.substring(0,paperWebFilePath.lastIndexOf('/')+1)+"note/note.config";
		}
		
		// 新建笔记 
		String addNoteID=addNoteFile(tmpPath,con);
		
		//路径
		String paperPath = fla.findLocation(userEmail, paperNickName);
		if(paperPath!="" || paperPath==null){
			paperPath = fla.findLocation4(userEmail, paperID);
		}
		paperPath  = paperPath.substring(0,paperPath.lastIndexOf("/"));
		
		
		FindLocationAction fla = new FindLocationAction();
		addlog ag = new addlog();
		String path = getWebrootPath() + paperPath;
		System.out.println("FROM FLA>> "+path+" "+paperPath);
		ag.addcreatelog(path,addNoteID);
		
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
	    String jsonString=addNoteID;  
	    out.println(jsonString);  
	    out.flush();  
	    out.close();  
	}
	
	public void wordTranslate() throws IOException{
		translate t = new translate();
		String resultT = t.translateWord(wordT);
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
	    String jsonString=resultT;  
	    out.println(jsonString);  
	    out.flush();  
	    out.close();  
	}

	private int nextNoteID(String con) {
		int num;
		addconfig(con);
		num=readconfig(con);
		return num;
	}


	private Integer readconfig(String con) {
		// TODO Auto-generated method stub
		File file = new File(con);
		String filecontent=null;
		try {
				filecontent = org.apache.commons.io.FileUtils.readFileToString(file, "utf8");
				System.out.println(filecontent);
				System.out.println(filecontent.length());
				return filecontent.length();
		} 
		catch (IOException e) {
			   e.printStackTrace();
			   System.out.println("error!!!!");
			   return null;
		}
	}


	private void addconfig(String con) {
		// TODO Auto-generated method stub
		try {   
			
			FileWriter writer = new FileWriter(con, true); 
			 writer.write("a"); 
			 writer.close();  
      } catch (IOException e) {   
          e.printStackTrace();   
      }  
	}


	private void deleteFile(String noteID, String tmpPath , String con) throws IOException {
		// TODO Auto-generated method stub
		String filename = noteID +".txt"; 
		File file = new File(tmpPath+"/"+filename);
		if(file.exists()){
		    file.delete();
		    modifyCon_when_deleteFile(noteID,tmpPath, con);
		}
	}
	
	// 例如 config aaaaa -> aabaa 删除笔记3
	private void modifyCon_when_deleteFile(String noteID,String tmpPath,String con) throws IOException{
		File file = new File(con);
		String filecontent = org.apache.commons.io.FileUtils.readFileToString(file, "utf8");
		System.out.println(filecontent);
		int pos = Integer.parseInt(noteID)-1;
		filecontent=  filecontent.substring(0,pos)+"b"+filecontent.substring(pos+1);
		System.out.println(filecontent);
		writeFile(filecontent,"note.config",tmpPath);
	}

	private void writeFile(String testtext, String filename, String tmpPath) {
		File file = new File(tmpPath+"/"+filename);
		// TODO Auto-generated method stub
		 try {
			   org.apache.commons.io.FileUtils.writeStringToFile(file, testtext, "utf8");
			  } catch (IOException e) {
			   e.printStackTrace();
			  }
	}


	private String addNoteFile(String tmpPath,String con) {
		int NoteID = nextNoteID(con);
		String filename = NoteID + ".txt";
		File path = new File(tmpPath);
		File dir=new File(path,filename);
		try {
			dir.createNewFile();
			System.out.println("创建成功");
			return ""+NoteID;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.print("创建失败");
			return null;
		}
	}

	// 获得所有笔记
	private void getAllExistedNotes(String tmpPath,String con) throws IOException {
		File file = new File(tmpPath);
		File[] tempList = file.listFiles();
		File confile = new File(con);
		System.out.println("FROM NM>> "+con);
		char[] confilecontent = org.apache.commons.io.FileUtils.readFileToString(confile, "utf8").toCharArray();	
		System.out.println("FROM NM>> "+confilecontent.toString());
		System.out.println("FROM NM>> "+tempList.length);
		String filename = null;
		for (int i=0;i<tempList.length-1;i++){
//			if (confilecontent[i]=='a'){
				String fileString=getFileString(tempList[i]);
				filename=tempList[i].toString().substring(tempList[i].toString().lastIndexOf("\\")+1);
				Note note = new Note(filename.substring(0,filename.length()-4),fileString);
				notes.add(note);
//			}
		}
	}
	public static String getFileString(File file) {
      try {
          String fileString = FileUtils.readFileToString(file,"utf8");
          return fileString;
      } catch (IOException e) {
          e.printStackTrace();
      }
      return null;
  }

	public ArrayList<Note> getNotes() {
		return notes;
	}

	public void setNotes(ArrayList<Note> notes) {
		this.notes = notes;
	}

	public String getAddNoteFlag() {
		return addNoteFlag;
	}

	public void setAddNoteFlag(String addNote) {
		this.addNoteFlag = addNote;
	}


	public String getDeleteNoteListID() {
		return deleteNoteID;
	}


	public void setDeleteNoteListID(String deleteNoteListID) {
		this.deleteNoteID = deleteNoteListID;
	}


	public String getModifyNoteID() {
		return modifyNoteID;
	}


	public void setModifyNoteID(String modifyNoteID) {
		this.modifyNoteID = modifyNoteID;
	}


	public String getDeleteNoteID() {
		return deleteNoteID;
	}
	public String getPaperWebFilePath() {
		return paperWebFilePath;
	}

	public void setPaperWebFilePath(String paperWebFilePath) {
		this.paperWebFilePath = paperWebFilePath;
	}


	public void setDeleteNoteID(String deleteNoteID) {
		this.deleteNoteID = deleteNoteID;
	}


	public String getModifyNoteContent() {
		return modifyNoteContent;
	}


	public void setModifyNoteContent(String modifyNoteContent) {
		this.modifyNoteContent = modifyNoteContent;
	}

	public String getWordT() {
		return wordT;
	}

	public void setWordT(String wordT) {
		this.wordT = wordT;
	}
	
}
