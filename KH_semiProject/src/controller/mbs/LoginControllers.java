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
import dto.common.UserInfo;
import service.face.chat.UserChatService;
import service.impl.chat.UserChatServiceImpl;

/**
 * Servlet implementation class LoginControllers
 */
@WebServlet("/Login/login")
public class LoginControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private UserChatService userChatService = new UserChatServiceImpl();


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/views/login/login.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 전달데이터 한글 인코딩 설정(UTF-8)
		req.setCharacterEncoding("UTF-8");
		// 전달해주는고
		resp.setContentType("text/html; charset=utf-8");


		//세션 정보 가져오기
		HttpSession session = req.getSession();
		
		//클라이언트 ip확인하기
		String userIp = getRemoteAddr(req);
		System.out.println(userIp);
		
		//채팅 유저 정보 객체 생성
		UserInfo user = null;
		
		//유저 정보 가져오기(전달받은 id를 이용하여)
		user = userChatService.infoById(req.getParameter("user_id"), userIp);
		
		//세션에 유저 정보 저장
		session.setAttribute("userinfo", user);
		session.setAttribute("userIp", userIp);
		//저장된 세션정보 확인
		System.out.println("session info : "+session.getAttribute("userinfo"));
		
		
		LoginDao dao = new LoginDao();

		// 사용자가 요청한 URL
		String url = req.getRequestURL().toString();

//		// getRequestURL StringBuffer 로 되어있어서 toString으로 변환해 주어야 한다.
		// 스트링.indexOf("검색어") 검색어를 찾은 위치값, 없으면 -1 리턴
		if (url.indexOf("/Login/login") != -1) {

			// 폼에서 입력한 값

			String user_id = req.getParameter("user_id");
			String user_pw = req.getParameter("user_pw");

			/* String grade_no = req.getParameter("grade_no"); */
			System.out.println("유저아이디 : " + user_id + "," + "유저 패스 : " + user_pw);

			int user_grade = dao.gradeCheck(user_id, user_pw);
			String user_name = dao.loginCheck(user_id, user_pw, 2);

			System.out.println("유저이름 : " + user_name + "\n" + "유저등급 : " + Integer.toString(user_grade));

			// 로그인 여부
			String message = new String();
			String page = new String();

//          
			if (user != null) {
				message = user_name + "(" + user_id + ")" + "님!";
				page = "/views/sh/day1.jsp";

				// session 객체 인스턴스
				session.setAttribute("user_id", user_id);
				session.setAttribute("message", message);

			} else {
				message = "아이디 또는 비밀번호가 일치하지 않습니다.";

				// 로그인 페이지로 돌아감
				page = "/Login/login?message=" + URLEncoder.encode(message, "utf-8");

			}

			
			resp.sendRedirect(req.getContextPath() + page);

		}

	}
	

	//클라이언트 ip가져오기
	public static String getRemoteAddr(HttpServletRequest request) {
        String ip = null;
        ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("Proxy-Client-IP"); 
        } 
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("WL-Proxy-Client-IP"); 
        } 
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("HTTP_CLIENT_IP"); 
        } 
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("X-Real-IP"); 
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("X-RealIP"); 
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("REMOTE_ADDR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getRemoteAddr(); 
        }
        return ip;
    }

}