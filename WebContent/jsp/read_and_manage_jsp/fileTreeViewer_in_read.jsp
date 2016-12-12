
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
            	beforeRename : beforeRename
			}
		};

		var zNodes =[];

		function setCheck() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.setting.edit.drag.isMove = false;
			zTree.setting.edit.drag.isCopy = false;
			
			zTree.setting.edit.drag.prev = true;
			zTree.setting.edit.drag.inner= true;
			zTree.setting.edit.drag.next = true;
		}
		
		function getZNodes(){
			var s = $("#ztreeNodes").html();		
			zNodes = eval("["+s+"]");
		}
		
		$(document).ready(function(){
			getZNodes();
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			setCheck();
		});
	</SCRIPT>
</head>


<!-- <div style="width: 200px;height: 400px;overflow-y: auto;overflow-x: auto;float:left;margin-left:10px;margin-top:100px;position: absolute;background:#FFF;"> -->

<BODY>
	<ul id="treeDemo" class="ztree"></ul>
	<div style="display:none">
		<p id="ztreeNodes">${ztreeNodes}</p>
	</div>
</BODY>
</HTML>