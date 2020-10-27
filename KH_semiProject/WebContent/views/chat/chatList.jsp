<%@page import="java.util.List"%>
<%@page import="dto.Chat"%>
<%@page import="dto.ChatUserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page errorPage ="./errorPage.jsp" %>
    <% ChatUserInfo userinfo = (ChatUserInfo)session.getAttribute("userinfo"); %>
    <% List<Chat> chatList = (List<Chat>)request.getAttribute("chatList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅 목록</title>
<style type="text/css">
#chatListTable{
	border : 1px solid #ccc;
}
th,td{
	border : 3px solid #ccc;
}
</style>
</head>
<body>
<h1><%=userinfo.getUser_name() %>님의 대화 목록</h1>
<h3>IP 주소 : <%=session.getAttribute("userIp")%></h3>
<hr>
<h3> 채팅 목록</h3>
<table id="chatListTable">
	<tr>
		<th>방 번호</th>
		<th>대화상대</th>
		<th>내용</th>
		<th>시간 </th>
	</tr>
<% for(Chat c : chatList){ %>
	<tr>
		<% if ( userinfo.getUser_name().equals( c.getUser_name() )) { %>
		<% continue; }  else {%>
		<td><%=c.getChatting_no() %></td>
		<td><%=c.getUser_name() %></td>
		<td><%=c.getRevision_date() %></td>
		<td><%=c.getRevision_date() %></td>
		<% } %>
	</tr>
<% } %>
</table>
		
</body>
</html>