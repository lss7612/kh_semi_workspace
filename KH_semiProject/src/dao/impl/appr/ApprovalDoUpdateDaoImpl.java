package dao.impl.appr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import common.JDBCTemplate;
import dao.face.appr.ApprovalDoUpdateDao;
import dto.appr.ApprMy;

public class ApprovalDoUpdateDaoImpl implements ApprovalDoUpdateDao{

	

	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public int UpdateParam(Connection conn, ApprMy apprmy) {
		
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Calendar time = Calendar.getInstance();
		String format_time1 = format1.format(time.getTime());
		
		
		
		
		
		String sql="";
		sql+=" update tb_approval set aprvl_state=? ,final_date="+"'" + format_time1 + "'" +" where aprvl_no=?";
		
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
