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
	<h1>��ѯ���</h1>
	<table border=1>
		<tr>
			<th>����</th>
			<td>�޸�</td>
			<td>ɾ��</td>
		</tr>
		<c:forEach var="book" items="${booklist}">
			<tr>

				<td>${book.text }</td>
			<!--  
				<td><a href='<s:url action="deleteByType" >
				<s:param name="type" value="type"></s:param>
				</s:url>'> ɾ��</a></td>
			-->
			<td><a href="selectbyid?id=${book.id }"> �޸�</a></td>
			  <td><a href="deleteByType?text=${book.text } "> ɾ��</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
