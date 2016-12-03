
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%  String path = request.getContextPath();  String basePath = request.getScheme() + "://"    + request.getServerName() + ":" + request.getServerPort()   
+ path + "/"; 
%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!-- saved from url=(0025)http://www.huawei.com/cn/ -->
<html xmlns="http://www.w3.org/1999/xhtml" class=" js flexbox canvas canvastext webgl no-touch geolocation postmessage websqldatabase indexeddb hashchange history draganddrop websockets rgba hsla multiplebgs backgroundsize borderimage borderradius boxshadow textshadow opacity cssanimations csscolumns cssgradients cssreflections csstransforms csstransforms3d csstransitions fontface generatedcontent video audio localstorage sessionstorage webworkers applicationcache svg inlinesvg smil svgclippaths">
<head>
	<title>
		就叫2333 - 文献阅读管理系统
	</title>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="<%=basePath%>jsp/read_and_manage_lib/bootstrap.min.css" type="text/css" media="screen, project, print">
	<link rel="stylesheet" href="<%=basePath%>jsp/read_and_manage_lib/main-cn.css" type="text/css" media="screen, project, print">
	<link rel="stylesheet" href="<%=basePath%>jsp/read_and_manage_lib/zTreeStyle.css" type="text/css" media="screen, project, print">

	<link rel="Shortcut Icon" href="#">
    <script src="<%=basePath%>jsp/read_and_manage_lib/src/jquery.js"></script>
    <script src="<%=basePath%>jsp/read_and_manage_lib/js/jquery.jsonp.js"></script>
    <script src="<%=basePath%>jsp/read_and_manage_lib/js/jquery.ztree.core-3.5.js"></script>
    <script language="javascript" type="text/javascript" src="<%=basePath%>jsp/read_and_manage_lib/js//jquery.ztree.excheck-3.5.js"></script>
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
                	<img alt="就叫2333" src="<%=basePath%>jsp/read_and_manage_lib/logo.gif">
                	</a>
                </div>
                <ul class="nav_ul hw1_masthead_cata hidden-sm hidden-xs">
                 	<celin>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</celin>
                    <li><a href="<%=basePath%>read">论文阅读</a></li>
                    <li><a href="<%=basePath%>manage">论文管理</a></li>
                </ul>
            </nav>
            <div style="float: right;font-size: 14px;margin-right: 50px;">
            	<celin id="userName"><s:property value="#session.USER_Nickname"/></celin> | <celin id="ID_logout"><a href="<%=basePath%>login?relogin=true">退出登录</a></celin>
             <script type="text/javascript">
    	     	var name=$("#userName").html();
    	     	if(name=="user_nickname" || name==""){
    	     		$("#userName").html("尚未登录");
    	     		$("#ID_logout").html("去<font color=\"blue\"><a href=\"<%=basePath%>login?relogin=true\">登录</a></font>");
    	     	}
            </script> 
        </div>
    </div>
    </div>
<div style="magrin-top:300px;float:left;margin-left:30px;margin-top:100px;position: absolute;background:#eee;">
<ul id="cityTree" class="zTree"></ul>
sdfadfsdfsdafsd
</div>

<script type="text/javascript" language="javascript">
/**ztree的参数配置，setting主要是设置一些tree的属性，是本地数据源，还是远程，动画效果，是否含有复选框等等**/  
var setting = {
 check: { /**复选框**/
  enable: false,
  chkboxType: {"Y":"", "N":""}
 },
 view: {                                  
  //dblClickExpand: false,
  expandSpeed: 300 //设置树展开的动画速度，IE6下面没效果，
 },                          
 data: {                                  
  simpleData: {   //简单的数据源，一般开发中都是从数据库里读取，API有介绍，这里只是本地的                         
   enable: true,
   idKey: "id",  //id和pid，这里不用多说了吧，树的目录级别
   pIdKey: "pId",
   rootPId: 0   //根节点
  }                          
 },                         
 callback: {     /**回调函数的设置，随便写了两个**/
  beforeClick: beforeClick,                                  
  onCheck: onCheck                          
 }
};
function beforeClick(treeId, treeNode) {
 alert("beforeClick");
}
function onCheck(e, treeId, treeNode) {
 alert("onCheck");
}     

