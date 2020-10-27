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

@WebServlet("/chat/room")
public class ChatRoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserChatService userChatService = new UserChatServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" > > >/chat/room [GET] 완료 < < <");
		
		if(req.getParameter("selectUserNo") == null) {
			System.out.println("선택된 회원이 없습니다");
			return;
		}
		
		//session의 회원 정보 가져오기
		HttpSession session = req.getSession();
		ChatUserInfo userinfo = (ChatUserInfo)session.getAttribute("userinfo");
		int user0_no = userinfo.getUser_no();
		
		//선택한 회원 번호값 가져오기
		int user1_no = Integer.parseInt(req.getParameter("selectUserNo"));
		System.out.println(req.getParameter("selectUserNo"));
		ChatUserInfo user1_info = userChatService.infoByUserNo(user1_no);
		
		//회원정보를 가져오지 못하면 종료
		if(user1_info == null) {
			System.out.println("정보가 들어가지 않았습니다.");
			return;
		}
		System.out.println(" > > > 채팅 상대 정보 출력 < < <");
		System.out.println("user1_info "+user1_info);
		//선택한 회원의 정보를 가져오기
		
		//System.out.println("생성 자 : "+user0_no);
		//System.out.println("초대 받은 자 : "+user1_no);
		
		//초대받은 인원 수 세기
		int[] userList = {user0_no, user1_no};
		int count = 0;
		
		for(int i=0;i<userList.length;i++) {
			count++;
		}
		
		//선택한 회원으로 대화방 생성하기
		userChatService.createRoom(user0_no, user1_no, count);
		
		req.setAttribute("opponentInfo", user1_info);
		req.getRequestDispatcher("/WEB-INF/views/chat/chat.jsp").forward(req, resp);
		
	}
}
