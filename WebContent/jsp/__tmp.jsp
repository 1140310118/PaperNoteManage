<!DOCTYPE html>
<!-- saved from url=(0025)http://www.huawei.com/cn/ -->
<html xmlns="http://www.w3.org/1999/xhtml" class=" js flexbox canvas canvastext webgl no-touch geolocation postmessage websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers applicationcache svg inlinesvg smil svgclippaths">
<head>
	<title>
		就叫2333 - 文献阅读管理系统
	</title>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="./read_and_manage_lib/bootstrap.min.css" type="text/css" media="screen, project, print">
	<link rel="stylesheet" href="./read_and_manage_lib/main-cn.css" type="text/css" media="screen, project, print">
	<link rel="Shortcut Icon" href="#">

	<!-- Iconos -->
	<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./read_and_manage_lib/css/style.css" media="screen" type="text/css" />

    <!--文件列表-->
    <link href="./read_and_manage_lib/css/file_list.css" rel="stylesheet" type="text/css" media="screen" />	
    <link href="./read_and_manage_lib/css/simple.css" rel="stylesheet" type="text/css" media="screen"/>	
    <link href="./read_and_manage_lib/css/table.css" rel="stylesheet" type="text/css" media="screen"/>	

	<script src="./read_and_manage_lib/js/simple.js"></script>

</head>


<body>  

<div id="container">  
<div id="hw1_masthead">
<!--导航--> 
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
                    <li><a href="./read.jsp">论文阅读</a></li>
                    
                    <li><a href="./manage.jsp">论文管理</a></li>
                	
                </ul>
            </nav>
        </div>
    </div>
<!---->

<br><br><br><br><br><br><br><br><br><br><br><br>
<form mothod="POST" id="search_form">
　　<div class="cf">
   　　<label class="search-bar">
      　　<input id="keyword" placeholder="请输入搜索关键词" name="user_info_keyword" type="text" value="" class="input-search">
      　　<a id="search" class="btn-search"><i class="icon-search"></i></a>
      　　<a href="javascript:;" class="btn-more"></a>
      </label>
　　</div>
</form>
<script type="text/javascript">
jQuery(document).ready(function (){
   jQuery('#search_form').bind("submit", function(){
         var key_word = jQuery("#keyword").val();
         if(key_word == ""){ return false; }

         var options = {
                url: '/portrait/user_info_display?user_info_keyword=' + key_word,
                type: 'post',
                dataType: 'text',
                data: $("#search_form").serialize(),
                success: function (data) {
                    if (data.length > 0)
                        jQuery("#user_info").html(data);
                }
         };
         $.ajax(options);
         return false;
   })

   $('#search').click(function(){
        $('#search_form').submit();
   })
});
</script>
</div>
</div>


</body>
</html>