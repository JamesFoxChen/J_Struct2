<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="UserIndex" method="post">
 用户名： <input type="text" name="userName">
 密码： <input type="text" name="password">
 用户名一： <input type="text" name="userInfoList[0].userName">
 用户名二： <input type="text" name="userInfoList[1].userName">
 <input type="submit" value="登录">
</form>
</body>
</html>