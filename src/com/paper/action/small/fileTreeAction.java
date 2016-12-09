package com.paper.action.small;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.paper.action.CatalogAction;


public class fileTreeAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	
	// 向后台传递的参数
	private String zNones = null;
	
	// 从前台接受的参数
	private String deletePaperID = null;
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
	public String viewTree(){
		zNones=catalog.showNode(userEmail);
		return "success";
	}
	
	//-------------main_2---------------
	// 删除节点
	public String deleteNode(){
		catalog.deleteNode(deletePaperID);
		return "success";
	}

	//-------------main_3---------------
	// 新建节点
	public String newNode(){
		catalog.createNode(userEmail,pID, paperNickName);
		return "success";
	}

	//-------------main_4---------------
	// 改变节点
	public String changeNode(){
		catalog.createNode(userEmail, pID, paperNickName);
		return "success";
	}
	
	
	
	public String getzNones() {
		return zNones;
	}

	public void setzNones(String zNones) {
		this.zNones = zNones;
	}
	public String getDeletePaperID() {
		return deletePaperID;
	}

	public void setDeletePaperID(String deletePaperID) {
		this.deletePaperID = deletePaperID;
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

	
	
	

	
