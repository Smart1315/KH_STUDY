<%@page import="board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Board b = (Board) request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 수정</title>
<style>
	.outer{
		width: 800px; height: 500px; background: rgba(255, 255, 255, 0.4); border: 5px solid white;
		margin-left: auto; margin-right: auto; margin-top: 50px;
	}
	.tableArea {width:500px; height:350px; margin-left:auto; margin-right:auto;}
	#updateBtn, #cancelBtn{background: #B2CCFF; border-radius: 10px; color: white; width: 80px; height: 25px; display: inline-block;}
	#updateBtn:hover, #cancelBtn:hover{cursor: pointer;}
	#cancelBtn{background: #D1B2FF;}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
		
	<div class="outer">
		<br>
		<h2 align="center">게시판 수정</h2>
		<div class="tableArea">
			<form action="<%= request.getContextPath() %>/update.bo" method="post" onsubmit="return boardCheck();">
				<table>
					<tr>
						<th>분야<input type="hidden" name="bid" value=<%= b.getBoardId() %>></th>
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
						<td colspan="3"><input type="text" size="58" name="title" value="<%= b.getBoardTitle() %>"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3">
							<textarea rows="15" cols="60" name="content" style="resize:none;"><%= b.getBoardContent() %></textarea>
						</td>
					</tr>
				</table>
				<br>
				<div align="center">
					<button type="submit" id="updateBtn">수정</button>
					<div id="cancelBtn" onclick="location.href='<%= request.getContextPath() %>/list.bo'">취소</div>
				</div>
			</form>
		</div>
	</div>
	<script>
		var category = document.getElementsByName('category')[0];
		for(var i = 0; i < category.children.length; i++) {
			if(category.children[i].text == '<%= b.getCategory() %>') {
				category.children[i].setAttribute('selected', 'selected');
				break;
			}
		}
		
		
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