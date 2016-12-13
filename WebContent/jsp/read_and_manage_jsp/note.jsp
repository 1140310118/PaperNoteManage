
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
</head>

<body>  
<div id="already_saved" style="display: none;z-index: 9999;position: absolute;left:10%">已经保存</div>
<div>
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
<div id="paperNickName_ID" style="display:none;"><s:property value="paperNickName"/></div>
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
			var paperNickName = $("#paperNickName_ID").html();
			$.post("<%=basePath%>newNote?paperNickName="+paperNickName,
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
		var paperNickName = $("#paperNickName_ID").html();
		//alert(paperNickName);
		$.post("<%=basePath%>note?paperNickName="+paperNickName,
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
		var paperNickName = $("#paperNickName_ID").html();
		$.post("<%=basePath%>note?paperNickName="+paperNickName,
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

</body>
</html>