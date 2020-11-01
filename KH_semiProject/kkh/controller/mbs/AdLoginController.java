package controller.mbs;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.face.mbs.AdLoginDao;

/**
 * Servlet implementation class adLoginControllers
 */
@WebServlet("/Login/adLogin")
public class AdLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/views/login/adLogin.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 전달데이터 한글 인코딩 설정(UTF-8)
		req.setCharacterEncoding("UTF-8");
		// 전달해주는고
		resp.setContentType("text/html; charset=utf-8");

		AdLoginDao dao = new AdLoginDao();

		// 사용자가 요청한 URL
		String adUrl = req.getRequestURL().toString();

		// getRequestURL StringBuffer 로 되어있어서 toString으로 변환해 주어야 한다.
		// 스트링.indexOf("검색어") 검색어를 찾은 위치값, 없으면 -1 리턴
		if (adUrl.indexOf("/Login/adLogin") != -1) {

			// 폼에서 입력한 값

			String user_id = req.getParameter("user_id");
			String user_pw = req.getParameter("user_pw");

			/* String grade_no = req.getParameter("grade_no"); */
			System.out.println("유저아이디 : " + user_id + "," + "유저 패스 : " + user_pw);

			int user_grade = dao.gradeCheck(user_id, user_pw);
			String user_name = dao.adLoginCheck(user_id, user_pw, 1);

			System.out.println("유저이름 : " + user_name + "\n" + "유저등급 : " + Integer.toString(user_grade));

			// 로그인 여부
			String message = new String();
			String page = new String();

//         
			if (user_name != null) {
				message = user_name + "(" + user_id + ")" + "님!";
				page = "/views/adminTb/gradeMem.jsp";

				// session 객체 인스턴스
				HttpSession session = req.getSession();
				session.setAttribute("user_id", user_id);
				session.setAttribute("message", message);

			} else {
				message = "아이디 또는 비밀번호가 일치하지 않습니다.";

				// 로그인 페이지로 돌아감
				page = "/Login/adLogin?message=" + URLEncoder.encode(message, "utf-8");

			}

			
			resp.sendRedirect(req.getContextPath() + page);

		}

	}

}