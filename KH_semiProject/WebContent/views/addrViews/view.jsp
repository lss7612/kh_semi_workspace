<%@page import="java.util.ArrayList"%> <%@page import="dto.addr.AddrView"%> <%@page
import="dto.addr.AddrParam"%> <%@page import="java.util.List"%> <%@ page language="java"
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% List<AddrView>
  list = (List<AddrView
    >) request.getAttribute("list"); %>
    <html>
      <head>
        <meta charset="UTF-8" />
        <title>주소록</title>
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
        <script type="text/javascript" src="/resources/js/httpRequest.js"></script>
        <script type="text/javascript">
          window.onload = function () {
            /* ajaxToServer(); */

            $("button[name='userid']").click(function () {
              console.log('clicked');
              $(this).toggleClass('ASC');
              if ($(this).hasClass('ASC')) {
                var isASC = 'ASC';
                var arrayCondition = 'userid';
                ajaxToServer(isASC, arrayCondition);
              } else {
                var isASC = 'DESC';
                var arrayCondition = 'userid';
                ajaxToServer(isASC, arrayCondition);
              }
            });
            $("button[name='username']").click(function () {
              console.log('clicked');
              $(this).toggleClass('ASC');
              if ($(this).hasClass('ASC')) {
                var isASC = 'ASC';
                var arrayCondition = 'username';
                ajaxToServer(isASC, arrayCondition);
              } else {
                var isASC = 'DESC';
                var arrayCondition = 'username';
                ajaxToServer(isASC, arrayCondition);
              }
            });
            $("button[name='dept']").click(function () {
              console.log('clicked');
              $(this).toggleClass('ASC');
              if ($(this).hasClass('ASC')) {
                var isASC = 'ASC';
                var arrayCondition = 'dept';
                ajaxToServer(isASC, arrayCondition);
              } else {
                var isASC = 'DESC';
                var arrayCondition = 'dept';
                ajaxToServer(isASC, arrayCondition);
              }
            });
            $("button[name='position']").click(function () {
              console.log('clicked');
              $(this).toggleClass('ASC');
              if ($(this).hasClass('ASC')) {
                var isASC = 'ASC';
                var arrayCondition = 'position';
                ajaxToServer(isASC, arrayCondition);
              } else {
                var isASC = 'DESC';
                var arrayCondition = 'position';
                ajaxToServer(isASC, arrayCondition);
              }
            });
          };

          function ajaxToServer(isASC, arrayCondition) {
            var params = 'arrayCondition=' + arrayCondition + '&isASC=' + isASC;
            sendRequest('POST', '/address/view', params, ajaxFromServer);
          }
          function ajaxFromServer() {
            if (httpRequest.readyState == 4) {
              if (httpRequest.status == 200) {
                console.log('정상응답');
              } else {
                console.log('AJAX요청/응답 에러');
              }
            }
          }
        </script>

        <style type="text/css">
          table,
          th,
          td {
            border: 1px solid #ccc;
          }
        </style>
      </head>
      <body>
        <h1>주소록</h1>
        <hr />
        <div id="refresh">
          <table>
            <thead>
              <tr>
                <th><button name="userid" class="ASC">아이디</button></th>
                <th><button name="username" class="ASC">이름</button></th>
                <th><button name="dept" class="ASC">부서</button></th>
                <th><button name="position" class="ASC">직급</button></th>
                <th>휴대전화</th>
              </tr>
            </thead>
            <% for (int i = 0; i < list.size(); i++) { %>
            <tbody>
              <tr>
                <td><%=list.get(i).getUser_id()%></td>
                <td><%=list.get(i).getUser_name() %></td>
                <td><%=list.get(i).getDept_name() %></td>
                <td><%=list.get(i).getPosition_name() %></td>
                <td><%=list.get(i).getCellphone_no() %></td>
              </tr>
              <% } %>
            </tbody>
          </table>
        </div>
        <jsp:include page="/views/common/paging.jsp" />
      </body>
    </html> </AddrView
></AddrView>
