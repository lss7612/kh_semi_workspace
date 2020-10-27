package dao.impl.sh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.face.sh.SchdlDao;
import dto.sh.Schdl;



public class SchdlDaoImpl implements SchdlDao {

	@Override
	public List<Schdl> seletAll(Connection conn) {
	
		System.out.println("SchdlDaoImpl get");

	
		PreparedStatement ps = null;  
		ResultSet rs = null;
	
		String sql = "";
		sql += "SELECT * FROM TB_SCHEDULE";
		sql += " ORDER BY SCHDL_NO";
	
		List<Schdl> SchdlList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); 
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Schdl schdl = new Schdl();
				
				schdl.setSchdl_no(rs.getInt("schdl_no"));
				schdl.setSchdl_type(rs.getInt("schdl_type"));
				schdl.setUser_no(rs.getInt("user_no"));
				schdl.setSchdl_title(rs.getString("schdl_title"));
				schdl.setSchdl_content(rs.getString("schdl_content"));
				schdl.setSchdl_start(rs.getDate("schdl_start"));
				schdl.setSchdl_end(rs.getDate("schdl_end"));
				schdl.setRevision_date(rs.getDate("revision_date"));
				schdl.setTable_no(rs.getInt("table_no"));

				
				SchdlList.add(schdl);

			}
				
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
		return SchdlList;
		
		
		
	}

	
}
