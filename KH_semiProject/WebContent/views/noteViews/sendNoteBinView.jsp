<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="dto.note.NoteList"%>
<%@page import= "dto.addr.AddrView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<% NoteList list = (NoteList)request.getAttribute("noteList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="/views/noteViews/resource/sendNoteBinView.js"></script>
<link rel="stylesheet" href="/views/noteViews/resource/noteView.css"></link>

</head>
<body>

<h1>삭제된 보낸 쪽지 보기</h1>
<hr>

<% String sender_name =  list.getSender_name();%>
<% String sender_DeptName = list.getSenderDept_name(); %>
<% String sender_PositionName = list.getPosition(); %>
<% %>
<% String send_date = list.getSend_date(); %>
<% List<AddrView> receivers =  list.getReceivers();%>
<% String note_article = list.getNote_article(); %>

<div class="view_content_wrap">

	<div class="content_title">
		<span class="note_no0"><%= list.getNote_no() %></span>
		<h3><%= list.getNote_title() %></h3>
	</div>
	<div class="content_sub_title">
		<div class="content_sub_title_1">
			<span class="user_name">보낸사람: <span><%=sender_DeptName +"/"+sender_PositionName+"/"+ sender_name  %></span></span>
			<span class="send_date" style="float:right;">보낸시간:<%= "("+ send_date	+")" %></span>
		</div>		
		<div class="content_sub_title2">
			<span class="receiver">받는사람:</span>
			<% for (int i = 0; i < list.getReceivers().size(); i++) {%>
			<span class="receiver<%=i%>"><%= receivers.get(i).getDept_name()+"/"+ receivers.get(i).getPosition_name()+"/"+ receivers.get(i).getUser_name()  %></span>
			<%} %>
		</div>
		<div class="content_article"><%= note_article %></div>
		
	</div>
	<div class="buttons">
		<span class="cursor reply">답장</span>
		<span class="cursor restore">복구</span>
		<span class="cursor toReceivedNoteList">받은쪽지함으로</span>
		<span class="cursor toSendNoteList">보낸쪽지함으로</span>
	</div>
	

</div>
<jsp:include page="/views/noteViews/buttons.jsp" />
</body>
</html>