<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%  String path = request.getContextPath();  String basePath = request.getScheme() + "://"    + request.getServerName() + ":" + request.getServerPort()   
+ path + "/"; %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" class=" js flexbox canvas canvastext webgl no-touch geolocation postmessage websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers applicationcache svg inlinesvg smil svgclippaths">
  <head>
    <meta http-equiv="Content-Type"  charset="utf-8">
    <title>用户注册</title>
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
        <a href="<%=basePath%>"><img src="<%=basePath %>jsp/login_and_register_lib/logo.gif"></a>
      </div>
      <div class="Links">
        <a href="">收藏本站 </a>|
        <a href="">帮助</a>
      </div>
    </div>

    <div class="Main">
    
    <div class="MainBg">
	    <div class="HINT" id="email_hint" style="top:150px;display:none;">
	    	<p style="margin-left:10px;margin-right:20px;">此邮件已经使用。</p>
	    </div>
	    
	    <div class="HINT" id="password_hint" style="top:207px;display:none;">
	    	<p style="margin-left:10px;margin-right:20px;">密码长度不得小于8。</p>
	    </div>
	    
	    <div class="HINT" id="password2_hint" style="top:265px;display:none;">
	    	<p style="margin-left:10px;margin-right:20px;">两次输入的密码不一致。</p>
	    </div>
	    <div class="HINT" style="top:385px;border: 1px #000;
			border-top-left-radius: 0px;
			border-top-right-radius: 0px;
			border-bottom-left-radius: 0px;
			border-bottom-right-radius:0px;">
	    	<p style="margin-left:10px;margin-right:20px;">注意：<br>1、密码及用户名中不得包含单引号；<br>2、密码长度不得小于8，也不得大于16。</p>
	    	<br><br>
	    </div>
      <form method="post" id="registerForm" action="<%=basePath %>register_result">    
      <div class="MainR">
          <div class="Header">
            <div class="title">用户注册</div>              
          </div>

          <div id="logArea">
            <div class="inptr">
              <input type="text" name="email" id="userEmail" class="inpUser inped" placeholder="email" required>
              <br><br>
              <input type="password" name="password" id="userPassword" class="inpPW" value="" autocomplete="off" placeholder="password" required>
              <br><br>
              <input type="password" class="inpPW" value="" id="userPasswordConfirm" autocomplete="off" placeholder="Confirm password" required>
              <br><br>
              <input type="text" name="nickName" id="userNickname" class="inpUser" placeholder="nickname" required></input>
              <input name="registeringFlag" value="1" style="display:none;">
            </div>

            <br><br><br><br><br><br><br><br><br><br><br><br>

            <div class="inpB">
              <div>
              <button name="action:login" id="registerButton" type="submit" class="Button">
                       	 注册
              </button>
              </div>
            </div>

            <br>
            <div class="1Links">
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              &nbsp;&nbsp;&nbsp;&nbsp;
              已有账号，
              <a href="<%=basePath %>login?relogin=true"><u>直接登录</u></a>
            </div>
          </div>
      </div>
      </form>
    </div>
    </div>
  <script type="text/javascript">
  	$("#userEmail").change(function(){
        var userEmail=$("#userEmail").val();
        var format_flag=emailCheck_for_format(userEmail);
        if (!format_flag){
        	$("#email_hint").show();
        	$("#email_hint p").html("邮件格式不正确。");
        }else{
        	emailCheck_and_E_for_isexisted(userEmail);
        }
  	});
  	$("#userPassword").change(function(){
        var userPassword=$("#userPassword").val();
        var userPasswordConfirm=$("#userPasswordConfirm").val();
        // 判断密码长度是否小于8
        if (userPassword.length<8){
            $("#password_hint").show();
        	$("#password_hint p").html("密码长度小于8。");
        }else if(userPassword.length>16){
            $("#password_hint").show();
        	$("#password_hint p").html("密码长度大于16。");
        }else{
            $("#password_hint").hide();
        }
        
  	  	// 判断两次输入的密码是否一致
        if (userPassword != userPasswordConfirm){
            $("#password2_hint").show();
        }else{
            $("#password2_hint").hide();
        }
  	});
  	$("#userPasswordConfirm").change(function(){
        var userPassword=$("#userPassword").val();
        var userPasswordConfirm=$("#userPasswordConfirm").val();
  	    // 判断两次输入的密码是否一致
        if (userPassword != userPasswordConfirm){
            $("#password2_hint").show();
        }else{
            $("#password2_hint").hide();
        }
  	});
    $("#registerButton").click(function(event){
        var userEmail=$("#userEmail").val();
        var userPassword=$("#userPassword").val();
        var userPasswordConfirm=$("#userPasswordConfirm").val();
        var userNickname=$("#userNickname").val();
        if(userEmail && userPassword && userPasswordConfirm && userNickname){
            
            // 输入的字段中不允许包含单引号
            if( userEmail.match("\'") || userPassword.match("\'") || 
                userPasswordConfirm.match("\'") || userNickname.match("\'")){
                alert("字段中不允许包含单引号！");
                event.preventDefault();
                return;
            }
            if($("#email_hint").css("display")=="none" && $("#password_hint").css("display")=="none" && $("#password2_hint").css("display")=="none"){
    			return;
    		}
            else{
            	event.preventDefault();
                return;
            }
        }
    });

    // email检查
    function emailCheck_for_format(email){
      //  userEmail中不包含 @ ，则提示“邮件格式不正确”
      if (!email.match("@")){
    	  return;
      }else{
    	  return 1;
      }
    }
    function emailCheck_and_E_for_isexisted(email){ 
      $.post("<%=basePath%>register_isEmailExisted",
	  	   		{
	  				 email: email
	  			},
	  	   		function(isexisted_flag){
	  				if (isexisted_flag.indexOf("1")!=-1){
	  			      	$("#email_hint").show();
	  				    	$("#email_hint p").html("此邮件已经使用。");
	  			  	}else{
	  			  		$("#email_hint").hide();
	  			  	}
	  			}
		);
    }
    
   
  </script>
  </body>
</html>