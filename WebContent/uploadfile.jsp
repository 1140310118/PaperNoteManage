<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>上传文件 </title>
</head>
<body>

<s:form action="uploadFile" enctype="multipart/form-data">
	<s:file name="resume" label="上传文件" />
	<s:submit value="提交" />
</s:form>

<s:form action="uploadFile" enctype="multipart/form-data">
	<input type="file" name="resume" label="上传文件" />
	<input type="submit" value="提交">
</s:form>

</body>
</html>
