package testForJsp.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

public class Note {
	
	private ArrayList<String> notes=new ArrayList<String>();
	private String addNoteFlag = "false";
	
	private String tmpPath = "M:/myGitHub/SE/PaperNoteManage/Webcontent/file/zzh19971968@foxmail.com/test/note";
	
	
	public String execute(){
		System.out.println(tmpPath);
		if(addNoteFlag!="false"){
			System.out.println("in");
			addNoteFile("9.txt");
		}
		getAllExistedNotes();
		return "success";
	}

	private void addNoteFile(String filename) {
		
		
		File path = new File(tmpPath);
		File dir=new File(path,filename);
		try {
			dir.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.print("创建失败");
		}
	}

	private void getAllExistedNotes() {
		File file = new File(tmpPath);
		File[] tempList = file.listFiles();
		for (int i=0;i<tempList.length;i++){
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
