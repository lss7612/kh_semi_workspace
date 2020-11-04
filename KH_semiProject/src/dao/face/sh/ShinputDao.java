package dao.face.sh;

import java.sql.Connection;

import dto.sh.Shinput;

public interface ShinputDao {
	
	/**
	 *  스케줄 인풋_seq의 넥스트val 을 반환한다
	 * @return 스케줄 인풋_seq,nextval
	 */
	public int seletNextschdl_no();

	
	
	/**
	 *  스케줄 인풋 객체의 값을 테이블에 삽입한다
	 * @param conn - 디비 연결 객체
	 * @param param - 삽입할 정보 객체
	 */
	public int insert(Connection conn, Shinput param);




	int selectNextSchdl_no(Connection conn);

}
