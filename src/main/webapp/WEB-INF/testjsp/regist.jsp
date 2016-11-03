<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<title>用户注册</title>
</head>
<body>
	<fieldset style="width: 500px; margin: 0px auto">
		<legend>用户注册</legend>
		<form action="<%=request.getContextPath()%>/servlet/doRegist"
			method="post">
			<input type="hidden" name="token"
				value="<%=session.getAttribute("token")%>">
			<table>
			
				<tr>
					<td>用户名:</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td>确认密码:</td>
					<td><input type="password" name="repassword"></td>
				</tr>
				<tr>
					<td>性别:</td>
					<td><input type="radio" name="sex" value="男" checked="checked">男
						<input type="radio" name="sex" value="女">女</td>
				</tr>
				<tr>
					<td>部门:</td>
					<td><select name="dept"><option value="技术部">技术部</option>
							<option value="销售部">销售部</option>
							<option value="财务部">财务部</option></select></td>
				</tr>
				<tr>
					<td>兴趣</td>
					<td><label for="sing"><input type="checkbox"
							name="interest" value="唱歌" id="sing">唱歌</label> <label for="swim">
							<input type="checkbox" name="interest" value="游泳" id="swim">游泳
					</label> <label for="coding"> <input type="checkbox"
							name="interest" value="编程" id="coding">编程
					</label> <label for="film"> <input type="checkbox" name="interest"
							value="电影" id="film">电影
					</label></td>
				</tr>
				<tr>
					<td>说明:</td>
					<td><textarea rows="5" cols="34" name="remark"></textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="提交"><input
						type="reset" value="重置"> <input type="button" value="关闭"
						onclick="javascript:window.close()"></td>

				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>