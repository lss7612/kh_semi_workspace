package controller.chat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dto.chat.Chat;
import dto.common.UserInfo;
import service.face.chat.UserChatService;
import service.impl.chat.UserChatServiceImpl;

@WebServlet("/chathome")
public class ChatHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserChatService userChatService = new UserChatServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("\n> > >/chathome [GET] 접속< < <");
		
		//세션 정보 가져오기
		HttpSession session = req.getSession();
		
		//세션에서 userinfo 가져오기
		UserInfo user = (UserInfo)session.getAttribute("userinfo");
		
		//세션의 userinfo에서 회원 번호 가져오기
		int user_no = user.getUser_no();
		System.out.println(user_no);
		
		//세션의 userinfo에서 회원 이름 가져오기
		String user_name = user.getUser_name();
		System.out.println(user_name);
		
		//회원이 속한 채팅방 번호 가져오기
		List rlist = new ArrayList();
		rlist = userChatService.getUserChatRoom(user_no);
		
		System.out.println(user_name+"가 속한 채팅반 번호");
		for(int i=0;i < rlist.size(); i++) {
			System.out.print(rlist.get(i)+" / ");
		}
		
		//회원번호,회원 이름을 통해 진행중인 채팅 목록과 마지막대화내용, 시간 가져오기
		List<Chat> chatList = userChatService.userChatList(rlist, user_no);		
	
		//최신 순으로 정렬하기.
		Comparator<Chat> comp = new Comparator<Chat>() {
			@Override
			public int compare(Chat o1, Chat o2) {
				return -1 * o1.getRevision_date().compareTo(o2.getRevision_date());
			}
		};
		
		chatList.sort(comp);
		
		req.setAttribute("chatList", chatList);
	

		req.getRequestDispatcher("/views/chat/chatHome.jsp").forward(req, resp);
	}
	

}
