<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/basepath.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
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
			<span class="wel_word">我的订单</span>
			<%@include file="../common/head.jsp" %>
	</div>
	
	
	<div id="main">
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
			</tr>
			
			<c:forEach items="${sessionScope.order}" var="orders">		
				<tr>
					<td>${orders.order_date}</td>
					<td>${orders.order_price}</td>
					<td>${orders.order_status}</td>
					<td><a href="<%=basePath%>OrderServlet?hide=updateOrder&id=${orders.id}">处理订单</a></td>
				</tr>	
			</c:forEach>
					
		</table>
		
	
	</div>
	
	<%@include file="../common/foot.jsp" %>
</body>
</html>