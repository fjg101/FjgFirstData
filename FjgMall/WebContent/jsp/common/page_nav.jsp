<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="page_nav">
			<c:if test="${requestScope.page.pageNo>1}">
				<a href="${applicationScope.basePath}${requestScope.page.pageUrl}&pageNo=1">首页</a>
				<a href="${applicationScope.basePath}${requestScope.page.pageUrl}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
			</c:if>
			<%-- 下标链接 --%>
			<c:choose>
				<%-- 下标最多5个 --%>
				<%-- 1少于5页 --%>
				<c:when test="${requestScope.page.pageSum<=5}">
					<c:set var="begin" value="1"></c:set>
					<c:set var="end" value="${requestScope.page.pageSum}"></c:set>
				</c:when>
				<%-- 2多于5页 --%>
				<c:when test="${requestScope.page.pageSum>5}">
					<c:choose>
						<%-- 2.1pageNo小于3 --%>
						<c:when test="${requestScope.page.pageNo<=3}">
							<c:set var="begin" value="1"></c:set>
							<c:set var="end" value="5"></c:set>
						</c:when>
						<%-- 2.3大于pageSum减去2--%>
						<c:when test="${requestScope.page.pageNo>(requestScope.pageSum-3)}">
							<c:set var="begin" value="${requestScope.page.pageSum-4}"></c:set>
							<c:set var="end" value="${requestScope.page.pageSum}"></c:set>
						</c:when>
						<%-- 2.1pageNo大于3 小于pageSum减去2--%>
						<c:otherwise>
							<c:set var="begin" value="${requestScope.page.pageNo-2}"></c:set>
							<c:set var="end" value="${requestScope.page.pageNo+2}"></c:set>
						</c:otherwise>
					</c:choose>
				</c:when>
			</c:choose>
			<c:forEach begin="${begin}" end="${end}" var="i">
				<c:if test="${i==requestScope.page.pageNo}">
					【${i}】
				</c:if>
				<c:if test="${i!=requestScope.page.pageNo}">
					<a href="${applicationScope.basePath}${requestScope.page.pageUrl}&pageNo=${i}">${i}</a>
				</c:if>
			</c:forEach>
			<c:if test="${requestScope.page.pageNo<requestScope.page.pageSum}">
				<a href="${applicationScope.basePath}${requestScope.page.pageUrl}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
				<a href="${applicationScope.basePath}${requestScope.page.pageUrl}&pageNo=${requestScope.page.pageSum}">尾页</a>
			</c:if>
			共${requestScope.page.pageSum}页，${requestScope.page.pageCount}条记录 到第<input value="${requestScope.page.pageNo}" name="pn" id="pn_input" type="number"/>页
			<input type="button" value="确定" id="pageClickBtn">
		</div>
		<script type="text/javascript">
			$(function(){
				$("#pageClickBtn").click(function(){
					var pageno = $("#pn_input").val();
					var pagemax = "${requestScope.page.pageSum}";
					var pageNo = parseInt(pageno);
					var pageMax = parseInt(pagemax);
					if(pageNo<1||pageNo>pageMax){
						alert("您必须输出的页码数为1~"+pageMax+"之间");
						$("#pn_input").val("${requestScope.page.pageNo}");
						return false;
					}
					location.href = "${applicationScope.basePath}${requestScope.page.pageUrl}&pageNo="+pageno;
				})
			})
		</script>
</body>
</html>