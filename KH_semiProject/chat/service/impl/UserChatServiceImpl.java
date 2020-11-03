package service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import common.Paging;
import dao.face.UserChatDao;
import dao.impl.UserChatDaoImpl;
import dto.Chat;
import dto.ChatUserInfo;
import dto.ChatUserList;
import service.face.UserChatService;

public class UserChatServiceImpl implements UserChatService{

	private UserChatDao userChatDao = new UserChatDaoImpl();
	@Override
	public ChatUserInfo infoById(String parameter) {
		Connection conn = JDBCTemplate.getConnection();
		
		return userChatDao.bringInfo(conn, parameter);
	}
	
	@Override
	public ChatUserInfo infoByUserNo(int user1_no) {
		Connection conn = JDBCTemplate.getConnection();
		
		return userChatDao.bringInfoByUserNo(conn, user1_no);
	}
	
	@Override
	public void insertMsg(int userno, String message) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result=0;
		
		result = userChatDao.saveMsg(conn, userno, message);
		
		if(result >0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
	}
	
	@Override
	public List<Chat> userChatList(List rlist, int user_no) {
		Connection conn = JDBCTemplate.getConnection();
		
		return userChatDao.selectUserChatList(conn, rlist, user_no);
	}
	
	@Override
	public List<ChatUserList> userList(int user_no) {
		Connection conn = JDBCTemplate.getConnection();
		
		return userChatDao.getUserList(conn, user_no);
	}
	
	@Override
	public int createRoom(int user0_no, int user1_no, int count) {
		Connection conn = JDBCTemplate.getConnection();
		
		//1.채팅방을 생성한다.
		int result = 0;
		result = userChatDao.makeRoom(conn, count);
		int chatting_no = 0;
		
		if (result >0 ) {
			//2. 생성한 채팅방 번호를 구한다.
			chatting_no = userChatDao.getNextRoomNo(conn);
			System.out.println("방번호 시퀀스 현재 값 :"+chatting_no);
			
			//2. 생성된 방 번호를 확인하여 방에 인원 삽입
			//tb_chattinguser에 방에 참가한 유저번호를 삽입한다.
			userChatDao.joinRoom(conn, user0_no, chatting_no);
			userChatDao.joinRoom(conn, user1_no, chatting_no);
			
			JDBCTemplate.commit(conn);
		} else {
			System.out.println("채팅방 생성 실패");
			JDBCTemplate.rollback(conn);
		}
		
		return chatting_no;
	}
	
	@Override
	public int searchRoom(int user0_no, int user1_no) {

		Connection conn = JDBCTemplate.getConnection();
		
		//회원0과 회원1의 1대1대화방이 있는지 조회한다.
		int result = userChatDao.searchChatNo(conn, user0_no, user1_no);
		
		if (result !=0 ) {
			//방번호를 반환
			return result;
		}
		//방이 없으면 0을 반환
		return 0;
	}
	
	@Override
	public List<Chat> getChatList(int user0_no, int user1_no, int chatting_no) {
		Connection conn = JDBCTemplate.getConnection();
		List<Chat> chatList = new ArrayList<>();
		chatList = userChatDao.getUserChatList(conn, chatting_no);
		return chatList;
	}
	
	@Override
	public void insertMsg(int chatting_no, int user0_no, String chatContent, String user_ip) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = 0;
		result = userChatDao.insertMsg(conn, chatting_no, user0_no, chatContent, user_ip);
		
		if(result != 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
	}
	
	@Override
	public int getLeastMsgNum(int chatting_no) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		
		return userChatDao.getMsgNum(conn, chatting_no);
	}
	
	@Override
	public List getUserChatRoom(int user_no) {
		Connection conn = JDBCTemplate.getConnection();
		List rList = userChatDao.getUserChatRoomList(conn,user_no);
		
		return rList;
	}

	@Override
	public Paging getPaging(HttpServletRequest req) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		//전달 파라미터를 파싱
		String param = req.getParameter("curPage");
		int curPage =0;
		if( param!=null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		
		//회원의 총 게시글수를 조회한다.
		int totalCount = userChatDao.selectCntAll(conn);
		
		//Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}
	
	@Override
	public List<ChatUserList> userList(int user_no, Paging paging) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		return userChatDao.getUserList(conn, user_no, paging);
	}
}
