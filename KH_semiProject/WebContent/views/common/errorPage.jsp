<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>

	<% String msg = (String)request.getAttribute("msg"); %>
	
	<%if(msg!=null) {%>
	<h1><%= msg %></h1>
	<%} %>
	
</body>
</html>