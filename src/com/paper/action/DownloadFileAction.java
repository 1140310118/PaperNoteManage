package com.paper.action;

import com.opensymphony.xwork2.ActionSupport;
import java.io.*;

public class DownloadFileAction extends ActionSupport
{
	private String filename;
    
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename)
	{
		this.filename = filename;
		System.out.println(filename+"...");
	}
    
	@Override
	public void validate()
	{
		if("system.ini".equalsIgnoreCase(filename))
		{
			addActionError("system.ini�ļ���������.");
			System.out.println(",,,,");
			return ;
		}
	}

	public InputStream getTargetInputStream() throws Exception
	{
		
		String downloadFilename = "d:\\upload\\" + filename;		
		if(new File(downloadFilename).exists())
		{
			FileInputStream fis = new FileInputStream(downloadFilename);
			System.out.println(fis+"***");
			return fis;
		}
		else
		{
			System.out.println("+++");
			return null;
		}
	}

	public String execute()
	{
		System.out.println("---");
		return "success";
	}
}
