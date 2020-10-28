<%@page import="dto.ChatUserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page errorPage ="./errorPage.jsp" %>
    <% ChatUserInfo usreinfo = (ChatUserInfo) session.getAttribute("userinfo"); %>
    <% int chatting_no = (int)request.getAttribute("chatting_no"); %>
    <% ChatUserInfo user1_info = (ChatUserInfo) request.getAttribute("user1_info");  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>채팅방개설중입니다. 잠시만 기다려주세요.</h1>
<hr>
<jsp:forward page="./chat.jsp" >
<jsp:param name="chatting_no" value="<%=chatting_no %>" />
<jsp:param name="user1_info" value="<%=user1_info %>" />
</jsp:forward>
</body>
</html>