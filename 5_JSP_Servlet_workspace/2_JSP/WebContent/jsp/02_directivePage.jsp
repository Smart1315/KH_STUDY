<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error/error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02_directivePage</title>
</head>
<body>
	<%
		int total = 0;
		for(int i = 1; i <= 10; i++) {
			total += i;
		}
		System.out.println("덧셈 끝");
		
		ArrayList<String> list = new ArrayList<String>();
		list.add(0, null);
		
		System.out.println(list.get(0).charAt(0));
	%>
</body>
</html>