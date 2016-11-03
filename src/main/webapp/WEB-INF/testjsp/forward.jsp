<%@page
	import="javax.swing.text.StyledEditorKit.ForegroundAction,com.cjt.study.utils.NetUtil,  org.apache.commons.lang3.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,java.lang.String"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>请求转发</title>
<style type="text/css">
#id {
	text-decoration: none;
}

a {
	position: relative;
}

a:hover:before {
	position: absolute;
	top: 20px;
	right: 0;
	content: attr(title);
	color: #000000;
	border: 1px solid #242424;
	background-color: #E5E5E5;
}
</style>
</head>
<body>
	你好,
	<a id="id" href="javascript:void(0);" title="iiiiiiii">${loginUser.userName }<c:if
			test="${!empty loginUser.userName }">!
</c:if>
	</a>
	<ul>
		<li><h5>${lastTime}</h5></li>
		<li><a
			href="${pageContext.request.contextPath }/servlet/downloadFile"
			title="测试文件下载" target="_blank">show picture!</a></li>
		<li>request.getContextPath()=<%=path%></li>
		<li>basePath = <%=basePath%></li>
		<li><a
			href="${pageContext.request.contextPath }/servlet/registServlet"
			target="_blank" title="重复提交表单">阻止表单重复提交</a></li>
		<li>测试推送地址:<%=request.getScheme() + "://" + NetUtil.getLocalIp() + ":" + request.getServerPort() + path + "/"%>servlet/testPush
		</li>
		<li><a
			href="${pageContext.request.contextPath }/servlet/testEChartsServlet"
			target="_blank">eCharts练习</a></li>
		<li><a href='<c:url value="${path}/test/jstl.action" />'
			target="_blank">JSTL练习</a></li>
	</ul>

</body>
<script type="text/javascript">
	function GetValueForToolTip(obj) {
		// 		alert(obj);
		// 		window.showModalDialog
		// 		var tValue = obj.innerText;
		// 		obj.setAttribute("title", tValue);
	}
</script>
</html>