package action.for_manage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import base.model.Paper;
import method.general.CatalogAction;
import method.general.RecycleBinAction;


public class SRecycleBinAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	
	// 向后台传递的参数
	private ArrayList<String> papers = new ArrayList<String>();
	
	// 从前台接受的参数
	private String paperNickName = null;
	
	// 获得用户email
	ActionContext actionContext = ActionContext.getContext();
	Map<String, Object> session = actionContext.getSession();
	private String userEmail = (String) session.get("USER_Email");

	// 调用 RecycleBinAction 中的方法
	private RecycleBinAction rb = new RecycleBinAction(); 
	
	
	
	//-------------main_1---------------
	// 显示回收站
	public String viewRB() throws SQLException{
		papers=(ArrayList<String>) rb.getRecycleBin(userEmail);
		return "success";
	}
	
	//-------------main_2---------------
	// 恢复回收站中的文件 --恢复到未分类中
	public String restorePaper(){
		rb.recoverPaper(userEmail,paperNickName);
		return "success";
	}

	//-------------main_3---------------
	// 彻底删除回收站中的文件
	public String deletePaperAbsolutely(){
		rb.completelyRemovePaper(userEmail,paperNickName);
		return "success";
	}
	
	public String getPaperNickName() {
		return paperNickName;
	}

	public void setPaperNickName(String paperNickName) {
		this.paperNickName = paperNickName;
	}
	
	public ArrayList<String> getPapers() {
		return papers;
	}

	public void setPapers(ArrayList<String> papers) {
		this.papers = papers;
	}
	

}

	
	
	

	
