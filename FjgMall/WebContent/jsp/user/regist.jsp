<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../common/basepath.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>注册页面</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/regist.css"/>
		<script type="text/javascript" src="<%=basePath%>static/js/jquery-1.12.4.js"></script>
		<script type="text/javascript">
			$(function(){
				<%-- 点击刷新验证码 --%>
				$("#code_pic").click(function(){
					this.src="<%=basePath%>KaptchaServlet";
				})
				<%-- 注册信息正则 --%>
				var nameandpwdRe= /^\w{5,12}$/;
				var emailRe= /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
				var phoneRe = /^[1][3,4,5,6,7,8,9][0-9]{9}$/
				var nicknameRe = /^[\u4e00-\u9fa5]{1,10}$/
				<%-- 点击验证 --%>
				$("#register").click(function(){
					<%-- 用户名验证 --%>
					var usernameValue = $("#username").val();
					if(!nameandpwdRe.test(usernameValue)){
						$("div.errmsg").text("用户名不合法，请重新输入");
						return false;
					}
					<%-- 昵称验证 --%>
					var nicknameValue = $("#nickname").val();
					if(!nicknameRe.test(nicknameValue)){
						$("div.errmsg").text("昵称不符合规则，请重新输入");
						return false;
					}
					<%-- 密码验证 --%>
					var passwordValue = $("#password").val();
					if(!nameandpwdRe.test(passwordValue)){
						$("div.errmsg").text("密码不符合规则，请重新输入");
						return false;
					}
					<%-- 确认密码验证 --%>
					var apdValue = $("#confirm_pwd").val();
					if(apdValue!=passwordValue){
						$("div.errmsg").text("两次密码不一致，请重新输入");
						return false;
					}
					<%-- 邮箱验证 --%>
					var emailValue = $("#email").val();
					if(!emailRe.test(emailValue)){
						$("div.errmsg").text("邮箱不符合规则，请重新输入");
						return false;
					}
					<%-- 手机号验证 --%>
					var phoneValue = $("#phone").val();
					if(!phoneRe.test(phoneValue)){
						$("div.errmsg").text("手机号不符合规则，请重新输入");
						return false;
					}
					<%-- 验证码是否为空 --%>
					var codeValue=$("#code").val();
					codeValue=$.trim(codeValue);
					if(codeValue==null ||codeValue==""){
						$("div.errmsg").text("验证码不能为空，请重新输入");
						return false;
					}
				})
				$("#username").change(function(){
					$.ajax({
						type:"GET",
						url:"<%=basePath%>UserServlet",
						data:"hide=registAjaxServlet&username="+$("#username").val(),
						dataType:"json",
						success:function(data){
							$("div.errmsg").text(data);
						}
					})
				})
			})
		</script>
	</head>
	<body>
		<a href="<%=basePath%>index.jsp">返回商城</a>
		<form action="<%=basePath%>UserServlet" method="post">
			<c:if test="${not empty requestScope.errmsg}">
				<div class="errmsg"></div>
			</c:if>
			<c:if test="${empty requestScope.errmsg}">
				<div class="errmsg"></div>
			</c:if>
			<input type="hidden" name="hide" value="registServlet">
			<input type="text" name="username" id="username" value="" placeholder="请输入用户名" /><br />
			<input type="text" name="nickname" id="nickname" value="" placeholder="请输入昵称" /><br />
			<input type="password" name="password" id="password" value="" placeholder="请输入6-18位密码" /><br />
			<input type="password" name="confirm_pwd" id="confirm_pwd" value="" placeholder="请再次输入密码" /><br />
			<input type="text" name="email" id="email" value="" placeholder="请输入邮箱" /><br />
			<input type="text" name="phone" id="phone" value="" placeholder="请输入手机号" /><br />
			<input type="text" name="code" id="code" value="" placeholder="请输入验证码" /><br />
			<img src="<%=basePath%>KaptchaServlet" style="height: 20px;width: 164px;" id="code_pic"/><br />
			<input type="reset" name="" id="" value="重置"  />
			<input type="submit" id="register" value="注册" />
		</form>
	</body>
</html>
