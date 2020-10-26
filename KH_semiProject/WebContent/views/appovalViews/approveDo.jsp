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
<style type="text/css">
table { 
 	margin: 0 auto; 
 	border-collapse: separate; 
   	border-spacing: 20px 10px; 
  	width:100%;	 
  	
	border-top:2px solid; 
 	border-color:#ccc; 
 } 

tr{
	border:2px 2px 2px 2px;
	border-color:#ccc;
}
th:nth-child(4){
	width:400px;
}

.dobutton{
	text-align:center;
	
	margin-bottom: 10px;
}
#dobutton{

	width:130px;
	height:50px;
}
</style>
</head>
<body>

	<div class="container">
		<jsp:include page="/views/common/topMenu.jsp"></jsp:include>

		<jsp:include page="/views/common/sideMenu.jsp"></jsp:include>
		<main>
		<h3 style="text-align:center;">결재 목록</h3>
		<form action="#">
		<div class =dobutton>
		<button id="dobutton">전체문서  3</button><button id="dobutton">대기문서  1</button><button id="dobutton">완료문서  2</button>
		</div>
		<table>
			<tr style="border : 2px;" >
				<th>이름</th>
				<th>부서</th>
				<th>직급</th>
				<th>결재 제목</th>
				<th>결재계</th>
				<th>상신일</th>
				<th>결재상태</th>
				<th>결재</th>
				<th>갯수</th>
			</tr>
			<tr>
				<td>김xx</td>
				<td>개발팀</td>
				<td>사원</td>
				<td><a style="color:red;"href="http://www.naver.com"> 휴가결재 상신드립니다</a></td>
				<td>휴가계</td>
				<td>20201026</td>
				<td>미승인</td>
				<td><button>승인</button><button>반려</button></td>
				<td>1개</td>
			
			<!-- 목록 뜨는 부분 -->
			</tr>
			<tr>
				<td>김xx</td>
				<td>개발팀</td>
				<td>사원</td>
				<td><a style="color:red;"href="http://www.naver.com"> 휴가결재 상신드립니다</a></td>
				<td>휴가계</td>
				<td>20201026</td>
				<td>미승인</td>
				<td><button>승인</button><button>반려</button></td>
				<td>1개</td>
			
			<!-- 목록 뜨는 부분 -->
			</tr>
		</table>		
		
		
		</form>
		</main>

		<jsp:include page="/views/common/footer.jsp"></jsp:include>
	</div>

</body>
</html>