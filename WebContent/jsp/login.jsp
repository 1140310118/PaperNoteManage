<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type"  charset="utf-8">
    <title>登录</title>
    <link href="./login_lib/login.css" rel="stylesheet" type="text/css" charset="utf-8">
    
    <script type="text/javascript" src="./login_lib/jquery-1.8.2.min.js" charset="utf-8"></script>
    
    <script type="text/javascript" src="./login_lib/login.js" charset="utf-8"></script>
    
    <script type="text/javascript">
      var markme_msg = "under construction";
    </script>

  </head>
  <body style="padding-top : 30px;">
    <div class="Head">
      <div class="logo">
        <img src="./login_lib/logo.gif">
      </div>
      <div class="Links">
        <a herf="javascript:bookmarkMe()">收藏本站 </a>|
        <a href="#">帮助</a>
      </div>
    </div>

    <div class="Main">
      <div class="MainBg">
          <form method="post" action="#" onsubmit="login_function;">
          <div class="MainL">
          </div>
          <div class="MainR">

            <div class="Header">
              <div class="title">用户登录</div>              
            </div>
            <br>

            <div id="logArea">
              <div class="inptr">
                
                <input type="text" name="userEmail" class="inpUser inped" placeholder="email" ></input>
                <br><br>

                <input type="password" name="password" class="inpPW" value="" autocomplete="off" placeholder="password"></input>
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
                <a href="./register.jsp">免费注册 </a>|
                <a href="#">意见反馈 </a>
                <a herf="#"></a>
              </div>

          </div>
      </div>
    </div>
     
  </body>
</html>