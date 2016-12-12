package com.paper.action;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.output.FileWriterWithEncoding;

public class Readtime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addreadtim("0-1 课程简介","pw@163.com");
		String get=getreadtime("0-1 课程简介","pw@163.com");
		System.out.println(get);
	}
	public static void addreadtim(String pickname,String useremail){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());
		
		String addreadtime = "D:\\upload\\"+useremail+"\\"+pickname+"\\"+"Readtime.txt";
		FileWriterWithEncoding writer;
		try {
//			writer = new FileWriter(addreadtime, true);
//			writer.write(date +"	"+ "阅读" +"\n"); 
//			writer.close();
			writer = new FileWriterWithEncoding(addreadtime,"utf8", true);
			writer.write("\n"+date +"	"+ "阅读" ); 
			writer.write("\r\n");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static String getreadtime(String pickname,String useremail){
		String getreadtime = "D:\\upload\\"+useremail+"\\"+pickname+"\\"+"Readtime.txt";
		File file = new File(getreadtime);
		try {
			String fileString = FileUtils.readFileToString(file,"utf8");
			return fileString;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
