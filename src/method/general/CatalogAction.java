package method.general;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.opensymphony.xwork2.ActionContext;

import base.db.DAO;

public class CatalogAction {
	private DAO dao = new DAO();
	ActionContext actionContext = ActionContext.getContext();

//	public static void main(String[] args) throws SQLException {
		// 1.changeNode方法测试通过
//		CatalogAction catalog = new CatalogAction();
		// System.out.println(catalog.changeNode("zorenv@163.com","5","21"));

		// 2.deleteNode方法测试
		// catalog.deletePaper("zorenv@163.com", "21");
//		System.out.println("CatalogAction: deleteNode返回的列表: " + catalog.deleteNode("zorenv@163.com", "43"));

		// 3.createNode方法测试通过
		// System.out.println(catalog.createNode("zorenv@163.com","1","机器学习"));

		// 4.showNode方法测试通过
		// System.out.println(catalog.showNode("zorenv@163.com"));

		// 5.rename方法测试
		// catalog.rename("zorenv@163.com", "2", "Lab1");
		//
//	}

	// 拖拽节点
	public String changeNode(String userEmail, String id, String pid) {
		// 更改当前节点的PID，实现拖拽功能
		// UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
		String sql = "UPDATE paper SET paperPID = " + "'" + pid + "'" + " WHERE paperID = " + "'" + id + "'"
				+ " AND paperUserEmail = " + "'" + userEmail + "'";
		System.out.println(sql);
		int rS = dao.executeUpdate(sql);
		if (rS > -1)
			return "changeNodesuccess";
		return "changeNodefail";
	}

	// 删除节点
	// 返回加入未分类的节点
	public String deleteNode(String userEmail, String id) throws SQLException {
		// 非递归：
		// 1.删除当前节点
		// 2.删除以当前节点为父节点的节点
		// 直到当前节点没有儿子节点
		int i = 0; // number of paper
		String papernodes = "["; // 用来返回叶节点
		String[][] paper;
		CatalogAction catalog = new CatalogAction();
		paper = catalog.getPaper(userEmail);
		// i = paper.length;
		// int k = 0;
		while (paper[i][0] != null)
			i++;
		Queue<String> pidqueue = new LinkedList<String>();
		// 删除第一个节点
		System.out.println("paper的数量：" + i);
		for (int j = 0; j < i; j++) {
			// 如果是要删除的节点
			if (paper[j][0].equals(id)) {
				System.out.println("要删除的节点id是：" + paper[j][0]);
				// 如果该节点是叶节点，不删除，改为未分类
				if (paper[j][2] != null || paper[j][3] != null) {
					catalog.changePaper(userEmail, paper[j][0]);
					System.out.println("CatalogAction: 叶节点论文名称是:" + paper[j][4]);
//					papernodes.add(paper[j][4]);
					papernodes += "{name:\"" + paper[j][4] + "\",id:\"" + paper[j][0] + "\"},";
					// catalog.changePaper(userEmail, paper[j][0]);
				}
				// 如果是非叶节点，直接删除该节点，并添加到pidqueue中
				else {
					catalog.deletePaper(userEmail, paper[j][0]);
					pidqueue.offer(paper[j][0]);
					System.out.println("删除第一个节点后pidqueue为：" + pidqueue);
				}
				paper = catalog.getPaper(userEmail);
				i = 0;
				while (paper[i][0] != null)
					i++;
				System.out.println("删除第一个节点后，剩余节点数量为：" + i);
			}
		}
		// 删除以pidqueue中id为pid的节点
		String pid = pidqueue.poll();
		System.out.println("第一个pid为：" + pid);
		while (pid != null) {
			System.out.println("开始进行pidqueue中的删除，此时pid为：" + pid);
			for (int j = 0; j < i; j++) {
				// 如果该节点的pid为pid，删除该节点，并把该节点添加到pidqueue中
				System.out.println("paperPID:" + paper[j][1]);
				if (paper[j][1].equals(pid)) {
					System.out.println("开始进行删除");
					// 如果是叶节点，成为未分类
					if (paper[j][2] != null || paper[j][3] != null) {
						System.out.println("CatalogAction 要设置成未分类的叶节点：" + paper[j][0]);
						catalog.changePaper(userEmail, paper[j][0]);
//						papernodes.add(paper[j][4]);
						papernodes += "{name:\"" + paper[j][4] + "\",id:\"" + paper[j][0] + "\"},";
//						break;
						// System.out.println("FROM clA>>
						// paperID:"+paper[j][0]);

					} else {// 否则，删除
						catalog.deletePaper2(userEmail, paper[j][1]);
						pidqueue.offer(paper[j][0]);
						System.out.println("新加入的pid为：" + paper[j][0]);
//						paper = catalog.getPaper(userEmail);
//						i = 0;
//						while (paper[i][0] != null)
//							i++;
//						System.out.println("剩余节点数量为：" + i);
					}
				}

			}
			// 更新pid
			pid = pidqueue.poll();
			paper = catalog.getPaper(userEmail);
			i = 0;
			while (paper[i][0] != null)
				i++;
			System.out.println("剩余节点数量为：" + i);

		}
		papernodes += "]";
		System.out.println("CatalogAction : DeleteNode : " + papernodes);
		return papernodes;
	}

