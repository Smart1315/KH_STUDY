<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 작성</title>
<style>
	.outer{
		width: 800px; height: 500px; background: rgba(255, 255, 255, 0.4); border: 5px solid white;
		margin-left: auto; margin-right: auto; margin-top: 50px;
	}
	.tableArea {width:500px; height:350px; margin-left:auto; margin-right:auto;}
	#insertBtn {background: #B2CCFF;}
	#cancelBtn{background: #D1B2FF;}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
		
	<div class="outer">
		<br>
		<h2 align="center">게시판 작성</h2>
		<div class="tableArea">
			<form action="<%= request.getContextPath() %>/insert.bo" method="post" onsubmit="return boardCheck();">
				<table>
					<tr>
						<th>분야</th>
						<td>
							<select name="category">
								<option>--------</option>
								<option value="10">공통</option>
								<option value="20">운동</option>
								<option value="30">등산</option>
								<option value="40">게임</option>
								<option value="50">낚시</option>
								<option value="60">요리</option>
								<option value="70">기타</option>
							</select>
						</td>	
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="3"><input type="text" size="58" name="title"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3">
							<textarea rows="15" cols="60" name="content" style="resize:none;"></textarea>
						</td>
					</tr>
				</table>
				<br>
				<div align="center">
					<input type="submit" id="insertBtn" value="등록하기">
					<input type="button" id="cancelBtn" onclick="location.href='<%= request.getContextPath() %>/list.bo'" value="취소">
				</div>
			</form>
		</div>
	</div>
	<script>
		function boardCheck() {
			var category = document.getElementsByName('category')[0];
			for(var i = 0; i < category.children.length; i++) {
				if(category.children[i].selected == true && i == 0) {
					alert("카테고리를 선택해주세요.");
					return false;
				}
			}
			return true;
		}
	</script>
	
</body>
</html>