package com.paper.model;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.paper.action.getMaxpaperID;

//import com.sun.java.util.jar.pack.Package.File;

public class Paper {


	public String paperNickName;
	public String paperOrigin;
	public String paperWebFilePath;


	public String paperExteriorURL;
	public String paperRemark;
	public String uploadDate;
	public String paperUserEmail;
	public String paperReadSituation;
	public String paperID;
	public String paperPID;
	public String paperIsDeleted;

	public String getPaperIsDeleted() {
		return paperIsDeleted;
	}

	public void setPaperIsDeleted(String paperIsDeleted) {
		this.paperIsDeleted = paperIsDeleted;
	}

	public String getPaperID() {
		return paperID;
	}

	public void setPaperID(String paperID) {
		this.paperID = paperID;
	}

	public String getPaperPID() {
		return paperPID;
	}

	public void setPaperPID(String paperPID) {
		this.paperPID = paperPID;
	}

	public String getPaperReadSituation() {
		return paperReadSituation;
	}

	public void setPaperReadSituation(String paperReadSituation) {
		this.paperReadSituation = paperReadSituation;
	}

	public String getPaperWebFilePath() {
		return paperWebFilePath;
	}

	public void setPaperWebFilePath(String paperWebFilePath) {
		this.paperWebFilePath = paperWebFilePath;
	}
	public String getPaperUserEmail() {
		return paperUserEmail;
	}

	public void setPaperUserEmail(String paperUserEmail) {
		this.paperUserEmail = paperUserEmail;
	}

	public String getPaperNickName() {
		return paperNickName;
	}

	public void setPaperNickName(String paperNickName) {
		this.paperNickName = paperNickName;
	}

	public String getPaperOrigin() {
		return paperOrigin;
	}

	public void setPaperOrigin(String paperOrigin) {
		this.paperOrigin = paperOrigin;
	}

	public String getPaperExteriorURL() {
		return paperExteriorURL;
	}

	public void setPaperExteriorURL(String paperExteriorURL) {
		this.paperExteriorURL = paperExteriorURL;
	}

	public String getPaperRemark() {
		return paperRemark;
	}

	public void setPaperRemark(String paperRemark) {
		this.paperRemark = paperRemark;
	}

	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	
	public String toInsertSql(String paperWebFilePath) throws SQLException{
		String sql = new String();
//		sql ="insert into paper (paperNickName,paperOrigin,paperWebFilePath,paperExteriorURL,paperRemark,uploadDate)"
//				+ " values";
//		sql+="(";
//		sql+="'"+this.paperNickName+"',";
//		sql+="'"+this.paperOrigin+"',";
//		sql+="'"+this.paperWebFilePath+"',";
//		sql+="'"+this.paperExteriorURL+"',";
//		sql+="'"+this.paperRemark+"',";
//		sql+="'"+this.uploadDate+"'";
//		sql+=");";
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());
		getMaxpaperID maxpaperID = new getMaxpaperID();
		paperID = maxpaperID.getMaxpaperID(this.paperUserEmail);
		if(this.paperExteriorURL!=null){
			sql = "insert into paper (paperNickName,paperOrigin,"
				+ "paperExteriorURL,paperRemark,uploadDate,paperUserEmail,paperReadSituation,paperID,paperIsDeleted) "
				+ "values('" + this.paperNickName 
				+ "','" +this.paperOrigin
				+ "','" +this.paperExteriorURL
				+ "','" +this.paperRemark 
				+ "','" +date
				+ "','" +this.paperUserEmail
				+ "','" +0
				+ "','" +paperID
				+ "','" +0
				+ "');";
		}else{
			sql = "insert into paper (paperNickName,paperOrigin,paperWebFilePath,"
					+ "paperRemark,uploadDate,paperUserEmail,paperReadSituation,paperID,paperIsDeleted) "
					+ "values('" + this.paperNickName 
					+ "','" +this.paperOrigin
					+ "','" +paperWebFilePath 
					+ "','" +this.paperRemark 
					+ "','" +date
					+ "','" +this.paperUserEmail
					+ "','" +0
					+ "','" +paperID
					+ "','" +0
					+ "');";
		}
		
		return sql;
		
	}

	public void show() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());
		String s="PAPER:"
			+this.paperNickName 
			+ "','" +this.paperOrigin
			+ "','" +paperWebFilePath 
			+ "','" +this.paperExteriorURL
			+ "','" +this.paperRemark 
			+ "','" +date
			+ "','" +this.paperUserEmail
			+ "','" +this.paperReadSituation //论文阅读情况
			+ "','" +this.paperID; // 论文ID
		System.out.println("From Paper>> "+s);
	}
	public String toString(){
		String res="";
		res=this.paperNickName+","+this.paperID+","+this.paperReadSituation;
		return res;
	}
}
