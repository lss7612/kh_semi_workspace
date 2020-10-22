<%@page import="dto.addr.AddrView"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<AddrView> list = (List<AddrView>) request.getAttribute("list"); %>
         <table>
            <tr>
              <th><button name="isASC" class="ASC" onclick="isASC()">아이디</button></th>
              <th><button name="isASC" class="" onclick="isASC()">이름</button></th>
              <th><button name="isASC" class="" onclick="isASC()">부서</button></th>
              <th><button name="isASC" class="" onclick="isASC()">직급</button></th>
              <th>휴대전화</th>
            </tr>
            <% for (int i = 0; i < list.size(); i++) { %>
            <tr>
              <td><%=list.get(i).getUser_id()%></td>
              <td><%=list.get(i).getUser_name() %></td>
              <td><%=list.get(i).getDept_name() %></td>
              <td><%=list.get(i).getPosition_name() %></td>
              <td><%=list.get(i).getCellphone_no() %></td>
            </tr>
            <% } %>
          </table>

          <jsp:include page="/views/common/paging.jsp" />