<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%  String path = request.getContextPath();  String basePath = request.getScheme() + "://"    + request.getServerName() + ":" + request.getServerPort()   
+ path + "/"; %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" class=" js flexbox canvas canvastext webgl no-touch geolocation postmessage websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers applicationcache svg inlinesvg smil svgclippaths">
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
    <link href="<%=basePath%>jsp/login_and_register_lib/login.css" rel="stylesheet" type="text/css">
    
    

  </head>
  <script type="text/javascript" src="<%=basePath%>jsp/login_and_register_lib/jquery-1.8.2.min.js" charset="utf-8"></script>
  <script type="text/javascript" src="<%=basePath%>jsp/login_and_register_lib/login.js" charset="utf-8"></script>
    
  <body style="padding-top : 30px;">
    <div class="Head">
      <div class="logo">
        <img src="<%=basePath%>jsp/login_and_register_lib/logo.gif">
      </div>
      <div class="Links">
        <a href="">收藏本站 </a>|
        <a href="">帮助</a>
      </div>
    </div>

    <div class="Main">
    <div class="MainBg">
      	<s:form method="post">
         	<div class="MainR">
			<div class="Header">
	        	<div class="title">用户登录</div>              
	        </div>
	        <br>
	
	        <div id="logArea">
	            <div class="inptr">
		            <input type="text" name="user.email" class="inpUser inped" placeholder="email" />
		            <br><br>
					<input type="password" name="user.password" class="inpPW" value="" autocomplete="off" placeholder="password"/>
		            <br><br>
	            </div>
				
				<br><br><br><br>
	           	<div class="inplist">
	                <label for="autoLogin">
	                <input type="checkbox">
	                    	自动登录
	                </label>
	            </div>
	            <br><br>
	
	            <div class="inpB">
	                <div>
	                    <button name="action:login" type="submit" class="Button">
	                     	 登录
	                  </button>
	                </div>
	            </div>
	              
	           	<br><br><br><br><br>
	
	            <div class="1Links">
	                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                <a href="#">忘记密码? </a>|
	                <a href="<%=basePath%>register">免费注册 </a>|
	                <a href="#">意见反馈 </a>
	                <a href="#"></a>
	            </div>
	        </div>
	        </div>
          
    	</s:form>
    </div>
    </div>
     
  </body>
</html>
