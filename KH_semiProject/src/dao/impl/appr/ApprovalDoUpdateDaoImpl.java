package dao.impl.appr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import dao.face.appr.ApprovalDoUpdateDao;
import dto.appr.ApprMy;

public class ApprovalDoUpdateDaoImpl implements ApprovalDoUpdateDao{

	

	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public int UpdateParam(Connection conn, ApprMy apprmy) {
		String sql="";
		sql+="update tb_approval set aprvl_state=? "
				+ "where aprvl_no=?";
		
		int result = 0;
		
		try {
			
			ps = conn.prepareStatement(sql);
		
			ps.setInt(1, apprmy.getAprvl_state());
			ps.setInt(2, apprmy.getAprvl_no());
			
			
			result = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		
		return result;
	}

	
	
}
