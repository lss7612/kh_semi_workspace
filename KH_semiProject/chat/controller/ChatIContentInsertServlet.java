package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.face.UserChatService;
import service.impl.UserChatServiceImpl;

@WebServlet("/chat/msgent")
public class ChatIContentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserChatService userChatService = new UserChatServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ajax dopost 요청");
		
		//요청객체에서 파라미터 얻어오기
		int user0_no = Integer.parseInt(req.getParameter("user0_no"));
		int chatting_no = Integer.parseInt( req.getParameter("chatting_no"));
		String chatContent = req.getParameter("msg");
		
		//세션에서 ip얻어오기
		HttpSession session = req.getSession();
		
		String user_ip = (String) session.getAttribute("userIp");
		
		System.out.println("메시지 작성자 : "+user0_no);
		System.out.println("채팅방 : "+chatting_no);
		System.out.println("메시지 내용 : "+chatContent);
		System.out.println("작성 IP : "+user_ip);
		
		//전달객체로 받아온 회원정보 채팅번호, 채팅내용, 사용자 ip를 db에 저장한다.
		userChatService.insertMsg(chatting_no, user0_no, chatContent, user_ip);
	}
	
}
