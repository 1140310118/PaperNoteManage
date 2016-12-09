package base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileOp {
	private String tmpPath = "M:/myGitHub/SE/PaperNoteManage/WebContent/file/zzh19971968@foxmail.com/test/note";
	
	//创建文件
	
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
	//读文件
	public static String getFileString(File file) {
        try {
            String fileString = FileUtils.readFileToString(file,"utf8");
            return fileString;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	//写文件
	private void writeFile(String testtext, String filename, String tmpPath) {
		File file = new File(tmpPath+"/"+filename);
		// TODO Auto-generated method stub
		 try {
			   org.apache.commons.io.FileUtils.writeStringToFile(file, testtext, "utf8");
			  } catch (IOException e) {
			   e.printStackTrace();
			  }
	}

}
