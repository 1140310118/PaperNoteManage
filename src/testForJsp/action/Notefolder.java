package testForJsp.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

class NoteFolder {
	private String path= new String();
	private ArrayList<String> noteStringArray = new ArrayList<String>();
	
	public void build(String path){
		this.path=path;
		File file = new File(path);
		File[] tempList = file.listFiles();
		for (int i=0;i<tempList.length;i++){
			String fileString=getFileString(tempList[i]);
			noteStringArray.add(fileString);
		}
	}
	
	private static String getFileString(File file) {
        try {
            String fileString = FileUtils.readFileToString(file,"utf8");
            return fileString;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
