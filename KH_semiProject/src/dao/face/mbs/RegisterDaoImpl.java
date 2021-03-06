package dao.impl.mbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import dao.face.mbs.RegisterDao;
import dto.mbs.Register;

public class RegisterDaoImpl implements RegisterDao{
	
	
	@Override
	public int selectNextUserno(Connection conn) {
		PreparedStatement ps = null; //SQL 수행 객체
		ResultSet rs = null; //결과 집합 객체
		
		String sql = "";
		sql += "SELECT tb_user_SEQ.nextval next FROM dual";
		
		int next = 0; //결과를 저장할 변수
		
		try {
			ps = conn.prepareStatement(sql);
			rs= ps.executeQuery();
			
			rs.next(); //조회된 첫 행 결과 찾기
			
			next = rs.getInt("next");
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		return next;
		
	}
	
	@Override
	public int insert(Connection conn, Register param) {
	
		PreparedStatement ps = null; //SQL 수행 객체

		
		String sql = "";
		sql += "INSERT INTO tb_user("
				+ "USER_NO"
				+ ",USER_NAME"
				+ ",USER_GRADE"
				+ ",USER_ADDR"
				+ ",USER_IDENTIFY"
				+ ",DEPT_NO"
				+ ",POSITION_NO"
				+ ", CELLPHONE_NO"
				+ ", EXTENTION_NO"
				+ ", USER_ID"
				+ ", USER_PW"
				+ ", USER_NOTICE"
				+ ", STATE_NO"
				+ ", REVISION_DATE"
				+ " , USER_IP"
				+ ",TABLE_NO"
				+ ",USER_ADDR2"
				+ ",USER_ADDR3)" ;
		
		sql += " VALUES(tb_user_SEQ.NEXTVAL,?,3,?,?,1,1,?,1,?,?,?,1,sysdate,1,10,?,?)";
		
		int result = 0; //INSERT 결과 저장 변수
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,param.getUser_name());
			ps.setString(2,param.getUser_addr());
			ps.setString(3, param.getUser_identify());
			ps.setString(4,param.getCellphone_no());
			ps.setString(5,param.getUser_id());
			ps.setString(6,param.getUser_pw());
			ps.setString(7,param.getUser_notice());
			ps.setString(8,param.getUser_addr2());
			ps.setString(9,param.getUser_addr3());
			
			//INSERT 수행
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

			JDBCTemplate.close(ps); //자원 해제
		}
		
		//INSERT 수행 결과 반환
		return result;
		
		
		
	}

	

}
