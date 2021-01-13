<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/basepath.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>登陆页面</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/login.css"/>
	</head>
	<body>
		<a href="<%=basePath%>index.jsp">返回商城</a>
		<div class="page-container">
			<h1>登录(Login)</h1>
			<div class="errmsg">${requestScope.errmsg}</div>
			<form action="<%=basePath%>UserServlet" method="post">
				<input type="hidden" name="hide" value="loginServlet">
				<input type="text" name="username" class="username" placeholder="请输入您的用户名！" value="${cookie.username.value}"><br />
				<input type="password" name="password" class="password" placeholder="请输入您的用户密码！"><br />
				<input type="submit" class="sub_btn" value="登录">
			</form>
		</div>
	</body>
</html>
