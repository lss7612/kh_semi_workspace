<%@page import="common.Paging"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% Paging paging = (Paging) request.getAttribute("paging"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
ul.pagination {
	list-style: none;
	padding: 0;
	margin: 0;
}
ul.pagination li {
	float: left;
	width: 20px;
    border: 1px solid #ccc;
    text-align: center;
}
ul.pagination li a {
	text-decoration: none;
	color: black;
}
ul.pagination li.active a {
	color: red;
	font-weight: bold;
}
</style>

</head>
<body>

<div class="text-center">
<ul class="pagination">

	<!-- 첫 페이지로 가기 -->
	<%	if( paging.getCurPage() != 1 ) { %>
	<li><a href="/address/view">&larr;</a></li>
	<%	} %>
	
	
	<!-- 이전 페이지로 가기 -->
	<%	if( paging.getCurPage() != 1 ) { %>
	<li><a href="/address/view?curPage=<%=paging.getCurPage()-1 %>">&lt;</a></li>
	<%	} %>
	


	<!-- 페이징 리스트 -->
	<%	for(int i=paging.getStartPage(); i<=paging.getEndPage(); i++) { %>
	
	<%		if( i == paging.getCurPage() ) { %>
	<li class="active"><a href="/address/view?curPage=<%=i %>"><%=i %></a></li>
	<%		} %>
	
	<%		if( i != paging.getCurPage() ) { %>
	<li><a href="/address/view?curPage=<%=i %>"><%=i %></a></li>
	<%		} %>
	
	<%	} %>	
	
	
	
	<!-- 다음 페이지로 가기 -->
	<%	if( paging.getCurPage() != paging.getTotalPage() ) { %>
	<li><a href="/address/view?curPage=<%=paging.getCurPage()+1 %>">&gt;</a></li>
	<%	} %>

	
	
	<!-- 마지막 페이지로 가기 -->
	<%	if( paging.getCurPage() != paging.getTotalPage() ) { %>
	<li><a href="/address/view?curPage=<%=paging.getTotalPage() %>">&rarr;</a></li>
	<%	} %>
</ul>
</div>

</body>
</html>