package com.paper.action.small;

import java.sql.SQLException;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.paper.action.CatalogAction;


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
	public String viewTree() throws SQLException{
		ztreeNodes=catalog.showNode(userEmail);
		System.out.println("FROM fileTreeAction: "+ztreeNodes);
		return "success";
	}
	
	//-------------main_2---------------
	// 删除节点
	public String deleteNode(){
		catalog.deleteNode(userEmail,deletePaperID);
		return "success";
	}

	//-------------main_3---------------
	// 新建节点
	public String newNode() throws SQLException{
		catalog.createNode(userEmail,pID, paperNickName);
		return "success";
	}

	//-------------main_4---------------
	// 改变节点
	public String changeNode(){
		catalog.changeNode(userEmail, pID, paperNickName);
		return "success";
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

	
	
	

	
