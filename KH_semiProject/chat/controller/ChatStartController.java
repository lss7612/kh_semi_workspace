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
		
		//회원 목록 가져오기
		List<ChatUserList> userList = userChatService.userList(user_no);
		
		req.setAttribute("userList", userList);
		req.getRequestDispatcher("/views/chat/chatSelect.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" > > >/chathome/start [POST] 요청 완료 < < <");
		
		//---------------- 이쪽으로 전달되는 대화 상대는 한명이라고 가정한다.----------------------
		//session의 회원 정보 가져오기
		HttpSession session = req.getSession();
		ChatUserInfo userinfo = (ChatUserInfo)session.getAttribute("userinfo");
		int user0_no = userinfo.getUser_no();
		
		//선택한 회원 번호값 가져오기
		int user1_no = Integer.parseInt(req.getParameter("selectUserNo"));
		System.out.println("대화 선택한 회원의 번호 : "+req.getParameter("selectUserNo"));
		//선택한 회원의 정보를 객체에 저장
		ChatUserInfo user1_info = userChatService.infoByUserNo(user1_no);
		
		//회원정보를 가져오지 못하면 종료
		if(user1_info == null) {
			System.out.println("정보가 들어가지 않았습니다.");
			req.getRequestDispatcher("/views/chat/chatSelect.jsp");
		}
		System.out.println(" > > > 채팅 상대 정보 출력 < < <");
		System.out.println("user1_info "+user1_info);
		//선택한 회원의 정보를 가져오기
		
		//System.out.println("생성 자 : "+user0_no);
		//System.out.println("초대 받은 자 : "+user1_no);
				
		//초대받은 인원 수 세기(지금은 2명만 구현)
		int[] userList = {user0_no, user1_no};
		int count = 0;
		
		for(int i=0;i<userList.length;i++) {
			count++;
		}
		
		//선택 대상이 2명일경우 개인 대화방이 기존에 있는지 검색한다.
		//	기존 대화방이 있으면 기존 대화방에서 계속해서 대화
		//	기존 대화방이 없으면 대화방을 생성해서 대화 시작.
		int chatting_no = 0;
	
		chatting_no = userChatService.searchRoom(user0_no, user1_no);
		
		//대화 기록 가져오기
		System.out.println("대화기록 가져오기");
		System.out.println("대화방 번호는 "+chatting_no+"입니다.");
		List<Chat> list = userChatService.getChatList(user0_no, user1_no, chatting_no);
		for(Chat c : list) {
			System.out.println(c);
		}
		
		if( chatting_no == 0) {
			System.out.println("과거 회원간 대화가 존재하지 않습니다.");
			//선택한 회원으로 대화방 생성하기
			chatting_no = userChatService.createRoom(user0_no, user1_no, count);
			req.setAttribute("chatting_no", chatting_no);
			req.setAttribute("user1_info", user1_info);
			//req.getRequestDispatcher("/chat/room").forward(req, resp);
			req.getRequestDispatcher("/views/chat/chatRoom.jsp").forward(req, resp);
		} else {
			System.out.println("기존에 회원간 대화 내용이 존재합니다.");
			System.out.println("두 회원의 최근 채팅방 번호는 : "+chatting_no+"입니다.");
			// 기존 대화방 정보로 대화 진행.
			req.setAttribute("chatting_no", chatting_no);
			req.setAttribute("user1_info", user1_info);
			//req.getRequestDispatcher("/chat/room").forward(req, resp);
			req.getRequestDispatcher("/views/chat/chatRoom.jsp").forward(req, resp);
		}
	}
}
