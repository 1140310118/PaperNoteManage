
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
		<c:forEach var="paper" items="${paperList}">
			<div id="paperE_${paper.paperNickName}">
				<li>
					<select class="RC_select" id="RC_select_${paper.paperReadSituation}" onload="set_readSituation()" style="-webkit-appearance: none;outline: 0;-webkit-tap-highlight-color: #fff; background:#ddd;border:none;width:11px;">
							<option value="0">*   未阅读</option>
							<option value="1">/   已粗读</option>
							<option value="2">#   已精读</option>
					</select>
					
					&nbsp;
					<a class="paperNameClick" target="_blank" style="cursor:pointer;">${paper.paperNickName}</a>
					<div class="URL" fileURL="${paper.paperWebFilePath }" webURL="${paper.paperExteriorURL }" style="display:none;"></div>
					<div style="float:right;">
						
						<a class="paperUpdate" style="cursor: pointer;">修改</a>&nbsp;&nbsp;
						<a class="paperDetail" style="cursor: pointer;">详情</a>&nbsp;&nbsp;
						<a class="paperDelete" style="cursor: pointer;">删除</a>&nbsp;&nbsp;
						<a class="viewLog" style="cursor: pointer;">查看log</a>&nbsp;&nbsp;
						<a class="share" style="cursor: pointer;">分享</a>&nbsp;&nbsp;
					</div>
				</li>
				<div style="display: none;z-index: 1000;" class="paperDetail_window">
					<p style="display:none;">false</p>
					<table class="bordered">
					    <tr><th colspan="2">论文详情</th></tr>
					    <tr>
					        <td>论文名称</td>
					        <td class="paperName">${paper.paperNickName }</td>
					    </tr>
					    <tr>
					        <td>分类目录</td>
					        <td></td>
					  	</tr>
					    <tr>
					        <td>论文来源</td>
					        <td class="paperOrigin">${paper.paperOrigin }</td>
					    </tr>
					    
					    <tr>
					        <td>论文URL</td>
					        <td class="paperExteriorURL">${paper.paperExteriorURL }</td>
					    </tr>
					    <tr>
					        <td>添加日期</td>
					        <td class="paperUploadDate">${paper.uploadDate }</td>
					    </tr>
					    <tr>
					        <td>备注</td>
					        <td class="paperRemark">${paper.paperRemark }</td>
					    </tr>
					</table>
				</div>
			</div>
		</c:forEach>
	</ol>
</div>
	<!-- <div style="position:absolute;left: 55%;top: 10%;margin-left: width/2;margin-height: height/2;width: 320px;"> -->
