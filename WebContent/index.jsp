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
	<h1>��ѯ�ʼ�</h1>
	<form action="selectbytype.action" method="post">
		�ʼǣ�<input type=text name=type>
		<!-- ��������action��������һ�� -->
		<input type=submit name=subm value="��ѯ">
	</form>
	<!--  
	<form action="add.action" method="post">
		<input type=submit name=subm value="�����ʼ�">
		</form>
		-->
	<a href='add.jsp'>�����ʼ�</a>
</body>
</html>