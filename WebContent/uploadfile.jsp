<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>�ϴ��ļ� </title>
</head>
<body>

<s:form action="uploadFile" enctype="multipart/form-data">
	<s:file name="resume" label="�ϴ��ļ�" />
	<s:submit value="�ύ" />
</s:form>

<s:form action="uploadFile" enctype="multipart/form-data">
	<input type="file" name="resume" label="�ϴ��ļ�" />
	<input type="submit" value="�ύ">
</s:form>

</body>
</html>
