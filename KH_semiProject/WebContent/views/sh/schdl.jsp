<%@page import="dto.sh.Schdl"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	List<Schdl> SchdlList = (List) request.getAttribute("list"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border-collapse: collapse;
	border: 1px solid #ccc;
}
td {
	border-top: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
	
	padding: 5px 10px;
}
td:hover {
	background: #FAFAD2;
}
</style>



</head>
<body>

<h1>Schdl 리스트</h1>
<hr>
<table>

<% for(int i=0; i<SchdlList.size(); i++) { %> <!--자바 코드  -->

<tr>
	<td><%=SchdlList.get(i).getSchdl_no() %></td> 
	
	<td>
		<a href="/sh/shdetail?eno=<%=SchdlList.get(i).getSchdl_no() %>">
		<%=SchdlList.get(i).getSchdl_type() %>
		</a>
	</td>
	
	<td><%=SchdlList.get(i).getUser_no() %></td>
	<td><%=SchdlList.get(i).getSchdl_title() %></td>
	<td><%=SchdlList.get(i).getSchdl_content() %></td>
	<td><%=SchdlList.get(i).getSchdl_start() %></td>
	<td><%=SchdlList.get(i).getSchdl_end() %></td>
	<td><%=SchdlList.get(i).getRevision_date()%></td>
	<td><%=SchdlList.get(i).getTable_no() %></td>
</tr>

<%	} %>
</table>


</body>
</html>