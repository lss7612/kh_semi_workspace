package bbs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dto.SessionDTO;
import service.Session;
import service.Sesssssssssssssion;

@WebServlet("/main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Session sessionnnnnn = new Sesssssssssssssion();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("main get 요청");

		HttpSession session = req.getSession(); //세션 객체 생성
		
//		session.setAttribute("session", "user_id");
		
		req.getParameter("user_id"); 
		
		String user_id = req.getParameter("user_id"); 
		
//		System.out.println(session.getAttribute("session"));
		System.out.println("아이디는 : " + user_id);
		
		//-----------------------------------------------------
		
		UserDao userDAO = new UserDao();
		
		int result = userDAO.login(user_id);
		
		
		System.out.println(result);

		
		SessionDTO sessionDto = new SessionDTO();
		
		sessionDto = sessionnnnnn.getUserNo(user_id);
		
		System.out.println(sessionDto);
		
		session.setAttribute("userinfo", sessionDto);
		
		req.setAttribute("userid", user_id);
		
		req.getRequestDispatcher("main.jsp")
			.forward(req, resp);
		
	}

}
