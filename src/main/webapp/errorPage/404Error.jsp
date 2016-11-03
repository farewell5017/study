<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<title>404错误友好提示页面</title>
<!-- 3秒钟后自动跳转回首页 -->
<meta http-equiv="refresh"
	content="30;url=${pageContext.request.contextPath}/index.jsp">
</head>
<body>
	<div align="center" style="margin-top: 8%;">
		<!-- 	<img alt="对不起，你要访问的页面没有找到，请联系管理员处理!" -->
		<%-- 		src="${pageContext.request.contextPath}/img/404Error.png" /> --%>
		<img alt="对不起，你要访问的页面没有找到，请联系管理员处理!" src="<%=path%>/image/404.png" />
		<br /> <span id="info">30s后跳转到主页!</span>如果没有跳转，请点击 <a
			href="${pageContext.request.contextPath}/servlet/testForward">这里</a>
	</div>
</body>
<%@ page contentType="text/html; charset=UTF-8"%>
<script type="text/javascript">
	var i = 30;
	window.onload = function() {
		setInterval(function() {
			document.getElementById("info").innerHTML = (--i) + "s后跳转到主页!";
		}, 1 * 1000)
	}
</script>
</html>