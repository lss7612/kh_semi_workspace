<%@page import="dto.addr.AddrView"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<% List<AddrView> list = (List<AddrView>) request.getAttribute("list"); %>




<table>
  <% for (int i = 0; i < list.size(); i++) { %>
  <tbody>
    <tr>
      <td><input type="checkbox" name="" id=""></td>
      <td><%=list.get(i).getUser_id()%></td>
      <td><%=list.get(i).getUser_name() %></td>
      <td><%=list.get(i).getDept_name() %></td>
      <td><%=list.get(i).getPosition_name() %></td>
      <td><%=list.get(i).getCellphone_no() %></td>
    </tr>
    <% } %>
  </tbody>
</table>

<jsp:include page="/views/addrViews/paging.jsp" />