package action.for_manage;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.io.output.FileWriterWithEncoding;

import base.db.DAO;
import base.model.Paper;
import base.model.file;
import method.general.StringandACSII;

public class NewPaper extends ActionSupport implements
		ModelDriven<file>
{
	private static final long serialVersionUID = 1L;
	private file singleFile = new file();
	private Paper paper=new Paper();
	private String fileUpFlag = "false";
	private String newPaperByURLFlag="false";

	private String newPaperFlag = "false";
	
	ActionContext actionContext = ActionContext.getContext();
	Map session = actionContext.getSession();
	private String userEmail = (String) session.get("USER_Email");
	 
	private DAO dao = new DAO();
	// panwei
	Connection conn = base.db.DbConn.getConn();
	
	
	public String getNewPaperByURLFlag() {
		return newPaperByURLFlag;
	}

	public void setNewPaperByURLFlag(String newPaperByURLFlag) {
		this.newPaperByURLFlag = newPaperByURLFlag;
	}
	
	
	public String getFileUpFlag() {
		return fileUpFlag;
	}

	public void setFileUpFlag(String fileUpFlag) {
		this.fileUpFlag = fileUpFlag;
	}
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public file getModel()
	{
		return singleFile;
	}
	
	public Paper getPaper()
	{
		return this.paper;
	}
	
	public void setPaper(Paper paper)
	{
		this.paper=paper;
	}

	//------------main------------
	//新建论文 Local URL
	public String newPaper() throws Exception{
		System.out.println("userEmail:"+userEmail);
		String root = getWebrootPath();
		System.out.println("From NewPaper.java>> root:"+root);
		if (newPaperFlag!="false"){
			if (newPaperByURLFlag!="false")
			{
				newPaperURL(root);
				return "newPaperSuccess";
			}
			if (fileUpFlag!="false"){
				newPaperLocal(root);
				return "newPaperSuccess";
			}
		}
		return "success";
	}
	private String getWebrootPath(){
		ClassLoader classLoader = Thread.currentThread()  
	            .getContextClassLoader();  
	    if (classLoader == null) {  
	        classLoader = ClassLoader.getSystemClassLoader();  
	    }  
	    java.net.URL url = classLoader.getResource("");  
	    String ROOT_CLASS_PATH = url.getPath() + "/";  
	    File rootFile = new File(ROOT_CLASS_PATH);  
	    String WEB_INFO_DIRECTORY_PATH = rootFile.getParent() + "/";  
	    File webInfoDir = new File(WEB_INFO_DIRECTORY_PATH);  
	    String SERVLET_CONTEXT_PATH = webInfoDir.getParent() + "/"; 
	    
	    String root=SERVLET_CONTEXT_PATH+"file/"+userEmail+"/";
		return root;
	}
	
	private void newPaperLocal(String root) throws Exception{
		System.out.println("新建文件 从本地");
		String paperWebFilePath=fileUp(root);
		System.out.println(paperWebFilePath);
		insertNewPaper(paperWebFilePath);
		System.out.println("UploadFileAction>> newPaperLocalSuccess");
	}
	
	private void newPaperURL(String root) throws Exception{
		System.out.println("新建文件 从URL");
		if(paper.paperExteriorURL.length()>=7){
			if( !(paper.paperExteriorURL.substring(0,7).equals("http://")) ){
				paper.paperExteriorURL = "http://" + paper.paperExteriorURL;
			}
		}
		else{
			paper.paperExteriorURL = "http://" + paper.paperExteriorURL;
		}
		
		insertNewPaper(paper.paperExteriorURL);
		
		System.out.println(paper.paperExteriorURL);
		
		
		String nickName=str2ascii(this.paper.paperNickName);
		String rootnull=createInitFile(root,nickName);
	}
	
	// 向数据库中插入 paper 对象	
	private void insertNewPaper(String paperWebFilePath) throws SQLException {
		String sql=this.paper.toInsertSql(paperWebFilePath);
		System.out.println(sql);
		//sql += " "
		int rs=dao.executeUpdate(sql);//"insert into paper values('fasfsdf','','null','null','null','null')");
		System.out.println(rs);
	}

	// 将文件上传到 root 目录	
	public String fileUp(String root) throws Exception
	{
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//		String date = df.format(new Date());
//		
//		File rootFile = new File(root);
//		if(!rootFile.exists())
//		{
//			rootFile.mkdir();
//		}
//
//		//String root1 = root+(singleFile.getResumeFileName()).substring(0,(singleFile.getResumeFileName()).length()-4);
		String nickName=str2ascii(this.paper.paperNickName);
//		String root1=root+nickName;
//		// 
//		File rootFile1 = new File(root1);
//		if(!rootFile1.exists())
//		{
//			rootFile1.mkdir();
//			String filename3 = "log.txt";
//			File path1 = new File(root1);
//			File dir1=new File(path1,filename3);
//			dir1.createNewFile();
//			String shangchuan = root1+"\\"+"log.txt";
//			FileWriter writer = new FileWriter(shangchuan, true);
//			writer.write(date +"	"+ "上传系统" + "	" +"||"); 
//			 writer.close();
//			String root2=root1+"\\note\\";
//			File rootFile2 = new File(root2);
//			if(!rootFile2.exists())
//			{
//				rootFile2.mkdir();
//				String filename2 = "note.config";
//				File path = new File(root2);
//				File dir=new File(path,filename2);
//				dir.createNewFile();
//			}
//			
//		}
		String root1= createInitFile(root,nickName);
		
		String pdfName=singleFile.getResumeFileName();
		pdfName=pdfName.substring(0,pdfName.length()-4);
		//System.out.println("FROM NP.java>> pdfName:"+pdfName);
		pdfName=str2ascii(pdfName)+".pdf";
		
		String filename = root1+"\\" + pdfName;
		
		System.out.println("FROM NP.java>> filename:"+filename);
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
		//System.out.println( singleFile.getResumeFileName());
		//System.out.println( singleFile.getResumeContentType());
		filename = filename.replaceAll("\\\\","/");
		//System.out.println("反倒是"+filename);
		String res = userEmail+"/"+nickName+"/"+pdfName;
		//res = URLEncoder.encode(res,"utf-8");
		System.out.println("FROM NewPaper.java>> "+res);
		return res;
	}
	//
	private String createInitFile(String root,String nickName) throws IOException{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());
		
		System.out.println("194");
		File rootFile = new File(root);
		if(!rootFile.exists())
		{
			rootFile.mkdir();
		}
		String root1=root+nickName;
		File rootFile1 = new File(root1);
		if(!rootFile1.exists())
		{
			rootFile1.mkdir();
			String filename3 = "log.txt";
			File path1 = new File(root1);
			File dir1=new File(path1,filename3);
			try {
				dir1.createNewFile();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String shangchuan = root1+"\\"+"log.txt";
			FileWriterWithEncoding writer = null;
			try {
				writer = new FileWriterWithEncoding(shangchuan,"utf8", true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//org.apache.commons.io.FileUtils.w writeStringToFile(shangchuan, testtext, "utf8");
			try {
				writer.write(date +"	"+ "上传系统");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			try {
				writer.write("\r\n");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {
				writer.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 String filename4 = "Readtime.txt";
			 File path2 = new File(root);
			 File dir2=new File(path2,filename4);
			 try {
				dir2.createNewFile();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String root2=root1+"\\note\\";
			File rootFile2 = new File(root2);
			if(!rootFile2.exists())
			{
				rootFile2.mkdir();
				String filename2 = "note.config";
				File path = new File(root2);
				File dir=new File(path,filename2);
				try {
					dir.createNewFile();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		return root1;
	}
	
	private String str2ascii(String s){
		return StringandACSII.showIntArray(StringandACSII.string2ASCII(s), "H");
	}

	

	public String getNewPaperFlag() {
		return newPaperFlag;
	}

	public void setNewPaperFlag(String newPaperFlag) {
		this.newPaperFlag = newPaperFlag;
	} 
}
