package testForJsp.action;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

public class Note {
	
	private ArrayList<String> notes=new ArrayList<String>();
	private String addNoteFlag = "false";
	private String testtext="最后一个";
	//private String tmpPath = "D:/ecllipse/PaperNoteManage/WebContent/file/zzh19971968@foxmail.com/test/note";
	//private String con="D:/ecllipse/PaperNoteManage/WebContent/file/zzh19971968@foxmail.com/test/note/config";
	private String tmpPath = "M:/myGithub/SE/PaperNoteManage/WebContent/file/zzh19971968@foxmail.com/test/note";
	private String con="M:/myGithub/SE/PaperNoteManage/WebContent/file/zzh19971968@foxmail.com/test/note/config";
		
	
	public String execute(){
		//System.out.println(tmpPath);
		int num;
		num=readconfig(con);
		String txt=num+".txt";
		if(addNoteFlag!="false"){
			//System.out.println("in");
			addNoteFile(txt);
		}
		
		addconfig(con);
		writeFile(testtext,txt,tmpPath);
		deleteFile("11.txt",tmpPath);
		getAllExistedNotes();
		return "success";
	}


	private int readconfig(String con) {
		// TODO Auto-generated method stub
		File file = new File(con);
		String filecontent=null,num;
		try {
				filecontent = org.apache.commons.io.FileUtils.readFileToString(file, "utf8");
				System.out.println(filecontent);
				System.out.println(filecontent.length());
				return filecontent.length();
			  } catch (IOException e) {
			   e.printStackTrace();
			  }
		return filecontent.length();
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


	private void deleteFile(String filename, String tmpPath) {
		// TODO Auto-generated method stub
		File file = new File(tmpPath+"/"+filename);
		if(file.exists())
		    file.delete();
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

	private void getAllExistedNotes() {
		File file = new File(tmpPath);
		File[] tempList = file.listFiles();
		for (int i=0;i<tempList.length-1;i++){
			String fileString=getFileString(tempList[i]);
			notes.add(fileString);
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

	public ArrayList<String> getNotes() {
		return notes;
	}

	public void setNotes(ArrayList<String> notes) {
		this.notes = notes;
	}

	public String getAddNoteFlag() {
		return addNoteFlag;
	}

	public void setAddNoteFlag(String addNote) {
		this.addNoteFlag = addNote;
	}
	
}
