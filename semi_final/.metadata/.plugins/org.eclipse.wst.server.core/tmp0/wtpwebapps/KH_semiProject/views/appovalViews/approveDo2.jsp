<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="dto.appr.ApprMy"%>
<%@page import="java.util.List"%>
<% 	List<ApprMy> list = (List<ApprMy>) request.getAttribute("list");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/resources/css/main.css">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<style type="text/css">
table {
	border-top: 2px solid;
	border-color: #ccc;
	margin: 0 auto;
	width: 80%;
}
 
 

tr{
	border:2px 2px 2px 2px;
	border-color:#ccc;
}
th:nth-child(4){
	width:400px;
}

.dobutton{
	text-align:center;
	
	margin-bottom: 10px;
}
#dobutton{

	width:130px;
	height:50px;
}
</style>

<jsp:include page="/views/common/headerKKH.jsp"></jsp:include>
	<div class="content-wrapper">

		<main>
		<h3 style="text-align:center;">내 결재 목록</h3>
		<form action="#">
		<div class =dobutton>
		<button id="dobutton">전체문서  3</button><button id="dobutton">대기문서  1</button><button id="dobutton">완결문서  2</button>
		</div>
		<table style="padding:50px 50px;">
			<tr style="border : 2px;" >
				<th>이름</th>
				<th>부서</th>
				<th>직급</th>
				<th>결재 제목</th>
				<th>결재계</th>
				<th>상신일</th>
				<th>1차결재자</th>
				<th>2차결재자</th>
				<th>결재상태</th>
				<th>결재</th>
	
			</tr>
		
					<!-- 결재 목록 -->
				<%
					for (int i = 0; i < list.size(); i++) {
				%>
				
			<tr>
				<td><%=list.get(i).getUser_name() %></td>
				<td><%=list.get(i).getDept_name() %></td>
				<td><%=list.get(i).getPosition_name() %></td>
				<td><a href='#' onclick="window.open('/approval/doDetail?a=<%=list.get(i).getAprvl_no()%>&b=<%=list.get(i).getAprvl_type() %>','_blank','width=800,height=800'); return false;" id=<%=i%> name=<%=list.get(i).getAprvl_no() %>><%=list.get(i).getAprvl_title() %></a></td>
				<td><%=list.get(i).getAprvl_type() %></td>
				<td><%=list.get(i).getCreate_date() %></td>
				<td><%=list.get(i).getMid_auth_name() %></td>
				<td><%=list.get(i).getFinal_auth_name() %></td>
				<td><%=list.get(i).getState_name() %></td>
				<td><button type="button" onclick="location.href='/approval/update?state=yes&now=<%=list.get(i).getState_name()%>&mid=<%=list.get(i).getMid_auth() %>&final=<%=list.get(i).getFinal_auth() %>&num=<%=list.get(i).getAprvl_no() %>'">승인</button>
				<button type="button" onclick="location.href='/approval/update?state=no&now=<%=list.get(i).getState_name()%>&num=<%=list.get(i).getAprvl_no() %>'">반려</button></td>
			</tr>
			
			<% }%>
			
		</table>		
		
		
		</form>
		
			<div style="text-align : center;padding:50px 50px; width:400px;  margin: 0 auto;">
			<jsp:include page="/views/common/paging_appdo.jsp" />
			</div>
		</main>

	</div>
		<jsp:include page="/views/common/footerKKH.jsp"></jsp:include>
