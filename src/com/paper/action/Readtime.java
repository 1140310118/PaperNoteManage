package com.paper.action;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Readtime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addreadtim("0-1 课程简介","pw@163.com");
	}
	public static void addreadtim(String pickname,String useremail){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());
		
		String addreadtime = "D\\upload\\"+useremail+"\\"+pickname+"Readtime.txt";
		FileWriter writer;
		try {
			writer = new FileWriter(addreadtime, true);
			writer.write(date +"	"+ "阅读" +"\n"); 
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
