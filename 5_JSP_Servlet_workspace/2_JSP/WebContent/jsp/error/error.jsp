<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error</title>
</head>
<body>
	<h1>에러발생</h1>
	<%= exception %>
	<br>
	<%= exception.getClass().getName() %>
</body>
</html>