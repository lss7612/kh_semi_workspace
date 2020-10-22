package dao.impl.addr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplete;
import common.Paging;
import dao.face.addr.AddrViewDao;
import dto.addr.AddrParam;
import dto.addr.AddrView;

public class AddrViewDaoImpl implements AddrViewDao{
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public List<AddrView> viewUserAddr(Connection conn, AddrParam addrParam, Paging paging) {
		
		

		List<AddrView> result = new ArrayList<AddrView>();
		
		String sql = "";
		sql += "SELECT * FROM (SELECT rownum rnum, j2.* FROM ";
		sql += " (SELECT * FROM ";
		sql += " (SELECT * FROM tb_user u ";
		sql += " LEFT OUTER JOIN tb_dept d ";
		sql += " ON u.detp_no = d.dept_no) j1 ";
		sql += " LEFT OUTER JOIN tb_position t ";
		sql += " ON j1.position_no = t.position_no ";
		sql += " ORDER BY ? , ?) j2) ";
		sql += " WHERE rnum BETWEEN ? and ? ";
		
		try {
			ps = conn.prepareStatement(sql);
			
			String arrCon = addrParam.getArrayCondition();
			Boolean isASC = addrParam.isASC();
			
			if(arrCon.equals("userid")) {
				ps.setString(1, " user_id");
			} else if(arrCon.equals("username")) {
				ps.setString(1, " user_name");
			} else if(arrCon.equals("dept")) {
				ps.setString(1, " dept_no");
			} else if(arrCon.equals("position")) {
				ps.setString(1, " position_no");
			} else{
				ps.setString(1, " user_id");
			}
			if(isASC) {
				ps.setString(2, " ASC");
			} else if(!isASC) {
				ps.setString(2, " DESC");
			} else {
				ps.setString(2, " ASC");
			}
			ps.setInt(3, paging.getStartNo());
			ps.setInt(4, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				AddrView e = new AddrView();
				
				e.setCellphone_no(rs.getString("cellphone_no"));
				e.setDept_name(rs.getString("dept_name"));
				e.setPosition_name(rs.getString("position_name"));
				e.setUser_id(rs.getString("user_id"));
				e.setUser_name(rs.getString("user_name"));
				
				result.add(e);
				System.out.println(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	
	}

	
	
	@Override
	public int selectCntAll(Connection conn) {

		int totalCnt= 0;
		
		String sql = "";
		sql += "SELECT count(*) FROM tb_user";
		
		try {
			ps = conn.prepareStatement(sql);
			rs= ps.executeQuery();
			while(rs.next()) {
				totalCnt=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplete.close(rs);
			JDBCTemplete.close(ps);
		}
		
		
		return totalCnt;
	}

}
