package com.paper.action;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.io.output.FileWriterWithEncoding;

import com.opensymphony.xwork2.ActionContext;

public class addlog {
	ActionContext actionContext = ActionContext.getContext();
	Map session = actionContext.getSession();
	private String userEmail = (String) session.get("USER_Email");
	
	// tree
	public void addModifyClasslog(String path,String oldC,String newC){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());
		path = path+"\\"+"log.txt";
		try {
			FileWriterWithEncoding writer = new FileWriterWithEncoding(path,"utf8", true);
			writer.write(date +"	"+ "更改分类:" + oldC +" ->" + newC ); 
			writer.write("\r\n");
			 writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	public void addModifyClasslog(String path,String newC){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());
		path = path+"\\"+"log.txt";
		try {
			FileWriterWithEncoding writer = new FileWriterWithEncoding(path,"utf8", true);
			writer.write(date +"	"+ "更改分类为 " + newC ); 
			writer.write("\r\n");
			 writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	

	// for fileListAction
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
			FileWriterWithEncoding writer = new FileWriterWithEncoding(path,"utf8", true);
			writer.write(date +"	"+ text );
			writer.write("\r\n");
			 writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	

	// for notemanage
	public void addcreatelog (String path ,String noteID){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());
		path = path+"\\"+"log.txt";
		try {
			FileWriterWithEncoding writer = new FileWriterWithEncoding(path,"utf8", true);
			writer.write(date +"	"+ "创建笔记 "+noteID ); 
			writer.write("\r\n");
			 writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	// for notemanage
	public void adddeletelog (String path, String deleteNoteID){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());
		path = path+"\\"+"log.txt";
		try {
			FileWriterWithEncoding writer = new FileWriterWithEncoding(path,"utf8", true);
			writer.write(date +"	"+ "删除笔记 "+deleteNoteID ); 
			writer.write("\r\n");
			 writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void addmonidfylog (String path,String noteID){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());
		path = path+"\\"+"log.txt";
		try {
			FileWriterWithEncoding writer = new FileWriterWithEncoding(path,"utf8", true);
			writer.write(date +"	"+ "修改笔记 "+noteID); 
			writer.write("\r\n");
			 writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}

	
	
	
	

}
