package com.paper.action.small;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.paper.action.CatalogAction;

import base.translate;


public class fileTreeAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	
	// 向后台传递的参数
	private String ztreeNodes = null;


	public String getZtreeNodes() {
		return ztreeNodes;
	}

	public void setZtreeNodes(String ztreeNodes) {
		this.ztreeNodes = ztreeNodes;
	}

	// 从前台接受的参数
	private String paperID = null;
	private String pID = null;
	private String paperNickName = null;
	
	// 获得用户email
	ActionContext actionContext = ActionContext.getContext();
	Map<String, Object> session = actionContext.getSession();
	private String userEmail = (String) session.get("USER_Email");

	// 调用 CatalogAction 中的方法
	private CatalogAction catalog = new CatalogAction(); 
	
	//-------------main_1---------------
	// 显示树
	public String viewTree() throws SQLException{
		ztreeNodes=catalog.showNode(userEmail);
		System.out.println("FROM fileTreeAction: "+ztreeNodes);
		return "success";
	}
	
	//-------------main_2---------------
	// 删除节点
	public String deleteNode() throws SQLException{
		catalog.deleteNode(userEmail,paperID);
		return "success";
	}

	//-------------main_3---------------
	// 新建节点
	// 返回值
	public void newNode() throws IOException, SQLException{
		String id = catalog.createNode(userEmail,pID, paperNickName);
		
		HttpServletResponse response=ServletActionContext.getResponse();
		/* 
	     * 在调用getWriter之前未设置编码(既调用setContentType或者setCharacterEncoding方法设置编码), 
	     * HttpServletResponse则会返回一个用默认的编码(既ISO-8859-1)编码的PrintWriter实例。这样就会 
	     * 造成中文乱码。而且设置编码时必须在调用getWriter之前设置,不然是无效的。 
	     * */  
		response.setContentType("text/html;charset=utf-8");  
	    //response.setCharacterEncoding("UTF-8");  
	    PrintWriter out = response.getWriter();  
	    //JSON在传递过程中是普通字符串形式传递的，这里简单拼接一个做测试  
	    String jsonString=id;  
	    out.println(jsonString);  
	    out.flush();  
	    out.close();  
	}
	

	//-------------main_4---------------
	// 改变节点
	public String changeNode(){
		catalog.changeNode(userEmail, paperID, pID);
		return "success";
	}
	public String renameNode(){
		catalog.rename(userEmail, paperID, paperNickName);
		return "success";
	}
	
	
	
	
	public String getPaperID() {
		return paperID;
	}

	public void setPaperID(String paperID) {
		this.paperID = paperID;
	}
	
	public String getpID() {
		return pID;
	}

	public void setpID(String pID) {
		this.pID = pID;
	}

	public String getPaperNickName() {
		return paperNickName;
	}

	public void setPaperNickName(String paperNickName) {
		this.paperNickName = paperNickName;
	}

	

}

	
	
	

	
