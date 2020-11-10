<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	Member member = (Member) request.getAttribute("member");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	.outer{
		width: 48%; height: 450px; background-color: rgba(255, 255, 255, 0.4); border: 5px solid white;
		margin-left: auto; margin-right: auto; margin-top: 5%;
	}
	#myForm td {text-align: center;}
	#myForm>table{margin: auto;}
	#updateBtn {background: #D1B2FF; color: white;}
	#updatePwdBtn {background: #FFD8D8; color: white;}
	#deleteBtn {background: #D5D5D5; color: white;}
	#goMain {background: #B2CCFF; color: white;}
</style>
<title>내 정보 보기</title>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	<div class="outer">
		<br>
		<h2 align="center">내 정보 보기</h2>
		
		<form action="<%= request.getContextPath() %>/updateForm.me" method="post" id="myForm" name="myForm">
			<table>
				<tr>
					<td width="200px">아이디</td>
					<td width="200px">
						<!-- <input type="text" maxlength="13" name="myId" required>  -->
						<%= member.getUserId() %>
					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>
						<!-- <input type="text" name="myName" required> -->
						<%= member.getUserName() %>
					</td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td>
						<!-- <input type="text" maxlength="15" name="myNickName" required> -->
						<%= member.getNickName() %>
					</td>
				</tr>
				<tr>
					<td>연락처</td>
					<td>
						<!-- <input type="tel" maxlength="11" name="myPhone" placeholder="(-없이)01012345678"> -->
						<%= member.getPhone() == null ? "-" : member.getPhone() %>
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>
						<!-- <input type="email" name="myEmail"> -->
						<%= member.getEmail() == null ? "-" : member.getEmail() %>
					</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
						<!-- <input type="text" name="myAddress"> -->
						<%= member.getAddress() == null ? "-" : member.getAddress() %>
					</td>
				</tr>
				<tr>
					<td>관심분야</td>
					<td>
						<!-- <input type="checkbox" id="sports" name="myInterest" value="운동">
						<label for="sports">운동</label>
						<input type="checkbox" id="climbing" name="myInterest" value="등산">
						<label for="climbing">등산</label>
						<input type="checkbox" id="fishing" name="myInterest" value="낚시">
						<label for="fishing">낚시</label>
						<input type="checkbox" id="cooking" name="myInterest" value="요리">
						<label for="cooking">요리</label>
						<input type="checkbox" id="game" name="myInterest" value="게임">
						<label for="game">게임</label>
						<input type="checkbox" id="etc" name="myInterest" value="기타">
						<label for="etc">기타</label> -->
						<%= member.getInterest() == null ? "-" : member.getInterest() %>
					</td>
				</tr>
			</table>
			
			<br>
			
			<div class="myPageBtns" align="center">
				<input id="updateBtn" type="submit" value="수정하기">
				<input id="updatePwdBtn" type="button" value="비밀번호 변경 하기" onclick="location.href='updatePwdForm.me'">
				<input id="deleteBtn" type="button" value="탈퇴하기" onclick="deleteMember();">
				<input type="button" id="goMain" onclick="goMain();" value="메인으로">
			</div>
		</form>
	</div>
	
	<script>
		function deleteMember(){
			// 정말 삭제할거냐고 물어본 후, 삭제하겠다고 하면 delete.me로 요청
			if(confirm("정말 삭제하시겠습니까?")) {
				location.href = 'delete.me';
			}
		}
	</script>
</body>
</html>