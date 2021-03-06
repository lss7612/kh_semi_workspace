<%@page import="java.util.ArrayList"%> <%@page import="dto.addr.AddrView"%> <%@page
import="dto.addr.AddrParam"%> <%@page import="java.util.List"%> <%@ page language="java"
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% List<AddrView>
  list = (List<AddrView
    >) request.getAttribute("list"); %>
    <jsp:include page="/views/common/headerKKH.jsp"></jsp:include>

        <title>주소록</title>

        <script type="text/javascript" src="/resources/js/httpRequest.js"></script>
        <script type="text/javascript" src="/views/addrViews/resource/view.js"></script>
        <script type="text/javascript" src="/views/noteViews/resource/selectAll.js"></script>

        <link rel="stylesheet" href="/views/addrViews/resource/view.css"></link>
 

<div class="content-wrapper">
        <h1>주소록</h1>
        <hr />
          <article>
            <div id="search">
              <form action="/address/search" method="GET">
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
              <form id="sendNote" action="/note/send" method="GET">
            <table>
              <thead>
                <tr>
                  <th><input type="checkbox" class="selectAllCheckbox"/></th>
                  <th><span>사번</span></th>
                  <th><span name="dept" class="ASC">부서</span></th>
                  <th><span name="position" class="ASC">직급</span></th>
                  <th><span name="username" class="content_title ASC">이름</span></th>
                  <th><span name="userid" class="ASC">아이디</span></th>
                  <th>휴대전화</th>
                </tr>
              </thead>
                <tbody>
                <% for (int i = 0; i < list.size(); i++) { %>
                  <tr class="">
                    <td><input type="checkbox" name="receiver_no<%=i%>" value="<%=list.get(i).getUser_no()%>"></td>
                    <td class="user_no"><%=list.get(i).getUser_no()%></td>
                    <td class="dept_name"><%=list.get(i).getDept_name() %></td>
                    <td class="position_name"><%=list.get(i).getPosition_name() %></td>
                    <td class="user_name">
                    	<span class="users"><%=list.get(i).getUser_name() %></span>
                    </td>
                    <td class="user_id"><%=list.get(i).getUser_id()%></td>
                    <td class="cellphone_no"><%=list.get(i).getCellphone_no() %></td>
                    <td><span class="chat">채팅하기</span></td>
                  </tr>
                  <% } %>
                </tbody>
              </table>
              </form>
            </div>
            <hr>
       		<button class="sendNote">쪽지보내기</button>
          </article>
           <jsp:include page="/views/addrViews/paging.jsp" />
  </div>

<jsp:include page="/views/common/footerKKH.jsp"></jsp:include>
