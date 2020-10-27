<%@page import="dto.Schdl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <% Schdl result = (Schdl) request.getAttribute("result"); %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> 스케줄 정보 상세보기</h1>
<hr>

<table border="1">
<tr>
	<th>스케줄번호</th>
	<th>스케줄 타입</th>
	<th>작성자</th>
	<th>스케줄이름</th>
	<th>스케줄내용</th>
	<th>스케줄시작</th>
	<th>스케줄종료</th>
	<th>작성시간</th>
	<th>테이블번호</th>
</tr>

<tr>
   <td><%=result.getSchdl_no() %></td>
   <td><%=result.getSchdl_type() %></td>
   <td><%=result.getUser_no() %></td>
   <td><%=result.getSchdl_title() %></td>
   <td><%=result.getSchdl_content() %></td>
   <td><%=result.getSchdl_start() %></td>
   <td><%=result.getSchdl_end() %></td>
   <td><%=result.getRevision_date() %></td>
   <td><%=result.getTable_no() %></td>
   
</tr>

</table>


</body>
</html>