<%@page import="dto.sh.Shinput"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Shinput s = (Shinput) request.getAttribute("result"); %>


    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> 스케줄 입력 결과</h1>
<hr>

스케줄 넘버 : <%= s.getSchdl_no() %><br>
스케줄 타입 : <%= s.getSchdl_type() %><br>
스케줄 이름 : <%= s.getSchdl_title() %><br>
스케줄 내용 : <%= s.getSchdl_content() %><br>
스케줄 시작일자 : <%= s.getSchdl_start() %><br>
스케줄 종료일자: <%= s.getSchdl_end() %><br>
스케줄 작성일자: <%= s.getRevision_date() %><br>
스케줄 테이블번호: <%= s.getTable_no() %><br>

<a href="/semi/SchdlInput"> 스케줄 입력 창으로</a>


</body>
</html>