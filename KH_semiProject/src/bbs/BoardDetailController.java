package bbs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Bbs;
import dto.SessionDTO;
import service.BoardService;
import service.BoardServiceImpl;

@WebServlet("/board")
public class BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String user_id = (String)req.getAttribute("userid");
		SessionDTO user_info = (SessionDTO) session.getAttribute("userinfo");
		System.out.println("여기는 board view의 : " + session.getAttribute("userinfo"));
		
		String param = req.getParameter("ano");
		
		System.out.println("/board param - " + param);
		
		int article_no = 0;
		if(param!=null && !"".equals(param)) {
			article_no = Integer.parseInt(param);
		}
		
		
		Bbs bbs = new Bbs();
		bbs.setArticle_no(article_no);
		
		Bbs res = boardService.detail(bbs);
		
//		System.out.println("/board - " + res);
		
		System.out.println("시밤.... 글번호 : " + bbs.getArticle_no());
		
		req.setAttribute("result", res);
		
//		System.out.println("쉬부루러ㅓㅓ러ㅓ럴ㄹ" + res);
		
		req.getRequestDispatcher("view.jsp").forward(req, resp);
		
	}

}
