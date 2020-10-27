package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/chathome")
public class ChatHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("\n> > >/chathome [GET] 접속< < <");
		
		//세션 정보 가져오기
		HttpSession session = req.getSession();
		
		//세션 정보 출력하기
		System.out.println("> > >userinfo 출력 < < <");
		System.out.println(session.getAttribute("userinfo"));
	

		req.getRequestDispatcher("/views/chat/chatHome.jsp").forward(req, resp);
	}
	

}
