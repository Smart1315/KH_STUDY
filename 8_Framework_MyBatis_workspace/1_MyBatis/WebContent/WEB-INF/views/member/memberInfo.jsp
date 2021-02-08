<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 보기</title>
<style>
	#infoTable{margin: auto;}
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<h1 align="center">내 정보 보기</h1>
	<form action="${ contextPath }/memberUpdateForm.me" method="post">
		<table id="infoTable">
			<tr>
				<td width="100px">* 아이디</td>
				<td>${ requestScope.member.userId }</td>
			</tr>
			<tr>
				<td>* 이름</td>
				<td>${ requestScope.member.userName }</td>
			</tr>
			<tr>
				<td>* 닉네임</td>
				<td>${ requestScope.member.nickName }</td>
			</tr>
			<tr>
				<td> &nbsp;&nbsp;이메일</td>
				<td>${ requestScope.member.email }</td>
			</tr>
			<tr>
				<td> &nbsp;&nbsp;생년월일</td>
				<td>${ requestScope.member.birthDay }</td>
			</tr>
			<tr>
				<td> &nbsp;&nbsp;전화번호</td>
				<td>${ requestScope.member.phone }</td>
			</tr>
			<tr>
				<td> &nbsp;&nbsp;주소</td>
				<td>${ requestScope.member.address }</td>
			</tr>
			<tr>
				<td> &nbsp;&nbsp;성별</td>
				<td>${ requestScope.member.gender == 'M' ? "남자" : "여자" }</td>
			</tr>
			<tr>
				<td colspan="2">
					<div align="center">
						<br>
						<button type="button" onclick="location.href='${ contextPath }/memberPwdUpdateForm.me'">비밀번호 변경</button>
						<input type="submit" value="내 정보 수정">
						<button type="button" onclick="deleteMember();">회원 탈퇴</button>
					</div>
				</td>
			</tr>
		</table>
	</form>
	
	<script>
		function deleteMember() {
			if(confirm("정말 탈퇴하시겠습니까?")) {
				location.href = '${contextPath}/mdelete.me';
			}
		}
	</script>
</body>
</html>