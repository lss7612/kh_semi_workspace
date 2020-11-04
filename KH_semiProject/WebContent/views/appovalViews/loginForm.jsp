<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인 폼</h1>


<hr>
<% if(session.getAttribute("login")==null) {%>

<%=session.getAttribute("loginid") %>님,반가워요
<form action="/Login" method="post">

<table>
<tr>
	<td><label for="userid">아이디</label></td>
	<td><input type="text" id = "userid" name="userid"/></td>
</tr>
<tr>
	<td><label for="userpw">비밀번호</label></td>
	<td><input type="text" id="userpw" name="userpw"/></td>
</tr>
</table>
<button>로그인</button>
</form>

<%--------------------------------- --%>
<% } else { %>
<%=session.getAttribute("loginid") %>님,반가워요
<button onclick="location.href='/logout'">로그아웃</button>
<% } %>
</body>
</html>