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

@WebServlet("/nowrite")
public class NoBoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		SessionDTO user_info = (SessionDTO) session.getAttribute("userinfo");
		String user_id = (String)req.getAttribute("userid");
		
		System.out.println("요청 성공쓰");
		
		req.getRequestDispatcher("write.jsp").forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post 요청 성공쓰");
		
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		SessionDTO user_info = (SessionDTO)session.getAttribute("userinfo");
		
		//세션에서 회원정보 갖고오기
		int user_no = user_info.getUser_no();
		
		System.out.println(user_no);
		
		//-------------------------------------
		
		String article_title = req.getParameter("article_title");
		String article_content = req.getParameter("article_content");
		
		System.out.println("테스트함만 : " + article_title);
		System.out.println("짱나.... : " + article_content);
		
		
		
		boardService.noWrite(user_no, article_title, article_content);
		
		
		resp.sendRedirect("/list");
		
		
		
	}
	

}
