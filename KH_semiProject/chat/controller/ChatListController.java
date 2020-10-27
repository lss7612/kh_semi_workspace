package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Chat;
import dto.ChatUserInfo;
import service.face.UserChatService;
import service.impl.UserChatServiceImpl;

@WebServlet("/chathome/list")
public class ChatListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserChatService userChatService = new UserChatServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("\n> > > /chathome/list 접속 < < <");
		System.out.println("> > >세션 정보 < < <");
		HttpSession session = req.getSession();
		System.out.println(session.getAttribute("userinfo"));
		
		//세션에서 userinfo 가져오기
		ChatUserInfo user = (ChatUserInfo)session.getAttribute("userinfo");
		
		//세션의 userinfo에서 회원 번호 가져오기
		int user_no = user.getUser_no();
		System.out.println(user_no);
		
		//회원번호를 통해 진행중인 채팅 목록 가져오기
		List<Chat> chatList = userChatService.userChatList(user_no);		
	
		req.setAttribute("chatList", chatList);
		req.getRequestDispatcher("/WEB-INF/views/chat/chatList.jsp").forward(req, resp);
		
		
	}
}
