<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>终于创建JSP文件成功</h1>
	本站访问次数为：${applicationScope.counter}
	<br /> ${sessionScope.user}，您已经登录！
	<br /> ${requestScope.tip}

	<a href="Add">Add</a>
	<a href="Update">Updae</a>
	
	<a href="/UserList">UserList</a>
		<a href="/UserLogin">UserLogin</a>
	<a href="sdfds">Error</a>
</body>
</html>