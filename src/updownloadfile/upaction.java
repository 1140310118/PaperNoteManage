package updownloadfile;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.ActionSupport;
import java.io.*;
import model.file;

public class upaction extends ActionSupport implements
		ModelDriven<file>
{
	private file singleFile = new file();

	public file getModel()
	{
		return singleFile;
	}
    public void validate()
    {
    	String filename = singleFile.getResumeFileName();
    	//System.out.println( singleFile.getResumeFileName()+"3333");
    	if(filename == null)
    	{
    		addFieldError("resume", "请上传文件.");
    	}
    	else if(!filename.toLowerCase().endsWith(".doc"))
    	{
    		addFieldError("resume", "ֻ请上传word文档.");
    	}    	
    }
	public String execute() throws Exception
	{
		String root = "d:\\upload\\";
		File rootFile = new File(root);
		if(!rootFile.exists())
		{
			rootFile.mkdir();
		}
		String filename = root + singleFile.getResumeFileName();		
		FileInputStream fis = new FileInputStream(singleFile.getResume());
		FileOutputStream fos = new FileOutputStream(filename);
		byte[] buffer = new byte[8192];
		int n = 0;
		while((n = fis.read(buffer)) > 0)
		{
			fos.write(buffer, 0, n);
		}
		fos.close();
		fis.close();
		System.out.println( singleFile.getResumeFileName());
		System.out.println( singleFile.getResumeContentType());
		return "success";
	} 

}
