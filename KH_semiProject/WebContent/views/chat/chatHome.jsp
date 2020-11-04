<%@page import="dto.chat.Chat"%>
<%@page import="java.util.List"%>
<%@page import="dto.common.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page errorPage ="./errorPage.jsp" %>
    <%
    	UserInfo userinfo = (UserInfo) session.getAttribute("userinfo");
    %>
    <% String userIp = (String) session.getAttribute("userIp"); %>
    <% List<Chat> chatList = (List<Chat>) request.getAttribute("chatList"); %>
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

.chatlist{
    border: solid steelblue;
    overflow-y: auto; 
    width:400px; 
    height: 300px;
}
.chatlist::-webkit-scrollbar{
  width : 5px;
}
.chatlist::-webkit-scrollbar-thumb{
  border-radius : 10px;
  background-color : #ccc;
}
.chatlist::-webkit-scrollbar-track{
  display:none;
}

.chatrow{
    height : 45px;
    width : 394px;
    border: 3px solid #ccc;
}

.chatrow:hover{
  background-color : #ccc;
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
<hr>
<div id=list>
<div>
<input type="button" id="chatStart" value="채팅시작하기"/>
</div>
<div class="chatlist" >
<% for(Chat c : chatList){ %>
		<div class="chatrow" onclick="location.href='/chat/room?selectUserNo=<%=c.getUser_no() %>'">
			<div class="msgname" ><%=c.getUser_name() %></div>
			<div class="msgtime"><%=c.getRevision_date() %></div>
			<div class="msgcontent"><%=c.getMsg_content() %></div>
		</div>
<% } %>
</div>
</div>

</body>
</html>