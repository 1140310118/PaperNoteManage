
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%  String path = request.getContextPath();  String basePath = request.getScheme() + "://"    + request.getServerName() + ":" + request.getServerPort()   
+ path + "/"; 
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" class=" js flexbox canvas canvastext webgl no-touch geolocation postmessage websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers applicationcache svg inlinesvg smil svgclippaths">
<head>
	<title>
		就叫2333 - 文献阅读管理系统
	</title>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!--文件列表-->
    <link href="<%=basePath%>jsp/read_and_manage_lib/css/file_list.css" rel="stylesheet" type="text/css" media="screen" />	
    <link href="<%=basePath%>jsp/read_and_manage_lib/css/simple.css" rel="stylesheet" type="text/css" media="screen"/>	
    <link href="<%=basePath%>jsp/read_and_manage_lib/css/table.css" rel="stylesheet" type="text/css" media="screen"/>	
    <link href="<%=basePath%>jsp/read_and_manage_lib/css/form.css" rel="stylesheet" type="text/css" media="screen"/> 

	<script src="<%=basePath%>jsp/read_and_manage_lib/src/jquery.js"></script>
	<link href="<%=basePath%>jsp/read_and_manage_lib/css/select.css" rel="stylesheet" />
	<!-- button -->
	<link href="<%=basePath%>jsp/read_and_manage_lib/css/button/bootstrap.css" rel="stylesheet">
	<link href="<%=basePath%>jsp/read_and_manage_lib/css/button/style.css" rel="stylesheet">
</head>

<body>
<!--文件列表-->
	<br>
<div style="float:left;">
	<ol class="rounded-list" id="allPaperShow">
		<s:forEach var="paper" items="${papers}">
			<div id="paperE_${paper}">
				<li>
					&nbsp;
					<a class="paperNameClick" target="_blank" style="cursor:pointer;">${paper.paperNickName}</a>
					<div style="float:right;">
						<a class="paperReStore" style="cursor: pointer;">恢复</a>&nbsp;&nbsp;
						<a class="paperDeleteAbsolutely" style="cursor: pointer;">彻底删除</a>&nbsp;&nbsp;]
					</div>
				</li>
				
			</div>
		</c:forEach>
	</ol>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		$("#paperReStore").click(function(){
			$(this).parent().parent().parent().hide();
			var paperNickName=$(this).parent().parent().parent().attr("id").substring(7);
			$.post("<%=basePath%>recycleBin_restore",
			   		{
						paperNickName : paperNickName
					},
			   		function(){
	      	}); 
		});
		$("#paperDeleteAbsolutely").click(function(){
			$(this).parent().parent().parent().hide();
			var paperNickName=$(this).parent().parent().parent().attr("id").substring(7);
			$.post("<%=basePath%>recycleBin_delete",
			   		{
						paperNickName : paperNickName
					},
			   		function(){
	      	}); 
		});
	});
</script>
</body>