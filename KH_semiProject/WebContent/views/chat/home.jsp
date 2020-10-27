<%@page import="dto.ChatUserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage ="./errorPage.jsp" %>
<% ChatUserInfo user = (ChatUserInfo)request.getAttribute("user"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
<style type="text/css">
#chatDiv{
	position : fixed;
	bottom : 0px;
	right : 0px;
	max-width : 100%;
	background: #ccc;
}
#chatBtn{
	height : 40px;
	width : 200px;
	right : 0px;
}
#test{
	background : #ccc;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$("#chatBtn").on("click",function(){
		//console.log("클릭");
		location.href='/chathome';
	})
})


</script>
</head>
<body>
<h1>Home 화면</h1>
<h5>
<%=user.getUser_name() %>님, 환영합니다.
</h5>
<hr>
<div id="test"></div>
<div id="chatDiv">
	<input type="button" id="chatBtn" value="채팅하기">
</div>
</body>
</html>