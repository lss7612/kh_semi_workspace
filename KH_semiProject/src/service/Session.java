package service;

import dto.SessionDTO;

public interface Session {
	
	/**
	 * id로  no 가져오기
	 * @param user_id
	 */
	public SessionDTO getUserNo(String user_id);
	
	

}
