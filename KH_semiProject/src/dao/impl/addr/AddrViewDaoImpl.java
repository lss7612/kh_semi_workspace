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

	@Override
	public List<AddrView> viewUser(Connection conn, AddrParam addrParam) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<AddrView> result = new ArrayList<AddrView>();
		
		String sql = "";
		sql += "SELECT * FROM tb_user";
		sql += " 1=1";
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
			
			while(rs.next()) {
				AddrView e = new AddrView();
				
				e.setCellphone_no(rs.getString("cellphone_no"));
				e.setDept_no(rs.getInt("deptno"));//고쳐야함
				e.setPosition_no(rs.getInt("position_no"));
				e.setUser_id(rs.getString("user_id"));
				e.setUser_name(rs.getString("user_name"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	
	}

}
