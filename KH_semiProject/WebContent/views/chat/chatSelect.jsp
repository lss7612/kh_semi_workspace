<%@page import="dto.addr.AddrView"%>
<%@page import="dto.common.UserInfo"%>
<%@page import="java.util.List"%>
<%@page import="dto.chat.ChatUserList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page errorPage ="./errorPage.jsp" %>
    <%
    	UserInfo usreinfo = (UserInfo) session.getAttribute("userinfo");
    %>
    <% List<AddrView>list = (List<AddrView>) request.getAttribute("list"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대화 상대 선택하기</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<style type="text/css">
</style>
<script type="text/javascript">

</script>
</head>
<body>
<div class="content-wrapper">
        <h1>주소록</h1>
        <hr />
          <article>
            <div id="search">
              <form action="/chat/search" method="GET">
                <input type="text" class="keyword"name="keyword"><button class="search">검색</button>
                <select class="classification" name="classification">
                	<option value="userid">아이디</option>
                  <option value="username" selected="selected">이름</option>
                  <option value="dept">부서</option>
                  <option value="position">직급</option>
                  <option value="cellphone">전화번호</option>
                </select>
              </form>
            </div>
            <hr>
              <div id="list">
              <form name="select" action="/chat/room" method="get" 
								onsubmit="return check()">
            <table>
              <thead>
                <tr>
                  <th><input type="checkbox" class="selectAllCheckbox"/></th>
                  <th><span>사번</span></th>
                  <th><span name="dept" class="ASC">부서</span></th>
                  <th><span name="position" class="ASC">직급</span></th>
                  <th><span name="username" class="content_title ASC">이름</span></th>
                  <th>휴대전화</th>
                </tr>
              </thead>
                <tbody>
                <% for (int i = 0; i < list.size(); i++) { %>
                  <tr class="">
                    <td><input type="checkbox" name="selectUserNo" value="<%=list.get(i).getUser_no()%>"></td>
                    <td class="user_no"><%=list.get(i).getUser_no()%></td>
                    <td class="dept_name"><%=list.get(i).getDept_name() %></td>
                    <td class="position_name"><%=list.get(i).getPosition_name() %></td>
                    <td class="user_name">
                    	<span class="users"><%=list.get(i).getUser_name() %></span>
                    </td>
                    <td class="cellphone_no"><%=list.get(i).getCellphone_no() %></td>
                    <td><input type="submit" id="ok" value="채팅하기"></td>
                  </tr>
                  <% } %>
                </tbody>
              </table>
              </form>
            </div>
            <hr>
          </article>
  </div>
<br>
<jsp:include page="./chatPaging.jsp" />
<br><br><br>
<button id="cancel" onClick="location.href='/chathome'" type="button">취소</button>
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