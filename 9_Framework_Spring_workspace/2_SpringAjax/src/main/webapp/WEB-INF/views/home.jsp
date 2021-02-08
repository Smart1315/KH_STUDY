<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	
	<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
	<h1 align="center">Spring에서의 Ajax사용 테스트 페이지</h1>
	<button onclick="location.href='test'">하이</button>
	
	
	<ol>
		<li>
			서버 쪽 컨트롤러로 값 보내기
			<button id="test1">테스트</button>
			
			<script>
				$(function() {
					$("#test1").on("click", function() {
							$.ajax({
								url: 'test1',
								data: {name: '안영재', age: 25},
								success: function(data) {
									if(data == 'ok') {
										alert("전송 성공");
									} else {
										alert("전송 실패");
									}
								}
							});
					});
				});
			</script>
		</li>
		
		<li>
			컨트롤러에서 리턴하는 json객체 받아서 출력하기
			<button id="test2">테스트</button>
			<div id="d2"></div>
			<script>
				$(function() {
					$("#test2").on("click", function() {
						$.ajax({
							url: "test2",
							success: function(data) {
								data = JSON.parse(decodeURIComponent(data).replace(/\+/g, " "));
								console.log(data);

								$("#d2").html("번호 : " + data.no + "<br>"
										    + "제목 : " + data.title + "<br>"
										    + "작성자 : " + data.writer + "<br>"
										    + "내용 : " + data.content);
							}
						});
					});
				});
			</script>
		</li>
		
		<li>
			컨트롤러에서 리턴하는 json객체 받아서 출력하기
			<button id="test3">테스트</button>
			<div id="d3"></div>
			<script>
				$(function() {
					$("#test3").on("click", function() {
							$.ajax({
								url: 'test3',
								success: function(data) {
									console.log(data);

									$("#d3").html("번호 : " + data.no + "<br>"
											    + "제목 : " + data.title + "<br>"
											    + "작성자 : " + data.writer + "<br>"
											    + "내용 : " + data.content);
								}
							});
					});
				});
			</script>
		</li>
		
		<li>
			컨트롤러에서 리턴하는 Json배열을 받아서 출력하기
			<button id="test4">테스트</button>
			<div id="d4"></div>
			<script>
				$(function() {
					$("#test4").on("click", function() {
							$.ajax({
								url: 'test4',
								success: function(data) {
									console.log(data);

									var innerd4 = "";

									for(var i in data) {
										innerd4 += "userId : " + data[i].userId + "<br>"
												    + "userPwd : " + data[i].userPwd + "<br>"
												    + "userName : " + data[i].userName + "<br>"
												    + "age : " + data[i].age + "<br>"
												    + "email : " + data[i].email + "<br>"
												    + "phone : " + data[i].phone;
									    if(i < data.length - 1) {
											innerd4 += "<hr>";
										}
									}

									$("#d4").html(innerd4);
								}
							});
					});
				});
			</script>
		</li>
		
	</ol>
	
</body>
</html>
