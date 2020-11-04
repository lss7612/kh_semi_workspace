package bbs;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Bbs;
import dto.SessionDTO;


@WebServlet("/nomodify")
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Connection conn = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String user_id = (String)req.getAttribute("userid");
		SessionDTO user_info = (SessionDTO) session.getAttribute("userinfo");
		
		//-----------------------------------------------------------------
		
		String ar_no = req.getParameter("article_no");
		int article_no = Integer.parseInt(ar_no);
//		System.out.println("개빡치는 글넘버 : " + article_no);
		System.out.println("------------------------" + ar_no);

		
//		int article_no = req.getParameter("article_no");
		BbsDAO bbsDao = BbsDAO.getInstance();
		Bbs bbs = new Bbs();
		bbs = bbsDao.selectByNo(article_no);
		
		System.out.println("비비ㅣ에스" + bbs);
//		
//		bbs = bbsDao.getBbs(Integer.parseInt(article_no));
		

		req.setAttribute("noupdate", bbs);
//		System.out.println("비비에스 나와라 얍 : " + bbs);
		req.getRequestDispatcher("/update.jsp").forward(req, resp);

	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		SessionDTO user_info = (SessionDTO)session.getAttribute("userinfo");
		
		//세션에서 회원정보 갖고오기
		int user_no = user_info.getUser_no();
		
		//------------------------------------------------------------
		
		String article_no = req.getParameter("article_no");
//		System.out.println(article_no);
		String article_title = req.getParameter("article_title");
//		System.out.println(article_title);
		String article_content = req.getParameter("article_content");
//		System.out.println(article_content);
		
		BbsDAO bbsDao = BbsDAO.getInstance();
		Bbs bbs = new Bbs();
		bbsDao.update(article_no, article_content, article_title);
		
		System.out.println("잘 받아왔나요? : " + bbs); //아니염.....
		
		bbs.setArticle_no(Integer.parseInt(article_no));
		bbs.setArticle_title(article_title);
		bbs.setArticle_content(article_content);
		
		resp.sendRedirect("/list");
		
		
		
	}
		
		
}
