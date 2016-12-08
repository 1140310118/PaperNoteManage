package com.paper.action;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class addlog {
	ActionContext actionContext = ActionContext.getContext();
	Map session = actionContext.getSession();
	private String userEmail = (String) session.get("USER_Email");
	
	public void addreadlog (String path,String flag){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());
		path = path+"\\"+"log.txt";
		String text=null;
		if(flag.charAt(0)=='0'){
			text="未读";
		}
		if(flag.charAt(0)=='1'){
			text="已粗读";
		}
		if(flag.charAt(0)=='2'){
			text="已精读";
		}
		try {
			FileWriter writer = new FileWriter(path, true);
			writer.write(date +"	"+ text + "	" +"||"); 
			 writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	public void addcreatelog (String path){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());
		path = path+"\\"+"log.txt";
		try {
			FileWriter writer = new FileWriter(path, true);
			writer.write(date +"	"+ "创建笔记" + "	" +"||"); 
			 writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	public void adddeletelog (String path){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());
		path = path+"\\"+"log.txt";
		try {
			FileWriter writer = new FileWriter(path, true);
			writer.write(date +"	"+ "删除笔记" + "	" +"||"); 
			 writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	public void addmonidfylog (String path){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());
		path = path+"\\"+"log.txt";
		try {
			FileWriter writer = new FileWriter(path, true);
			writer.write(date +"	"+ "修改笔记" + "	" +"||"); 
			 writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	
	
	
	

}