<div id="updatePaperWindow" style="width:270px;float:left;display:none;">
		<p style="display:none;">false</p>
		<form  action="<%=basePath%>fileList" method="post">
	   		<input value="true" name="updatePaperFlag" style="display: none;"></input>
			<table class="bordered">
			    <tr><th colspan="2">修改论文信息</th></tr>
			    <tr>
			        <td>论文名称</td>
			        <td><input id="updatedPaperName" name="updatedPaper.paperNickName" readonly style="border: none;"/></td>
			    </tr>
			    <tr>
			        <td>分类目录</td>
			        <td></td>
			    </tr>
			    <tr>
			        <td>论文来源</td>
			        <td><input id="updatedPaperOrigin" name="updatedPaper.paperOrigin"/></td>
			    </tr>
			    <tr>
			        <td>论文URL</td>
			        <td><input id="updatedPaperURL" name="updatedPaper.paperExteriorURL"/></td>
			    </tr>
			    <tr>
			        <td>添加日期</td>
			        <td><input id="updatedPaperUploadDate" name="updatedPaper.uploadDate" readonly style="border: none;"/></td>
			    </tr>
			    <tr>
			        <td>备注</td>
			        <td><textarea id="updatedPaperRemark" name="updatedPaper.paperRemark"></textarea></td>
			    </tr>
			    	<!-- <td><input name="updatePaperFlag" value="true" style="display: none;"></td> -->
				<tr>
					<td colspan="2">
						<button type="submit" class="btn btn-block btn-sm btn-warning">确定</button>
					</td>
				</tr>
			</table>
	      		
		</form>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		viewLog_btn_init();
		RC_init();
		RC_change();
		showPaperDetail();
		deletePaper();
		updatePaper();
		openPaper();
		viewLog();
		share();
	});
	function viewLog(){
		$(".viewLog").click(function(){
			var id=$(this).parent().parent().parent().attr("id");
			var fileURL = $("#"+id+" .URL").attr("fileURL");
			if(fileURL){
				var index = fileURL.lastIndexOf("\/");  
				fileURL = fileURL.substring(0,index);
				index = fileURL.lastIndexOf("\/");
				fileURL = fileURL.substring(index+1,fileURL.length);
				
				src="<%=basePath%>logViewer?filePath=/"+fileURL;
				var html= $(window.parent.document).find("#mainShow").attr("src",src);
				
			}
			else window.open(webURL);
		});
	}
	function share(){
		$(".share").click(function(){
			var id=$(this).parent().parent().parent().attr("id");
			var paperName=$(this).parent().parent().parent().attr("id").substring(7);
			$.post("<%=basePath%>get_share",
			   		{
						paperName : paperName
					},
			   		function(url){
						url = "<%=basePath%>share?file=<%=basePath%>file/"+url;
						window.open(url);	
	      	}); 
		});
	}
	function openPaper(){
		$(".paperNameClick").click(function(){
			var id=$(this).parent().parent().attr("id");
			var fileURL = $("#"+id+" .URL").attr("fileURL");
			var webURL  = $("#"+id+" .URL").attr("webURL");
			//alert(fileURL+" "+webURL);
			if(fileURL) window.open("<%=basePath%>jsp/read_and_manage_lib/pdfjs-1.5.188-dist/web/viewer.html?file=<%=basePath%>file/"+fileURL);
			else window.open(webURL);
		});
	}
	function viewLog_btn_init(){
		$(".viewLog").each(function(){
			var id=$(this).parent().parent().parent().attr("id");
			var fileURL  = $("#"+id+" .URL").attr("fileURL");
			if(!fileURL){
				$(this).css("cursor","default");
				$(this).css('text-decoration',  'none');
				$(this).html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp");
			}
		});
		$(".share").each(function(){
			var id=$(this).parent().parent().parent().attr("id");
			var fileURL  = $("#"+id+" .URL").attr("fileURL");
			if(!fileURL){
				$(this).css("cursor","default");
				$(this).css('text-decoration',  'none');
				$(this).html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp");
			}
		});
	}
	function RC_init(){
		$(".RC_select").each(function(key){
			var rc=$(this).attr("id").substring(10);
			$(this).val(rc);
		});
	}
	function RC_change(){
		$(".RC_select").change(function(){
			var modifyPaperName=$(this).parent().parent().attr("id").substring(7);
			var readSituation = $(this).val();
			$.post("<%=basePath%>fileList",
			   		{
						modifyPaperName : modifyPaperName,
						readSituation   : readSituation
					},
			   		function(){
	      	}); 
		});
	}
	function showPaperDetail(){
		$(".paperDetail").click(function(){
			var name=$(this).parent().parent().parent().attr("id").substring(7);
			_showPaperDetail(name);
		});
	}
	function deletePaper(){
		$(".paperDelete").click(function(){
			var deletePaperNickName=$(this).parent().parent().parent().attr("id").substring(7);
			_deletePaper(deletePaperNickName);
		});
	}
	function updatePaper(){
		$(".paperUpdate").click(function(){
			var name=$(this).parent().parent().parent().attr("id").substring(7);
			_updatePaper(name);
		});
	}
	function _deletePaper(deletePaperNickName){
		$("#paperE_"+deletePaperNickName).hide();
		$.post("<%=basePath%>fileList",
				{
					deletePaperNickName :deletePaperNickName
				},
				function(){alert("删除的论文将被放入回收站中。");}
		);
	}
	function _showPaperDetail(name){
		//heightAdjust();
		var w=$("#paperE_"+name+" .paperDetail_window");
		var display=$("#paperE_"+name+" .paperDetail_window p");
		if (display.html()=="false"){
			w.show();
			display.html("true");
		}
		else{
			w.hide();
			display.html("false");
		}
	}
	
	function _updatePaper(name){
		if ($("#updatePaperWindow p").html()=="false" || name!=$("#updatedPaperName").val()){
			$("#updatedPaperName").val($("#paperE_"+name+" .paperDetail_window .paperName").html());
			$("#updatedPaperOrigin").val($("#paperE_"+name+" .paperDetail_window .paperOrigin").html());
			$("#updatedPaperUploadDate").val($("#paperE_"+name+" .paperDetail_window .paperUploadDate").html());
			$("#updatedPaperRemark").html($("#paperE_"+name+" .paperDetail_window .paperRemark").html());
			var url=$("#paperE_"+name+" .paperDetail_window .paperExteriorURL").html();
			if (url){
				$('#updatedPaperURL').val(url);
			}
			else{
				$("#updatedPaperURL").attr('readonly','readonly');
				$('#updatedPaperURL').css('border','none');
			}
			$("#updatePaperWindow").show();
			$("#updatePaperWindow p").html("true");
		}
		else{
			$("#updatePaperWindow").hide();
			$("#updatePaperWindow p").html("false");
		}
	}
</script>
</body>