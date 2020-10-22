<%@page import="java.util.ArrayList"%> <%@page import="dto.addr.AddrView"%> <%@page
import="dto.addr.AddrParam"%> <%@page import="java.util.List"%> <%@ page language="java"
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% List<AddrView> list = (List<AddrView>) request.getAttribute("list"); %>
    <html>
      <head>
        <meta charset="UTF-8" />
        <title>주소록</title>
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
        <script type="text/javascript" src="/resources/js/httpRequest.js"></script>
        <script type="text/javascript">
          window.onload = function () {
            ajaxToServer();
          };
          function ajaxToServer() {
            sendRequest('POST', "/WEB-INF/views/addrViews/view_ok.jsp", "", ajaxFromServer);
          }
          function ajaxFromServer() {
            if (httpRequest.readyState == 4) {
              //응답 완료
              if (httpRequest.status == 200) {
                //정상 응답
                console.log('정상응답');

                console.log(httpRequest.responseText); //응답 데이터 확인

                //div#resu에 응답받은 내용을 채우기
                refresh.innerHTML = httpRequest.responseText;
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
        <div id="refresh"></div>
      </body>
    </html> 
