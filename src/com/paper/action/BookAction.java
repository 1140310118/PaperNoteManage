package com.paper.action;

import com.paper.action.BookOper;
import com.paper.model.Book;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String type; 
	private BookOper bo = new BookOper(); // ��ѯ��
	private List<Book> data;
	private String text;
	private int id;
	private static final String  inCode = "ISO-8859-1";
    private static final String  outCode  = "gb2312";
	
    public int getId() {
		
		return id;
	}

	public void setId(int id) {



		this.id = id;
	}
	public String getText() {
		
		return text;
	}

	public void setText(String text) {
		byte[] tempByte = null;
		try {
			tempByte = text.getBytes(inCode);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			text = new String(tempByte,outCode);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		this.text = text;
	}
	
	
	public String getType() {
		
		return type;
	}

	public void setType(String type) {



		this.type = type;
	}
	

	
	public String selectbytype () {
		// TODO Auto-generated method stub
		// ��ѯ�������request��
		System.out.println(type);
		ActionContext.getContext().put("booklist", bo.selectByType(type));
		// ����successָ����ҳ��
		return SUCCESS; // "success"
	}
	public String selectbyid () {
		// TODO Auto-generated method stub
		// ��ѯ�������request��
		//System.out.println(type);
		ActionContext.getContext().put("booklist", bo.selectByid(id));
		// ����successָ����ҳ��
		return SUCCESS; // "success"
	}
	
	public String update(){
		if(bo.update(id,type,text)==1){
			//System.out.println("del111");
			return "success";
		}
		return "success";
	}
	
	
	public String deleteByType()
	{

		System.out.println(text+"***");
		if(bo.deleteByType(text)==1){
			//System.out.println("del111");
			return "delete";
		}
			
		//System.out.println("del222");
		return "delete";
	}
}
