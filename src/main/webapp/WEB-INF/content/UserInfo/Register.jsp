<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<%@ include file="/WEB-INF/content/Header.jsp"%>
</head>
<body>
<form method="post">
		用户名： <input type="text" id="userName" name="userName">
		密码： <input type="text" id="password" name="password">
		<input type="button" value="注册" id="btnRegister">
	</form>
	<script type="text/javascript">
		$(function() {
			$("#btnRegister").click(function() {
				var userName = $("#userName").val().trim();
				var password = $("#password").val().trim();
				if (userName == '') {
					alert("用户名不能为空");
					return false;
				}
				if (password == '') {
					alert("用户名不能为空");
					return false;
				}

				$.ajax({
					type : "post",
					url : '/userinfo/userregister',
					data : {//设置数据源
						userName : userName,
						password : password
					},
					dataType : "json",//设置需要返回的数据类型
					success : function(d) {
						if (d != '') {
							alert(d);
							return;
						}
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