<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../common/basepath.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>fjgMall首页</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/index.css"/>
		<style type="text/css">
			#page_nav{
				width: 100%;
				height: 10px;
				margin: auto;
				
				text-align: center;
			}
			#pn_input {
				width: 30px;
				text-align: center;
			}
			#search{
				text-align: center;
			}
			#searchName{
				width: 500px;
				height: 28px;
			}
			#search_btn{
				width: 100px;
				height: 30px;
			}
			#showlogo{
				text-align: center;
				color: blue;
				background-color: gray;
			}
			span.nicknameshow{
				font-size: 20px;
				color: red;
			}
		</style>
		<script type="text/javascript" src="<%=basePath%>static/js/jquery-1.12.4.js"></script>
	</head>
	<body>
		<div id="main">
			<div id="head">
				<div class="titleHead">
					FMall电子商城
				</div>
				<c:if test="${not empty sessionScope.user}">
					<div id="showlogo">
						欢迎<span class="nicknameshow">${sessionScope.user.nickname}</span>登录FMall电子商城
					</div>
				</c:if>
				<c:if test="${empty sessionScope.user}">
					<div id="showlogo">
						请登录FMall电子商城
					</div>
				</c:if>
				<div class="menu">
					<a href="<%=basePath%>jsp/user/login.jsp">登录</a> | 
					<a href="<%=basePath%>jsp/user/regist.jsp">注册</a>
					<a href="<%=basePath%>UserServlet?hide=loginoutServlet">注销</a>
					<a href="<%=basePath%>CartServlet?hide=queryCarts">购物车</a>
					<a href="<%=basePath%>jsp/manager/manager.jsp">后台管理</a>
				</div>
			</div>
			<div id="body">
				<div id="search">
					<input type="text" name="product_name" value="" id="searchName"><input type="button" value="搜索" id="search_btn">
				</div>
				<table class="product" cellpadding="0" cellspacing="0">
					<tr>
						<c:forEach items="${requestScope.page.items}" var="products">
							<td>
								<img src="<%=basePath%>${products.product_img}"/>
								<div class="product_inv">
									商品名：<span class="product_name">${products.product_name}</span><br />
									价格：<span class="product_price">${products.product_price}</span><br />
									销量：<span class="product_sales">${products.product_sales}</span><br />
									库存：<span class="product_stock">${products.product_stock}</span><br />
									<input type="button" value="加入购物车" class="cart_btn" product_id = "${products.id}" user_id = "${products.f_user_id}"/>
								</div>
							</td>
						</c:forEach>
						
					</tr>
				</table>
				<%@include file="../common/page_nav.jsp" %>
			</div>
			<%@include file="../common/foot.jsp" %>
		</div>
		<script type="text/javascript">
			$(function(){
				/*加入购物车*/
				$(".cart_btn").click(function(){
					var id = $(this).attr("product_id");
					var f_user_id = $(this).attr("user_id");
					location.href = "<%=basePath%>CartServlet?hide=insertCart&id="+id+"&f_user_id="+f_user_id;
				})
				/*按名称搜索商品*/
				$("#search_btn").click(function(){
					var product_name = $("#searchName").val();
					location.href = "<%=basePath%>PageServlet?hide=pageNameIndex&searchName="+product_name;
				})
			})
		</script>
	</body>
</html>