var citynodes = [      /**自定义的数据源，ztree支持json,数组，xml等格式的**/
 {id:0, pId:-1, name:"中国"},
 {id:1, pId:0, name:"北京"}, 
 {id:2, pId:0, name:"天津"},
 {id:3, pId:0, name:"上海"}, 
 {id:6, pId:0, name:"重庆"}, 
 {id:4, pId:0, name:"河北省", open:false, nocheck:true}, 
 {id:41, pId:4, name:"石家庄"}, 
 {id:42, pId:4, name:"保定"}, 
 {id:43, pId:4, name:"邯郸"}, 
 {id:44, pId:4, name:"承德"}, 
 {id:5, pId:0, name:"广东省", open:false, nocheck:true}, 
 {id:51, pId:5, name:"广州"}, 
 {id:52, pId:5, name:"深圳"}, 
 {id:53, pId:5, name:"东莞"}, 
 {id:54, pId:5, name:"佛山"}, 
 {id:6, pId:0, name:"福建省", open:false, nocheck:true}, 
 {id:61, pId:6, name:"福州"}, 
 {id:62, pId:6, name:"厦门"}, 
 {id:63, pId:6, name:"泉州"}, 
 {id:64, pId:6, name:"三明"},
 {id:7, pId:0, name:"四川省", open:true, nocheck:true},
 {id:71, pId:7, name:"成都"},
 {id:72, pId:7, name:"绵阳"},
 {id:73, pId:7, name:"自贡"},
 {id:711, pId:71, name:"金牛区"},
 {id:712, pId:71, name:"锦江区"},
 {id:7111, pId:711, name:"九里堤"},
 {id:7112, pId:711, name:"火车北站"}
];

$(document).ready(function(){//初始化ztree对象   
  var zTreeDemo = $.fn.zTree.init($("#cityTree"),setting, citynodes);
});
</script>  

<!--pdf-->
<!-- embed width="800" height="600" src="./test.pdf">
<iframe width="800" height="600" src="./test.pdf"></iframe-->
 <div style="float:left;margin-left:200px;margin-top: 50px;">
 <iframe width="800" height="600" src="<%=basePath%>file/zzh19971968@foxmail.com/test/test.pdf"></iframe>
</div>

<div id="already_saved" style="display: none;z-index: 9999;position: absolute;left:80%">已经保存</div>
<div style="magrin-top:300px;float:left;margin-left:1000px;margin-top:100px;position: absolute;background:#eee;">
	<input type="text" style="width: 210px;" id="wordT"/>
	<button id="dictS_button">查询</button>
	<div id="translateResult"></div>
	<br>
	<button id="addNoteButton" name="addNoteFlag">添加笔记</button>
	<c:set var="i" value="0"></c:set>
	<div id="noteArea">
		<s:iterator value="notes">
			<div id="note_${notes[i].noteID}">	
				<c:set var="i" value="${i+1}"></c:set>
				<textarea placeholder="笔记" class="note_class" spellcheck="false" style="font-size:12px;width:200px;height:100px;line-height:18px;"><s:property value="content"/></textarea>
				<button class="note_delete_button_class">删除笔记</button>
			</div>
		</s:iterator>
	</div>
</div>

<br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br>

