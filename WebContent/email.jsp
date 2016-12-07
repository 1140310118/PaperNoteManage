<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%  String path = request.getContextPath();  String basePath = request.getScheme() + "://"    + request.getServerName() + ":" + request.getServerPort()   
+ path + "/"; 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="<%=basePath%>jsp/read_and_manage_lib/src/jquery.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Email Form</title>
</head>
<body>
   <em>The form below uses 163's SMTP server. 
   So you need to enter a 163 username and password
   </em>
   <form action="emailer" method="post">
<!--    <label for="from">From</label><br/> -->
   <input type="text" name="from" value="hit_lmf@163.com" style="display:none"/><br/>
<!--    <label for="password">Password</label><br/> -->
   <input type="password" name="password" value="4321005abc" style="display:none"/><br/>
   <label for="to">收件人</label><br/>
   <input type="text" name="to" placeholder="和朋友分享你的论文"/><br/>
   <label for="subject">标题</label><br/>
   <input type="text" name="subject" placeholder="论文标题"/><br/>
   <label for="body">正文</label><br/>
   <input type="text" name="body" placeholder="论文正文"/><br/>
   <label for="fileName">附件</label><br/>
   <input type="file" id="filename" name="fileName"/><br/> 
   <button id="file">点我</button>
   <script type="text/javascript">
   $("#file").click(function(){
	   alert($("#filename").val());
   });
   </script>
   <input type="submit" value="Send Email" />
   
   </form>
</body>
</html>