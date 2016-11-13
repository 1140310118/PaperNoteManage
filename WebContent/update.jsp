<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()

			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>My  page</title>
</head>
<body>
	<h1>修改笔记</h1>
	<table border=1>
		
		<!--  s:iterator value = "deleteByType">-->
		<c:forEach var="book" items="${booklist}">
			
			<form action="update.action" method="post">
		<input type=hidden name=type value="${book.id}">
		<input type=text name=type value="${book.text}">
		
		<input type=submit name=subm value="submit">
		</form>
		</c:forEach>
		<!--  /s:iterator>-->
	</table>
</body>
</html>
