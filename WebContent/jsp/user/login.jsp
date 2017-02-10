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
    <script type="text/javascript" src="<%=basePath %>jsp/ssslogin_and_register_lib/jquery-1.8.2.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath %>jsp/login_and_register_lib/login.js" charset="utf-8"></script>
    <script src="<%=basePath%>jsp/read_and_manage_lib/src/jquery.js"></script>
    <style type="text/css">
    .HINT{
		background-color: #efefef;
		border: 1px solid #000;	
		border-top-left-radius: 10px;
		border-top-right-radius: 10px;
		border-bottom-left-radius: 10px;
		border-bottom-right-radius: 10px;
		position:absolute;
		right:630px;
		opacity: 0.9;
	}
	</style>
  </head>
    
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
		<div class="HINT" id="correct_hint" style="top:200px;display:none;">
	    	<p style="margin-left:10px;margin-right:20px;">邮箱或者密码错误。</p>
	    </div>

	  	<s:form method="post">
	     	<div class="MainR">
			<div class="Header">
	        	<div class="title">用户登录</div>              
	        </div>
	        <br>

	        <div id="logArea">
	            <div class="inptr">
		            <input type="text" name="email" class="inpUser inped" placeholder="email" required id="userEmail">
		            <br><br>
					<input type="password" name="password" class="inpPW" id="userPassword" autocomplete="off" placeholder="password" required>
		            <br><br>
	            </div>
				
				<br><br><br><br>
	           	<div class="inplist">
	                <label for="autoLogin">
	                <input type="checkbox" id="ck_rmbUser" onclick="Save()">
	                    	记住用户名和密码
	                </label>
	            </div>
	            <br><br>

	            <div class="inpB">
	                <div>
	                    <button id="loginButton" class="Button">
	                     	 登 录
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
	<script type="text/javascript">
    $("#loginButton").click(function(event){
        event.preventDefault();
        var userEmail=$("#userEmail").val();
        var userPassword=$("#userPassword").val();
        // 当二个字段都不为空的时候，开始判断
        if(userEmail && userPassword){
	        // 输入的字段中不允许包含单引号
	        if( userEmail.match("\'") || userPassword.match("\'")){
	            alert("字段中不允许包含单引号！");
	        }else{
	        	login(userEmail,userPassword);
	        }
        }
    });
    function login(email,password){
    	$.post("<%=basePath%>login_result",
	  	   		{
	  				 email: email,
	  				 password:password
	  			},
	  	   		function(success_flag){
	  				if (success_flag.indexOf("1")!=-1){
	  			   		window.location.href="<%=basePath%>manage";
	  			  	}else{
	  			  		alert("用户名或者密码错误");
	  			  	}
	  			}
		);
    }
  	</script>
	</body>
</html>
