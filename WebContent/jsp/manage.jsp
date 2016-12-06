
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

<div id="container">  
<div id="hw1_masthead">

<!--导航--> 
    <div id="hw1_masthead_wrap" class="hw1_skinny">
      
        <div id="hw1_global_nav" class="lg-container">
            <nav>
                <div id="hw1_logo">
                	<a href="#">
                	<img alt="就叫2333" src="<%=basePath%>jsp/read_and_manage_lib/logo.gif">
                	</a>
                </div>
                <ul class="nav_ul hw1_masthead_cata hidden-sm hidden-xs">
                 	<celin>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</celin>
                    <li><a href="<%=basePath%>read">论文阅读</a></li>
                    
                    <li><a href="<%=basePath%>manage">论文管理</a></li>
                </ul>
            </nav>
             <div style="float: right;font-size: 14px;margin-right: 50px;">
            	<celin id="userName"><s:property value="#session.USER_Nickname"/></celin> | <celin id="ID_logout"><a href="<%=basePath%>login?relogin=true">退出登录</a></celin>
            </div>
             <script type="text/javascript">
    	     	var name=$("#userName").html();
    	     	if(name=="user_nickname" || name==""){
    	     		$("#userName").html("尚未登录");
    	     		$("#ID_logout").html("去<font color=\"blue\"><a href=\"<%=basePath%>login?relogin=true\">登录</a></font>");
    	     	}
            </script> 
        </div>
    </div>
<!---->



<!--左侧菜单-->
	<ul id="accordion" class="accordion">
	<li>
		<div class="link"><i class="fa fa-paint-brush"></i>新建论文<i class="fa fa-chevron-down"></i></div>
		<ul class="submenu">
			<li><a href="#" id="newPaperFromLocal_Show">从本地上传</a></li>
			<li><a href="#" id="newPaperByURL_Show">导入URL链接</a></li>
		</ul>
	</li>
	<li>
		<div class="link" id="allPaperShow_Show"><i class="fa fa-mobile"></i>所有论文</div>
	</li>
	<li>
		<div class="link"><i class="fa fa-code"></i>文件分类树<i class="fa fa-chevron-down"></i></div>
		<ul class="submenu">
			<li><a href="#">查看</a></li>
			<li><a href="#">编辑</a></li>
		</ul>
	</li>
	<li><div class="link"><i class="fa fa-globe"></i>文件操作记录<i class="fa fa-chevron-down"></i></div>
		<ul class="submenu">
			<li><a href="#">查看我的Log</a></li>
			<li><a href="#">导出我的Log</a></li>
			<li><a href="#">分享我的Log</a></li>
		</ul>
	</li>

	<li>
		<div class="link"><i class="fa fa-mobile"></i>回收站</div>
	</li>
	<li>
		<div class="link"><i class="fa fa-mobile"></i>阅读时间线</div>
	</li>
	</ul>
	<script src='http://codepen.io/assets/libs/fullpage/jquery.js'></script>
	<script src="<%=basePath%>jsp/read_and_manage_lib/js/index.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		$("#newPaperFromLocal_Show").click(function(){
			$("#newPaperFromLocal").show();
			$("#allPaperShow").hide();
			$("#newPaperByURL").hide();
		});
		
		$("#allPaperShow_Show").click(function(){
			$("#newPaperFromLocal").hide();
			$("#newPaperByURL").hide();
			$("#allPaperShow").show();
		});
		
		$("#newPaperByURL_Show").click(function(){
			$("#newPaperByURL").show();
			$("#allPaperShow").hide();
			$("#newPaperFromLocal").hide();
		});
	});
	</script>
<!---->


<!--paperNickName paperOrigin paperExteriorURL paperRemark-->
<!-- 新建论文 导入URL链接-->
	<div class="form_container" id="newPaperByURL" style="display:none;">  
	<br><br>
	<form id="paperForm" action="manage?newPaperFlag=true&newPaperByURLFlag=true" method="post" enctype="multipart/form-data">
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






<iframe id="mainShow" src="<%=basePath%>fileList" style="width:850px;height:450px;display: block;margin: 80px 340px;position: block;border:none;"></iframe>



<!--底部-->
	<div id="footer" class="winwin-footer" style="top: initial;">
    <div class="container">
    <div class="top">
    <div class="row">
        <div class="col-md-8 col-sm-12 hidden-xs">
        <div class="left">
        <div class="left_inner row">
            <div class="col-sm-3">
            	<label>关于我们</label>
                <ul>
                    <li><a href="#">小组简介</a></li>
                    <li><a href="#">联系我们</a></li>
                   	<li><a href="#">意见反馈</a></li>
                    <li><a href="#">留言板</a></li>
                </ul>
            </div>
            <div class="col-sm-3">
            	<label>新闻 &amp; 通知</label>
                <ul>
                	<li><a href="#">新闻</a></li>
                </ul>
            </div>
            <div class="col-sm-3">
            	<label>友情链接</label>
                <ul>
                	<li><a href="http://www.hit.edu.cn">
                		哈尔滨工业大学
                	</a></li>
                	<li><a href="http://www.cnki.net/">
                    	中国知网
                    </a></li>
                    <li><a href="#">万方数据库</a></li>
                </ul>
            </div>
        </div>       
    	</div>
		</div>
	</div>
    </div>
    </div>

	<hr class="hw1_hr">
	<div class="container">
	    <div class="bottom">
	    <div class="row">
	    	<div class="col-sm-7 col-md-5 hidden-xs hidden-sm">
	        <div class="bottom_left">
			<span id="indexfooter_2_tCopyRight">
		    ©2016 就叫2333小组 &nbsp;&nbsp; 版权所有 &nbsp;&nbsp;
		    </span>
	        </div>
	    	</div>
	    </div>
	    </div>
	</div>
	</div>
<!---->


</div>
</div>

<!-- <div style="display: none;"> -->
<!-- <p name="userEmail"><s:property value="#session.USER_Email"  /></p> -->
<!-- </div> -->

<!-- <input type="button" action="logout" value="退出" > -->
<!-- onclick="close();document.write('<n>')"> -->
<%-- <s:property value="#session.USER_Email" name="userEmail"/> --%>
</body>
</html>