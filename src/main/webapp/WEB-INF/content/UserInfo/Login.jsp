<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<%@ include file="/WEB-INF/content/Header.jsp"%>
</head>
<body>
	<form action="loginValidate" method="post">
		用户名： <input type="text" id="userName" name="userName" value="James">
		密码： <input type="text" id="password" name="password" value="天天密码">
		<input type="button" value="登录" id="btnLogin">
	</form>
	<script type="text/javascript">
		$(function() {
			$("#btnLogin").click(function() {
				var userName = $("#userName").val().trim();
				var password = $("#password").val().trim();
				if (userName == '') {
					alert("用户名不能为空");
					return false;
				}

				$.ajax({
					type : "post",
					url : '/userinfo/userlogin',
					data : {//设置数据源
						userName : userName,
						password : "123456"
					},
					dataType : "json",//设置需要返回的数据类型
					success : function(d) {
						if (d != '') {
							alert(d);
							return;
						} else
						window.location.href = "/userinfo/userindex";
					},
					error : function(d) {
						alert(d.responseText);
					}
				});
			});
		});
	</script>
</body>
</html>