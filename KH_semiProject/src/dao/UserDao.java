package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import dto.SessionDTO;

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
	
	
	
	public int login(String user_id) {
		
		String sql = "";
		sql += "select user_no from tb_user";
		sql += " where user_id = ?";
		
		int result = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user_id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt("user_no");
				
				return result;
			}
			
			return -1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -2; //데이터베이스 오류
	}



	public SessionDTO getUserNo(Connection conn2, String user_id) {
		
		ResultSet rs = null;
		
		String sql = "";
		sql += "select u.user_no, u.user_name,g.grade_no,g.grade_name, u.user_id from tb_user u";
		sql += " inner join tb_grade g";
		sql += " on u.user_grade = g.grade_no";
		sql += " where u.user_id = ? ";  
		
		SessionDTO sessionDto = new SessionDTO();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user_id);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				sessionDto.setGrade_no(rs.getInt("grade_no"));
				sessionDto.setUser_no(rs.getInt("user_no"));
				sessionDto.setUser_name(rs.getString("user_name"));
				sessionDto.setGrade_name(rs.getString("grade_name"));
				sessionDto.setUser_id(rs.getString("user_id"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps); //자원 해제
		}
		
		return sessionDto;
		
	}
	
	
	
	
	
	

}
