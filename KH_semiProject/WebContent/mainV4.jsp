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
	
</head>
<body>
	 
	<div class="container">
		<jsp:include page="/views/common/header.jsp"></jsp:include>
		<!-- header랑 footer는 공용으로 쓰면 되고
		nav는 메뉴별로 하나씩 두면 될 것 같습니다 -->
		<jsp:include page="/views/common/navMain.jsp"></jsp:include>

	
		<main>
		내용없음
		</main>
		
		<jsp:include page="/views/common/footer.jsp"></jsp:include>
	</div>

</body>
</html>