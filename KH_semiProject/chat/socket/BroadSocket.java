package socket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import common.HttpSessionConfigurator;
import dto.ChatUserInfo;
import service.face.UserChatService;
import service.impl.UserChatServiceImpl;

//handshake 설정하기 위한 클래스를 지정
@ServerEndpoint(value = "/broadsocket", configurator = HttpSessionConfigurator.class)
public class BroadSocket {

	//채팅에 관련된 유저정보를 담을 객체 생성
	ChatUserInfo userinfo = new ChatUserInfo();
	//service처리할 객체 생성
	private UserChatService userChatService = new UserChatServiceImpl();
	
	public String getParam(HttpServletRequest req) {
		String chatno = req.getParameter("chatting_no");
		return chatno;
	}
		
	//세션 객체와 웹소켓을 저장
	private Map<Session, EndpointConfig> configs = Collections.synchronizedMap(new HashMap<>());
	
	//채팅을 통해 전달받은 userNo
	int user_no=0;
	
	//접속된 클라이언트 Session 관리 리스트
	private static List<Session> sessionUsers  = Collections.synchronizedList(new ArrayList<>());
	
	//메시지에서 유저명을 위한 정규식
	private static Pattern pattern = Pattern.compile("^\\{\\{.*?\\}\\}");
	
	//-----------------------------------------------------
	
	//브라우저가 접속하면 요청되는 함수
	@OnOpen
	public void handleOpen(Session userSession, EndpointConfig config) {
		
		//클라이언트가 접속하면 WebSocket세션을 저장
		sessionUsers.add(userSession);
		
		//EndpointConfig의 클래스를 Map에 넣는다.
		if(!configs.containsKey(userSession)) {
			//userSession클래스는 connection()이 될때마다 인스턴스를 생성
			//	따라서 키로서 사용이 가능하다.
			configs.put(userSession, config);
		}
		
		System.out.println("클라이언트가 접속되었습니다.");
		
	}
	
	//WebSocket으로 메시지가 오면 요청되는 함수
	@OnMessage
	public void handleMessage(String msg, Session userSession) {
		
		HttpSession getSession = null;
		//맴에 저장한 userSession을 key로 EndpointConfig의 값을 가져온다.
		if( configs.containsKey(userSession)) {
			EndpointConfig config = configs.get(userSession);
			
			//HttpSession session값을 가져온다.
			getSession = (HttpSession) config.getUserProperties().get(HttpSessionConfigurator.Session);
			
			System.out.println(getSession.getAttribute("userinfo"));
		}
		
		//메시지 내용을 콘솔체 출력한다
		System.out.println(msg);
		
		//초기 유저명
		String name = "아무개";
		
		//메시지로 유저명을 추출한다.
		Matcher matcher = pattern.matcher(msg);
		
		//메시지 예 {유저명} 메시지
		if(matcher.find()) {
			name = matcher.group();
		}
		
		
		//클로저를 위해 변수의 상수화
		//메시지 내용 추출
		final String message = msg.replaceAll(pattern.pattern(), "");
		//메시지창네 나타날 이름상태 추출(이름/부서/직급)
		final String username = name.replaceAll("\\}\\}$", "").replaceAll("^\\{\\{", "").replaceAll("\\d","");
		
		//세션정보에서 회원번호 추출
		ChatUserInfo userInfo = (ChatUserInfo) getSession.getAttribute("userinfo");
		int userno = userInfo.getUser_no();
		
		//사원 번호 추출
//		final String userno = name.replaceFirst("\\}\\}$", "").replaceAll("^\\{\\{", "").replaceAll("\\D","");
//		user_no = Integer.parseInt(userno);
		System.out.println("메시지 : "+ message);
		System.out.println("대화 창 출력 이름 : "+username);
		System.out.println("보낸 회원 번호 : "+userno);
		
		//메시지 내용을 전달하기.
		userChatService.insertMsg(userno, message);

		
		//Session관리 리스트에서 Session을 취득한다.
		sessionUsers.forEach(session -> {
			//리스트에 있는 세션과 메시지를 보낸 세션이 같으면 메시지를 송신 할 필요 X
			if( session == userSession) {
				return;
			}
			try {
				session.getBasicRemote().sendText("<div class='row'><strong>"+username +"</strong>님의 메시지 </div>"
					+"<div class='row'>"+message+"</div><hr>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	//WebSocket과 브라우저가 접속이 끊기면 요청되는 함수
	@OnClose
	public void handleClose(Session userSession) {
		//Session 리스트로 접속 끊은 세션을 제거한다.
		sessionUsers.remove(userSession);
		
		//콘솔에 접속 끊김 로그를 출력한다.
		System.out.println("채팅을 종료합니다.");
	}
	
	//WebSocket과 브라우저 간에 통신 에러가 발생하면 요청되는 함수
	@OnError
	public void handleError(Throwable t) {
		t.printStackTrace();
	}
	
}

