<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login form</h1>
	<form action="web_login" method="post">
		User: <input type="text"  name="user"> </br>
		Password: <input type="password"  name="password"> </br>
		<input type="submit" value="LOGIN">
	</form>
	<h3 style="color: #FF0000">${requestScope.error}</h3>
</body>
</html>