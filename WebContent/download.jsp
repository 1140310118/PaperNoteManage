<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


</head>
<body>

<s:actionerror/>
<%
   java.io.File dir = new java.io.File("d:\\upload");
   java.io.File[] files = dir.listFiles();
   for(java.io.File file: files)
   {
	   String html = "<a href='download_" + file.getName() + ".action'>" + file.getName() + "</a><br>"; 
	   out.println(html);
   }
%>
</body>
</html>
