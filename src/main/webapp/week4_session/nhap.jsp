<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Nhap danh sách</h1>
	<form action="nhap1">
		Nhap ten: <input type="text" name="name"> <br/><br/>
		<input type="submit" value="Nhap">
	</form>
	<h2>Danh sách đã nhập</h2>
	<h3 style="color: #FF0000">${sessionScope.fa}</h3>
	<h3>
		<c:set var="i" value="0"/>
		<c:forEach items="${sessionScope.names}" var="c">
			${i}. ${c}<br/>
			<c:set var="i" value="${(i+1)}"/>
		</c:forEach>
	</h3>
</body>
</html>