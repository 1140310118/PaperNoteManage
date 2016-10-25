<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type"  charset="utf-8">
    <title>用户注册</title>
    <link href="./register_lib/login.css" rel="stylesheet" type="text/css" charset="utf-8">
    
    <script type="text/javascript" src="./register_lib/jquery-1.8.2.min.js" charset="utf-8"></script>
    
    <script type="text/javascript" src="./register_lib/login.js" charset="utf-8"></script>
    
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
              <div class="title">用户注册</div>              
            </div>
            <br>

            <div id="logArea">
              <div class="inptr'">
                
                <input type="text" name="userEmail" class="inpUser inped" placeholder="email"></input>
                <br><br>

                <input type="password" name="password" class="inpPW" value="" autocomplete="off" placeholder="password"></input>
                <br><br>

                 <input type="password" name="password" class="inpPW" value="" autocomplete="off" placeholder="Confirm password"></input>
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
                <a href="./login.jsp"><u>直接登录</u></a>
              </div>

          </div>
      </div>
    </div>
     
  </body>
</html>