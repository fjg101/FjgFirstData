<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/basepath.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理</title>
<link type="text/css" rel="stylesheet" href="${applicationScope.basePath}static/css/style.css" >
<script src="${applicationScope.basePath}static/js/jquery-1.12.4.js"></script>
<style type="text/css">
	#main{
		background-color: #00fff7;
	}
</style>
</head>
<body>
	
	<div id="header">
			
			<span class="wel_word">商品管理系统</span>
			<div>
				<a href="<%=basePath%>PageServlet?hide=pageProducts">商品管理</a>
				<a href="${applicationScope.basePath}pages/manager/order_manager.jsp">订单管理</a>
				<a href="${applicationScope.basePath}index.jsp">返回商城</a>
			</div>
	</div>
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>		
				
			<c:forEach items="${requestScope.page.items}" var="products">
				<tr>
					<td>${products.product_name}</td>
					<td>${products.product_price}</td>
					<td>${products.product_sales}</td>
					<td>${products.product_stock}</td>
					<td><a href="${applicationScope.basePath}manager/ProductServlet?hide=queryProductById&id=${products.id}&f_user_id=${products.f_user_id}&method=updateProduct">修改</a></td>
					<td><a href="${applicationScope.basePath}manager/ProductServlet?hide=deleteProduct&id=${products.id}&f_user_id=${products.f_user_id}" class="del">删除</a></td>
				</tr>
			</c:forEach>
				
			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="${applicationScope.basePath}jsp/manager/product_edit.jsp?method=insertProduct">添加图书</a></td>
			</tr>	
		</table>
		<%@include file="../common/page_nav.jsp" %>
	</div>
	<%@include file="../common/foot.jsp" %>
</body>
</html>