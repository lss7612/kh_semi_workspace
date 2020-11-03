<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="dto.Bbs" %>
<%@ page import="bbs.BbsDAO" %>
<% Bbs result = (Bbs) request.getAttribute("result"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>WorkJob</title>
</head>
<body>
	<%
		String user_id = null;
		if (session.getAttribute("user_id") != null) {
			user_id = (String) session.getAttribute("user_id");
		}
		
// 		int article_no = 0;
// 		if(request.getParameter("article_no") != null){
// 			article_no = Integer.parseInt(request.getParameter("article_no"));
// 		}
		
// 		if(article_no == 0) {
// 			PrintWriter script = response.getWriter();
// 			script.println("<script>");
// 			script.println("alert('유효하지 않은 글임')");
// 			script.println("location.href = 'bbs.jsp'");
// 			script.println("</script>");
// 		}
// 		Bbs bbs = new BbsDAO().getBbs(article_no);
	%>
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main.jsp">WorkJob</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="main.jsp">메인</a></li>
				<li class="active"><a href="bbs.jsp">게시판</a></li>
			</ul>
			
				<%
				//로그인이 되어 있지 않다면 
				if (user_id == null) {
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					role="button" aria-haspopup="true" data-toggle="dropdown"
					aria-expanded="false">접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="login.jsp">로그인</a></li>
						<li><a href="join.jsp">회원가입</a></li>
					</ul></li>
			</ul>
			<%
				} else {
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					role="button" aria-haspopup="true" data-toggle="dropdown"
					aria-expanded="false">회원관리<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="logoutAction.jsp">로그아웃</a></li>
					</ul></li>
			</ul>
			<% } %>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3"
							style="background-color: #eeeeee; text-align: center;">글보기</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 20%;">글 제목</td>
						<td colspan="2"><%= result.getArticle_title() %>
					</tr>
					<tr>
						<td>작성자</td>
						<td colspan="2"><%=result.getUser_no() %></td>
					</tr>
					<tr>
						<td>작성일자</td>
						<td><%=result.getRevision_date() %></td>
					</tr>
					<tr>
						<td>내용</td>
						<td colspan="2" style="min-height: 200px; text-align: left;">
							<%= result.getArticle_content().replaceAll(" "," ").replaceAll("<", "<").replaceAll(">", ">").replaceAll("\n","<br>") %></td>
					</tr>
				</tbody>
			</table>
			<a href="bbs.jsp" class="btn btn-primary">목록</a>
<%--  			<%  --%>
// 				//글작성자 본인일시 수정 삭제 가능
// 				if (user_no != null && user_no.equals(bbs.getUser_no())) {
<%--  			%>  --%>
   			<a class="btn btn-primary" href="update.jsp">수정</a>   
<%--    			href="update.jsp?bbsID=<%= article_no %>" --%>
   			<a onclick="return confirm('삭제하시겠습니까?')" href="delete.jsp" class="btn btn-primary">삭제</a>   
<%--    			href="deleteAction.jsp?bbsID=<%= article_no %>" --%>
<%--  			<% } %>  --%>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-1.11.3.js"
		integrity="sha256-IGWuzKD7mwVnNY01LtXxq3L84Tm/RJtNCYBfXZw3Je0="
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
</body>
</html>