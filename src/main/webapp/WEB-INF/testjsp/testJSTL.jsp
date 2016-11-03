<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstl</title>
<style type="text/css">
body {
	/* 	background-color: #b0c4de; */
	/* 	background-image: url("../image/64j58PICp4v_1024.jpg"); */
	background-repeat: no-repeat;
	background-position: top;
	/* 	color: lime; */
	/* 	text-decoration: underline; */
	font-family: courier New;
}
</style>
<script type="text/javascript"
	src="<c:url value='../script/jquery-3.1.1.min.js'/>">
	
</script>
</head>
<body>
	<p>十月 29, 2016 3:52:45 下午 org.apache.coyote.AbstractProtocol init
		信息: Initializing ProtocolHandler ["http-bio-8280"] 十月 29, 2016 3:52:45</p>
	<c:out value="c:out呵呵哒" />
	<c:set var="username" value="张三" scope="session" />
	<c:set var="password" value="admin" scope="session" />
	<c:out value="${username}" />
	<jsp:useBean id="user" class="com.cjt.study.basic.domain.XmlUser"
		scope="page" />
	<jsp:setProperty property="userName" value="李四" name="user" />
	<jsp:getProperty property="userPwd" name="user" />
	user.userName:${user.userName }
	<br>user.userPwd: ${user.userPwd }
	<br>
	<%=pageContext.findAttribute("user")%>
</body>
</html>