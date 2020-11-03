package dao.face.appr;

import java.sql.Connection;
import java.util.List;

import dto.appr.Person;

public interface ApprovalPersonDao {

	/**
	 * 결재권자 추가할때 부서정보랑사람정보가져오는메소드입니다~
	 * @param connection
	 * @return
	 */
	List<Person> selectDeptAndName(Connection connection);

	/**
	 * 회사내 부서 리스트
	 * @param connection
	 * @return
	 */
	List<Person> selectDept(Connection connection);

	
	
	
}
