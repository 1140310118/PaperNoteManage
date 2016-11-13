
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%  String path = request.getContextPath();  String basePath = request.getScheme() + "://"    + request.getServerName() + ":" + request.getServerPort()   
+ path + "/"; 
%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<!-- saved from url=(0025)http://www.huawei.com/cn/ -->
<html xmlns="http://www.w3.org/1999/xhtml" class=" js flexbox canvas canvastext webgl no-touch geolocation postmessage websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers applicationcache svg inlinesvg smil svgclippaths">
<head>
	<title>
		就叫2333 - 文献阅读管理系统
	</title>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="<%=basePath%>jsp/read_and_manage_lib/bootstrap.min.css" type="text/css" media="screen, project, print">
	<link rel="stylesheet" href="<%=basePath%>jsp/read_and_manage_lib/main-cn.css" type="text/css" media="screen, project, print">
	<link rel="Shortcut Icon" href="#">
    <script src="<%=basePath%>jsp/read_and_manage_lib/src/jquery.js"></script>
    
   
</head>


<body>  

<!--导航-->  
<div id="container">  
<div id="hw1_masthead">
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
                    <li><a href="<%=basePath%>jsp/read">论文阅读</a></li>
                    <li><a href="<%=basePath%>jsp/manage">论文管理</a></li>
                </ul>
            </nav>
        </div>
    </div>




<!--pdf-->
<!-- embed width="800" height="600" src="./test.pdf">
<iframe width="800" height="600" src="./test.pdf"></iframe-->
 <div style="float:left;margin-left:200px;margin-top: 50px;">
 <object width="800" height="600" data="<%=basePath%>file/zzh19971968@foxmail.com/test/test.pdf"></object>
</div>


<div style="magrin-top:300px;float:left;margin-left:1000px;margin-top:100px;position: absolute;">
<iframe src="http://cn.bing.com/dict/"></iframe>
<input id="dictWord"></input>
<button id="dictClick">查询</button>
<button id="addNoteButton" name="addNoteFlag">添加笔记</button>
<%int i=0;%>
<div id="noteArea">
	<s:iterator value="notes" id="note">
		<%i++;%>
		<textarea placeholder="笔记" spellcheck="false" style="font-size:12px;width:200px;height:100px;line-height:18px;"><s:property value="note"/></textarea>
	</s:iterator>
</div>
</div>
<br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br>

<!--  http://dict-co.iciba.com/api/dictionary.php?w=go&key=574912FE50E41DF3EE2CE7F826A792E7&type=json -->
<script type="text/javascript">
	$(document).ready(function(){
		$("#dictClick").click(function(){
			alert("查-- 询");
			dictQuery();
			// $.post("http://dict-co.iciba.com/api/dictionary.php?w=go&key=574912FE50E41DF3EE2CE7F826A792E7&type=json",
			// 	{},
			// 	function(result){
			// 		alert(result.word_name);
			// 	});
		});
	})
	function dictQuery3(){
		var xhrurl = "http://dict-co.iciba.com/api/dictionary.php?type=json&key=574912FE50E41DF3EE2CE7F826A792E7&w=go";
		$.getJSON(xhrurl,function(){alert("das");});
	}
	function dictQuery(){
		var xhrurl = "http://dict-co.iciba.com/api/dictionary.php?type=json&key=574912FE50E41DF3EE2CE7F826A792E7&w=go";
		$.ajax({
	        type : "post",
	        async : true,
	        url :xhrurl, 
	        cache : false,
	        data : "{}",
	        dataType : "jsonp",
	        jsonp: "callbackparam",
	        success : function(json){
	            alert("成功");
	        },
	         error: function(XMLHttpRequest, textStatus, errorThrown) {
				 alert(XMLHttpRequest.status+" "+XMLHttpRequest.readyState+" "+textStatus);
        	}
    	});
	}
	function jsonpCallback1(result){
		alert("你调我了");
	}
	function dictQuery2(){
		var xhrurl = "http://dict-co.iciba.com/api/dictionary.php?type=json&key=574912FE50E41DF3EE2CE7F826A792E7&w=go";
		$.ajax({
	        type : "post",
	        async : false,
	        url :xhrurl, 
	        cache : false,
	        dataType : "jsonp",
	        jsonp: "callbackparam",
	        jsonpCallback:"jsonpCallback1",
	        success : function(json){
	            alert("成功");
	        },
	         error: function(XMLHttpRequest, textStatus, errorThrown) {
				 alert(XMLHttpRequest.status);
				 alert(XMLHttpRequest.readyState);
				 alert(textStatus);
        	}
    	});
	}
	$(document).ready(function(){
		//var path="<%=basePath%>file/zzh19971968@foxmail.com/test/note1.txt";
	    //LoadNote(path);
	    //alert("");
        addNote();
	    //NoteWrite();
	});
	function addNote(){
		$("#addNoteButton").click(function(){
			$.post( "<%=basePath%>read",
				    {addNoteFlag:"true"},
				    function(){
				    	//alert("添加笔记");
				    	$("#noteArea").append("<textarea></textarea>");
				    });
			
		});
		
	}
	function LoadNote(path){
        $("#note").load(path);
	}
	function NoteWrite(id){
		$("#"+id).change(function(){
	    	$.post(   "<%=basePath%>read",
	    		     {note:$("#note").val()},
    			     function(){
	    			    //alert("ok");
	    		     }
	    		   );
	    });
	}
    
</script>

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

</body>
</html>