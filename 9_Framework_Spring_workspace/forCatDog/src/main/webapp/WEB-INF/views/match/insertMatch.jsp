<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forCatDog</title>
<%@ include file="/resources/globalVariable.jsp" %>
<link rel="stylesheet" type="text/css" href="${ contextPath }/resources/css/common/base.css">
<link rel="stylesheet" type="text/css" href="${ contextPath }/resources/css/common/content.css">
<link rel="stylesheet" type="text/css" href="${ contextPath }/resources/css/match/InsertMatch.css">
<script src="${ contextPath }/resources/js/matchFile.js"></script>
</head>
<body>
	<div class="wrap">
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		<%@ include file="/WEB-INF/views/common/nav.jsp" %>
		
		<div id='content'>
			<div class="match_title"><h1>매칭</h1></div>
			
			<br>
			
			<button type="button" class="match_type_btn" ${ cate == 1 ? "id='btn_on'" : "" } onClick="location.href='${ contextPath }/findMatchList.mc?cate=1'">
				<i class="fa fa-heart"></i> 짝
			</button>
			<button type="button" class="match_type_margin_btn0" ${ cate == 2 ? "id='btn_on'" : "" } onClick="location.href='${ contextPath }/findMatchList.mc?cate=2'">
				<i class="fa fa-walking"></i> 산책메이트
			</button>
			<button type="button" class="match_type_margin_btn1" ${ cate == 3 ? "id='btn_on'" : "" } onClick="location.href='${ contextPath }/findMatchList.mc?cate=3'">
				<i class="fa fa-baby-carriage"></i> 펫 시터
			</button>
			
			<br>
			<br>
			<div class="match_content">
			<form action="insertMatch.mc" method="post" role="form" onsubmit="return matchInsert();">
				<input type="hidden" name="matchCate" value="1">
				
				<span class="detail_title">제목</span>
				<input type="text" class="input_title" name="matchTitle">
				<div class="petImg"><i class="fas fa-dog"></i><span class="font_size">펫을 등록해주세요!</span></div>
					<div id="petArea">
						<div class="pet">						
							<img name="petImg" onclick="selectMyPet();">
							<input type="hidden" name="petList[0].petNum">
						</div>
						
						<div id="petInfo"></div>
					</div>
				<br>
				<p class="font_deco1">기타내용</p>
				<br>
				<textarea id="matchContent" name="matchContent" class="backColor" placeholder="희망사항을 적어주세요!"></textarea>
											 
			    <br>
				
				<button type="button" class="returnListBtn" onClick="location.href='${ contextPath }/findMatchList.mc?cate=1'">
					<i class="fa fa-undo"></i> 목록으로
				</button>
				<button type="submit" class="applyBtn">
					<i class="fa fa-check"></i> 등록
				</button>
		
			</form>
		</div>
	</div>
	
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</div>
	<script>
		function goBack(){
			window.history.back();
		}
	</script>
		
			
	<script>
		function selectMyPet() {
			var popupX = (window.screen.width / 2) - (853 / 2);
			var popupY = (window.screen.height / 2) - (632 / 2);
			window.open("matchPetSelect.mc", "selectMyPet", 'status=no, height=632, width=853, left='+ popupX + ', top='+ popupY);
		}
	</script>
</body>
</html>