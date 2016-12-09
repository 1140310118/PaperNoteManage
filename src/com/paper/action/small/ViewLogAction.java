package com.paper.action.small;

import java.io.File;

import com.opensymphony.xwork2.ActionSupport;

import base.FileOp;

public class ViewLogAction extends ActionSupport
{
	public String logContent = null;
	public String filePath = null;
	private static final long serialVersionUID = 1L;
	
	public String getLogContent() {
		return logContent;
	}
	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String showLog(){
		File file = new File(filePath);
		logContent = FileOp.getFileString(file);
		System.out.println("FROM ViewLogAction>> "+filePath+":"+logContent);
		return "success";
	}

}
