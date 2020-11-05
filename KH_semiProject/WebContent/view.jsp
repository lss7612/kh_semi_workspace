<%@page import="dto.UploadFile"%>
<%@page import="java.util.List"%>
<%@page import="dto.SessionDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="dto.Bbs" %>
<%@ page import="bbs.BbsDAO" %>
<% Bbs result = (Bbs) request.getAttribute("result"); %>
<%	List<Bbs> list = (List<Bbs>) request.getAttribute("list"); %>
<% SessionDTO user_info = (SessionDTO) session.getAttribute("userinfo");  %>
<% String user_id = (String)request.getAttribute("userid"); %>
<% List<UploadFile> listFiles = (List<UploadFile>) request.getAttribute("list"); %>

<jsp:include page="/views/common/headerKKH.jsp"></jsp:include>
<style type="text/css">
body{
	overflow: auto;
}
</style>

<%
	int article_no = result.getArticle_no();
	if(article_no != 0){
		System.out.println("그지가튼거사" + article_no);
		
	}
	Bbs bbs = new BbsDAO().getBbs(article_no);
%>
<%-- 	<% article_no = integer.parseint(request.getparameter("article_no")); %> --%>
<%-- 	<% user_no = integer.parseint(request.getparameter("user_no")); %> --%>
	
	<div class="content-wrapper">
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
						<td colspan="2"><%=result.getUser_name() %></td>
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
					<hr>
<!-- 					<tr> -->
<!-- 						<td colspan="2"> -->
<!-- 						<div>여긴 덧글 작성</div> -->
<!-- 						</td> -->
						
<!-- 					</tr> -->
				</tbody>
			</table>
			<a href="/list" class="btn btn-primary">목록</a>
  			<%--
 				//글작성자 본인일시 수정 삭제 가능 -->
 				if(user_info.getUser_id() != null && user_id.equals(user_id)){ 
  			--%>  
<%--   			<div class="btn btn-primary" onclick="location.href='/nomodify?article_no=<%=result.getArticle_no()%>'"> --%>
   			<a class="btn btn-primary" href="/nomodify?article_no=<%=result.getArticle_no()%>">수정</a>   
   			<a onclick="return confirm('삭제하시겠습니까?')" action="delete.jsp" class="btn btn-primary">삭제</a>   
  			<%-- } --%> 
		</div>
	</div>
	<jsp:include page="/views/common/footerKKH.jsp"></jsp:include>