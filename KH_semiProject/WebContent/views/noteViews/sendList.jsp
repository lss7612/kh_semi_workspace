<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="dto.note.NoteList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String msg = (String)request.getAttribute("msg"); %>
    <% List<NoteList> list = (List<NoteList>) request.getAttribute("list"); %>
    <% SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd HH:mm:ss"); %>
	<% List<String> sdl = new ArrayList<>(); %>

    <%for(int i = 0; i < list.size(); i ++){ %>
    <% String send_date = list.get(i).getSend_date(); %>
    <% sdl.add(i, send_date); %>
    <%} %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>q</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="/resources/js/httpRequest.js"></script>
<script type="text/javascript" src="/views/noteViews/resource/sendList.js"></script>

<link rel="stylesheet" href="/views/noteViews/resource/sendList,receivedList.css"></link>
   
</head>
<body>
<body>
    <h1>보낸 쪽지함</h1>
    <hr />

    <article>
      <div class ="wrapper" id="search">
        <form action="/note/send" method="POST">
          <select>
            <option value="all" selected="selected">전체</option>
            <option value="title">제목</option>
            <option value="article">내용</option>
            <option value="sender">보낸사람</option>
            <option value="receiver">받는사람</option>
          </select>
          <input type="text" name="keyword"><button name="search">검색</button>
        </form>
      </div>
      <hr>
        <div class ="wrapper" id="list">
        <form id="deleteAll" action="/note/sendnotedelete" method="GET">
      <table>
        <thead>
          <tr>
            <th></th>
            <th>no</th>
            <th>제목</th>
            <th>받는사람</th>
            <th>보낸시간</th>
          </tr>
        </thead>
          <tbody>
          <% for (int i = 0; i < list.size(); i++) { %>
            <tr>
              <td class="checkbox"><input type="checkbox" name="note_no<%=i%>" value="<%=list.get(i).getNote_no()%>" id=""></td>
              <td class="note_no"><%=list.get(i).getNote_no() %></td>
              <td class="title"><span class="content_title"><%=list.get(i).getNote_title() %></span></td>
              <td class="receiver_name"><span><%=list.get(i).getReceiver_name()%>
              	<%if((list.get(i).getCntReceiver()-1)>0){%>
              	<%= "외 " + (list.get(i).getCntReceiver()-1) + "명" %></span>
              	<%} %>
              	</td>
              <td class="send_date"><%=sdl.get(i)%></td>
            </tr>
            <% } %>
          </tbody>
        </table>
        </form>
        <br><br>
      </div>
      <hr>
        <button class="deleteAll">선택삭제</button>
    </article>
    
	<jsp:include page="/views/noteViews/send_paging.jsp" />
	<jsp:include page="/views/noteViews/buttons.jsp" />
  </body>
</body>
</html>