package dao.impl.addr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.face.addr.AddrViewDao;
import dto.addr.AddrParam;
import dto.addr.AddrView;

public class AddrViewDaoImpl implements AddrViewDao{
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public List<AddrView> viewUser(Connection conn, AddrParam addrParam) {
		
		

		List<AddrView> result = new ArrayList<AddrView>();
		
		String sql = "";
		sql += "SELECT * FROM ";
		sql += " (SELECT * FROM tb_user u";
		sql += " LEFT OUTER JOIN tb_dept d";
		sql += " ON u.detp_no = d.dept_no) j1";
		sql += " LEFT OUTER JOIN tb_position t";
		sql += " ON j1.position_no = t.position_no";
		
		
		if(addrParam.getArrayCondition().equals("userid")) {
			sql += " ORDER BY user_id";
		} else if(addrParam.getArrayCondition().equals("username")) {
			sql += " ORDER BY user_name";
		} else if(addrParam.getArrayCondition().equals("dept")) {
			sql += " ORDER BY detp_no";
		} else if(addrParam.getArrayCondition().equals("position")) {
			sql += " ORDER BY position_no";
		}
		
		if(addrParam.isASC()) {
			sql += " ASC";
		} else {
			sql += " DESC";
		}
		
		try {
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println(rs.next());
			
			while(rs.next()) {
				AddrView e = new AddrView();
				
				e.setCellphone_no(rs.getString("cellphone_no"));
				e.setDept_name(rs.getString("dept_name"));
				e.setPosition_name(rs.getString("position_name"));
				e.setUser_id(rs.getString("user_id"));
				e.setUser_name(rs.getString("user_name"));
				
				result.add(e);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	
	}

}
