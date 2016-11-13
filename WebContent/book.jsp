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
<title>My JSP 'book.jsp' starting page</title>
</head>
<body>
	<h1>查询结果</h1>
	<table border=1>
		<tr>
			<th>名称</th>
			<td>修改</td>
			<td>删除</td>
		</tr>
		<c:forEach var="book" items="${booklist}">
			<tr>

				<td>${book.text }</td>
			<!--  
				<td><a href='<s:url action="deleteByType" >
				<s:param name="type" value="type"></s:param>
				</s:url>'> 删除</a></td>
			-->
			<td><a href="selectbyid?id=${book.id }"> 修改</a></td>
			  <td><a href="deleteByType?text=${book.text } "> 删除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
