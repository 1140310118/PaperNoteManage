<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%  String path = request.getContextPath();  String basePath = request.getScheme() + "://"    + request.getServerName() + ":" + request.getServerPort()   
+ path + "/"; %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" class=" js flexbox canvas canvastext webgl no-touch geolocation postmessage websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers applicationcache svg inlinesvg smil svgclippaths">
  <head>
    <meta http-equiv="Content-Type"  charset="utf-8">
    <title>用户注册</title>
    <link href="<%=basePath %>jsp/register_lib/login.css" rel="stylesheet" type="text/css">
    
    <script type="text/javascript" src="<%=basePath %>jsp/register_lib/jquery-1.8.2.min.js" charset="utf-8"></script>
    
    <script type="text/javascript" src="<%=basePath %>jsp/register_lib/login.js" charset="utf-8"></script>
    
    <script type="text/javascript">
      var markme_msg = "under construction";
    </script>

  </head>
  <body style="padding-top : 30px;">
    <div class="Head">
      <div class="logo">
        <img src="./register_lib/logo.gif">
      </div>
      <div class="Links">
        <a href="">收藏本站 </a>|
        <a href="#">帮助</a>
      </div>
    </div>

    <div class="Main">
      <div class="MainBg">
          <s:form method="post">
          <div class="MainL">
          </div>
          <div class="MainR">

            <div class="Header">
              <div class="title">用户注册</div>              
            </div>
            <br>

            <div id="logArea">
              <div class="inptr'">
                
                <input type="text" name="user.email" class="inpUser inped" placeholder="email"></input>
                <br><br>

                <input type="password" name="user.password" class="inpPW" value="" autocomplete="off" placeholder="password"></input>
                <br><br>

                 <input type="password" class="inpPW" value="" autocomplete="off" placeholder="Confirm password"></input>
              	<input name="registeringFlag" value="1" style="display:none;"></input>
             
              </div>

              <br><br><br><br>

              <div class="inpB">
                <div>
                    <button name="action:login" type="submit" class="Button">
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
                <a href="<%=basePath %>jsp/login.jsp"><u>直接登录</u></a>
              </div>

          </div>
        </div>

        </s:form>
    </div>
  </div>
     
  </body>
</html>