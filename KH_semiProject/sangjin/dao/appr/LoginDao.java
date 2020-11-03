package dao.appr;

import java.sql.Connection;
import java.util.List;

import dto.appr.Login;

public interface LoginDao {
	/**
	 * 로그인 파라미터
	 * @param connection
	 * @return 사람들 id,pw
	 */
	List<Login> selectList(Connection connection);

}
