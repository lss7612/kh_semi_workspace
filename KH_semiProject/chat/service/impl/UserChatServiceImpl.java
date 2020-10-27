package service.impl;

import java.sql.Connection;
import java.util.List;

import common.JDBCTemplate;
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
	public List<Chat> userChatList(int user_no) {
		Connection conn = JDBCTemplate.getConnection();
		
		return userChatDao.selectUserChatList(conn, user_no);
	}
	
	@Override
	public List<ChatUserList> userList(int user_no) {
		Connection conn = JDBCTemplate.getConnection();
		
		return userChatDao.getUserList(conn, user_no);
	}
	
	@Override
	public void createRoom(int user0_no, int user1_no, int count) {
		Connection conn = JDBCTemplate.getConnection();
		
		//1. 채팅방을 개설
		int result = 0;
		result = userChatDao.makeRoom(conn, count);
		//2. 생성된 방 번호를 확인하여 방에 인원 삽입
		if (result >0 ) {
			int roomNo = userChatDao.selectRoom(conn);
			userChatDao.joinRoom(conn, user0_no, roomNo);
			userChatDao.joinRoom(conn, user1_no, roomNo);
			
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
	}
	
	
}
