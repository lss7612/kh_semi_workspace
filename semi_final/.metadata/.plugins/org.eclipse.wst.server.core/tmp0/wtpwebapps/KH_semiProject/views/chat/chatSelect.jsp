<%@page import="dto.common.UserInfo"%>
<%@page import="java.util.List"%>
<%@page import="dto.chat.ChatUserList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page errorPage ="./errorPage.jsp" %>
    <%
    	List<ChatUserList> list = (List<ChatUserList>) request.getAttribute("userList");
    %>
    <%
    	UserInfo usreinfo = (UserInfo) session.getAttribute("userinfo");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대화 상대 선택하기</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<style type="text/css">
#chatUserList{
	border : 1px solid #ccc;
}
th,td{
	border : 3px solid #ccc;
}
</style>
<script type="text/javascript">

</script>
</head>
<body>
<h1>대화 상대 선택하기</h1>
<h3 style="color:red;">이것은 임시 페이지 입니다.</h3>
<h3> 본인은 목록에서 <span style="color:red;">제외</span>되어 나타납니다.</h3>
<hr>
<h3> 사 내 주 소 록</h3>
<form name="select" action="/chat/room" method="get" 
	onsubmit="return check()">
<table id="chatUserList" >
	<tr>
		<th>선택</th>
		<th>이름</th>
		<th>부서</th>
		<th>직급</th>
		<th>휴대번호</th>
		<th>내선번호</th>
	</tr>
	<% for( ChatUserList ulist : list) { %>
	<tr>
		<th><input name="selectUserNo" type="checkbox" value="<%=ulist.getUser_no() %>"/></th>
		<th><%=ulist.getUser_name() %></th>
		<th><%=ulist.getDept_name() %></th>
		<th><%=ulist.getPosition_name() %></th>
		<th><%=ulist.getCellphone_no() %></th>
		<% if(ulist.getExtension_no() == null) { %>
		<th> - </th>
		<% } else { %>
		<th><%=ulist.getExtension_no() %></th>
		<% } %>
	</tr>
	<% } %>
</table>
<br>
<jsp:include page="./chatPaging.jsp" />
<br><br><br>
<div id="buttonTray">
<input type="submit" id="ok" >
<button id="cancel" onClick="location.href='/chathome'" type="button">취소</button>
</div>
</form>

<script type="text/javascript">

	//***대화상대 선택은 현재 한명으로 제한한다. ***
	function check(){
		//체크박스이 체크된 수를 카운트한다.
		var checkCount = 
			$("input:checkbox[name=selectUserNo]:checked").length;
		//console.log(checkCount);
		
		//한명 선택되었을경우 진행
		if(checkCount == 1){
			//form 태그의 action 동작
			return true;
		} else {
			//한명선택 외에 선태할경우 중단
			alert('대화상대를 한 명 선택하세요!');
			//form 태그의 action 동작 금지
			return false;
		}
		
	}

</script>
</body>
</html>