package service;

import java.sql.Connection;

import common.JDBCTemplate;
import dao.UserDao;
import dto.SessionDTO;

public class Sesssssssssssssion implements Session {

	private UserDao userDao = new UserDao(); 
	
	@Override
	public SessionDTO getUserNo(String user_id) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		SessionDTO sessionDto = new SessionDTO();
		
		sessionDto = userDao.getUserNo(conn, user_id);
		
		return sessionDto;

	}
	
	
	
	
}
