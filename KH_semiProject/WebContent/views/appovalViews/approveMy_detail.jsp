<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="dto.appr.Appr"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File" %>
<%	List<Appr> list = (List<Appr>) request.getAttribute("list"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="/approval/myDetail" method="post">


	<h3>상세페이지</h3>
	<table>
		<tr><th>결재계 : </th>
			<td><input type="text" name=aprvl_type id="aprvl_type" readonly="readonly" value="<%=list.get(0).getAprvl_type() %>" /></td>
		
		</tr>
		
		<tr>
			<th>결재 상신일</th>
			<td><input type="text" name="create_date" id="create_date" readonly="readonly" value="<%=list.get(0).getCreate_date() %>"/></td>
			<th>결재일
			<td><input type="text" name="final_date" id="final_date" readonly="readonly" value="<%=list.get(0).getFinal_date() %>" /></td>
		</tr>
		<tr>
			<th>결재번호</th>
			<td><input type="number" name="aprvl_no" id="aprvl_no"
								readonly="readonly" value="<%=list.get(0).getApprl_no() %>" />
			</td>
		</tr>
		<tr>
			<th>상신자</th>
			<td><input type="text" name="user" id="user" readonly="readonly" value="<%=list.get(0).getUser_name() %>"/>
			<th>1차결재자</th>
			<td><input type="text" name="mid_auth" id="mid_auth" readonly="readonly" value="<%=list.get(0).getMid_auth_name() %>" />
			<th>2차결재자</th>
			<td><input type="text" name="final_auth" id="final_auth" readonly="readonly" value="<%=list.get(0).getFinal_auth_name() %>"/>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="aprvl_title" id="aprvl_title" readonly="readonly" value="<%=list.get(0).getAprvl_title() %>" /></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea style="border-collapse: collapse;" rows="20" cols="50" name="aprvl_article" id="aprvl_article" readonly="readonly" placeholder="<%=list.get(0).getAprvl_article() %>" ></textarea></td>
		</tr>
		<tr>
		
			<th>첨부파일<a class="btn" href="/upload/<%=list.get(0).getFile_name() %>" download><%=list.get(0).getFile_origin_name() %> </a></th>
			<td>띠용</td>
		</tr>
	</table>
	<button>닫기</button>

</form>
</body>
</html>