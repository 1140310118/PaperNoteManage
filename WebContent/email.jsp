<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Email Form</title>
</head>
<body>
   <em>The form below uses 163's SMTP server. 
   So you need to enter a 163 username and password
   </em>
   <form action="emailer" method="post">
   <label for="from">From</label><br/>
   <input type="text" name="from" value="hit_lmf@163.com"/><br/>
   <label for="password">Password</label><br/>
   <input type="password" name="password" value="4321005abc"/><br/>
   <label for="to">To</label><br/>
   <input type="text" name="to"/><br/>
   <label for="subject">Subject</label><br/>
   <input type="text" name="subject"/><br/>
   <label for="body">Body</label><br/>
   <input type="text" name="body"/><br/>
   <input type="submit" value="Send Email"/>
   </form>
</body>
</html>