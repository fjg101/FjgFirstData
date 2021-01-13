<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/basepath.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理</title>
<link type="text/css" rel="stylesheet" href="<%=basePath%>static/css/style.css" >
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			
			<span class="wel_word">后台管理系统</span>
			<div>
				<a href="<%=basePath%>PageServlet?hide=pageProducts">商品管理</a>
				<a href="<%=basePath%>OrderServlet?hide=queryOrders">订单管理</a>
				<a href="<%=basePath%>index.jsp">返回商城</a>
			</div>
	</div>
	<div id="main">
		<h1>欢迎管理员进入后台管理系统</h1>
	</div>
	
	<%@include file="../common/foot.jsp" %>
</body>
</html>