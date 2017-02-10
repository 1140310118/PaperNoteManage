package tmp;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import base.model.Book;

public class BookAction extends ActionSupport {
	private String type; 
	private BookOper bo = new BookOper(); // 查询类
	private List<Book> data;
	private static final String  inCode = "ISO-8859-1";
    private static final String  outCode  = "gb2312";
	
	public String getType() {
		
		return type;
	}

	public void setType(String type) {



		this.type = type;
	}
	

	
	public String selectbytype () {
		// TODO Auto-generated method stub
		// 查询结果放在request中
		System.out.println(type);
		ActionContext.getContext().put("booklist", bo.selectByType(type));
		// 返回success指定的页面
		return SUCCESS; // "success"
	}
	public String selectbyid () {
		// TODO Auto-generated method stub
		// 查询结果放在request中
		//System.out.println(type);
		ActionContext.getContext().put("booklist", bo.selectByid(type));
		// 返回success指定的页面
		return SUCCESS; // "success"
	}
	public String selectbyid1 () {
		// TODO Auto-generated method stub
		// 查询结果放在request中
		//System.out.println(type);
		ActionContext.getContext().put("booklist", bo.selectByid(type));
		// 返回success指定的页面
		return SUCCESS; // "success"
	}

	
	public String deleteByType()
	{

		//System.out.println(text+"***");
		if(bo.deleteByType(type,"")==1){
			//System.out.println("del111");
			return "delete";
		}
			
		//System.out.println("del222");
		return "delete";
	}
}