<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 수정</title>
<style>
	#infoTable{margin: auto;}
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<h1 align="center">내 정보 수정</h1>
	<form action="${ contextPath }/mupdate.me" method="post">
		<table id="infoTable">
			<tr>
				<td width="100px">* 아이디</td>
				<td>${ requestScope.member.userId }</td>
			</tr>
			<tr>
				<td>* 이름</td>
				<td><input type="text" name="userName" value="${ requestScope.member.userName }" required></td>
			</tr>
			<tr>
				<td>* 닉네임</td>
				<td><input type="text" name="nickName" value="${ requestScope.member.nickName }" required></td>
			</tr>
			<tr>
				<td> &nbsp;&nbsp;이메일</td>
				<td><input type="email" name="email" value="${ requestScope.member.email }"></td>
			</tr>
			<tr>
				<td> &nbsp;&nbsp;생년월일</td>
				<td>
					<select id='year' name="year">
						<c:forEach begin="<%= new GregorianCalendar().get(Calendar.YEAR) - 100 %>" end="<%= new GregorianCalendar().get(Calendar.YEAR) %>" var="i">
							<option value="${ i }">${ i }</option>
						</c:forEach>
					</select>
					<select id='month' name="month">
						<c:forEach begin="1" end="12" var="i">
							<option value="${ i }">${ i }</option>
						</c:forEach>
					</select>
					<select id='date' name="date">
						<c:forEach begin="1" end="31" var="i">
							<option value="${ i }">${ i }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td> &nbsp;&nbsp;전화번호</td>
				<td><input type="text" name="phone" value="${ requestScope.member.phone }"></td>
			</tr>
			<tr>
				<td> &nbsp;&nbsp;주소</td>
				<td><input type="text" name="address" value="${ requestScope.member.address }"></td>
			</tr>
			<tr>
				<td> &nbsp;&nbsp;성별</td>
				<td>
					<input type="radio" name="gender" value="M">남자 &nbsp;&nbsp;
					<input type="radio" name="gender" value="F">여자
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div align="center">
						<br>
						<input type="submit" value="수정">
						<button type="reset">취소</button>
					</div>
				</td>
			</tr>
		</table>
	</form>
		
	<script>
		var birthDay = '${ requestScope.member.birthDay }';
		birthDay = birthDay.split('-');
		birthDay[0] = parseInt(birthDay[0]);
		birthDay[1] = parseInt(birthDay[1]);
		birthDay[2] = parseInt(birthDay[2]);
		
		var year = document.getElementById("year");
        for(var i = 0; i < year.children.length; i++) {
           if(year.children[i].value == birthDay[0]) { 
        	   year.children[i].setAttribute('selected', '');
           }
        }
        
        var month = document.getElementById("month");
        for(var i = 0; i < month.children.length; i++) {
           if(month.children[i].value == birthDay[1]) { 
        	   month.children[i].setAttribute('selected', '');
           }
        }
        
        var date = document.getElementById("date");
        for(var i = 0; i < date.children.length; i++) {
           if(date.children[i].value == birthDay[2]) { 
        	   date.children[i].setAttribute('selected', '');
           }
        }
        
        var gender = '${ requestScope.member.gender }';
        var genderRadio = document.getElementsByName('gender');
        
        if(gender == 'M') {
        	genderRadio[0].checked = true;
        } else {
        	genderRadio[1].checked = true;
        }
	</script>
</body>
</html>