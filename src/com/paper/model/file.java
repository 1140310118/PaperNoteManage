package com.paper.model;

import java.io.*;

public class file 
{
//    private String name;
//    private int age;
    private File resume;
    private String resumeContentType;
    private String resumeFileName;
//	public String getName()
//	{
//		return name;
//	}
//	public void setName(String name)
//	{
//		this.name = name;
//	}
//	public int getAge()
//	{
//		return age;
//	}
//	public void setAge(int age)
//	{
//		this.age = age;
//	}
	public File getResume()
	{
		//System.out.println(resume+"8888");
		return resume;
		
	}
	public void setResume(File resume)
	{
		this.resume = resume;
	}
	public String getResumeContentType()
	{
		return resumeContentType;
	}
	public void setResumeContentType(String resumeContentType)
	{
		this.resumeContentType = resumeContentType;
	}
	public String getResumeFileName()
	{
		return resumeFileName;
	}
	public void setResumeFileName(String resumeFileName)
	{
		//System.out.println(resume+"6666");
		this.resumeFileName = resumeFileName;
	}
    
    
}
