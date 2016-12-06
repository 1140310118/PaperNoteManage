
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
	<link rel="stylesheet" href="<%=basePath%>jsp/read_and_manage_lib/bootstrap.min.css" type="text/css" media="screen, project, print">
	<link rel="stylesheet" href="<%=basePath%>jsp/read_and_manage_lib/main-cn.css" type="text/css" media="screen, project, print">
	<link rel="stylesheet" href="<%=basePath%>jsp/read_and_manage_lib/css/zTreeStyle.css" type="text/css">
	

	<link rel="Shortcut Icon" href="#">
    <script src="<%=basePath%>jsp/read_and_manage_lib/src/jquery.js"></script>
    <script src="<%=basePath%>jsp/read_and_manage_lib/js/jquery.jsonp.js"></script>
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
            <div style="float: right;font-size: 14px;margin-right: 50px;">
            	<celin id="userName"><s:property value="#session.USER_Nickname"/></celin> | <celin id="ID_logout"><a href="<%=basePath%>login?relogin=true">退出登录</a></celin>
             <script type="text/javascript">
    	     	var name=$("#userName").html();
    	     	if(name=="user_nickname" || name==""){
    	     		$("#userName").html("尚未登录");
    	     		$("#ID_logout").html("去<font color=\"blue\"><a href=\"<%=basePath%>login?relogin=true\">登录</a></font>");
    	     	}
            </script> 
        </div>
    </div>
    </div>


<div style="width: 200px;height: 400px;overflow-y: auto;overflow-x: auto;float:left;margin-left:10px;margin-top:100px;position: absolute;background:#FFF;">
	<ul id="treeDemo" class="ztree"></ul>
</div>
<!--pdf-->
<!-- embed width="800" height="600" src="./test.pdf">
<iframe width="800" height="600" src="./test.pdf"></iframe-->
 <div style="float:left;margin-left:230px;margin-top: 60px;">
<%--  <iframe width="800" height="600" src="<%=basePath%>file/zzh19971968@foxmail.com/test/test.pdf"></iframe> --%>
<iframe width="800" height="600" src="<%=basePath%>jsp/read_and_manage_lib\pdfjs-1.5.188-dist\web\viewer.html?file=<%=basePath%>file/zzh19971968@foxmail.com/test/test.pdf"></iframe>
</div>

<div id="already_saved" style="display: none;z-index: 9999;position: absolute;left:80%">已经保存</div>
<div style="magrin-top:300px;float:left;margin-left:1030px;margin-top:100px;position: absolute;background:#fff;">
	<input type="text" style="width: 210px;" id="wordT"/>
	<button id="dictS_button">查询</button>
	<div id="translateResult"></div>
	<br>
	<button id="addNoteButton" name="addNoteFlag">添加笔记</button>
	<c:set var="i" value="0"></c:set>
	<div id="noteArea">
		<s:iterator value="notes">
			<div id="note_${notes[i].noteID}">	
				<c:set var="i" value="${i+1}"></c:set>
				<textarea placeholder="笔记" class="note_class" spellcheck="false" style="font-size:12px;width:200px;height:100px;line-height:18px;"><s:property value="content"/></textarea>
				<button class="note_delete_button_class">删除笔记</button>
			</div>
		</s:iterator>
	</div>
</div>


<br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br>

<script type="text/javascript">
	$(document).ready(function(){
		dictSearch();
        addNote();
        modifyNote();
        deleteNote();
    });
	function strToJson(str){ 
		var json = eval('(' + str + ')'); 
		return json; 
		} 
	
	function dictSearch(){
    	$("#dictS_button").click(function(){
    		var wordT = $("#wordT").val(); 
    		if (!wordT){
    			alert("请输入您要查询的单词。");
    			return;
    		}
    		$.post("<%=basePath%>wordTranslate",
			   		{
						wordT : wordT
					},
			   		function(data){
						//alert(data);
						var json = strToJson(data);
						//alert(json["basic"]["explains"]);
						$("#translateResult").html("<div class=\"translationResultContent\">"
													+json["basic"]["explains"]
													+"<br>"
													+"<a id=\"tDetail\" style=\"cursor:pointer\"><font color=\"blue\">去有道，查看详情</font></a>|"
													+"<a class=\"hideTR\" style=\"cursor:pointer\"><font color=\"blue\">关闭</font></a>"
													+"</div>");
						translateDetail(wordT);
						hideTranslationR();
	      	}); 
    	});
    }
	function hideTranslationR(){
		$(".hideTR").click(function(){
			$(".translationResultContent").hide();
		});
	}
	function translateDetail(wordT){
		$("#tDetail").click(function(){
			var url="http://simsent.youdao.com/search?q="+wordT;
			//window.location.href=url;
			window.open(url);
		});
	}
    
	function addNote(){
		$("#addNoteButton").click(function(){
			$.post("<%=basePath%>newNote",
			   		{
						addNoteFlag : true
					},
			   		function(newNoteID){
						newNoteID=newNoteID.substring(0,newNoteID.length-2);
						$("#noteArea").append("");
						$("#noteArea").append("<div id=\"note_"+newNoteID+"\">"
												+"<textarea placeholder=\"笔记\" class=\"note_class\" spellcheck=\"false\" style=\"font-size:12px;width:200px;height:100px;line-height:18px;\"></textarea>"
												+"\n<button class=\"note_delete_button_class\">删除笔记</button>"
												+"</div>");
						$("#note_"+newNoteID+" textarea").change(function(){
				        	var id = $(this).parent().attr("id");
							_modifyNote(id);
						});
						$("#note_"+newNoteID+" button").click(function(){
				        	var id = $(this).parent().attr("id");
				        	_deleteNote(id);
						});
						
			   		}
			);
		});
	}
	function modifyNote(){
		$(".note_class").change(function(){
        	var id = $(this).parent().attr("id");
			_modifyNote(id);
		});
	}
	function _modifyNote(id){
		$.post("<%=basePath%>read",
		   		{
				 	modifyNoteID: id.substring(5),
					modifyNoteContent:$("#"+id+" textarea").val()
				},
		   		function(){
		   			showAlreadySaved();
		   		}
		);
	}
	function deleteNote(){
		$(".note_delete_button_class").click(function(){
        	var id = $(this).parent().attr("id");
        	_deleteNote(id);
		});
	}
	function _deleteNote(id){
		$.post("<%=basePath%>read",
		   		{
				 	deleteNoteID: id.substring(5)
				},
		   		function(){
					$("#"+id).hide();//hide 删除按钮
		   			alert("删除成功！");		   			
		   		}
		);
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
</div>
</div>

</body>
</html>