	// 新增节点
	public String createNode(String userEmail, String pid, String paperNickName) throws SQLException {
		// 1.当前节点生成一个id
		String paperID = "";
		getMaxpaperID maxpaperID = new getMaxpaperID();
		paperID = maxpaperID.getMaxpaperID(userEmail);
		System.out.println("新生成的paperID为：" + paperID);

		// 2.当前节点插入paper中
		// insert into t_user(id, username) values(10, "hehehe");
		String sql = "INSERT INTO paper(paperNickName, paperUserEmail, paperID, paperPID, paperIsDeleted) VALUES(" + "'" + paperNickName
				+ "', " + "'" + userEmail + "', '" + paperID + "', " + "'" + pid + "' ,'0')";
		System.out.println(sql);
		int rS = dao.executeUpdate(sql);
		if (rS > -1)
			return paperID;
		return "createNodefail";

	}

	// 显示节点
	public String showNode(String userEmail) throws SQLException {
		// 生成zNodesList，用于前台显示分类文件目录
		String zNodesList = "";
		// 1.从mysql获得所有paper的paperNickName，paperID，paperPID
		String sql = "SELECT * FROM paper WHERE paperUserEmail = '" + userEmail + "' AND paperIsDeleted = 0";
		System.out.println(sql);
		ResultSet rS = dao.executeQuery(sql);

		// 2.用所有paper信息生成zNodesList
		while (rS.next()) {
			String paperID = rS.getString("paperID");
			String paperPID = rS.getString("paperPID");
			String paperNickName = rS.getString("paperNickName");
			String paperWebFilePath = rS.getString("paperWebFilePath");
			String paperExteriorURL = rS.getString("paperExteriorURL");
			// System.out.println("paperWebFilePath:" + paperWebFilePath);
			// System.out.println("paperExteriorURL:" + paperExteriorURL);

			if (paperWebFilePath == null && paperExteriorURL == null)
				zNodesList += "{ id:" + paperID + ", pId:" + paperPID + ", name:" + "\"" + paperNickName + "\""
						+ ",isParent:true},";
			else
				zNodesList += "{ id:" + paperID + ", pId:" + paperPID + ", name:" + "\"" + paperNickName
						+ "\",drop:false},";
		}
		return zNodesList;
	}

	// 删除一个paper
	public void deletePaper(String userEmail, String paperID) {
		// delete from 表名 where id=1;
		String sql = "DELETE FROM paper WHERE paperUserEmail = '" + userEmail + "' AND paperID = '" + paperID + "'";
		System.out.println(sql);
		int rS = dao.executeUpdate(sql);
	}

	// 删除一个paper
	public void deletePaper2(String userEmail, String paperID) {
		// delete from 表名 where id=1;
		String sql = "DELETE FROM paper WHERE paperUserEmail = '" + userEmail + "' AND paperPID = '" + paperID + "'";
		System.out.println(sql);
		int rS = dao.executeUpdate(sql);
	}

	// 获取所有paper
	public String[][] getPaper(String userEmail) throws SQLException {
		String paper[][] = new String[50][5];
		int i = 0;
		String sql = "SELECT * FROM paper WHERE paperUserEmail = '" + userEmail + "'";
		System.out.println(sql);
		ResultSet rS = dao.executeQuery(sql);
		while (rS.next()) {
			String paperID = rS.getString("paperID");
			String paperPID = rS.getString("paperPID");
			String paperWebFilePath = rS.getString("paperWebFilePath");
			String paperExteriorURL = rS.getString("paperExteriorURL");
			String paperNickName = rS.getString("paperNickName");
			paper[i][0] = paperID;
			paper[i][1] = paperPID;
			paper[i][2] = paperWebFilePath;
			paper[i][3] = paperExteriorURL;
			paper[i][4] = paperNickName;
			System.out.println("paperID:" + paper[i][0] + " paperPID:" + paperPID + " paperNickName:" + paperNickName);
			i++;
		}
		return paper;
	}

	// 把一个paper加入到未分类
	public void changePaper(String userEmail, String paperID) {
		// UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
		String sql = "UPDATE paper SET paperPID = 1 WHERE paperID = '" + paperID + "' AND paperUserEmail = '"
				+ userEmail + "'";
		System.out.println(sql);
		int rS = dao.executeUpdate(sql);
	}

	public String rename(String userEmail, String paperID, String paperNickName) {
		String sql = "UPDATE paper SET paperNickName = '" + paperNickName + "' WHERE paperUserEmail = '" + userEmail
				+ "' AND paperID = '" + paperID + "'";
		System.out.println(sql);
		int rS = dao.executeUpdate(sql);
		if (rS > -1) {
			return "renamesuccess";
		}
		return null;
	}

}
