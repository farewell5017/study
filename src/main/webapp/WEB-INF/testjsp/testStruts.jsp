<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试struts</title>
</head>
<body>
	<h1>struts2</h1>
	<div>
		1:
		<s:property value="#ognlMap" />
		<br /> 2:
		<s:property value="age" />
		<br /> 3:
		<s:property value="#parameters.username" />
		<br /> 4:
		<s:property value="username" />
		<br /> 5:
		<s:property value="#parameters.password" />
		<br />
	</div>
</body>
</html>