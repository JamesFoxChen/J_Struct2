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
<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.7.1.js"></script>
</head>
<body>
	<form action="loginValidate" method="post">
		用户名： <input type="text" id="userName"> 密码： <input type="text"
			id="password"> <input type="submit" value="登录">
		<s:fielderror fieldName="userName" />
	</form>
	<input type="button" id="btnAjax" value="Ajax调用" />
	<script type="text/javascript">
		$(function() {
			$("#btnAjax").click(function() {
				var userName = $("#userName").val().trim();
				var password = $("#password").val().trim();
				if (userName == '') {
					alert("用户名不能为空");
					return false;
				}
				
				$.ajax({
					type : "post",
					url : '/login1/ajaxExecute',
					data : {//设置数据源
						userName : userName,
						password : "我是密码"
					},
					dataType : "json",//设置需要返回的数据类型
					success : function(d) {
						alert(d.sayHi);
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