<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>01_sum</title>
</head>
<body>
	<!-- HTML 주석 -->
	<%-- JSP 주석 --%>
	<%-- 두 주석의 차이를 적어보자 --%>
	<%-- 차이 : 페이지 소스보기/개발자도구에서 HTML주석만 보임 (HTML주석은 클라이언트에게 그대로 전달되기 때문) --%>
	
	<%
		// 한줄 주석
		/*
			여러 줄 주석
		*/
		// 스크립틀릿 : 자바코드가 들어오는 곳
		int total = 0;
		for(int i = 1; i <= 10; i++) {
			total += i;
		}
		System.out.println("덧셈 끝");
	%>
	
	expression 출력 : 1부터 10까지의 합은 <%= total %>입니다<br>
	scriptlet : 출력 : 1부터 10까지의 합은 <% out.println(total); %>입니다
</body>
</html>