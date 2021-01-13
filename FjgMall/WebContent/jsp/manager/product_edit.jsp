<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/basepath.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>
<link type="text/css" rel="stylesheet" href="<%=basePath%>static/css/style.css" >
<script src="<%=basePath%>static/script/jquery-1.7.2.js"></script>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
</head>
<body>
		<div id="header">
			
			<span class="wel_word">编辑商品</span>
			<div>
				<a href="<%=basePath%>manager/BookServlet?hide=queryBooks">商品管理</a>
				<a href="order_manager.jsp">订单管理</a>
				<a href="<%=basePath%>index.jsp">返回商城</a>
			</div>
		</div>
		
		<div id="main">
			<form action="<%=basePath%>manager/ProductServlet" method="post">
				<input type="hidden" name="hide" value="${param.method}">
				<input type="hidden" name="id" value="${param.id}">
				<input type="hidden" name="f_user_id" value="${param.f_user_id}">
				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<td><input name="product_name" type="text" value="${requestScope.product.product_name}"/></td>
						<td><input name="product_price" type="number" value="${requestScope.product.product_price}"/></td>
						<td><input name="product_sales" type="number" value="${requestScope.product.product_sales}"/></td>
						<td><input name="product_stock" type="number" value="${requestScope.product.product_stock}"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
			
	
		</div>
		
		<%@include file="../common/foot.jsp" %>
</body>
</html>