<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 수정</title>
<style>
	#pwdTable{margin: auto;}
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<h1 align="center">비밀번호 수정</h1>
	<form action="${ contextPath }/mPwdUpdate.me" method="post" onsubmit="return pwdUpdate();">
		<table id="pwdTable">
			<tr>
				<td>* 현재 비밀번호</td>
				<td><input type="password" name="userPwd" required></td>
			</tr>
			<tr>
				<td>* 새 비밀번호</td>
				<td><input type="password" id='newPwd' name="newPwd" required></td>
			</tr>
			<tr>
				<td>* 새 비밀번호 확인</td>
				<td><input type="password" id='newPwd2' name="newPwd2" required></td>
			</tr>
			<tr>
				<td colspan="2">
					<div align="center">
						<br>
						<input type="submit" value="수정하기">
						<button type="reset">취소</button>
					</div>
				</td>
			</tr>
		</table>
	</form>
	
	<script>
		function pwdUpdate() {
			var newPwd = document.getElementById('newPwd').value;
			var newPwd2 = document.getElementById('newPwd2').value;
			
			if(newPwd != newPwd2) {
				alert('새 비밀번호를 다시 확인하세요.');
				return false;
			}
		}
	</script>
</body>
</html>