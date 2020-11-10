<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax</title>
<script src="js/jquery-3.5.1.min.js"></script>
<style>
.test {
	width: 300px;
	min-height: 50px;
	border: 1px solid red;
}
</style>
</head>
<body>
	<h1>jQuery를 통한 Ajax 구현</h1>
	
	<h3>1. 버튼 선택 시 전송 값 서버에 출력</h3>
	이름 : <input type="text" id="myName">
	<button id="nameBtn">이름 전송</button>
	<script>
		$('#nameBtn').click(function() {
			var name = $('#myName').val();
			$.ajax({
				url: 'jQueryTest1.do', // 필수속성
				data: {name : name},
				type: "GET",
				success: function(data) {
					console.log('서버 전송 성공 시 호출되는 함수');
				},
				error: function(data) {
					console.log('서버 전송 실패 시 호출되는 함수');
				},
				complete: function(data) {
					console.log('무조건 호출되는 함수');
				}
			});
		});
	</script>
	
	<h3>2. 버튼 선택 시 서버에서 보낸 값 사용자가 수신</h3>
	<button id="getServerTextBtn">서버에서 보낸 값 확인</button>
	<p class="test" id="p1"></p>
	<script>
		$('#getServerTextBtn').click(function() {
			$.ajax({
				url: 'jQueryTest2.do',
				type: "get",
				success: function(data) {
					console.log(data);
					$('#p1').text(data);
				},
				error: function(data) {
					console.log(data);
				}
			});
		});
	</script>
	
	<h3>3. 서버로 기본형 전송 값이 있고, 결과로 문자열을 받아 처리</h3>
	<h4>두 개의 값을 더한 결과를 받아옴</h4>
	첫 번째 숫자 : <input type="text" id="firstNum"><br>
	두 번째 숫자 : <input type="text" id="secondNum"><br>
	<button id="plusBtn">더하기</button>
	<p class="test" id="p2"></p>
	<script>
		$('#plusBtn').click(function() {
			var firstNum = $('#firstNum').val();
			var secondNum = $('#secondNum').val();
			
			$.ajax({
				url: 'jQueryTest3.do',
				data: {firstNum : firstNum, secondNum : secondNum},
				success: function(data) {
					console.log(data);
					$('#p2').text(data);
				}
			});
		});
	</script>
	
	<h3>4. Object형태의 데이터를 서버에 전송, 서버에서 처리 후 서버 console로 출력</h3>
	학생1 : <input type="text" id="student1"><br>
	학생2 : <input type="text" id="student2"><br>
	학생3 : <input type="text" id="student3"><br>
	<button id="studentTest">결과확인</button>
	<script>
		$('#studentTest').click(function() {
			var student1 = $('#student1').val();
			var student2 = $('#student2').val();
			var student3 = $('#student3').val();
	
			var students = {
					student1 : student1,
					student2 : student2,
					student3 : student3
			};
			
			$.ajax({
				url: 'jQueryTest4.do',
				data: students,
				success: function() {
					console.log('성공');
				}
			});
		});
	</script>
	
	<h3>5. 서버로 기본형 데이터 전송, 서버에서 객체 반환</h3>
	<h4>유저 번호 보내서 해당 유저 정보 가져오기</h4>
	유저 번호 : <input type="text" id="userNo"><br>
	<button id="getUserInfoBtn">정보 가져오기</button>
	<p class="test" id="p3"></p>
	<textarea class="test" id="textarea3" rows="40" cols="5"></textarea>
	<script>
		$('#getUserInfoBtn').click(function() {
			var userNo = $('#userNo').val();
			
			$.ajax({
				url: "jQueryTest5.do",
				data: {userNo : userNo},
				success: function(data) {
					console.log(data);
					
					var resultStr = "";
					
					if(data != null) {
						resultStr = data.userNo + ", " + data.userName + ", " + data.userNation;
					} else {
						resultStr = "해당 사용자가 존재하지 않습니다.";
					}
					
					$('#p3').text(resultStr);
					$('#textarea3').val(resultStr);
				}
			});
		});
	</script>
	
	<h3>6. 서버로 기본 값 전송, 서버에서 리스트 객체 반환</h3>
	<h4>유저 번호 요청 ---> 해당 유저 번호가 있으면 유저 정보, 없는 경우 전체 가져오기</h4>
	유저 번호 : <input type="text" id="userNo2"><br>
	<button id="getUserInfoBtn2">정보 가져오기</button>
	<p class="test" id="p4"></p>
	
	<script>
		$('#getUserInfoBtn2').click(function() {
			var userNo = $('#userNo2').val();
			
			$.ajax({
				url: 'jQueryTest6.do',
				data: {userNo:userNo},
				success: function(data) {
					console.log(data);
					
					var result = "";
					for(var i in data) {
						var user = data[i];
						result += user.userNo + ", " + user.userName + ", " + user.userNation + "<br>";
					}

					$('#p4').html(result);
				}
			});
		});
	</script>
	
	<h3>7. 서버로 데이터 여러 개 전송, 서버에서 리스트 객체 반환</h3>
	<h4>유저 번호 전송 --> 현재 있는 유저 정보만 보아서 출력</h4>
	<h4>10 이상의 숫자는 ','로 쓸 수 없다고 설정</h4>
	유저 정보(번호, 번호, 번호) : <input type="text" id="userNo3"><br>
	<button id="getUserInfoBtn3">정보 가져오기</button>
	<textarea rows="5" cols="40" id="textarea5" class="text"></textarea>
	<script>
		$("#getUserInfoBtn3").click(function() {
			$.ajax({
				url: 'jQueryTest7.do',
				data: {userNo:$('#userNo3').val()},
				success: function(data) {
					console.log(data);
					
					var result = "";
					for(var i in data.list) {
						var user = data.list[i];
						result += user.userNo + ", " + user.userName + ", " + user.userNation + "\n";
					}
					
					$("#textarea5").val(result);
				}
			});
		});
	</script>
	
	<h3>8. 서버 유저 정보로 표 구성하기</h3>
	<button id="userInfoBtn">유저 정보 불러오기</button>
	<br><br>
	<table id="userInfoTable" border="1" cellpadding="0" cellspacing="0">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>국적</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	
	<script>
		$("#userInfoBtn").click(function() {
			$.ajax({
				url: 'jQueryTest8.do',
				success: function(data) {
					console.log(data);
					
					$tableBody = $("#userInfoTable tbody");
					//$tableBody.html('');
					$tableBody.children().remove();
					
					$.each(data, function(index, value) {
						var $tr = $('<tr>');
						var $noTd = $('<td>').text(value.userNo);
						var $nameTd = $('<td>').text(value.userName);
						var $nationTd = $('<td>').text(value.userNation);
						
						$tr.append($noTd);
						$tr.append($nameTd);
						$tr.append($nationTd);
						
						$tableBody.append($tr);
					});
				}
			});
		});
	</script>
	
	<h3>9. 서버에서 List객체 반환 받아 select태그를 이용해서 보여줌</h3>
	유저 이름 : <input type="text" id="selectUserName">
	<button id="selectListBtn">9번 예제</button>
	<br>
	<select id="selectListTest"></select>
	
	<script>
		$('#selectListBtn').click(function() {
			$.ajax({
				url: 'jQueryTest9.do',
				success: function(data) {
					console.log(data);
					
					$select = $('#selectListTest');
					//$select.children().remove();
					$select.find('option').remove();
					
					for(var i = 0; i < data.length; i++) {
						var name = data[i].userName;
						var selected = name == $('#selectUserName').val() ? 'selected' : "";
						
						$select.append($("<option value='" + data[i].userNo + "'" + selected + ">" + name + '</option>'));

					}
					
					
				}
			});
		});
	</script>
	
	<h3>10. Gson을 이용한 List 반환</h3>
	<button id="gsonListBtn">list 가져오기</button>
	<select id="gsonListSelect"></select>
	
	<script>
		$('#gsonListBtn').click(function() {
			$.ajax({
				url: 'jQueryTest10.do',
				success: function(data) {
					console.log(data);
					
					$select = $('#gsonListSelect');
					$select.find('option').remove();
					
					for(var i in data) {
						var $option = $('<option>');
						$option.val(data[i].userNo);
						$option.text(data[i].userName);
						
						$select.append($option);
					}
				}
			});
		});
	</script>
	
	
	<h3>11. Gson을 이용한 Map 반환</h3>
	<button id="gsonMapBtn">Map가져오기</button>
	<select id="gsonMapSelect"></select>
	
	<script>
		$('#gsonMapBtn').click(function() {
			$.ajax({
				url: 'jQueryTest11.do',
				success: function(data) {
					console.log(data);
					
					$select = $('#gsonMapSelect');
					$select.find('option').remove();
					
					for(var key in data) {
						var $option = $('<option>');
						$option.val(data[key].userNo);
						$option.text(data[key].userName);
						
						$select.append($option);
					}
					
				}
			});
		});
	</script>
</body>
</html>