package testForJsp.action;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

public class NoteManage{
	
	//所有笔记
	private ArrayList<Note> notes=new ArrayList<Note>();
	
	//添加笔记
	private String addNoteFlag = "false";
	//修改笔记
	private String modifyNoteContent=new String(); //修改后的内容
	private String modifyNoteListID = null;//待修改的笔记id
	//删除笔记
	private String deleteNoteListID = null;

// 根据情况修改
//	private String tmpPath = "D:/ecllipse/PaperNoteManage/WebContent/file/zzh19971968@foxmail.com/test/note";
//	private String con="D:/ecllipse/PaperNoteManage/WebContent/file/zzh19971968@foxmail.com/test/note/note.config";
	private String tmpPath = "M:/myGitHub/SE/PaperNoteManage/WebContent/file/zzh19971968@foxmail.com/test/note";
	private String con="M:/myGitHub/SE/PaperNoteManage/WebContent/file/zzh19971968@foxmail.com/test/note/note.config";
	
	
	public String execute() throws IOException{
		//System.out.println(tmpPath);
		
		// 新建文件
		if(addNoteFlag!="false"){
			//System.out.println("in");
			int num;
			addconfig(con);
			num=readconfig(con);
			String txt=num+".txt";
			addNoteFile(txt);
		}
		
		// 获得所有文件
		getAllExistedNotes();
		
		// 删除文件
		if(deleteNoteListID!=null){
			String deleteNoteID= ""+notes.get(Integer.parseInt(deleteNoteListID)-1).noteID;
			deleteFile(deleteNoteID,tmpPath);
			System.out.println("被删除的笔记:"+deleteNoteID);
		}
		
		// 修改文件
		if(modifyNoteListID!=null){
			String modifyNoteID= ""+notes.get(Integer.parseInt(modifyNoteListID)-1).noteID;
			writeFile(modifyNoteContent,modifyNoteID+".txt",tmpPath);
			System.out.println("被修改的笔记:"+modifyNoteID);
//			System.out.println(modifyNoteContent);
		}
		return "success";
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
		    //file.delete();
		    modifyCon_when_deleteFile(noteID);
		}
	}
	
	// 例如 config aaaaa -> aabaa 删除笔记3
 	private void modifyCon_when_deleteFile(String noteID) throws IOException{
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


	private void addNoteFile(String filename) {
		
		
		File path = new File(tmpPath);
		File dir=new File(path,filename);
		try {
			dir.createNewFile();
			System.out.println("创建成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.print("创建失败");
		}
	}

	// 获得所有笔记
	private void getAllExistedNotes() throws IOException {
		File file = new File(tmpPath);
		File[] tempList = file.listFiles();
		File confile = new File(con);
		char[] confilecontent = org.apache.commons.io.FileUtils.readFileToString(confile, "utf8").toCharArray();
		for (int i=0;i<tempList.length-1;i++){
			if (confilecontent[i]=='a'){
				String fileString=getFileString(tempList[i]);
				Note note = new Note(i+1,fileString);
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
		return deleteNoteListID;
	}


	public void setDeleteNoteListID(String deleteNoteListID) {
		this.deleteNoteListID = deleteNoteListID;
	}


	public String getModifyNoteListID() {
		return modifyNoteListID;
	}


	public void setModifyNoteListID(String modifyNoteListID) {
		this.modifyNoteListID = modifyNoteListID;
	}


	public String getModifyNoteContent() {
		return modifyNoteContent;
	}


	public void setModifyNoteContent(String modifyNoteContent) {
		this.modifyNoteContent = modifyNoteContent;
	}
	
}
