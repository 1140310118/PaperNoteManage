
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
    <script type="text/javascript" src="http://open.iciba.com/ds_open.php?id=53648&name=2333&auth=AEE55034FB1F422E38947BDF265B7A17" charset="utf-8"></script>
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
                    <li><a href="<%=basePath%>read">论文阅读</a></li>
                    <li><a href="<%=basePath%>manage">论文管理</a></li>
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

<div id="already_saved" style="display: none;z-index: 9999;background: #eee;position: absolute;left:80%">已经保存</div>
<div style="magrin-top:300px;float:left;margin-left:1000px;margin-top:100px;position: absolute;">
	<!--  <iframe src="http://cn.bing.com/dict/"></iframe>-->
	<button id="addNoteButton" name="addNoteFlag">添加笔记</button>
	<%int i=0;%>
	<div id="noteArea">
		<s:iterator value="notes">
			<%i++;%>
			<center><s:property value="noteID"/></center>
			<textarea placeholder="笔记" id="note_<%=i%>" class="note_class" spellcheck="false" style="font-size:12px;width:200px;height:100px;line-height:18px;"><s:property value="content"/></textarea>
			<button class="note_delete_button_class" id="note_delete_button_<%=i%>">删除笔记</button>
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

<script type="text/javascript">
	$(document).ready(function(){
        addNote();
        modifyNote();
        deleteNote();
    });
	function modifyNote(){
		$(".note_class").change(function(){
        	var id = $(this).attr("id");
			$.post("<%=basePath%>read",
			   		{
					 	modifyNoteListID: ""+parseInt(id.substring(5)),
						modifyNoteContent:$("#"+id).val()
					},
			   		function(){
			   			//alert(parseInt(id.substring(5))+":already post");
			   			showAlreadySaved();
			   		}
			);
		});
	}
	
	function modifyNote_by_id(id){
		$("#"+id).change(function(){
        	$.post("<%=basePath%>read",
			   		{
					 	modifyNoteListID: ""+parseInt(id.substring(5)),
						modifyNoteContent:$("#"+id).val()
					},
			   		function(){
			   			//alert(parseInt(id.substring(5))+":already post");
			   			///////////
			   			showAlreadySaved();
			   		}
			);
		});
	}
	
	function addNote(){
		$("#addNoteButton").click(function(){
			$.post( "<%=basePath%>read",
				    {addNoteFlag:"true"},
				    function(){
				    	<%i++;%>
				    	$("#noteArea").append("<textarea placeholder=\"笔记\" id=\"note_<%=i%>\" class=\"note_class\" spellcheck=\"false\" style=\"font-size:12px;width:200px;height:100px;line-height:18px;\"/>\
										<button class=\"note_delete_button_class\" id=\"note_delete_button_<%=i%>\">删除笔记</button>");
				    	modifyNote_by_id("note_<%=i%>");
				    	deleteNote_by_id("note_<%=i%>");
				    });
		});
	}
	function deleteNote(){
		$(".note_delete_button_class").click(function(){
        	var id = $(this).attr("id");
        	alert(id.substring(19));
        	$.post("<%=basePath%>read",
			   		{
					 	deleteNoteListID: id.substring(19)
					},
			   		function(){
						$("#note_"+id.substring(19)).hide();// hide 输入框
						$("#"+id).hide();//hide 删除按钮
			   			alert(id.substring(19)+":删除成功！");			   			
			   		}
			);
		});
	}
	function deleteNote_by_id(id){
		$("#"+id).click(function(){
        	$.post("<%=basePath%>read",
			   		{
					 	deleteNoteListID: id.substring(19)
					},
			   		function(){
						$("#note_"+id.substring(19)).hide();// hide 输入框
						$("#"+id).hide();//hide 删除按钮
			   			alert(id.substring(19)+":删除成功！");			   			
			   		}
			);
		});
	}
	function showAlreadySaved(){
		if ($("#already_saved").css('display')=='none'){
			 $('#already_saved').css({display:'block', top:'-100px'}).animate({top: '+100'}, 500, function(){ 
                        		setTimeout(outAlreadySaved, 750); 
            					}
            ); 
		}
	}
	function outAlreadySaved(){
		$('#already_saved').animate({top:'0'}, 200, function(){ 
                $(this).css({display:'none', top:'-100px'}); 
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