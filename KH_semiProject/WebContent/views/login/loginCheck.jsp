<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page errorPage ="/error" %>

<% 
	String userid=(String)session.getAttribute("user_id");
	if(user_id == null) {
%>
	<script>
		alert("로그인한 사용자만 사용가능한 화면입니다.");
		location.href="/Login/login";
	</script>
<% 
	}
%>