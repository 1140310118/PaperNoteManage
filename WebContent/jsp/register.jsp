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
  </head>

  <body style="padding-top : 30px;">
    <div class="Head">
      <div class="logo">
        <img src="<%=basePath %>jsp/login_and_register_lib/logo.gif">
      </div>
      <div class="Links">
        <a href="">收藏本站 </a>|
        <a href="#">帮助</a>
      </div>
    </div>

    <div class="Main">
    <div class="MainBg">
      <s:form method="post" id="registerForm">    
      <div class="MainR">
          <div class="Header">
            <div class="title">用户注册</div>              
          </div>
          <br>

          <div id="logArea">
            <div class="inptr">
              <input type="text" name="user.email" id="userEmail" class="inpUser inped" placeholder="email" required>
              <br><br>
              <input type="password" name="user.password" id="userPassword" class="inpPW" value="" autocomplete="off" placeholder="password" required>
              <br><br>
              <input type="password" class="inpPW" value="" id="userPasswordConfirm" autocomplete="off" placeholder="Confirm password" required>
              <br><br>
              <input type="text" name="user.nickname" id="userNickname" class="inpUser" placeholder="nickname" required></input>
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
      </s:form>
    </div>
    </div>
  <script type="text/javascript">
    $("#registerButton").click(function(event){
        var userEmail=$("#userEmail").val();
        var userPassword=$("#userPassword").val();
        var userPasswordConfirm=$("#userPasswordConfirm").val();
        var userNickname=$("#userNickname").val();
        // 当四个字段都不为空的时候，开始判断
        //（不都为空的时候，由于requird属性限制，表单无法提交）
        if(userEmail && userPassword && userPasswordConfirm && userNickname){
            
            // 输入的字段中不允许包含单引号
            if( userEmail.match("\'") || userPassword.match("\'") || 
                userPasswordConfirm.match("\'") || userNickname.match("\'")){
                alert("字段中不允许包含单引号！");
                event.preventDefault();
                return;
            }

            //  userEmail中不包含 @ ，则提示“邮件格式不正确”
            if (!emailCheck(userEmail)){
                event.preventDefault();
                return;
            }

            // 密码格式检查
            if (!passwordCheck(userPassword,userPasswordConfirm)){
                event.preventDefault();
                return;
            }
        }
    });

    // 密码检查
    function passwordCheck(password,passwordConfirm){
      // 判断两次输入的密码是否一致
      if (password != passwordConfirm){
          alert("两次输入的密码不一致!");
          return;
      }

      // 判断密码的长度是否大于8
      if (password.length<8){
          alert("密码的长度不得小于8");
          return;
      }
      return 1;
    }

    // email检查
    function emailCheck(email){
      //  userEmail中不包含 @ ，则提示“邮件格式不正确”
      if (!email.match("@")){
          alert("邮件格式不正确！");
          return;
      }
      return 1;
    }
  </script>
  </body>
</html>