<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
			<td><input type="text" name=aprvl_type id="aprvl_type" readonly="readonly" /></td>
		
		</tr>
		
		<tr>
			<th>���� �����</th>
			<td><input type="text" name="create_date" id="create_date" readonly="readonly" /></td>
			<th>������
			<td><input type="text" name="final_date" id="final_date" readonly="readonly" /></td>
		</tr>
		<tr>
			<th>�����ȣ</th>
			<td><input type="number" name="aprvl_no" id="aprvl_no"
								readonly="readonly" />
			</td>
		</tr>
		<tr>
			<th>�����</th>
			<td><input type="text" name="user" id="user" readonly="readonly" />
			<th>1��������</th>
			<td><input type="text" name="mid_auth" id="mid_auth" readonly="readonly" />
			<th>2��������</th>
			<td><input type="text" name="final_auth" id="final_auth" readonly="readonly" />
		</tr>
		<tr>
			<th>���۳�¥</th><td>��</td>
			<th>����¥</th><td>����</td>
			
		</tr>
		<tr>
			<th>����</th>
			<td><input type="text" name="aprvl_title" id="aprvl_title" readonly="readonly" /></td>
		</tr>
		<tr>
			<th>����</th>
			<td><textarea style="border-collapse: collapse;" rows="20" cols="50" name="aprvl_article" id="aprvl_article" readonly="readonly" ></textarea></td>
		</tr>
		<tr>
			<th>÷������</th>
			<td>���</td>
		</tr>
	</table>
	<button>�ݱ�</button>

</form>
</body>
</html>