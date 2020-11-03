package bbs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Bbs;
import service.BoardService;
import service.BoardServiceImpl;

@WebServlet("/board")
public class BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String param = req.getParameter("ano");
		
//		System.out.println("/board param - " + param);
		
		int article_no = 0;
		if(param!=null && !"".equals(param)) {
			article_no = Integer.parseInt(param);
		}

		
		Bbs bbs = new Bbs();
		bbs.setArticle_no(article_no);
		
		Bbs res = boardService.detail(bbs);
		
		System.out.println("/board - " + res);
		
		req.setAttribute("result", res);
		
		
		req.getRequestDispatcher("view.jsp").forward(req, resp);
		
	}

}
