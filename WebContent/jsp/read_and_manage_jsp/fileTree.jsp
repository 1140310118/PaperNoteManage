
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
	<script type="text/javascript" src="<%=basePath%>jsp/read_and_manage_lib/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jsp/read_and_manage_lib/js/jquery.ztree.core-3.5.js"></script>
    <!-- <script language="javascript" type="text/javascript" src="<%=basePath%>jsp/read_and_manage_lib/js//jquery.ztree.excheck-3.5.js"></script> -->
    <script type="text/javascript" language="javascript">
		var setting = {
					data: {
						simpleData: {
							enable: true
						}
					}
				};
	
		var zNodes =[
				{ id:1, pId:0, name:"父节点1 - 展开", open:true},
				{ id:11, pId:1, name:"父节点11 - 折叠"},
				{ id:111, pId:11, name:"叶子节点111"},
				{ id:112, pId:11, name:"叶子节点112"},
				{ id:113, pId:11, name:"叶子节点113"},
				{ id:114, pId:11, name:"叶子节点114"},
				{ id:12, pId:1, name:"父节点12 - 折叠"},
				{ id:121, pId:12, name:"叶子节点121"},
				{ id:122, pId:12, name:"叶子节点122"},
				{ id:123, pId:12, name:"叶子节点123"},
				{ id:124, pId:12, name:"叶子节点124"},
				{ id:2, pId:0, name:"父节点2 - 折叠"},
				{ id:21, pId:2, name:"父节点21 - 展开", open:true},
				{ id:211, pId:21, name:"叶子节点211"},
				{ id:212, pId:21, name:"叶子节点212"},
				{ id:213, pId:21, name:"叶子节点213"},
				{ id:214, pId:21, name:"叶子节点214"},
				{ id:22, pId:2, name:"父节点22 - 折叠"},
				{ id:221, pId:22, name:"叶子节点221"},
				{ id:222, pId:22, name:"叶子节点222"},
				{ id:223, pId:22, name:"叶子节点223"},
				{ id:224, pId:22, name:"叶子节点224"},
				{ id:23, pId:2, name:"父节点23 - 折叠"},
				{ id:231, pId:23, name:"叶子节点231"},
				{ id:232, pId:23, name:"叶子节点232"},
				{ id:233, pId:23, name:"叶子节点233"},
				{ id:234, pId:23, name:"叶子节点234"}
		];
		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		});
	</script>  
</head>

<body>  

<div style="width: 200px;height: 400px;overflow-y: auto;overflow-x: auto;float:left;margin-left:10px;margin-top:100px;position: absolute;background:#FFF;">
	<ul id="treeDemo" class="ztree"></ul>
</div>


</body>
</html>