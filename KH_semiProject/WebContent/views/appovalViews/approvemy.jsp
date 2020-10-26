<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/resources/css/main.css">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<style>
table {
	border-top:2px solid;
	border-color:#ccc;
	margin: 0 auto;
	width: 80%;
}

.dobutton {
	text-align: center;
	margin-bottom: 10px;
}

#dobutton {
	width: 130px;
	height: 50px;
}

#bot :first-child{

	margin-left:10%
}


</style>
</head>
<body>

	<div class="container">
		<jsp:include page="/views/common/topMenu.jsp"></jsp:include>

		<jsp:include page="/views/common/sideMenu.jsp"></jsp:include>
		<main>

			<h3 style="text-align: center;">기안함</h3>

			<div class=dobutton>
				<button id="dobutton">승인 문서 3</button>
				<button id="dobutton">반려 문서 1</button>
			</div>
			
	
			<table>
				<tr>
					<th><label>전체선택<input type="checkbox" name="color"
							value="blue">
					</label></th>
					<th>이름</th>
					<th>부서</th>
					<th>직급</th>
					<th>결재 제목</th>
					<th>결재계</th>
					<th>상신일</th>
					<th>결재상태</th>
					<th>결재 일시</th>
					<th>버튼</th>
				</tr>
				<tr>
					<td><input type="checkbox" name="color" value="blue"></td>
					<td>본인</td>
					<td>개발팀</td>
					<td>대리</td>
					<td><a style="color: red;" href="http://www.naver.com">
							기안문서 상신드립니다</a></td>
					<td>휴가계</td>
					<td>20201026</td>
					<td>미승인</td>
					<td>20201028</td>
					<td><button>수정</button></td>

					<!-- 목록 뜨는 부분 -->
				</tr>
			</table>
			<div id="bot"> 
			<button>기안하기</button>
			<button>삭제</button>
			</div>

		</main>

		<jsp:include page="/views/common/footer.jsp"></jsp:include>
	</div>

</body>
</html>