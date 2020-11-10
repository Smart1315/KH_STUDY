<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03_directiveInclude</title>
</head>
<body>
	<h2>
		오늘 날짜 
		<span style="color: yellowgreen;">
			<%@ include file="today.jsp" %>
		</span>
	</h2>
</body>
</html>