<%@page import="dto.note.NoteReceiverView"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<NoteReceiverView> manUser = (List<NoteReceiverView>) request.getAttribute("manUser");
%>
<%
	List<NoteReceiverView> accUser = (List<NoteReceiverView>) request.getAttribute("accUser");
%>
<%
	List<NoteReceiverView> hrUser = (List<NoteReceiverView>) request.getAttribute("hrUser");
%>
<%
	List<NoteReceiverView> devUser = (List<NoteReceiverView>) request.getAttribute("devUser");
%>
<%
	List<NoteReceiverView> salesUser = (List<NoteReceiverView>) request.getAttribute("salesUser");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>

<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="/views/noteViews/resource/send.js"></script>

<link rel="stylesheet" href="/views/noteViews/resource/send.css"></link>
</head>
<body>
	<h1>쪽지 보내기</h1>
	<hr />

	<div class="whole_wrapper">
	<form action="/note/send" method="POST">
		<table>
			<tbody>
				<tr>
					<td><label for="title">제목</label></td>
					<td><input type="text" name="title" id="title" /></td>
				</tr>
				<tr>
					<td>받는사람</td>
					<td id="receiver"></td>
					<td></td>
				</tr>
				<tr>
					<td>받는사람추가</td>
					<td id="select"><select name="dept" id="dept">
							<option value="select">부서선택</option>
							<option id="acc" value="acc">회계</option>
							<option id="man" value="man">경영</option>
							<option id="hr" value="hr">인사</option>
							<option id="dev" value="dev">개발</option>
							<option id="sal" value="sal">영업</option>
							<option id="addr" value="addr">내주소록</option>
					</select> 
					<select name="man" id="selectMan" class="none selectPerson">
					
							<%
								for (int i = 0; i < manUser.size(); i++) {
							%>
							<option value="<%=manUser.get(i).getUser_no()%>">
								<%="사번(" + manUser.get(i).getUser_no() + ")" + " / " + manUser.get(i).getUser_name()%>
							</option>
							<%
								}
							%>
					</select> 
					<select name="acc" id="selectAcc" class="none selectPerson">
							<%
								for (int i = 0; i < accUser.size(); i++) {
							%>
							<option value="<%=accUser.get(i).getUser_no()%>">
								<%="사번(" + accUser.get(i).getUser_no() + ")" + " / " + accUser.get(i).getUser_name()%>
							</option>
							<%
								}
							%>
					</select> 
					<select name="hr" id="selectHr" class="none selectPerson">
							<%
								for (int i = 0; i < hrUser.size() - 1; i++) {
							%>
							<option value="<%=hrUser.get(i).getUser_no()%>">
								<%="사번(" + hrUser.get(i).getUser_no() + ")" + " / " + hrUser.get(i).getUser_name()%>
							</option>
							<%
								}
							%>
					</select> 
					<select name="dev" id="selectDev" class="none selectPerson">
							<%
								for (int i = 0; i < devUser.size(); i++) {
							%>
							<option value="<%=devUser.get(i).getUser_no()%>">
								<%="사번(" + devUser.get(i).getUser_no() + ")" + " / " + devUser.get(i).getUser_name()%>
							</option>
							<%
								}
							%>
					</select> 
					<select name="sal" id="selectSal" class="none selectPerson">
							<%
								for (int i = 0; i < salesUser.size(); i++) {
							%>
							<option value="<%=salesUser.get(i).getUser_no()%>">
								<%="사번(" + salesUser.get(i).getUser_no() + ")" + " / " + salesUser.get(i).getUser_name()%>
							</option>
							<%
								}
							%>
					</select> 
					<select name="addr" id="selectDevAddr" class="none selectPerson">
							<option value=""></option>
					</select>
					<span id="add">추가</span>
					</td>
				</tr>

				<tr>
					<td><label for="article">쪽지내용</label></td>
					<td><textarea name="article" id="article" cols="30" rows="10"></textarea>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="보내기" /></td>
				</tr>
			</tbody>
		</table>
	</form>
	</div>
	<jsp:include page="/views/noteViews/buttons.jsp" />
</body>
</html>
