package dao.impl.sh;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import dao.face.sh.ShinputDao;
import dto.sh.Shinput;

public class ShinputDaoimpl implements ShinputDao{

	private PreparedStatement ps = null; // Sql 수행 객체
	private ResultSet rs = null; //결과 집합 객체
	
	
	@Override
	public int selectNextSchdl_no(Connection conn) {
		
		String sql = "";
		sql += "SELECT tb_schedule_SEQ.NEXTVAL AS next FROM DUAL";
		
		int next = 0; //결과를 저장할 변수
		
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			rs.next();//조회된 첫행 결과 찾기
			
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
	public int insert(Connection conn, Shinput param) {
		
		//PreparedStatement ps = null; // Sql 수행 객체
		//ResultSet rs = null; //결과 집합 객체 -- select할 때만 필요
		
		String sql = "";
		sql += "INSERT INTO tb_schedule (SCHDL_NO, SCHDL_TYPE, USER_NO, SCHDL_TITLE, SCHDL_CONTENT, SCHDL_START, SCHDL_END, REVISION_DATE, TABLE_NO)";
		sql += " VALUES ( ?, ?, ?, ?, ?, ?, ?, sysdate, ?)";
		
		int result =0; //인설트 결과 저장 변수
		
		try {
			ps = conn.prepareStatement(sql);
			
			System.out.println(param);
			
			ps.setInt(1, param.getSchdl_no());
			ps.setInt(2, param.getSchdl_type());
			ps.setInt(3, 2); //나중에 이부분을 세션션에서 받아와서 쓰는 기능을 구현 해야함 
			ps.setString(4, param.getSchdl_title());
			ps.setString(5, param.getSchdl_content());
			ps.setDate(6, param.getSchdl_start());
			ps.setDate(7, param.getSchdl_end());
			ps.setInt(8, 50);
			
			//인서트 수행
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally{
			JDBCTemplate.close(ps); //자원 해제
			
		}
		
		//인설트 수행결과 반롼
		return result;
		
	}

	@Override
	public int seletNextschdl_no() {
		// TODO Auto-generated method stub
		return 0;
	}









}
