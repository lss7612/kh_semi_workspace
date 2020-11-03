package bbs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Bbs;


@WebServlet("/board/modify")
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String article_no = req.getParameter("article_no");
		BbsDAO bbsDao = BbsDAO.getInstance();
		Bbs bbs = new Bbs();
		
		
	}
		
		
	

}
