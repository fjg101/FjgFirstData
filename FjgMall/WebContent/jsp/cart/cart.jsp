<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../common/basepath.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<link type="text/css" rel="stylesheet" href="<%=basePath%>static/css/style.css" >
<script type="text/javascript" src="<%=basePath%>static/js/jquery-1.12.4.js"></script>
<style>
	#goshopping{
		display: block;
		text-align: center;
		text-decoration:none;
		color: red;
		font-size: 30px;
	}
	h4.carttitle{
		display: block;
		text-align: center;
	}
</style>
</head>
<body>
	
	<div id="header">
			<span class="wel_word">购物车</span>
			<%@include file="../common/head.jsp" %>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:set var="priceSum" value="0"></c:set>
			<c:forEach items="${sessionScope.cart}" var="carts">		
				<c:set var="priceSum" value="${priceSum + carts.price_total}"></c:set>
				<tr>
					<td>${carts.cart_name}</td>
					<td>
						<input type="button" value="-" class="reduce_btn" product_id="${carts.f_product_id}" cart_nums="${carts.cart_num}">
						${carts.cart_num}
						<input type="button" value="+" class="add_btn" product_id="${carts.f_product_id}" cart_nums="${carts.cart_num}">					
					</td>
					<td>${carts.cart_price}</td>
					<td>${carts.price_total}</td>
					<td><a href="<%=basePath%>CartServlet?hide=deleteCartById&id=${carts.id}">删除</a></td>
				</tr>		
			</c:forEach>	
		</table>
		
		<div class="cart_info">
			<c:if test="${not empty sessionScope.cart}">
				<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cartSum}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${priceSum}</span>元</span>
				<span class="cart_span"><a href="<%=basePath%>CartServlet?hide=clearCart">清空购物车</a></span>
				<span class="cart_span"><a href="<%=basePath%>OrderServlet?hide=insertOrder&order_price=${priceSum}&f_user_id=${sessionScope.user.id}">去结账</a></span>
			</c:if>
			<c:if test="${empty sessionScope.cart}">
				<h4 class="carttitle">你的购物车空空如也快点击下方链接添加商品吧</h4>
				<a href="<%=basePath%>index.jsp" id="goshopping">FjgMall商城</a>
			</c:if>
		</div>
	
	</div>
	
	<%@include file="../common/foot.jsp" %>
	<script type="text/javascript">
		$(function(){
			<%-- 数量减1 --%>
			$("input.reduce_btn").click(function(){
				var cart_nums = $(this).attr("cart_nums");
				var cart_num = parseInt(cart_nums);
				var product_id = $(this).attr("product_id");
				if(cart_num>1){
					cart_num--;
				}
				location.href = "<%=basePath%>CartServlet?hide=updateCart&cartUpdate="+product_id+"&cart_num="+cart_num;
			})
			<%-- 数量加1 --%>
			$("input.add_btn").click(function(){
				var cart_nums = $(this).attr("cart_nums");
				var cart_num = parseInt(cart_nums) + 1;
				var product_id = $(this).attr("product_id");
				location.href = "<%=basePath%>CartServlet?hide=updateCart&cartUpdate="+product_id+"&cart_num="+cart_num;
			})
		})
	</script>
</body>
</html>