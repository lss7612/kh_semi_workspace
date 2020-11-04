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
                postArrayCondition(isASC, arrayCondition);
              } else {
                var isASC = 'DESC';
                var arrayCondition = 'userid';
                postArrayCondition(isASC, arrayCondition);
              }
            });
            $("button[name='username']").click(function () {
              console.log('clicked');
              $(this).toggleClass('ASC');
              if ($(this).hasClass('ASC')) {
                var isASC = 'ASC';
                var arrayCondition = 'username';
                postArrayCondition(isASC, arrayCondition);
              } else {
                var isASC = 'DESC';
                var arrayCondition = 'username';
                postArrayCondition(isASC, arrayCondition);
              }
            });
            $("button[name='dept']").click(function () {
              console.log('clicked');
              $(this).toggleClass('ASC');
              if ($(this).hasClass('ASC')) {
                var isASC = 'ASC';
                var arrayCondition = 'dept';
                postArrayCondition(isASC, arrayCondition);
              } else {
                var isASC = 'DESC';
                var arrayCondition = 'dept';
                postArrayCondition(isASC, arrayCondition);
              }
            });
            $("button[name='position']").click(function () {
              console.log('clicked');
              $(this).toggleClass('ASC');
              if ($(this).hasClass('ASC')) {
                var isASC = 'ASC';
                var arrayCondition = 'position';
                postArrayCondition(isASC, arrayCondition);
              } else {
                var isASC = 'DESC';
                var arrayCondition = 'position';
                postArrayCondition(isASC, arrayCondition);
              }
            });
          };

          function postArrayCondition(isASC, arrayCondition) {
            var params = 'arrayCondition=' + arrayCondition + '&isASC=' + isASC;
            sendRequest('POST', '/address/view/array', params, getArrayCondition);
          }
          
          function getArrayCondition() {
            if (httpRequest.readyState == 4) {
              if (httpRequest.status == 200) {
                console.log('정상응답');
                list.innerHTML = httpRequest.reponseText
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
        <content>
          <article>
            <div id="search">
              <form action="/address/search" method="GET">
                <select>
                  <option value="all" selected="selected">전체</option>
                  <option value="userid">아이디</option>
                  <option value="username">이름</option>
                  <option value="dept">부서</option>
                  <option value="position">직급</option>
                  <option value="cellphone">전화번호</option>
                </select>
                <input type="text" name="keyword"><button name:="search">검색</button>
              </form>
            </div>
            <hr>
            <div id="list">
              <table>
                <thead>
                  <tr>
                    <th></th>
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
            </div>
           <jsp:include page="/views/addrViews/paging.jsp" />
          </article>
        </content>
      </body>
    </html> </AddrView
></AddrView>
