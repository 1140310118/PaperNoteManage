<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%  String path = request.getContextPath();  String basePath = request.getScheme() + "://"    + request.getServerName() + ":" + request.getServerPort()   
+ path + "/"; %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" class=" js flexbox canvas canvastext webgl no-touch geolocation postmessage websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers applicationcache svg inlinesvg smil svgclippaths">
  <head>
    <meta http-equiv="Content-Type"  charset="utf-8">
    <title>注册失败</title>
    <link href="<%=basePath%>jsp/login_and_register_lib/login.css" rel="stylesheet" type="text/css">
    
    <script type="text/javascript" src="<%=basePath %>jsp/ssslogin_and_register_lib/jquery-1.8.2.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath %>jsp/login_and_register_lib/login.js" charset="utf-8"></script>
    <script src="<%=basePath%>jsp/read_and_manage_lib/src/jquery.js"></script>
  </head>

  <body style="padding-top : 30px;">
    <div class="Head">
      <div class="logo">
        <a href="<%=basePath%>"><img src="<%=basePath %>jsp/login_and_register_lib/logo.gif"></a>
      </div>
      <div class="Links">
        <a href="">收藏本站 </a>|
        <a href="">帮助</a>
      </div>
    </div>
    <div style="margin-left:300px;margin-top:50px;">
    	<font size="5">
    		<p>注册失败，重新 <a href="<%=basePath%>register"><font color="blue"><u>注 册</u></font></a> 。</p>
    	</font>
    </div>
  </body>
</html>