<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>닉네임 중복 검사</title>
</head>
<body onload="inputValue();">
	<b>닉네임 중복 검사</b>
	<br>
	<form action="<%= request.getContextPath() %>/checkNickname.me" id="nickNameCheckForm">
		<input type="text" id="inputNickname" name="inputNickname">
		<input type="submit" value="중복확인"/>
	</form>
	
	<br>
	
	<% 
		if(request.getAttribute("result") != null) { 
			int result = (int) request.getAttribute("result");
			if(result > 0) {
	%>
				이미 사용중인 닉네임입니다.
	<%		} else { %>
				사용 가능한 닉네임입니다.
	<%		} %>
	<% } %>
	
	<br>
	<br>
	
	<input type="button" id="usedId" value="확인" onclick="usedNickname();">
	<input type="button" id="cancel" value="취소" onclick="window.close();">
	
	<script>
		function inputValue() {
			if('<%= request.getAttribute("checkedNickname") %>' == 'null') {
				document.getElementById('inputNickname').value = opener.document.joinForm.nickName.value;
			} else {
				document.getElementById('inputNickname').value = "<%= request.getAttribute("checkedNickname") %>";
			}
		}
		
		function usedNickname() {
			opener.document.joinForm.nickName.value = document.getElementById('inputNickname').value;
			
			self.close();
			//window.close();
		}
	</script>
</body>
</html>