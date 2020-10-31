package controller.appr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/views/appovalViews/loginForm.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("로그인요청");
		String id = req.getParameter("userid");
		System.out.println("userid : " + id);

		String pw = req.getParameter("userpw");
		System.out.println("userpw : " + pw);
		// 세션 객체 얻기
		HttpSession session = req.getSession();

		String url = null; // 포워드될 VIEW
		if (id.equals("abc") && pw.equals("123")) {

			// 로그인 성공
			url = "/views/appovalViews/loginSuccess.jsp";

			// 로그인 상태 정보 저장 - Session Scope
			session.setAttribute("login", true); // 로그인 상태, login==true
			session.setAttribute("loginid", id); // 로그인 아이디

		} else {
			// 로그인 실패
			url = "/views/appovalViews/loginFail.jsp";
//		session.setAttribute("login", false);
//		session.setAttribute("loginid", "");

		}
		req.getRequestDispatcher(url).forward(req, resp);
	}
}
