<%@page import="dto.SessionDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bbs.BbsDAO"%>
<%@ page import="dto.Bbs"%>
<%@ page import="java.io.PrintWriter"%>
<% SessionDTO user_info = (SessionDTO) session.getAttribute("userinfo");  %>
<% String user_id = (String)request.getAttribute("userid"); %>
<%
    request.setCharacterEncoding("UTF-8");
    //response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WorkJob</title>
</head>
<body>
  <%
  
  System.out.println("넘어왔습니까 휴먼?");
      
        int article_no = 0;
        if(request.getParameter("article_no") != null){
        	article_no = Integer.parseInt(request.getParameter("article_no"));
        }
        if(article_no == 0) {
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('유효하지 않은 글 입니다')");
            script.println("location.href='bbs.jsp'");
            script.println("</script>");
        }
//         Bbs bbs = new BbsDAO().getBbs(article_no);
//         if(!user_id.equals(bbs.getUser_id())) {
//             PrintWriter script = response.getWriter();
//             script.println("<script>");
//             script.println("alert('권한이 없습니다')");
//             script.println("location.href='bbs.jsp'");
//             script.println("</script>");            
//         }
//         else{
            BbsDAO bbsDAO = new BbsDAO();
            int result = bbsDAO.deleteNo(article_no);
            if (result == -1) {
                PrintWriter script = response.getWriter();
                script.println("<script>");
                script.println("alert('글 삭제에 실패했습니다')");
                script.println("history.back()");
                script.println("</script>");
            } else {
                PrintWriter script = response.getWriter();
                script.println("<script>");
                script.println("location.href='/list'");
                script.println("</script>");
            }
        
    %>
</body>
</html>