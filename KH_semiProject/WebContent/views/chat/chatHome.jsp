<%@page import="dto.ChatUserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page errorPage ="./errorPage.jsp" %>
    <% ChatUserInfo user = (ChatUserInfo) session.getAttribute("userinfo"); %>
    <% String userIp = (String) session.getAttribute("userIp"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅 홈</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$("#chatStart").on("click",function(){
		//console.log("클릭");
		location.href='/chathome/start';
	})
})

</script>
<style type="text/css">
button{
	height : 30px;
	width : 100px;
}
div{
	padding : 5px;
}
</style>
</head>
<body>
<h1>채팅</h1>
<h3><%=user.getUser_name() %>님의 대화</h3>
<h4>접속 ip : <%=userIp %></h4>
<hr>
<div id=list>
	<div>
<!-- 		JSP페이지 연결안되서 일단 페이지 이동으로 사용 -->
<!-- 		<button id="StartChatBtn" onclick="showPopup();">채팅시작하기</button> -->
		<input type="button" id="chatStart" value="채팅시작하기"/>
		<script type="text/javascript">
		//JSP페이지 연결안되서 일단 중단
// 		function showPopup(){
			
// 			var url ="localhost:8089/chathome/start";
// 			var name ="chat";
// 			window.open(url,name,"width=400, height=300, left=100, top=50")
// 		};
		</script>
	</div>
	<div>
		<a href="/chathome/list">
			<button id="ListChatBtn">채팅목록</button>
		</a>
	</div>
</div>

</body>
</html>