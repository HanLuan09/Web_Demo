<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="web_books" method="post">
		Title: <input type="text"  name="title"> </br>
		Author: <input type="text"  name="author"> </br>
		Category: <input type="text"  name="category"> </br>
		Sold: <input type="checkbox"  name="sold"> </br>
		<input type="submit" value="Add Book">
	</form>
</body>
</html>