package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import dto.ParamData;
import dto.UploadFile;

public class NoFileDaoImpl implements NoFileDao{
	
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	
	
	public int insertParam(Connection conn, ParamData paramData) {
		String sql = "";
		sql += "insert into paramdata(datano, title, data1)";
		sql += " values(paramdata_seq.nextval, ?, ?)";
		
		int result = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, paramData.getTitle());
			ps.setString(2, paramData.getTitle());
			ps.setString(3, paramData.getTitle());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return result;
		
	}



	@Override
	public int insertFile(Connection conn, UploadFile uploadFile) {
		
		String sql = "";
		sql += "insert into tb_noticeAttdfile(file_no, table_no, article_no, file_addr, origin_name, stored_name";
		sql += " values (tb_noticeAttdfile_seq, 81, ?, ?, ?, ?)";
		
		int result = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uploadFile.getArticle_no());
			ps.setString(2, uploadFile.getFile_addr());
			ps.setString(3, uploadFile.getOrigin_name());
			ps.setString(4, uploadFile.getStored_name());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return result;
		
	}


		
	

	
	
	
	

}
