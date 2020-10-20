<%@page import="java.util.ArrayList"%>
<%@page import="dto.addr.AddrView"%>
<%@page import="dto.addr.AddrParam"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% List<AddrView> list = (List<AddrView>) request.getAttribute("list"); %>
<html>
<head>
<meta charset="UTF-8">
<title>주소록</title>

<script type="text/javascript">

</script>

<style type="text/css">
table, th, td {
	border:1px solid #ccc;
}
</style>
</head>
<body>


<div id="refresh">

<table>
<tr>
	<th><button class="ASC">아이디</button></th>
	<th><button class="ASC">이름</button></th>
	<th><button class="ASC">부서</button></th>
	<th><button class="ASC">직급</button></th>
	<th><button class="ASC">휴대전화</button></th>
</tr>
<% for (int i = 0; i < list.size(); i++) { %>
<tr>
	<td><%=list.get(i).getUser_id()%></td>
	<td><%=list.get(i).getUser_name() %></td>
	<td><%=list.get(i).getDept_name() %></td>
	<td><%=list.get(i).getPosition_name() %></td>
	<td><%=list.get(i).getCellphone_no() %></td>
</tr>
<%} %>
</table>

</div>

</body>
</html>