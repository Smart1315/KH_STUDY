<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pizza = (String) request.getAttribute("pizza");
	String[] topping = (String[]) request.getAttribute("topping");
	String[] side = (String[]) request.getAttribute("side");
	String t = null;
	String s = null;
	if(topping != null) {
		t = String.join(", ", topping);
	}
	if(side != null) {
		s = String.join(", ", side);
	}
	
	int total = (int) request.getAttribute("total");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pizzaEnd</title>
<style>
	#pizza {
		color: red;
	}
	#topping {
		color: green;
	}
	#side {
		color: blue;
	}
	#total {
		text-decoration: underline; 
	}
</style>
</head>
<body>
	<h2>주문 내역</h2>
	<h3>
		피자는 <span id="pizza"><%= pizza %></span>
		<% if(t != null) { %>
		, 
		토핑은 <span id="topping"><%= t %></span>
		<% } %>
		<% if(s != null) { %>
		, 
		사이드는 <span id="side"><%= s %></span>
		<% } %>
		주문하셨습니다.
	</h3>
	<br>
	<br>
	<h3>총합 : <span id="total"><%= total %>원</span></h3>
	<br>
	<br>
	<h2 style="color:#FFC0CB">즐거운 식사시간 되세요 ~</h2>
</body>
</html>