<script type="text/javascript">
	$(document).ready(function(){
		dictSearch();
        addNote();
        modifyNote();
        deleteNote();
    });
	function strToJson(str){ 
		var json = eval('(' + str + ')'); 
		return json; 
		} 
	
	function dictSearch(){
    	$("#dictS_button").click(function(){
    		var wordT = $("#wordT").val(); 
    		if (!wordT){
    			alert("请输入您要查询的单词。");
    			return;
    		}
    		$.post("<%=basePath%>wordTranslate",
			   		{
						wordT : wordT
					},
			   		function(data){
						//alert(data);
						var json = strToJson(data);
// 						alert(json["basic"]["explains"]);
						$("#translateResult").html("<div class=\"translationResultContent\">"
													+json["basic"]["explains"]
													+"<br>"
													+"<a id=\"tDetail\" style=\"cursor:pointer\"><font color=\"blue\">去有道，查看详情</font></a>|"
													+"<a class=\"hideTR\" style=\"cursor:pointer\"><font color=\"blue\">关闭</font></a>"
													+"</div>");
						translateDetail(wordT);
						hideTranslationR();
	      	}); 
    	});
    }
	function hideTranslationR(){
		$(".hideTR").click(function(){
			$(".translationResultContent").hide();
		});
	}
	function translateDetail(wordT){
		$("#tDetail").click(function(){
			var url="http://simsent.youdao.com/search?q="+wordT;
			//window.location.href=url;
			window.open(url);
		});
	}
    
	function addNote(){
		$("#addNoteButton").click(function(){
			$.post("<%=basePath%>newNote",
			   		{
						addNoteFlag : true
					},
			   		function(newNoteID){
						newNoteID=newNoteID.substring(0,newNoteID.length-2);
						$("#noteArea").append("");
						$("#noteArea").append("<div id=\"note_"+newNoteID+"\">"
												+"<textarea placeholder=\"笔记\" class=\"note_class\" spellcheck=\"false\" style=\"font-size:12px;width:200px;height:100px;line-height:18px;\"></textarea>"
												+"\n<button class=\"note_delete_button_class\">删除笔记</button>"
												+"</div>");
						$("#note_"+newNoteID+" textarea").change(function(){
				        	var id = $(this).parent().attr("id");
							_modifyNote(id);
						});
						$("#note_"+newNoteID+" button").click(function(){
				        	var id = $(this).parent().attr("id");
				        	_deleteNote(id);
						});
						
			   		}
			);
		});
	}
	function modifyNote(){
		$(".note_class").change(function(){
        	var id = $(this).parent().attr("id");
			_modifyNote(id);
		});
	}
	function _modifyNote(id){
		$.post("<%=basePath%>read",
		   		{
				 	modifyNoteID: id.substring(5),
					modifyNoteContent:$("#"+id+" textarea").val()
				},
		   		function(){
		   			showAlreadySaved();
		   		}
		);
	}
	function deleteNote(){
		$(".note_delete_button_class").click(function(){
        	var id = $(this).parent().attr("id");
        	_deleteNote(id);
		});
	}
	function _deleteNote(id){
		$.post("<%=basePath%>read",
		   		{
				 	deleteNoteID: id.substring(5)
				},
		   		function(){
					$("#"+id).hide();//hide 删除按钮
		   			alert("删除成功！");		   			
		   		}
		);
	}
	function showAlreadySaved(){
		if ($("#already_saved").css('display')=='none'){
			 $('#already_saved').css({display:'block', top:'-100px'}).animate({top: '+100'}, 500, function(){ 
                        setTimeout(outAlreadySaved, 750); 
            			}
            ); 
		}
	}
	function outAlreadySaved(){
		$('#already_saved').animate({top:'0'}, 200, function(){ 
                $(this).css({display:'none', top:'-100px'}); 
            }); 
	}
</script>

<!--底部-->
<div id="footer" class="winwin-footer" style="top: initial;">
    <div class="container">
    <div class="top">
    <div class="row">
        <div class="col-md-8 col-sm-12 hidden-xs">
        <div class="left">
        <div class="left_inner row">
            <div class="col-sm-3">
            	<label>关于我们</label>
                <ul>
                    <li><a href="#">小组简介</a></li>
                    <li><a href="#">联系我们</a></li>
                    <li><a href="#">意见反馈</a></li>
                    <li><a href="#">留言板</a></li>
                </ul>
            </div>
            <div class="col-sm-3">
            	<label>新闻 &amp; 通知</label>
                <ul>
                	<li><a href="#">新闻</a></li>
                </ul>
            </div>
            <div class="col-sm-3">
            	<label>友情链接</label>
                <ul>
                	<li><a href="http://www.hit.edu.cn">
                		哈尔滨工业大学
                	</a></li>
                	<li><a href="http://www.cnki.net/">
                    	中国知网
                    </a></li>
                    <li><a href="#">万方数据库</a></li>
                </ul>
            </div>
        </div>       
    	</div>
		</div>
	</div>
    </div>
    </div>

	<hr class="hw1_hr">
	<div class="container">
	    <div class="bottom">
	    <div class="row">
	    	<div class="col-sm-7 col-md-5 hidden-xs hidden-sm">
	        <div class="bottom_left">
			<span id="indexfooter_2_tCopyRight">
		    ©2016 就叫2333小组 &nbsp;&nbsp; 版权所有 &nbsp;&nbsp;
		    </span>
	        </div>
	    	</div>
	    </div>
	    </div>
	</div>
</div>
</div>
</div>

</body>
</html>