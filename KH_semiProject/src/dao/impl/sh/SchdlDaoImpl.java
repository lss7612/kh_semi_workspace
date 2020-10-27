package dao.impl.sh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.face.SchdlDao;
import dto.Schdl;


public class SchdlDaoImpl implements SchdlDao {

	@Override
	public List<Schdl> seletAll(Connection conn) {
	
		System.out.println("�뒪耳�以� �떎�삤 �쟾泥� �샇異�");

	
		PreparedStatement ps = null;  //sql �닔�뻾 媛앹껜
		ResultSet rs = null;
	
		//SQL �옉�꽦
		String sql = "";
		sql += "SELECT * FROM TB_SCHEDULE";
		sql += " ORDER BY SCHDL_NO";
	
		//議고쉶 寃곌낵 ���옣 由ъ뒪�듃 媛앹껜	
		List<Schdl> SchdlList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); // sql �닔�뻾 媛앹껜 �깮�꽦
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				//�깉濡쒖슫 鍮꾩뼱�엳�뒗 schdl 媛앹껜 �깮寃�
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

				
				//議고쉶 寃곌낵 �떞湲�
				SchdlList.add(schdl);

			}
				
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
		//議고쉶 寃곌낵 諛섑솚
		return SchdlList;
		
		
		
	}

	
}
