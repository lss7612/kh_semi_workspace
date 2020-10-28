package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.ChatUserInfo;
import service.face.UserChatService;
import service.impl.UserChatServiceImpl;

@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ChatUserInfo user = new ChatUserInfo();
	private UserChatService userChatService = new UserChatServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/home doget 접속");

		//세션 정보 가져오기
		HttpSession session = req.getSession();
		
		//클라이언트 ip확인하기
		String userIp = getRemoteAddr(req);
		System.out.println(userIp);
		
		//채팅 유저 정보 객체 생성
		ChatUserInfo user = null;
		
		//유저 정보 가져오기
		user = userChatService.infoById(req.getParameter("userid"));
		
		//세션에 유저 정보 저장
		session.setAttribute("userinfo", user);
		session.setAttribute("userIp", userIp);
		
		//저장된 세션정보 확인
		System.out.println("session info : "+session.getAttribute("userinfo"));
		
		//응답 전달
		req.setAttribute("user", user);
		req.setAttribute("userIp", userIp);
		req.getRequestDispatcher("/views/chat/home.jsp").forward(req, resp);
	}
	
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
