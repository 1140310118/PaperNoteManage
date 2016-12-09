package com.paper.action.small;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.paper.action.CatalogAction;
import com.paper.action.RecycleBinAction;
import com.paper.model.Paper;


public class SRecycleBinAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	
	// 向后台传递的参数
	private ArrayList<Paper> papers = new ArrayList<Paper>();
	
	// 从前台接受的参数
	private String paperID = null;
	
	// 获得用户email
	ActionContext actionContext = ActionContext.getContext();
	Map<String, Object> session = actionContext.getSession();
	private String userEmail = (String) session.get("USER_Email");

	// 调用 RecycleBinAction 中的方法
	private RecycleBinAction rb = new RecycleBinAction(); 
	
	
	
	//-------------main_1---------------
	// 显示回收站
	public String viewRB(){
		papers=rb.getRecycleBin(userEmail);
		return "success";
	}
	
	//-------------main_2---------------
	// 恢复回收站中的文件 --恢复到未分类中
	public String restorePaper(){
		rb.restorePaper(userEmail,paperID);
		return "success";
	}

	//-------------main_3---------------
	// 彻底删除回收站中的文件
	public String deletePaperAbsolutely(){
		rb.deleteAbsolutely(userEmail,paperID);
		return "success";
	}
	
	public String getPaperID() {
		return paperID;
	}

	public void setPaperID(String paperID) {
		this.paperID = paperID;
	}
	
	public ArrayList<Paper> getPapers() {
		return papers;
	}

	public void setPapers(ArrayList<Paper> papers) {
		this.papers = papers;
	}
	

}

	
	
	

	
