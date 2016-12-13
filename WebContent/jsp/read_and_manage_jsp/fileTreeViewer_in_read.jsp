
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%  String path = request.getContextPath();  String basePath = request.getScheme() + "://"    + request.getServerName() + ":" + request.getServerPort()   
+ path + "/"; 
%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!-- saved from url=(0025)http://www.huawei.com/cn/ -->
<html xmlns="http://www.w3.org/1999/xhtml" class=" js flexbox canvas canvastext webgl no-touch geolocation postmessage websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers applicationcache svg inlinesvg smil svgclippaths">
<head>
	<title>
		就叫2333 - 文献阅读管理系统
	</title>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- 	<link rel="stylesheet" href="<%=basePath%>jsp/read_and_manage_lib/ztree/zTreeStyle.css" type="text/css"> --%>
	<link rel="stylesheet" href="<%=basePath%>jsp/read_and_manage_lib/css/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="<%=basePath%>jsp/read_and_manage_lib/ztree/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jsp/read_and_manage_lib/ztree/jquery.ztree.core.js"></script>
	<script type="text/javascript" src="<%=basePath%>jsp/read_and_manage_lib/ztree/jquery.ztree.excheck.js"></script>
	<script type="text/javascript" src="<%=basePath%>jsp/read_and_manage_lib/ztree/jquery.ztree.exedit.js"></script>
    <SCRIPT type="text/javascript">
		var setting = {
			edit: {
				enable: true,
				showRemoveBtn: false,
				showRenameBtn: false
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeDrag: beforeDrag,
				beforeDrop: beforeDrop,
				beforeRemove : beforeRemove,  
            	beforeRename : beforeRename,
            	onClick: zTreeOnClick
			}
		};

		var zNodes =[];

		function beforeDrag(treeId, treeNodes) {
			for (var i=0,l=treeNodes.length; i<l; i++) {
				if (treeNodes[i].drag === false) {
					return false;
				}
			}
			return true;
		}
		function beforeDrop(treeId, treeNodes, targetNode, moveType) {
			if (targetNode.drop !== false){
				//alert(targetNode.id + " " + treeNodes[0].id);
			}
			return targetNode ? targetNode.drop !== false : true;
		}
		function beforeRename(treeId, treeNode, newName) {  
	        if (newName.length == 0) {  
	            alert("节点名称不能为空.");  
	            return false;  
	        }  
	        var param = "id=" + treeNode.id + "&name=" + newName;  
	        // $.post(encodeURI(encodeURI("/peTreeDemo2/jsondata?method=updatePp&"  
	        //         + param)));  
	        alert(treeNode.id+":"+newName);
	        return true;
	    }
	    function beforeRemove(treeId, treeNode) {  
	        // return true;
	    	if (confirm("确认删除节点--" + treeNode.name + "--吗?")) {  
	            var param = "id=" + treeNode.id;  
	            
	        } else {  
	            return false;  
	        }  
	    }
		function setCheck() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			isMove = $("#move").attr("checked"),
			delete_option = $("#delete_option").attr("checked"),
			rename_option = $("#rename_option").attr("checked");
			zTree.setting.edit.showRemoveBtn = delete_option;
			zTree.setting.edit.showRenameBtn = rename_option;
			//alert(isMove);
			zTree.setting.edit.drag.isMove = isMove;
			zTree.setting.edit.drag.isCopy = false;
			
			zTree.setting.edit.drag.prev = true;
			zTree.setting.edit.drag.inner= true;
			zTree.setting.edit.drag.next = true;
		}
		var newCount = 1;
		var downloadEnable = $("#download_option").attr("checked");
		function add(e) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			isParent = e.data.isParent;
			treeNode = zTree.addNodes(null, {id:(100 + newCount), pId:0, isParent:isParent, name:"new node" + (newCount++)});	
		};
		function zTreeOnClick(e,treeId,treeNode){
			//alert(treeNode.name);
			if (treeNode.isParent!=true){
				$.post("<%=basePath%>getURLbyID",
						{
							paperNickName:treeNode.name,
						},
						function(url){
							var src="<%=basePath%>jsp/read_and_manage_lib/pdfjs-1.5.188-dist/web/viewer.html?file=<%=basePath%>file/"+url;
							$(window.parent.document).find("#paperArea").attr("src",src);
							src="<%=basePath%>note?paperID="+treeNode.id;
							$(window.parent.document).find("#noteArea").attr("src",src);
				});
			}
		}
		function setUndropable(){
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			var treeNodes = zTree.getNodes();
    		treeNodes = zTree.transformToArray(treeNodes);
			for(var i=0;i<treeNodes.length;i++){
			 	if(treeNodes[i].isParent!== true){
			 		treeNodes[i].drop = false;
			 	}
			}
		}
		function getZNodes(){
			<%-- <%  
			  String s2 = (String)request.getParameter("ztreeNodes");
			%>
			var s = '<%=s2%>';//输出s2给js变量s
			alert(s); --%>
			var s = $("#ztreeNodes").html();
			//alert(s);
			zNodes = eval("["+s+"]");
		}
		$(document).ready(function(){
			getZNodes();
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			setUndropable();
			setCheck();
			$("#delete_option").bind("change",setCheck);
			$("#rename_option").bind("change",setCheck);
			$("#move").bind("change",setCheck);
			$("#addParent").bind("click", {isParent:true}, add);
			$("#download_option").change(function(){
				downloadEnable = $("#download_option").attr("checked");
			});
		});

	</SCRIPT>
</head>


<!-- <div style="width: 200px;height: 400px;overflow-y: auto;overflow-x: auto;float:left;margin-left:10px;margin-top:100px;position: absolute;background:#FFF;"> -->

<BODY>
	<ul id="treeDemo" class="ztree"></ul>
	<div style="display:none">
		<p id="ztreeNodes">${ztreeNodes}</p>
		<input type="checkbox" id="delete_option" class="checkbox first"  /><span>删除</span>
		<input type="checkbox" id="rename_option" class="checkbox first"  /><span>重命名</span>
		<input type="checkbox" id="move" class="checkbox first" /><span>拖拽</span>
		<a id="addParent" style="cursor:pointer;" title="增加父节点" onclick="return false;">新建分类</a>
	
	</div>
	
</BODY>
</HTML>