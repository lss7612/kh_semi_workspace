package controller.mbs;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/Login/adLogout")
public class AdLogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//객체얻기
		HttpSession session = req.getSession();
	
					
			// session을 초기화
			session.invalidate();
			
					
			//로그인 페이지로 되돌아감
			resp.sendRedirect(req.getContextPath() + "/views/login/adLoginCheck.jsp");
	
		 
			
			
		
		}
}
