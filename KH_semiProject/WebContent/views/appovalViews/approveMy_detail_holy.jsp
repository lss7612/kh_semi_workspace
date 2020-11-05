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


	<h3>��������</h3>
	<table>
		<tr><th>����� : </th>
			<td><input type="text" name=aprvl_type id="aprvl_type" readonly="readonly" value="<%=list.get(0).getAprvl_type() %>"/></td>
			
		</tr>
		<tr><th>�ް� ���� : </th>
			<td><input type="text" name=aprvl_type id="aprvl_type" readonly="readonly" value="<%=list.get(0).getAppr_holi_kind() %>"/></td>

		
		</tr>
		
		<tr>
			<th>���� �����</th>
			<td><input type="text" name="create_date" id="create_date"  readonly="readonly" value="<%=list.get(0).getCreate_date() %>"/></td>
			<th>������
			<td><input type="text" name="final_date" id="final_date" readonly="readonly" value="<%=list.get(0).getFinal_date() %>"/></td>
		</tr>
		<tr>
			<th>�����ȣ</th>
			<td><input type="number" name="aprvl_no" id="aprvl_no"
								readonly="readonly" value="<%=list.get(0).getApprl_no() %>"/>
			</td>
		</tr>
		<tr>
			<th>�����</th>
			<td><input type="text" name="user" id="user" readonly="readonly" value="<%=list.get(0).getUser_name() %>"/>
			<th>1��������</th>
			<td><input type="text" name="mid_auth" id="mid_auth" readonly="readonly" value="<%=list.get(0).getMid_auth_name() %>" />
			<th>2��������</th>
			<td><input type="text" name="final_auth" id="final_auth" readonly="readonly" value="<%=list.get(0).getFinal_auth_name() %>" />
		</tr>
		<tr>
			<th>���۳�¥</th><td><input type="text" name="final_auth" id="final_auth" readonly="readonly" value="<%=list.get(0).getHoliday_start() %>"/></td>
			<th>����¥</th><td><input type="text" name="final_auth" id="final_auth" readonly="readonly" value="<%=list.get(0).getHoliday_end() %>"/></td>
		</tr>
		<tr>
			<th>����</th>
			<td><input type="text" name="aprvl_title" id="aprvl_title" readonly="readonly" value="<%=list.get(0).getAprvl_title() %>"/></td>
		</tr>
		<tr>
			<th>����</th>
			<td><textarea style="border-collapse: collapse;" rows="20" cols="50" name="aprvl_article" id="aprvl_article" readonly="readonly"  ><%=list.get(0).getAprvl_article() %></textarea></td>
		</tr>
		<tr>
			<th>÷������<a class="btn" href="/upload/<%=list.get(0).getFile_name() %>" download><%=list.get(0).getFile_origin_name() %> </a></th>
		
		</tr>
	</table>
	<input type="button" value="â�ݱ�" onClick="window.close()">
</form>
</body>
</html>