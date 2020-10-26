<%@page import="dto.note.NoteList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% List<NoteList> list = (List<NoteList>) request.getAttribute("list"); %>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <h1>받은 쪽지함</h1>
    <hr />

    <article>
      <div id="search">
        <form action="" method="POST">
          <select>
            <option value="all" selected="selected">전체</option>
            <option value="title">제목</option>
            <option value="article">내용</option>
            <option value="sender">보낸사람</option>
            <option value="receiver">받는사람</option>
          </select>
          <input type="text" name="keyword"><button name:="search">검색</button>
        </form>
      </div>
      <hr>
        <div id="list">
      <table>
        <thead>
          <tr>
            <th></th>
            <th>쪽지번호</th>
            <th>제목</th>
            <th>보낸사람</th>
            <th>보낸시간</th>
          </tr>
        </thead>
          <% for (int i = 0; i < list.size(); i++) { %>
          <tbody>
            <tr>
              <td><input type="checkbox" name="" id=""></td>
              <td><%=list.get(i).getNote_no() %></td>
              <td><%=list.get(i).getNote_title() %></td>
              <td><%=list.get(i).getSender_name()%></td>
              <td><%=list.get(i).getSend_date() %></td>
            </tr>
            <% } %>
          </tbody>
          
        </table>
        <hr>
        <button>선택삭제</button>
      </div>
    </article>

  </body>
</html>
