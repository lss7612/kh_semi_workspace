<%@page import="dto.SessionDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@page import="bbs.BbsDAO"%>
<%@page import="dto.Bbs"%>
<% SessionDTO user_info = (SessionDTO) session.getAttribute("userinfo");  %>
<% String user_id = (String)request.getAttribute("userid"); %>
<% Bbs noupdate = (Bbs) request.getAttribute("noupdate"); %>
<jsp:include page="/views/common/headerKKH.jsp"></jsp:include>
	<%
// 		String user_id = null;
// 		if (session.getAttribute("user_id") != null) {
// 			user_id = (String) session.getAttribute("user_id");
// 		}
// 	System.out.println("냥ㅇㅇㅇㅇ용 : " + noupdate.getArticle_content());
	%>
	
	<div class="content-wrapper">
		<div class="row">
			<form id="writeForm" method="post" action="/nomodify" style="width:100%; ">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2" style="background-color: #eeeeee; text-align: center;">글 수정</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" class="form-control" value="<%=noupdate.getArticle_title() %>"
								 name="article_title" maxlength="50"></td>
						</tr>
						<tr>
							<td><textarea class="form-control" 
									name="article_content" maxlength="2048" style="height: 500px;"><%=noupdate.getArticle_content() %></textarea></td>
						</tr>
<!-- 						<tr> -->
<!-- 							<td><input type="file" name="upfile" /></td>  -->
<!-- 						</tr> -->
					</tbody>
				</table>
				<input type="submit" class="btn btn-primary pull-right" value="등록">
				<div style="display: none;">
					<input type="text" name="article_no" value="<%=noupdate.getArticle_no() %>" />
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="/views/common/footerKKH.jsp"></jsp:include>