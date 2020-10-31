package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public UserDao() {
		try {
			String URL = "jdbc:oracle:thin:@localhost:1521:xe";
			String USERNAME = "scott";
			String PASSWORD = "tiger";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public int login(String user_id, String user_pw) {
		
		String sql = "";
		sql += "select user_pw from tb_user";
		sql += " where user_id = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user_id);
			rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(user_pw)) {
					return 1; //로그인 성공
				} else {
					return 0; //비밀번호 불일치
				}
			}
			return -1; //아이디 없음
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2; //데이터베이스 오류
	}
	

}
