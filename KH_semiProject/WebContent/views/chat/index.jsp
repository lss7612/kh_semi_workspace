<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>로그인</h1>
<hr>

<form action="/home" method="doget">
<table>
	<tr>
		<td>아이디</td>
		<td><input type="text" id="userid" name="userid"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="text" id="userpw" name="userpw"></td>
	</tr>
	<tr>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td><button>로그인</button></td>
	</tr>
</table>
</form>

</body>
</html>