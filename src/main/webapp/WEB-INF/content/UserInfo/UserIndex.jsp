<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/content/Header.jsp"%>
</head>
<body>
<h1><a href="/userinfo/loginout" onclick="return confirm('确认要注销吗?')">注销</a></h1>
<br/>

<h1>欢迎你：${sessionScope.UserName}</h1>

</body>
</html>