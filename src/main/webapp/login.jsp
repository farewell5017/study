<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- struts标签库s:   OGNL要结合struts标签来使用-->
<%-- <%@ taglib prefix="s" uri="/struts-tags"%> --%>
<!-- jstl核心标签库c: -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set value="${pageContext.request.contextPath}" var="webRoot"
	scope="page" />
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>用户登录</title>
<!-- Bootstrap core CSS -->
<link
	href="<c:url value='/script/bootstrap/dist/css/bootstrap.min.css' />"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href="<c:url value='/script/css/signin.css'/>" rel="stylesheet">
<style type="text/css">
.error {
    background: #d63920 none repeat scroll 0 0;
    text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<form class="form-signin" role="form"
			action="<c:url value='/user/userAction.action'/>" method="post">
			<h2 class="form-signin-heading">请登录</h2>
			<input type="email" class="form-control" placeholder="Email address"
				required autofocus name="user.username" value="${username }">
			<input type="password" class="form-control" placeholder="Password"
				required name="password">
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					下次自动登录
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
		</form>
	</div>
</body>
<script type="text/javascript">
	
</script>
</html>
