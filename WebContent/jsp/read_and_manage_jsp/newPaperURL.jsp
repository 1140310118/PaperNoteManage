
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

<!--paperNickName paperOrigin paperExteriorURL paperRemark-->
<!-- 新建论文 导入URL链接-->
	<div class="form_container" id="newPaperByURL">  
	<form id="paperForm" action="newPaperURL?newPaperFlag=true&newPaperByURLFlag=true" method="post" enctype="multipart/form-data">
	    <h3>新建论文</h3>
	    <h4>导入URL链接</h4>
	    
	    <fieldset>
	   	<input id="newPaperByURL_userEmail" value='<%=session.getAttribute("USER_Email")%>' name="paper.paperUserEmail" style="display: none;"></input>
	   	</fieldset>
	   	
		<fieldset>
	      <input placeholder="*论文名称 nickname" type="text" tabindex="1" name="paper.paperNickName" id="newPaperByURL_name" required autofocus>
	    </fieldset>

	    <fieldset>
	      <input placeholder="论文来源，如中国知网" type="text" tabindex="2" name="paper.paperOrigin" 
	      >
	    </fieldset>
	  
	    <fieldset>
	        <input type="text" placeholder="*URL"  name="paper.paperExteriorURL" tabindex="3" id="newPaperByURL_url" required>
	    </fieldset>

	    <fieldset>
	      <textarea placeholder="备注" id="tmp" tabindex="4" name="paper.paperRemark"></textarea>
	    </fieldset>
	    <fieldset>
	      <button name="submit" type="submit" id="newPaperByURL_Submit" data-submit="...Sending">Submit</button>
	    </fieldset>
	</form>
	<script type="text/javascript">
		$("#newPaperByURL_Submit").click(function(){
				if($("#newPaperByURL_name").val() && 
				   $("#newPaperByURL_url").val()){
				   	//alert($("#newPaperByURL_userEmail").val());
					alert("上传成功！");
				}
			});
	</script>
  </div> 
<!---->


</body>
</html>