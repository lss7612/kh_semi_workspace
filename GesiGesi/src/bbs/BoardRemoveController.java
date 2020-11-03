//package bbs;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import dto.Bbs;
//
//@WebServlet("/board/delete")
//public class BoardRemoveController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	private static final int article_no = 0;
//	
//	private BbsDAO bbsDao;
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		if(req.getParameter("article_no") == null) {
//			resp.sendRedirect(req.getContextPath() + "bbs.jsp");
//			Bbs bbs = new Bbs();
//			bbs.setArticle_no(article_no);
//			
//			
//		}
//		
//		
//	}
//
//}
