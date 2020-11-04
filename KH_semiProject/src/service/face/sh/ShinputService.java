package service.face.sh;

import javax.servlet.http.HttpServletRequest;

import dto.sh.Shinput;

public interface ShinputService  {

	public Shinput getParam(HttpServletRequest req);
	
	/**
	 *  전달된 데이터를 이용하여 회원 가입 처리
	 * @param param - 클라이언트로 부터 전달된 회원 정보 객체
	 * @return DB에 삽입 완료된 회원 정보 객체
	 */
	
	public Shinput join(Shinput param);
		

	
}
