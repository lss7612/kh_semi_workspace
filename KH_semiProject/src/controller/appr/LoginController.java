package controller.appr;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.JDBCTemplate;
import dao.face.appr.LoginDao;
import dao.impl.appr.LoginDaoImpl;
import dto.appr.Login;

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
		String user_id =null; //id 담아둘 변수
		String user_pw =null; //pw 담아둘 변수
		int loginCheck=0;
		//로그인
		LoginDao loginDao = new LoginDaoImpl();
		List<Login> list = loginDao.selectList(JDBCTemplate.getConnection());
//		System.out.println("전달받은 list"+ list);
		
		System.out.println(list);
		 for(int i = 0; i<list.size(); i++) {
			 user_id=list.get(i).getUser_id();
			 user_pw=list.get(i).getUser_pw();
			 if (id.equals(user_id) && pw.equals(user_pw)) {
				 loginCheck=1;
				 
			 }
			 
		 }
		
		
		
		
		if (loginCheck==1) {

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
