
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
<div style="float:left;">
	<ol class="rounded-list" id="allPaperShow">
		
		<%int paperIndex=0; %>
		<c:forEach var="paper" items="${paperList}">
			<% paperIndex++; %>
			<div id="paperE_<%=paperIndex%>">
				<li>
					<select class="RC_select" id="Reading_Conditions_select_<%=paperIndex%>" style="-webkit-appearance: none;outline: 0;-webkit-tap-highlight-color: #fff; background:#ddd;border:none;width:13px;">
							<option  style="padding : 40px 100px 40px 100px;font-weight: normal;">&nbsp;*   未阅读</option>
							<option>&nbsp;/   已粗读</option>
							<option>&nbsp;#   已精读</option>
					</select>
					&nbsp;
					<a id="paperNickName_forDelete_<%=paperIndex%>" href="${paper.paperWebFilePath}" target="_blank">${paper.paperNickName }</a>
					
					<div style="float:right;">
						
						<a onClick="paperUpdate(<%=paperIndex%>)" style="cursor: pointer;">修改&nbsp;&nbsp;</a>
						<a id="detail" onClick="paperDetail(<%=paperIndex%>)" style="cursor: pointer;">详情&nbsp;&nbsp;</a>
						<a onClick="deletePaper(<%=paperIndex%>)" style="cursor: pointer;">删除&nbsp;&nbsp;</a>
					</div>
				</li>
				<div style="display: none;z-index: 1000;" id="paperDetail_<%=paperIndex%>">
					<p style="display:none;">false</p>
					<div class="paperDetail_window">
						<table class="bordered">
						    <tr><th colspan="2">论文详情</th></tr>
						    <tr>
						        <td>论文名称</td>
						        <td id="paperName_<%=paperIndex%>">${paper.paperNickName }</td>
						    </tr>
						    <tr>
						        <td>分类目录</td>
						        <td></td>
						  	</tr>
						    <tr>
						        <td>论文来源</td>
						        <td id="paperOrigin_<%=paperIndex%>">${paper.paperOrigin }</td>
						    </tr>
						    
						    <tr id="paperExteriorURL_tr_<%=paperIndex%>">
						        <td>论文URL</td>
						        <td id="paperExteriorURL_<%=paperIndex%>">${paper.paperExteriorURL }</td>
						    </tr>
						    <tr>
						        <td>添加日期</td>
						        <td id="paperUploadDate_<%=paperIndex%>">${paper.uploadDate }</td>
						    </tr>
						    <tr>
						        <td>备注</td>
						        <td id="paperRemark_<%=paperIndex%>">${paper.paperRemark }</td>
						    </tr>
						</table>
						<!-- <center>
							<button onClick="paperDetailClose(<%=paperIndex%>)">确定</button>
						</center> -->
					</div>
				</div>
			</div>
		</c:forEach>
	</ol>
</div>
	<!-- <div style="position:absolute;left: 55%;top: 10%;margin-left: width/2;margin-height: height/2;width: 320px;"> -->
<div id="updatePaperWindow" style="width:270px;float:left;display:none;">
		<p style="display:none;">false</p>
		<form  action="<%=basePath%>fileList" method="post">
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
			        <td>添加日期</td>
			        <td><input id="updatedPaperUploadDate" name="updatedPaper.uploadDate" readonly style="border: none;"/></td>
			    </tr>
			    <tr>
			        <td>备注</td>
			        <td><input id="updatedPaperRemark" name="updatedPaper.paperRemark"/></td>
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
	function deletePaper(Index){
		$("#paperE_"+Index).hide();
		var name = $("#paperNickName_forDelete_"+Index).html();
		$.post("<%=basePath%>manage",
				{
					deletePaperNickName :name
				},
				function(){alert("删除 "+name+" 成功");}
		);
	}
	//var paperDetailOpen =paperIndex;
	function paperDetail(Index){
		//heightAdjust();
		if ($("#paperDetail_"+Index+" p").html()=="false"){
			paperDetailShow(Index);
			$("#paperDetail_"+Index+" p").html("true")
		}
		else{
			paperDetailClose(Index);
			$("#paperDetail_"+Index+" p").html("false")
		}
		//paperDetailOpen=!paperDetailOpen;
	}
	function paperDetailShow(Index){
		$("#paperDetail_"+Index).show();
	}
	function paperDetailClose(Index){
		$("#paperDetail_"+Index).hide();
	}
	function paperUpdate(Index){
		if ($("#updatePaperWindow p").html()=="false"){
			$("#updatedPaperName").val($("#paperName_"+Index).html());
			$("#updatedPaperOrigin").val($("#paperOrigin_"+Index).html());
			$("#updatedPaperUploadDate").val($("#paperUploadDate_"+Index).html());
			$("#updatedPaperRemark").val($("#paperRemark_"+Index).html());
			$("#updatePaperWindow").show();
			$("#updatePaperWindow p").html("true");
		}
		else{
			$("#updatePaperWindow").hide();
			$("#updatePaperWindow p").html("false");
		}
	}
	function heightAdjust(){
		var main = $(window.parent.document).find("#mainShow");
		//var thisHeight = $(document).height() + 50;
		thisHeight=$(document).outerHeight()+50;
		main.height(thisHeight);
		//alert(thisHeight);
	}
	//heightAdjust();
	//});
</script>
</body>