package testForJsp.action;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

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
	//要翻译的单词
	private String wordT = null;
	

//根据情况修改
	private String tmpPath = "D:/ecllipse/PaperNoteManage/WebContent/file/zzh19971968@foxmail.com/test/note";
	private String con="D:/ecllipse/PaperNoteManage/WebContent/file/zzh19971968@foxmail.com/test/note/note.config";
//	private String tmpPath = "M:/myGitHub/SE/PaperNoteManage/WebContent/file/zzh19971968@foxmail.com/test/note";
//	private String con="M:/myGitHub/SE/PaperNoteManage/WebContent/file/zzh19971968@foxmail.com/test/note/note.config";
	
	
	public String execute() throws IOException{
		
		// 笔记的各种操作
		// 包括        从磁盘中获得用户的所有笔记，新建笔记，删除笔记，修改笔记
		NoteOpeartion();
		
		return "success";
	}

	private void NoteOpeartion() throws IOException {
		// 获得所有笔记
		getAllExistedNotes();
		
		// 删除笔记
		if(deleteNoteID!=null){
			deleteFile(deleteNoteID,tmpPath);
			System.out.println("被删除的笔记:"+deleteNoteID);
		}
		
		// 修改笔记
		if(modifyNoteID!=null){
			writeFile(modifyNoteContent,modifyNoteID+".txt",tmpPath);
			System.out.println("被修改的笔记:"+modifyNoteID);
//			System.out.println(modifyNoteContent);
		}
	}
	public void newNote() throws IOException{
		// 新建笔记 
		String addNoteID=addNoteFile();
		
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

	private int nextNoteID() {
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


	private void deleteFile(String noteID, String tmpPath) throws IOException {
		// TODO Auto-generated method stub
		String filename = noteID +".txt"; 
		File file = new File(tmpPath+"/"+filename);
		if(file.exists()){
		    file.delete();
		    //modifyCon_when_deleteFile(noteID);
		}
	}
	
	// 例如 config aaaaa -> aabaa 删除笔记3
//	private void modifyCon_when_deleteFile(String noteID) throws IOException{
//		File file = new File(con);
//		String filecontent = org.apache.commons.io.FileUtils.readFileToString(file, "utf8");
//		System.out.println(filecontent);
//		int pos = Integer.parseInt(noteID)-1;
//		filecontent=  filecontent.substring(0,pos)+"b"+filecontent.substring(pos+1);
//		System.out.println(filecontent);
//		writeFile(filecontent,"note.config",tmpPath);
//	}

	private void writeFile(String testtext, String filename, String tmpPath) {
		File file = new File(tmpPath+"/"+filename);
		// TODO Auto-generated method stub
		 try {
			   org.apache.commons.io.FileUtils.writeStringToFile(file, testtext, "utf8");
			  } catch (IOException e) {
			   e.printStackTrace();
			  }
	}


	private String addNoteFile() {
		int NoteID = nextNoteID();
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
	private void getAllExistedNotes() throws IOException {
		File file = new File(tmpPath);
		File[] tempList = file.listFiles();
		File confile = new File(con);
		char[] confilecontent = org.apache.commons.io.FileUtils.readFileToString(confile, "utf8").toCharArray();
		String filename = null;
		for (int i=0;i<tempList.length-1;i++){
			if (confilecontent[i]=='a'){
				String fileString=getFileString(tempList[i]);
				filename=tempList[i].toString().substring(tempList[i].toString().lastIndexOf("\\")+1);
				Note note = new Note(filename.substring(0,filename.length()-4),fileString);
				notes.add(note);
			}
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
