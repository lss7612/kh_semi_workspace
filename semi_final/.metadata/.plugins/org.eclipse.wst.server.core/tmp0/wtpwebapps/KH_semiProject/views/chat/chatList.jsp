<%@page import="java.util.List"%>
<%@page import="dto.chat.Chat"%>
<%@page import="dto.common.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page errorPage ="./errorPage.jsp" %>
    <%
    	UserInfo userinfo = (UserInfo)session.getAttribute("userinfo");
    %>
    <% List<Chat> chatList = (List<Chat>) request.getAttribute("chatList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅 목록</title>
<style type="text/css">
.chatlist{
    border: solid steelblue;
    overflow-y: auto; 
    width:400px; 
    height: 600px;
}
.chatlist::-webkit-scrollbar{
  display:none;
}
.chatrow{
    height : 45px;
    width : 394px;
    border: 3px solid #ccc;
}

.msgname{
    height :50px;
    width: 300px;
    display: inline;
}
.msgtime{
    display : inline;
    text-align : right;
    display: inline;
    font-size: small;
}
.msgcontent{
  text-align : right;
}

.bg1{
    background-color: turquoise;
}
.bg2{
    background-color: white;
}
</style>

</head>
<body>
<h1><%=userinfo.getUser_name() %>님의 대화 목록</h1>
<h3>IP 주소 : <%=session.getAttribute("userIp")%></h3>
<hr>
<h3> 채팅 목록</h3>
<div class="chatlist" ">
<% for(Chat c : chatList){ %>
		<div class="chatrow" onclick="location.href='/chat/room?selectUserNo=<%=c.getUser_no() %>'">
			<div class="msgname" ><%=c.getUser_name() %></div>
			<div class="msgtime"><%=c.getRevision_date() %></div>
			<div class="msgcontent"><%=c.getMsg_content() %></div>
		</div>
<% } %>
</div>

</body>
</html>