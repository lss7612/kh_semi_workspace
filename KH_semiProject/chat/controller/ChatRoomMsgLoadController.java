package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dto.Chat;
import dto.ChatUserInfo;
import dto.SendMsgClient;
import service.face.UserChatService;
import service.impl.UserChatServiceImpl;


@WebServlet("/chat/msgload")
public class ChatRoomMsgLoadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserChatService userChatService = new UserChatServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("\n > > >/chat/msgload POST 요청 < < <");
		resp.setContentType("application/json; charset=utf-8");	
		
		//전달객체 저장하기
		int chatting_no = Integer.parseInt(req.getParameter("chatting_no"));
		int user0_no = Integer.parseInt(req.getParameter("user0_no"));
		int user1_no = Integer.parseInt(req.getParameter("user1_no"));
		
		System.out.println("방번호 : "+chatting_no+", 인원1의 번호 : "+user0_no+", 인원2의 번호 : "+user1_no);
		
		//전달객체 유저번호를 통해 회원 정보 가져오기
		ChatUserInfo user0_info = userChatService.infoByUserNo(user0_no);
		ChatUserInfo user1_info = userChatService.infoByUserNo(user1_no);
		
		//대화 기록을 가져온다.
		List<Chat> list = userChatService.getChatList(user0_no, user1_no, chatting_no);
		
		//현재 대화방의 메시지 번호를 가져온다.
		int msg_no = userChatService.getLeastMsgNum(chatting_no);
		System.out.println(chatting_no+"번 방의 마지막 메시지 번호는 "+msg_no+"입니다.");
		
		//전달받은 방번호, 유저0, 유저1의 정보로 채팅이력을 가져온다.
		List<SendMsgClient> clist = new ArrayList<>();
		clist= sendChatMsgList(list,user0_info, user1_info);
		
		PrintWriter out = resp.getWriter();
		
		out.print(getString(clist, msg_no));
		
//		Gson gs = new Gson();
//		
		System.out.println("clist : "+getString(clist, msg_no));
//		System.out.println("toJson(clist) : "+ gson.toJson(clist));
//		PrintWriter out = resp.getWriter();
//		out.println(gson.toJson(clist));
		
	}
	
	//메세지에 변환
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
	
	//변환된 메시지를 JSON으로 변환
	public String getString(List<SendMsgClient> clist, int msg_no) {
		StringBuffer result = new StringBuffer("");
		result.append("{\"result\" : [");
		if(clist.size()==0) {
			return "";
		}
		for(int i=0; i<clist.size();i++) {
			result.append("[{\"value\" : \""+clist.get(i).getWinfo()+"\"},");
			result.append("{\"value\" : \""+clist.get(i).getChatTime()+"\"},");
			result.append("{\"value\" : \""+clist.get(i).getMsgContent()+"\"}]");
			if(i !=clist.size()-1) {
				result.append(",");
			}
		}
		result.append("],\"last\":\""+msg_no+"\"}");
		return result.toString();
	}
}
