<%@page import="board.model.vo.Reply"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Board b = (Board) request.getAttribute("board");
	ArrayList<Reply> list = (ArrayList<Reply>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 상세보기</title>
<style>
	.outer{
		width:800px; min-height:500px; background: rgba(255, 255, 255, 0.4); border: 5px solid white;
		margin-left:auto; margin-right:auto; margin-top:50px;
	}
	.tableArea {width: 450px; height:350px; margin-left:auto; margin-right:auto; align: center;}
	table{align: center;}
	#updateBtn{background: #B2CCFF;}
	#menuBtn{background: #D1B2FF;}
	#deleteBtn{background: #D5D5D5;}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
		
	<div class="outer">
		<br>
		<h2 align="center">게시판 상세보기</h2>
		<div class="tableArea">
			<form action="<%= request.getContextPath() %>/boardUpdateForm.bo" id="detailForm" method="post">
				<table>
					<tr>
						<th>분야</th>
						<td><%= b.getCategory() %></td>
						<th>제목</th>
						<td colspan="3">
							<input type="hidden" name="no" value="<%= b.getBoardId() %>">
							<%= b.getBoardTitle() %>
						</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><%= b.getNickName() %></td>
						<th>조회수</th>
						<td><%= b.getBoardCount() %></td>
						<th>작성일</th>
						<td><%= b.getCreateDate() %></td>
					</tr>
					<tr>
						<th>내용</th>
					</tr>
					<tr>
						<td colspan="6">
							<textarea cols="60" rows="15" style="resize:none;" readonly><%= b.getBoardContent() %></textarea>
						</td>
					</tr>
				</table>
				
				<% if(loginUser != null && loginUser.getUserId().equals(b.getBoardWriter())) { %>
				<div align="center">
					<input type="submit" id="updateBtn" value="수정">
					<input type="button" onclick="deleteBoard();" id="deleteBtn" value="삭제">
					<input type="button" onclick="location.href='<%= request.getContextPath() %>/list.bo'" id="menuBtn" value="메뉴로">
				</div>
				<% } %>
			</form>
		</div>
		
		<div class="replyArea">
			<% if(loginUser != null) { %>
			<div class="replyWriterArea">
				<table>
					<tr>
						<td>댓글작성</td>
						<td><textarea rows="3" cols="80" id="replyContent" style="resize: none;"></textarea></td>
						<td><button id="addReply">댓글등록</button></td>
					</tr>
				</table>
			</div>
			<% } %>
			<div id="replySelectArea">
				<table id="replySelectTable">
				<% if(list.isEmpty()) { %>
					<tr><td colspan="3">댓글이 없습니다.</td></tr>
				<% } else { %>
					<% for(int i = 0; i < list.size(); i++) { %>
					<tr>
						<td width="100px"><%= list.get(i).getReplyWriter() %></td>
						<td width="400px"><%= list.get(i).getReplyContent() %></td>
						<td width="200px"><%= list.get(i).getCreateDate() %></td>
					</tr>
					<% } %>
				<% } %>
				</table>
			</div>
		</div>
		
	</div>
	<script>
		function deleteBoard() {
			if(confirm('정말 삭제하시겠습니까?')) {
				var form = document.getElementById("detailForm");
				form.setAttribute("action", "<%= request.getContextPath() %>/delete.bo");
				form.submit();
			}
		}
		<% if(loginUser != null) { %>
		$('#addReply').click(function() {
			var writer = '<%= loginUser.getUserId() %>'
			var bId = '<%= b.getBoardId() %>';
			var content = $("#replyContent").val();
			
			$.ajax({
				url: 'insertReply.bo',
				data: {writer: writer, bId:bId, content:content},
				success: function(data) {
					console.log(data);
					
					$replySelectTable = $("#replySelectTable");
					$replySelectTable.children().remove();
					
					for(var key in data) {
						var $tr = $('<tr>');
						var $writerTd = $('<td>');
						$writerTd.text(data[key].replyWriter).css('width', '100px');
						var $contentTd = $('<td>');
						$contentTd.text(data[key].replyContent).css('width', '400px');
						var $dateTd = $('<td>');
						$dateTd.text(data[key].createDate).css('width', '200px');
						
						$tr.append($writerTd);
						$tr.append($contentTd);
						$tr.append($dateTd);
						
						$replySelectTable.append($tr);
					}
					
					$("#replyContent").val("");
				}
			});
		});
		<% } %>
	</script>
</body>
</html>