
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%  String path = request.getContextPath();  String basePath = request.getScheme() + "://"    + request.getServerName() + ":" + request.getServerPort()   
+ path + "/"; 
%>

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
                    <li><a href="<%=basePath%>jsp/read.jsp">论文阅读</a></li>
                    
                    <li><a href="<%=basePath%>jsp/manage.jsp">论文管理</a></li>
                	
                </ul>
            </nav>
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


<!--paperNickName paperOrigin paperLocalFilePath paperRemark-->
<!-- 新建论文  从本地上传-->
	<div class="form_container" id="newPaperFromLocal" style="display:none;">
	<br><br>
	<s:form id="paperForm" action="manage" method="post" enctype="multipart/form-data">
	  	 <h3>新建论文</h3>
	    <h4>从本地上传</h4>
	    <fieldset>
	      <input placeholder="*论文名称 nickname" type="text" id="newPaperFromLocal_name"tabindex="1" name="paper.paperNickName"
	      required autofocus/>
	    </fieldset>
	    <fieldset>
	      <input placeholder="论文来源，如中国知网" type="text" tabindex="2" name="paper.paperOrigin">
	    </fieldset>
	    
	    <fieldset>
	        <input type="text" id="newPaperFromLocal_fileName" placeholder="*" style="float: left;width: 270px;">
	        &nbsp;
	        <input type="file" id="newPaperFromLocal_fileSelect" name="resume" style="outline: 0px;width:70px;" required tabindex="3">
	        

	    </fieldset>

	    <fieldset>
	      <textarea placeholder="备注" id="tmp" tabindex="4" name="paper.paperRemark"></textarea>
	    </fieldset>
	    <fieldset>
	      <button name="submit" type="submit" id="newPaperFromLocal_Submit" data-submit="...Sending" >Submit</button>
	    </fieldset>
	</s:form>
  </div> 
  	<script type="text/javascript">
		$(document).ready(function(){
			$("#newPaperFromLocal_fileSelect").change(function(){
				$("#newPaperFromLocal_fileName").val(
					$("#newPaperFromLocal_fileSelect").val()
				);
			});
			$("#newPaperFromLocal_Submit").click(function(){
				if($("#newPaperFromLocal_name").val() && 
				   $("#newPaperFromLocal_fileName").val()){
					alert("提交啦！");
				}
			});
		// $("#newPaperFromLocal").submit(function(e){
  //   		e.preventDefault();
  //   		alert("Submit prevented");
  // 		});
		});

	</script>
<!---->


<!--paperNickName paperOrigin paperExteriorURL paperRemark-->
<!-- 新建论文 导入URL链接-->
	<div class="form_container" id="newPaperByURL" style="display:none;">  
	<br><br>
	<form id="paperForm" action="manage" method="post">
	    <h3>新建论文</h3>
	    <h4>导入URL链接</h4>
	    <fieldset>
	      <input placeholder="*论文名称 nickname" type="text" tabindex="1" name="paper.paperNickName" id="newPaperByURL_name" required autofocus>
	    </fieldset>

	    <fieldset>
	      <input placeholder="论文来源，如中国知网" type="text" tabindex="2" name="paper.paperOrigin" 
	      >
	    </fieldset>
	  
	    <fieldset>
	        <input type="text" placeholder="*URL"  name="paper.paperExteriorURL" id="newPaperByURL_url" required>
	    </fieldset>

	    <fieldset>
	      <textarea placeholder="备注" id="tmp" tabindex="5" name="paper.paperRemark"></textarea>
	    </fieldset>
	    <fieldset>
	      <button name="submit" type="submit" id="newPaperByURL_Submit" data-submit="...Sending">Submit</button>
	    </fieldset>
	</form>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#newPaperByURL_Submit").click(function(submitEvent){
				if(	$("#newPaperByURL_name").val() && 
				   	$("#newPaperByURL_url").val()){
					var URL=$("#newPaperByURL_url").val();
					var flag;
					alert("URL:"+URL);
					$.ajax({
						url: URL,
						type: 'GET',
						complete: function(response,submitEvent) {
							alert("URL_and_result:"+URL+""+response.status);
							if(response.status == 404) {
								alert("无效");
								flag=false;
								}
							else {
								alert("有效");
								flag=true;
							}
						}
					});
					alert("flag:"+flag);
				}
			});
		});
		function NetPing(URL) {
		   $.ajax({
				url: URL,
				type: 'GET',
				complete: function(response) {
					alert(URL+""+response.status);
					if(response.status == 404) {
						return 1;
						} 
					else {
						return 2;
					}
				}
			});
		}
	</script>
  </div> 
<!---->


<!--遮挡层和弹出窗口 详情 修改-->
	<script>
	function deTail()
	{
	    // if ($(".mask").css("display")=='none')
	    {
	    	$(".mask").show();
	    	$(".centerWindow").show();
			$('body').css("overflow","hidden");
	    }
	}
	function backNormal()
	{
	    	$(".mask").hide();
	    	$(".centerWindow").hide();
			$('body').css("overflow","visible");
	    
	}
	</script>
	<div class="mask"></div>
	<div class="centerWindow">
		<table class="bordered">
		    <tr><th colspan="2">论文详情</th></tr>
		    <tr>
		        <td>论文名称</th>
		        <td>K-partion</td>
		    </tr>
		    <tr>
		        <td>文件名</th>
		        <td>K-partion.pdf</td>
		    </tr>
		    <tr>
		        <td>分类目录</th>
		        <td>数据结构/哈希</td>
		    </tr>
		    <tr>
		        <td>论文来源</th>
		        <td></td>
		    </tr>
		    <tr>
		        <td>添加日期</th>
		        <td>2016/11/5</td>
		    </tr>
		    <tr>
		        <td>备注</th>
		        <td>算法设计与分析大作业</td>
		    </tr>
		</table>
		<center>
			<button onClick="backNormal()">确定</button>
		</center>
	</div>
<!---->



<!--文件列表-->
	<br><br><br>
	<ol class="rounded-list" id="allPaperShow">
		<!--以下四行是 为了便于展示，在实际过程中，使用s:property-->
		<li><a href="#">KD树异常检测</a>
			<div style="float:right;">
				<a href="#" >修改&nbsp;&nbsp;</a>
				<a href="#" id="detail" onClick="deTail()">详情&nbsp;&nbsp;</a>
				<a href="#" onClick="delcfm()">删除&nbsp;&nbsp;</a>
			</div>
		</li>	
		<li><a href="#">感知哈希综述</a>
			<div style="float:right;">
				<a href="#" >修改&nbsp;&nbsp;</a>
				<a href="#" >详情&nbsp;&nbsp;</a>
				<a href="#" >删除&nbsp;&nbsp;</a>
			</div>
		</li>	
		<li><a href="#">k-partion</a>
			<div style="float:right;">
				<a href="#" >修改&nbsp;&nbsp;</a>
				<a href="#" >详情&nbsp;&nbsp;</a>
				<a href="#" >删除&nbsp;&nbsp;</a>
			</div>
		</li>	
		<li><a href="#">mixed tabulation</a>
			<div style="float:right;">
				<a href="#" >修改&nbsp;&nbsp;</a>
				<a href="#" >详情&nbsp;&nbsp;</a>
				<a href="#" >删除&nbsp;&nbsp;</a>
			</div>
		</li>						
	</ol>
<!---->



<br><br><br><br><br><br><br><br><br>

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


</body>
</html>