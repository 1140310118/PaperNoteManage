<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%  String path = request.getContextPath();  String basePath = request.getScheme() + "://"    + request.getServerName() + ":" + request.getServerPort()   
 
+ path + "/"; 
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
</head>
<body>
	<h1>查询笔记</h1>
	<form action="selectbytype.action" method="post">
		笔记：<input type=text name=type>
		<!-- 参数名和action中属性名一样 -->
		<input type=submit name=subm value="查询">
	</form>
	<!--  
	<form action="add.action" method="post">
		<input type=submit name=subm value="创建笔记">
		</form>
		-->
	<a href='add.jsp'>创建笔记</a>
</body>
</html>