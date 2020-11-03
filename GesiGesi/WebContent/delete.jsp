<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bbs.BbsDAO"%>
<%@ page import="dto.Bbs"%>
<%@ page import="java.io.PrintWriter"%>
<%
    request.setCharacterEncoding("UTF-8");
    //response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp 게시판 웹사이트</title>
</head>
<body>
  <%
        String user_id = null;
        if (session.getAttribute("user_id") != null) {//유저아이디이름으로 세션이 존재하는 회원들은 
        	user_id = (String) session.getAttribute("user_id");//유저아이디에 해당 세션값을 넣어준다.
        }
        
        if (user_id == null) {
            PrintWriter script = response.getWriter();
            script.println("<script>");
            script.println("alert('로그인을 하세요.')");
            script.println("location.href = 'login.jsp'");
            script.println("</script>");
        } 
        
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
//         Bbs bbs = new BbsDAO().selectByNo(conn, bbs);
//         if(!user_no.equals(bbs.getUser_no())) {
//             PrintWriter script = response.getWriter();
//             script.println("<script>");
//             script.println("alert('권한이 없습니다')");
//             script.println("location.href='bbs.jsp'");
//             script.println("</script>");            
//         }
//         else{
            BbsDAO bbsDAO = new BbsDAO();
            int result = bbsDAO.deleteBoard(article_no);
            if (result == -1) {
                PrintWriter script = response.getWriter();
                script.println("<script>");
                script.println("alert('글 삭제에 실패했습니다')");
                script.println("history.back()");
                script.println("</script>");
            } else {
                PrintWriter script = response.getWriter();
                script.println("<script>");
                script.println("location.href='bbs.jsp'");
                script.println("</script>");
            }
//         }
    %>
</body>
</html>