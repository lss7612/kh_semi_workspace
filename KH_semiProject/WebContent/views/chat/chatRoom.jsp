<%@page import="service.face.chat.UserChatService"%>
<%@page import="service.impl.chat.UserChatServiceImpl"%>
<%@page import="dto.chat.Chat"%>
<%@page import="dto.chat.SendMsgClient"%>
<%@page import="java.util.List"%>
<%@page import="dto.common.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page errorPage ="./errorPage.jsp" %>
    <%
    	UserInfo userinfo = (UserInfo) session.getAttribute("userinfo");
    %>
    <%
    	int chatting_no = (int) request.getAttribute("chatting_no");
    %>
    <%
    	UserInfo user1_info = (UserInfo) request.getAttribute("user1_info");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대화방 입장중...</title>
</head>
<body>
<h1>채팅방개설중입니다. 잠시만 기다려주세요.</h1>
<hr>
<% 	UserChatService userChatService = new UserChatServiceImpl();
	List<Chat> clist = userChatService.getChatList(userinfo.getUser_no(), user1_info.getUser_no(), chatting_no); 
%>



<jsp:forward page="/chat/room" >
<jsp:param name="chatting_no" value="<%=chatting_no %>" />
<jsp:param name="user1_info" value="<%=user1_info %>" />
<jsp:param name="clist" value="<%=clist %>" />
</jsp:forward>
</body>
</html>