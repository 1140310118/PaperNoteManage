
<!DOCTYPE html>
<head>
    <title>
        就叫2333 - 文献阅读管理系统
    </title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="./read_and_manage_lib/bootstrap.min.css" type="text/css" media="screen, project, print">
    <link rel="stylesheet" href="./read_and_manage_lib/main-cn.css" type="text/css" media="screen, project, print">
    <link rel="Shortcut Icon" href="#">
    <script src="./read_and_manage_lib/src/jquery.js"></script>
</head>


<body>  

<!--导航-->  
<div id="container">  
<div id="hw1_masthead">
    <div id="hw1_masthead_wrap" class="hw1_skinny">
      
        <div id="hw1_global_nav" class="lg-container">
            <nav>
                <div id="hw1_logo">
                    <a href="#">
                    <img alt="就叫2333" src="./read_and_manage_lib/logo.gif">
                    </a>
                </div>
                <ul class="nav_ul hw1_masthead_cata hidden-sm hidden-xs">
                    <celin>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</celin>
                    <li><a href="<%=basePath%>jsp/read">论文阅读</a></li>
                    <li><a href="<%=basePath%>jsp/manage">论文管理</a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>
</div>
<div id="windowZ" style="margin-top: 200px;margin-left: 500px;background:#eee;width: 200px;
    height: 300px;">
    <div id="window_head" style="background: #aaa;cursor:move">
        <center>我是头部</center>
    </div>
    <div >
        <textarea style="width:196px;height: 270px;margin-left: 2px;margin-top:5px;">something</textarea>
    </div>
</div>
<script type="text/javascript">
    var mDown=false;
    var positionX;
    var positionY;
    var X
    var Y;
    var moveX;
    var moveY;
    var xPage;
    var yPage;
    var keydownFlag=false;
    $("#window_head").mousedown(function(e){
        mDown=!mDown;
        X=e.clientX;
        Y=e.clientY;
        positionX = parseInt($("#windowZ").css("margin-left"));
        positionY = parseInt($("#windowZ").css("margin-top"));
        //alert("moveX="+e.pageX+"+"+positionX+"-"+X);
        return false;
    });
    $(document).mouseup(function(e){
        mDown=false;
    });
    $(document).mousemove(function (e){
        xPage=e.clientX;
        yPage=e.clientY;
        moveX=xPage+positionX-X;
        moveY=yPage+positionY-Y;
        if (keydownFlag==true){
            alert(moveX+"="+xPage+"+"+positionX+"-"+X);
        }
        if (mDown==true){
            $("#windowZ").css("margin-left",xPage);//moveX);
            $("#windowZ").css("margin-top" ,yPage);//moveY);
        }
    });

    // $(document).keydown(function(e){
    //     keydownFlag=true;
    // });
    // $(document).keyup(function(e){
    //     keydownFlag=false;
    // });
        

</script>








<br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br>


</body>
</html>