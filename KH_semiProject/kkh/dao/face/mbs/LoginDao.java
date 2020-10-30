package dao.face.mbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.JDBCTemplate;

public class LoginDao {

	public String loginCheck(String user_id, String user_pw) {
		Connection conn = JDBCTemplate.getConnection(); 
	    String user_name = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
			
	    try {
	      String SQL = "SELECT user_name FROM tb_user WHERE user_id=? and user_pw=?";
	      pstmt = conn.prepareStatement(SQL);
	      pstmt.setString(1, user_id);
	      pstmt.setString(2, user_pw);
				
	      rs = pstmt.executeQuery();
	      if(rs.next()) {
	    	  user_name = rs.getString("user_name");
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      try {
	        if(rs != null)
	          rs.close();
	      } catch (Exception e2) {
	        e2.printStackTrace();
	      }
	    }
			
	    return user_name;
	  }
	}