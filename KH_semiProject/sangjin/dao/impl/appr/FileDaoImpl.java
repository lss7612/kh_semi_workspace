package dao.impl.appr;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import dao.appr.FileDao;
import dto.appr.Appr;
import dto.appr.ApprFile;

public class FileDaoImpl implements FileDao {

	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public int insertParam(Connection connection, Appr appr) {
		String sql = "";
		sql += "INSERT INTO TB_APPROVAL(APRVL_NO,USER_NO,MID_AUTH,FINAL_AUTH,APRVL_STATE,CREATE_DATE,\r\n"
				+ "FINAL_DATE,APRVL_TYPE,APRVL_TITLE,APRVL_ARTICLE,TABLE_NO,HOLIDAY_START,HOLIDAY_END,APPR_HOLI_KIND)";
		sql += " VALUES(TB_APPROVAL_SEQ.nextval,4,1,5,1,'20-10-28','20-10-30' ,?,?,?,70,SUBSTR(?, 1, 8),SUBSTR(?, 1, 8),?)";
		System.out.println(sql);

		/// 해야할거 ??넣기 ,aprvl_type... 현재시각~마감시각 받아서 넣기

		int result = 0;

		try {
			
		    
//		    Date start_day = new java.sql.Date(appr.getHoliday_start().getTime());
//		    Date end_day = new java.sql.Date(appr.getHoliday_end().getTime());
		    System.out.println("--------------------------------");
		    System.out.println(appr.getAprvl_type());
		    System.out.println(appr.getAprvl_title());
		    System.out.println(appr.getAprvl_article());
		    System.out.println(appr.getAprvl_type());
//		    System.out.println(start_day);
//		    System.out.println(end_day);
		    System.out.println(appr.getAppr_holi_kind());
		    
			ps = connection.prepareStatement(sql);
			ps.setString(1, appr.getAprvl_type());
			ps.setString(2, appr.getAprvl_title());
			ps.setString(3, appr.getAprvl_article());
			ps.setTimestamp(4, appr.getHoliday_start());
			ps.setTimestamp(5,  appr.getHoliday_end());
			ps.setString(6, appr.getAppr_holi_kind());

			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("파라미터 인서트 오류");
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		return result;
	}

	@Override
	public int insertFile(Connection connection, ApprFile uploadFile) {
		String sql = "";
		sql += "insert into tb_approvalAttdfile(table_no,aprvl_no,file_addr,origin_name,stored_name)";
		sql += " select 70, (SELECT * FROM( SELECT aprvl_no FROM tb_approval ORDER BY ROWNUM DESC)";
		sql += " WHERE ROWNUM = 1)as a,?,?,? from dual";
		System.out.println(sql);
		int result = 0;

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, uploadFile.getFile_addr());
			ps.setString(2, uploadFile.getOrigin_name());
			ps.setString(3, uploadFile.getStored_name());

			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("파일테이블인서트오류");
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		return result;
	}

}
