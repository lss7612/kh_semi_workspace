package controller.mbs;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.face.mbs.LoginDao;

/**
 * Servlet implementation class LoginControllers
 */
@WebServlet("/Login/login")
public class LoginControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	private LoginService loginService = new LoginServiceImpl(); 

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/login/login.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		
		
		
		  // 사용자가 요청한 URL
	    String url = req.getRequestURL().toString();
	    System.out.println(url+"아이이이이잉이");
	    
	    // getRequestURL StringBuffer 로 되어있어서 toString으로 변환해 주어야 한다.
	    // 스트링.indexOf("검색어") 검색어를 찾은 위치값, 없으면 -1 리턴
	    if(url.indexOf("/Login/login") != -1) {
	    
	      // 폼에서 입력한 값
	      String user_id = req.getParameter("user_id");
	      String user_pw = req.getParameter("user_pw");
	      System.out.println(user_id + "," + user_pw);
				
	      LoginDao dao = new LoginDao();
	      String user_name = dao.loginCheck(user_id, user_pw);
	      System.out.println("이름 : " + user_name);
				
	      // 로그인 여부
	      String message = new String();
	      String page = new String();
				
	      if(user_name != null) {
		message = user_name + "님 환영합니다.";
		page = "/views/members/myInfo.jsp";
					
		// session 객체 인스턴스
		HttpSession session = req.getSession();
		session.setAttribute("user_id", user_id);
	        session.setAttribute("message", message);
	      } else {
		message = "아이디 또는 비밀번호가 일치하지 않습니다.";

		// 로그인 페이지로 돌아감
	        page = "/views/login/loginFail.jsp?message="+URLEncoder.encode(message, "utf-8");
	      }
				
		resp.sendRedirect(req.getContextPath() + page);
				
	      } else if (url.indexOf("logout.do") != -1) {
		// session 객체 만들기
		HttpSession session = req.getSession();
				
		// session을 초기화
		session.invalidate();
				
		//로그인 페이지로 되돌아감
		String message = "로그아웃되었습니다.";
		resp.sendRedirect(req.getContextPath() + "/views/login/login.jsp?message="+URLEncoder.encode(message, "utf-8"));
	      } 
		
			
			
//		//로그인 아이디 받아와서 저장하기
//		Login param = loginService.getClass;
//		System.out.println("user_id 화긴" + user_id);
//		System.out.println("user_ow 화긴" + user_pw);
//		
//		
//					//세션 객체 얻기
//					HttpSession session = req.getSession();
//					
//					String url = null; //포워드될 jsp?
//		
//		
//					Login id = Login.(user_id);
//					
//					//dto == null일 경우 아이디x
//					if(dto == null||!dto.getUser_pw().equals(user_pw)) {
//							
//						url="/views/members/myInfo.jsp";
//						
//						session.setAttribute("login", true);//로그인 상태 login==true
//						session.setAttribute("loginid", user_id);//로그인 아이디
//						
//					}else {
//						//실패했을때
//						url="views/login/loginFail.jsp";
//					}
//					
//					req.getRequestDispatcher(url).forward(req, resp);
//					
							
	      }
			

}
