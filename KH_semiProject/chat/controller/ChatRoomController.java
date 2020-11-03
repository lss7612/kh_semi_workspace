package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Chat;
import dto.ChatUserInfo;
import dto.SendMsgClient;
import service.face.UserChatService;
import service.impl.UserChatServiceImpl;

@WebServlet("/chat/room")
public class ChatRoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserChatService userChatService = new UserChatServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println(" > > >/chat/room [POST] 완료 < < <");
		
		//현재 세션 정보 가져오기
		HttpSession session = req.getSession();
		//세션 정보에서 유저 정보 가져오기
		ChatUserInfo user0_info = (ChatUserInfo)session.getAttribute("userinfo");
		int user0_no = user0_info.getUser_no();
		
		//전달 객체(유저번호) 저장하기
		//	선택한 회원 번호값 가져오기
		int user1_no = Integer.parseInt(req.getParameter("selectUserNo"));
		//	회원번호로 회원 정보 가져오기
		ChatUserInfo user1_info = userChatService.infoByUserNo(user1_no);
		System.out.println(user1_info);
		//정보 확인
		System.out.println(user1_info);
		//회원정보를 가져오지 못하면 이전페이지로 다시 이동
		if(user1_info == null) {
			System.out.println("정보가 들어가지 않았습니다.");
			req.getRequestDispatcher("/views/chat/chatSelect.jsp");
		}
		//---------------- 이쪽으로 전달되는 대화 상대는 한명이라고 가정한다.----------------------
		
		System.out.println("대화 선택한 회원의 번호 : "+req.getParameter("selectUserNo"));

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
		System.out.println(list.size());
		if( chatting_no == 0) {
			System.out.println("과거 회원간 대화가 존재하지 않습니다.");
			//선택한 회원으로 대화방 생성하기
			chatting_no = userChatService.createRoom(user0_no, user1_no, count);
			System.out.println(chatting_no+"번 방이 생성되었습니다.");
			req.setAttribute("chatting_no", chatting_no);
			req.setAttribute("user1_info", user1_info);
			req.getRequestDispatcher("/views/chat/chatRoom.jsp").forward(req, resp);
		} else {
			//채팅대화 이력을 뽑아낸다.
			List<SendMsgClient> clist = new ArrayList<>();
			clist= sendChatMsgList(list,user0_info, user1_info);
			
			System.out.println("기존에 회원간 대화 내용이 존재합니다.");
			System.out.println("두 회원의 최근 채팅방 번호는 : "+chatting_no+"입니다.");
			System.out.println("두 회원의 기존 대화");
			for(SendMsgClient s : clist) {
				System.out.println(s);
			}
			// 기존 대화방 정보로 대화 진행.
			req.setAttribute("clist", clist);
			req.setAttribute("chatting_no", chatting_no);
			req.setAttribute("user1_info", user1_info);
			req.getRequestDispatcher("/views/chat/chat2.jsp").forward(req, resp);
		}		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println(" > > >/chat/room [POST] 완료 < < <");
		
		//현재 세션 정보 가져오기
		HttpSession session = req.getSession();
		//세션 정보에서 유저 정보 가져오기
		ChatUserInfo user0_info = (ChatUserInfo)session.getAttribute("userinfo");
		int user0_no = user0_info.getUser_no();
		
		//전달 객체(유저번호) 저장하기
		//	선택한 회원 번호값 가져오기
		int user1_no = Integer.parseInt(req.getParameter("selectUserNo"));
		//	회원번호로 회원 정보 가져오기
		ChatUserInfo user1_info = userChatService.infoByUserNo(user1_no);
		System.out.println(user1_info);
		//정보 확인
		System.out.println(user1_info);
		//회원정보를 가져오지 못하면 이전페이지로 다시 이동
		if(user1_info == null) {
			System.out.println("정보가 들어가지 않았습니다.");
			req.getRequestDispatcher("/views/chat/chatSelect.jsp");
		}
		//---------------- 이쪽으로 전달되는 대화 상대는 한명이라고 가정한다.----------------------
		
		System.out.println("대화 선택한 회원의 번호 : "+req.getParameter("selectUserNo"));

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
		System.out.println(list.size());
		if( chatting_no == 0) {
			System.out.println("과거 회원간 대화가 존재하지 않습니다.");
			//선택한 회원으로 대화방 생성하기
			chatting_no = userChatService.createRoom(user0_no, user1_no, count);
			System.out.println(chatting_no+"번 방이 생성되었습니다.");
			req.setAttribute("chatting_no", chatting_no);
			req.setAttribute("user1_info", user1_info);
			req.getRequestDispatcher("/views/chat/chatRoom.jsp").forward(req, resp);
		} else {
			//채팅대화 이력을 뽑아낸다.
			List<SendMsgClient> clist = new ArrayList<>();
			clist= sendChatMsgList(list,user0_info, user1_info);
			
			System.out.println("기존에 회원간 대화 내용이 존재합니다.");
			System.out.println("두 회원의 최근 채팅방 번호는 : "+chatting_no+"입니다.");
			System.out.println("두 회원의 기존 대화");
			for(SendMsgClient s : clist) {
				System.out.println(s);
			}
			// 기존 대화방 정보로 대화 진행.
			req.setAttribute("clist", clist);
			req.setAttribute("chatting_no", chatting_no);
			req.setAttribute("user1_info", user1_info);
			req.getRequestDispatcher("/views/chat/chat2.jsp").forward(req, resp);
		}		
	}
	
	public List<SendMsgClient> sendChatMsgList(List<Chat> list, ChatUserInfo user0_info, ChatUserInfo user1_info) {
		List<SendMsgClient> clist = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			if( user0_info.getUser_no() == list.get(i).getUser_no()) {
				String chatT = "<div class='row'><strong>"+user0_info.getUser_name()+" / "+user0_info.getDept_name() 
					+" / "+user0_info.getPosition_name() +"</strong></div>";
				String sendTime = list.get(i).getRevision_date();
				String chatC = "<div class='row'>"+list.get(i).getMsg_content()+"</div><hr>";
				SendMsgClient smc = new SendMsgClient();
				smc.setWinfo(chatT);
				smc.setChatTime(sendTime);
				smc.setMsgContent(chatC);
				clist.add(smc);
			} else {
				String chatT = "<div class='row'><strong>"+user1_info.getUser_name()+" / "+user1_info.getDept_name() 
					+" / "+user1_info.getPosition_name() +"</strong> 님의 메시지 </div>";
				String sendTime = list.get(i).getRevision_date();
				String chatC = "<div class='row'>"+list.get(i).getMsg_content()+"</div><hr>";
				SendMsgClient smc = new SendMsgClient();
				smc.setWinfo(chatT);
				smc.setChatTime(sendTime);
				smc.setMsgContent(chatC);
				clist.add(smc);
			}
		}
		return clist;
	}
}
