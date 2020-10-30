package dao.face.mbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import dto.mbs.MembersTb;

public interface MembersTbDao {
	
	//회원목록  list 형식
	List<MembersTb> memberList();
	
	
	 // List 객체를 인스턴스 합니다.
	  List<MembersTb> list = new ArrayList<MembersTb>();
	  Connection conn = JDBCTemplate.getConnection(); 
	  PreparedStatement pstmt = null; // SQL실행
	  ResultSet rs = null; // select의 결과 처리
			
	  try {
	      String sql = "SELECT * FROM user";
	      pstmt = conn.prepareStatement(sql);
	      rs = pstmt.executeQuery();
				
	      while(rs.next()) { // 다음 레코드가 있으면 실행
	        String user_id = rs.getString("user_id");
	        String user_pw = rs.getString("user_pw");
	        String user_name = rs.getString("user_name");
	        String identify = rs.getString("identify");
	        String cellphone_no = rs.getString("cellphone_no");
	        
	        param.setUser_addr(req.getParameter("user_addr"));		
			param.setUser_notice(req.getParameter("user_notice"));
			param.setUser_addr2(req.getParameter("user_addr2"));
			param.setUser_addr3(req.getParameter("user_addr3"));
	        
	        
					
	        MembersTb dto = new MembersTb(userid, password, name, address, tel);
					
	        // SQL 결과를 list 에 저장합니다.
	        list.add(dto);
	        
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	    
	      // 열어주었던 값들을 전부 닫아줍니다.
	      try {
	        if(rs != null)
	          rs.close();
	      } catch (Exception e2) {
	        e2.printStackTrace();
	      }
				
	      try {
	        if(pstmt != null)
	          pstmt.close();
	      } catch (Exception e2) {
	        e2.printStackTrace();
	      }
				
	      try {
	        if(conn != null)
	          conn.close();
	      } catch (Exception e2) {
	        e2.printStackTrace();
	      }
	    }
			
	    return list;
	  }

}
