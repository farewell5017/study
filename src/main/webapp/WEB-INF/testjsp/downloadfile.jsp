<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>文件下载</title>
</head>
<body>
	<img alt="panda"
		src="<%=request.getContextPath()%>/servlet/showPicture">
	<br>
	<img src="<%=request.getContextPath()%>/image/07huafei.png" width="50%"
		height="300px">
	<br>
	<a href="<%=path%>/servlet/fileDownload.action" title="有美女!">点击下载文件!</a>
	<%
		@SuppressWarnings("unchecked")
		ArrayList<String> files1 = (ArrayList<String>) request.getAttribute("files");
	%>
	<%
		for (String string : files1) {
	%>
	<div>
		<a href="<%=path%>/servlet/fileDownload.action?fileName=<%=string%>">
			<%=string%>
		</a>
	</div>
	<%
		}
	%>
	<div align="left">
		<input type="button" value="关闭" onclick="javascript:window.close()">
	</div>
</body>
<script type="text/javascript">
	function base64encode(str) {
		var out, i, len;
		var c1, c2, c3;
		len = str.length;
		i = 0;
		out = "";
		while (i < len) {
			c1 = str.charCodeAt(i++) & 0xff;
			if (i == len) {
				out += base64EncodeChars.charAt(c1 >> 2);
				out += base64EncodeChars.charAt((c1 & 0x3) << 4);
				out += "==";
				break;
			}
			c2 = str.charCodeAt(i++);
			if (i == len) {
				out += base64EncodeChars.charAt(c1 >> 2);
				out += base64EncodeChars.charAt(((c1 & 0x3) << 4)
						| ((c2 & 0xF0) >> 4));
				out += base64EncodeChars.charAt((c2 & 0xF) << 2);
				out += "=";
				break;
			}
			c3 = str.charCodeAt(i++);
			out += base64EncodeChars.charAt(c1 >> 2);
			out += base64EncodeChars.charAt(((c1 & 0x3) << 4)
					| ((c2 & 0xF0) >> 4));
			out += base64EncodeChars.charAt(((c2 & 0xF) << 2)
					| ((c3 & 0xC0) >> 6));
			out += base64EncodeChars.charAt(c3 & 0x3F);
		}
		return out;
	}
</script>
</html>