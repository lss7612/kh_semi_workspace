<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page errorPage ="/views/common/errorpage.jsp" %>

   	<%-- 캐시방지 --%>
	<%        
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate, private");
    response.setDateHeader("Expires", -1);
%>
  


<% 
	String user_id=(String)session.getAttribute("user_id");
	if(user_id == null) {
%>
	<script>
		alert("로그인한 사용자만 사용가능함미다");
		location.href="/Login/adLogin";
	</script>
<% 
	}
%>

