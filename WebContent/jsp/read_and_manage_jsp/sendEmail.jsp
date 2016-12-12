
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
	<link rel="stylesheet" href="<%=basePath%>jsp/read_and_manage_lib/bootstrap.min.css" type="text/css" media="screen, project, print">
	<link rel="stylesheet" href="<%=basePath%>jsp/read_and_manage_lib/main-cn.css" type="text/css" media="screen, project, print">
	<link rel="Shortcut Icon" href="#">

	<!-- Iconos -->
	<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="<%=basePath%>jsp/read_and_manage_lib/css/style.css" media="screen" type="text/css" />

    <!--文件列表-->
    <link href="<%=basePath%>jsp/read_and_manage_lib/css/file_list.css" rel="stylesheet" type="text/css" media="screen" />	
    <link href="<%=basePath%>jsp/read_and_manage_lib/css/simple.css" rel="stylesheet" type="text/css" media="screen"/>	
    <link href="<%=basePath%>jsp/read_and_manage_lib/css/table.css" rel="stylesheet" type="text/css" media="screen"/>	
    <link href="<%=basePath%>jsp/read_and_manage_lib/css/form.css" rel="stylesheet" type="text/css" media="screen"/> 

	<script src="<%=basePath%>jsp/read_and_manage_lib/js/simple.js"></script>
	<script src="<%=basePath%>jsp/read_and_manage_lib/src/jquery.js"></script>
	<link href="<%=basePath%>jsp/read_and_manage_lib/css/select.css" rel="stylesheet" />
	
</head>


<body>  


<div class="form_container">
	<form id="paperForm" action="emailer" method="post">
	  	<h3>通过邮件分享</h3>
	    <h4>和朋友分享你的论文</h4>
	    <fieldset>
	    	<input type="text" name="from" value="hit_lmf@163.com" style="display:none"/>
	   	</fieldset>
	    <fieldset>
	   		<input type="password" name="password" value="4321005abc" style="display:none"/>
	    </fieldset>
	    <fieldset>
		   <input type="text" name="to" placeholder="*收件人邮箱"/><br/>
	    </fieldset>
	    <fieldset>
			<input type="text" name="subject" placeholder="主题" value="2333论文阅读管理系统 论文分享"/><br/>
	    </fieldset>
	    
	    <fieldset>
	        <input type="text" style="float: left;width: 270px;" placeholder="附件" value="${file}">
	        &nbsp;
	   		<input type="file" id="filename" name="fileName" style="outline: 0px;width:70px;" value="${file}"/><br/> 
	    </fieldset>

	    <fieldset>
	      <textarea placeholder="正文"  name="body"></textarea>
	    </fieldset>

	    <fieldset>
	      	<button name="submit" type="submit" id="newPaperFromLocal_Submit" data-submit="...Sending" >Submit</button>
	    </fieldset>
	</form>
</div> 

</body>
</html>