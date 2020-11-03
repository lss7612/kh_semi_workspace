package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Paging;
import dto.ChatUserInfo;
import dto.ChatUserList;
import service.face.UserChatService;
import service.impl.UserChatServiceImpl;

@WebServlet("/chathome/start")
public class ChatStartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserChatService userChatService = new UserChatServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("\n> > >/chathome/start [GET] 접속< < <");
		
		//세션 정보 얻어오기
		HttpSession session = req.getSession();
		//세션 정보에서 회원번호 가져오기
		ChatUserInfo userinfo = (ChatUserInfo)session.getAttribute("userinfo");
		int user_no = userinfo.getUser_no();
		
		//페이징 정보 생성하기
		Paging paging = userChatService.getPaging(req);
		//Page처리 결과 전달
		req.setAttribute("paging", paging);
		
		//회원 목록 가져오기
		List<ChatUserList> userList = userChatService.userList(user_no, paging);
		
		
		req.setAttribute("userList", userList);
		req.getRequestDispatcher("/views/chat/chatSelect.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" > > >/chathome/start [POST] 요청 완료 < < <");
		
		
	}
}
