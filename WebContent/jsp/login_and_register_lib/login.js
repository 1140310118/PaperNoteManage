var jQ=jQuery.noConflict();
var dialog;
function init(_1){
var _2,i,_3;
_2=["uid","domain","password","dynamicPwd","verifyCode"];
for(i=0;i<_2.length;i++){
_3=document.getElementById(_2[i])||document.getElementsByName(_2[i])[0];
if(_3==null){
continue;
}
if(_3.type=="text"){
_3.onfocus=function(_4){
var e=_4||window.event;
var _5=e.target||e.srcElement;
jQ(_5).addClass("focus");
if(this.name=="verifyCode"){
var _6=document.getElementById("vcImageTR");
if(_6){
_6.style.display="";
}
}
};
_3.onblur=function(_7){
var e=_7||window.event;
var _8=e.target||e.srcElement;
jQ(_8).removeClass("focus");
};
}
if(_3.name=="uid"||_3.name=="password"){
_3.onkeyup=function(){
uidPasswordChanged();
};
}
if(!_3.value){
var _9=getCookie(_3.name);
if(_9){
_3.value=_9;
}
}
if(_3.name==_1){
_3.focus();
}
}
initCommon();
uidPasswordChanged();
};
function switchLoginForm(id){
var _a=["userLoginTab","adminLoginTab"];
for(var i=0;i<_a.length;i++){
var _b=document.getElementById(_a[i]);
if(_b){
if(_b.id==id){
_b.className="active";
}else{
_b.className="inactive";
}
}
}
};
function initXT3(_c){
var _d,_e;
_d=["uid","password","verifyCode"];
initInputCss(_d,_c);
var _f=new RegExp("^Button-.*\\s");
jQ("button[name='action:login']").bind("mouseover",function(){
this.className="Button-hover "+this.className;
});
jQ("button[name='action:login']").bind("mouseout",function(){
this.className=this.className.replace(_f,"");
});
jQ("button[name='action:login']").bind("click",function(){
this.className=this.className.replace(_f,"");
this.className="Button-click "+this.className;
});
if(Math.round(Math.random())==1){
jQ(".Main").removeClass("Main").addClass("Main1");
jQ(".MainBg").removeClass("MainBg").addClass("MainBg1");
}
jQ(document).mousedown(function(e){
e=e||window.event||this.parentWindow.event;
var _10=e.srcElement||e.target;
while(_10!==undefined&&_10!==null){
if(_10.className!="language"){
fadeOutElement(jQ(".localePanel").get(0));
}
if(_10.id!="inpDomain"){
fadeOutElement(jQ(".domainPanel").get(0));
}
if(_10.id!="faceSelectOption"){
fadeOutElement(jQ(".facePanel").get(0));
}
_10=_10.parentNode;
}
});
initCommon();
adjustHeight();
window.onresize=adjustHeight;
};
function initInputCss(_11,_12){
var _13;
for(var i=0;i<_11.length;i++){
_13=document.getElementById(_11[i])||document.getElementsByName(_11[i])[0];
if(_13==null){
continue;
}
if(_13.type=="text"||_13.type=="password"){
_13.onmouseover=function(){
if(document.activeElement.name!=this.name){
jQ(this).addClass("inpOver");
jQ(this).removeClass("inpFocus");
}
};
_13.onmouseout=function(){
if(document.activeElement.name!=this.name){
jQ(this).removeClass("inpOver");
jQ(this).removeClass("inpFocus");
}
};
_13.onblur=function(){
jQ(this).removeClass("inpOver");
jQ(this).removeClass("inpFocus");
jQ(this).removeClass("inped");
if(jQ.trim(this.value).length>0){
jQ(this).addClass("inped");
}
this.value=jQ.trim(this.value);
};
_13.onfocus=function(){
jQ(this).removeClass("inpOver");
jQ(this).addClass("inpFocus");
};
}
if(!_13.value){
var _14=getCookie(_13.name);
if(_14){
_13.value=_14;
}
}
if(_13.name==_12){
_13.focus();
}
if(jQ.trim(_13.value).length>0){
jQ(_13).addClass("inped");
}
}
};
function initCommon(){
(document.getElementById("vcImage")||{}).onclick=function(){
this.src=this.src.replace(/&rand=[\w\-\.]+/,"&rand="+Math.random());
};
(document.getElementById("vcHint")||{}).href="javascript:document.getElementById('vcImage').onclick();";
var _15=document.getElementById("homepage");
if(_15){
if(document.all){
_15.href="javascript:void(0);";
_15.style.behavior="url(#default#homepage)";
_15.onclick=function(){
this.setHomePage(document.location);
};
}else{
_15.style.display="none";
}
}
};
function adjustHeight(){
var _16=jQ("div[class='Head']").height();
var _17=jQ("div[class='Main']").length==0?jQ("div[class='Main1']").height():jQ("div[class='Main']").height();
var _18=jQ("div[class='MainM']").height();
var _19=jQ("div[class='footer']").height();
var _1a=parseInt(jQ(".footer").css("padding-bottom"));
var _1b=_16+_17+_18+_19+_1a;
var top=(getClientSize()[1]-_1b)/2;
if(top>0){
jQ("body").css("padding-top",top);
}else{
jQ("body").css("padding-top","0px");
}
adjustElPos(jQ("localeArea").get(0),jQ("#language").get(0),5,-4);
adjustElPos(jQ("#domainPanel").get(0),jQ("#inpDomain").get(0));
};
function getCookie(_1c){
var reg=new RegExp("(^| )"+_1c+"=([^;]*)(;|$)","gi");
var tmp=reg.exec(document.cookie);
return unescape((tmp||[])[2]||"");
};
function setCookie(_1d,_1e){
document.cookie=_1d+"="+escape(_1e)+";expires="+(new Date(1990,1,1)).toGMTString();
document.cookie=_1d+"="+escape(_1e)+";path=/"+";expires="+(new Date(2099,12,31)).toGMTString();
};
function changeLocale(_1f,_20){
setCookie("locale",_1f);
window.location=location;
};
function changeDomain(val){
jQ("input[name='domain']").val(val);
jQ("#domainVal").html(val);
fadeOutElement(jQ(".domainPanel").get(0));
};
function changeFace(key,val){
jQ("input[name='face']").val(key);
jQ("#faceVal").html(val);
fadeOutElement(jQ(".facePanel").get(0));
};
function fadeInElement(el,_21,_22,_23){
if(jQ(el).length>0){
if(jQ(el).is(":hidden")){
jQ(el).fadeIn();
adjustElPos(el,_21,_22,_23);
}
}
};
function displayFacePanel(el){
fadeInElement(jQ(".facePanel").get(0),el);
var _24=0-jQ(".facePanel").height()-jQ(el).height();
adjustElPos(jQ(".facePanel").get(0),el,_24-5,-12);
};
function fadeOutElement(el){
if(jQ(el).length>0){
if(jQ(el).is(":visible")){
jQ(el).fadeOut();
}
}
};
function adjustElPos(el,_25,_26,_27){
_26=_26||0;
_27=_27||0;
if(jQ(el).length>0){
if(jQ(el).is(":visible")){
jQ(el).css("top",jQ(_25).offset().top+jQ(_25).height()+_26+"px");
jQ(el).css("left",jQ(_25).offset().left+_27+"px");
}
}
};
function loginSubmit(_28,_29,_2a){
_2a=_2a||"/coremail";
if((document.getElementById("saveUsername")||{checked:true}).checked){
setCookie("uid",document.getElementById("uid").value);
if(document.getElementById("domain")){
setCookie("domain_name",jQ("#domain").val());
}
}
if(document.getElementById("locale")){
setCookie("locale",document.getElementById("locale").value);
}
var _2b=document.getElementById("speedtest");
if(_2b){
var _2c=getCookie("netSpeedServerHost");
if(_2c){
var _2d=location.protocol+"//"+_2c;
if(location.pathname){
_2d+=location.pathname;
}
_28.action=_2d;
}
}
var _2e=(document.getElementsByName("useSSL")[0]||{}).checked;
if(typeof (_2e)=="boolean"){
var _2f=_2e?"http://":"https://";
var _30=_2e?"https://":"http://";
_28.action=(function translateProtocol(url){
if(url.charAt(0)=="/"){
if(location.protocol+"//"!=_30){
return _31(_30+location.hostname+url);
}
return _31(url);
}
if(url.substring(0,_2f.length).toLowerCase()==_2f){
var _32=url.indexOf("/",_2f.length);
var _33=url.lastIndexOf(":",_32);
if(_32>0&&_33>0&&url.substring(_33+1,_32).match(/^\d+$/)){
return _31(_30+url.substring(_2f.length,_33)+url.substring(_32));
}else{
return _31(_30+url.substring(_2f.length));
}
}
return _31(url);
})(_28.action);
}
if((document.getElementById("face_classic_cgi")||{}).selected){
if(document.all){
_29.returnValue=false;
}
document.getElementById("classic_cgi_form").elements["user"].value=_28.elements["uid"].value;
document.getElementById("classic_cgi_form").elements["pass"].value=_28.elements["password"].value;
document.getElementById("classic_cgi_form").submit();
return false;
}
function _31(url){
if((document.getElementById("adminLoginTab")||{}).className=="active"){
url=url.replace(_2a+"/index.jsp","/webadmin/index.jsp?submit=true");
url=url.replace(_2a+"/login.jsp","/webadmin/index.jsp?submit=true");
}
return url;
};
return true;
};
function recoverPwd(_34){
_34.href+="?uid="+document.getElementById("uid").value;
};
function bookmarkMe(){
try{
window.external.AddFavorite(location.href,document.title);
}
catch(e){
alert(markme_msg);
}
};
function uidPasswordChanged(){
var _35=document.getElementById("verifyCellCode");
var _36=document.getElementById("sendVerifyCellCodeLink");
if(_36==null||_36==null){
return;
}
var _37=["uid","password"];
for(var i=0,len=_37.length;i<len;i++){
var _38=document.getElementById(_37[i])||document.getElementsByName(_37[i])[0];
if(_38.value==""){
_35.disabled=true;
_36.onclick=null;
return;
}
}
_35.disabled=false;
_36.onclick=submitSendVerifyCellCode;
};
function submitSendVerifyCellCode(){
if(dialog){
dialog.close();
}
var _39=document.getElementById("loginForm");
var _3a=document.getElementsByName("action:sendVerifyCellCode")[0];
if(_3a){
_3a.disabled=false;
document.getElementById("verifyCellCode").value="";
_39.submit();
}
};
function initDialog(_3b,_3c,_3d){
if(_3b=="verifyCellCode"||_3b=="dynamicPwd"){
var _3e=_3b+"_d";
var msg=_3c+"<p><input type='text' class='inpKey' name='"+_3e+"'/>";
if(_3b=="verifyCellCode"){
msg=msg+"<p>"+"<a href='javascript:submitSendVerifyCellCode();' style='padding-left: 10px;'>"+jQ("input[name='action:sendVerifyCellCode']").val()+"</a>";
}
var _3f={showMask:true,body:msg,button:_3d,actions:[function(){
jQ("input[name='"+_3b+"']").val(jQ("input[name='"+_3e+"']").val());
jQ("button[name='action:login']").click();
}]};
dialog=new Dialog(_3f);
initInputCss([_3e],_3e);
}
};
function Dialog(_40){
_40=_40||{};
var _41=this;
var _42=document.getElementById("#dialogContainerPanel");
if(!_42){
_42=document.createElement("div");
_42.id="dialogContainerPanel";
document.body.appendChild(_42);
}
var _43=document.createElement("div");
var _44=""+"<div id='winFrame'>"+"<div class='winHead'>"+"<div class='closeBtn' id='closeBtn'><b class='ico icoClose'></b></div>"+"</div>"+"<div class='winMain'>$BODY$</div>"+"<div class='winFoot'>$BUTTONS$</div>"+"</div>";
_43.innerHTML=(document.all?"<iframe style=\"position:absolute;z-index:-1;top:0;left:0;width:0;height:0;);\" frameborder=0 src=\"javascript:''\"></iframe>":"")+"<div style=\"position:absolute;top:0;left:0;\">"+_44+"</div>";
var _45=_40.showMask===undefined?false:_40.showMask;
var _46=_40.maskValue===undefined?0.5:_40.maskValue;
var _47=_40.button===undefined?"OK":_40.button;
var _48=_40.actions||[_40.action];
var _49,_4a;
for(var i=0,_4b=_43.getElementsByTagName("*");_4b[i];i++){
if(_4b[i].childNodes.length==1&&_4b[i].firstChild.nodeType==3){
var s=_4b[i].firstChild.data;
_4b[i].removeChild(_4b[i].firstChild);
if(s=="$BODY$"){
_49=_4b[i];
}else{
if(s=="$BUTTONS$"){
_4a=_4b[i];
}
}
}
}
_49.innerHTML=_40.body;
_4a.innerHTML=_4c(_47.split("_")).join(" ");
var _4d=jQ(_4a).children("button");
for(var i=0;i<_4d.length;i++){
_4d[i].onclick=(function(k){
return function(){
_4e(k);
};
})(i);
}
_4f();
jQ("#closeBtn").click(_50);
_41.close=_50;
function _4c(key){
var _51=new Array();
for(var i=0;i<key.length;i++){
var _52=key[i].split(":");
var _53=_52.length>1?_52[1]:_52[0];
_51.push("<button type='button' class='winBotton'>"+_53+"</button>");
}
return _51;
};
function _54(_55,_56){
return (_55||function(){
})(_56||_49.getElementsByTagName("FORM")[0]||_49,_41);
};
function _4e(_57){
if(_54(_48[_57])===false){
return;
}
_50();
};
function _50(){
if(_42==_43.parentNode){
_42.removeChild(_43);
}
var _58=(_42.lastChild||{}).previousSibling;
if(_58){
_58.style.zIndex=999;
}else{
_42.style.display="none";
_43.innerHTML="";
_42.innerHTML="";
}
};
function _59(){
_43.style.cssText="position:absolute;z-index:999;top:0;left:0;display:none;";
if(_42.firstChild==null){
var _5a=_45?_46:0;
var _5b=_45?_46*100:0;
if(getIEVersionLt10()){
_42.innerHTML="<div style=\"position:absolute;z-index:998;top:0;left:0;width:100%;height:100%;background-color:#b8b8b8;filter:alpha(opacity="+_5b+");\">"+"<iframe style=\"position:absolute;z-index:-1;top:0;left:0;width:100%;height:100%;filter:alpha(opacity=0)\" frameborder=0 src=\"javascript:''\"></iframe>"+"</div>";
}else{
_42.innerHTML="<div style=\"position:absolute;z-index:998;top:0;left:0;width:100%;height:100%;background-color:#b8b8b8;opacity:"+_5a+";\"></div>";
}
}
var _5c=_42.lastChild.previousSibling;
if(_5c){
_5c.style.zIndex=997;
}
_42.insertBefore(_43,_42.lastChild);
};
function _5d(){
_42.style.display="";
_43.style.display="";
_5e();
window.onresize=function(){
_5e();
};
};
function _5e(){
var div=_43.lastChild;
var w=div.offsetWidth;
var h=div.offsetHeight;
var _5f=getClientSize();
var _60=_5f[0];
var _61=_5f[1];
_43.style.left=Math.floor(Math.max(0,_60-w)/2)+"px";
_43.style.top=Math.floor(Math.max(0,_61-h)/2)+"px";
document.body.screenTop=document.body.screenLeft=0;
};
function _4f(){
_59();
_5d();
};
};
function getClientSize(){
return [jQ(window).width(),jQ(window).height()];
};
function getIEVersionLt10(){
var _62=navigator.userAgent;
if((_62.indexOf("MSIE")!=-1)&&(_62.indexOf("MSIE 10")==-1)){
return true;
}else{
return false;
}
};

