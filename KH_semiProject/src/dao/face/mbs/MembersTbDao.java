package dao.face.mbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.mbs.MembersTb;

public class MembersTbDao {
	
	  // 회원 목록을 List 형식으로 리턴
	  public List<MembersTb> memberList() {
	  
	  // List 객체를 인스턴스 합니다.
	  List<MemberDTO> list = new ArrayList<MemberDTO>();
			
	  Connection conn = null;	// DB접속
	  PreparedStatement pstmt = null; // SQL실행
	  ResultSet rs = null; // select의 결과 처리
			
	  try {
	      conn = DataBase.getConnection();
	      String sql = "SELECT * FROM user";
	      pstmt = conn.prepareStatement(sql);
	      rs = pstmt.executeQuery();
				
	      while(rs.next()) { // 다음 레코드가 있으면 실행
	        String userid = rs.getString("userid");
	        String password = rs.getString("password");
	        String name = rs.getString("name");
	        String address = rs.getString("address");
	        String tel = rs.getString("tel");
					
	        MemberDTO dto = new MemberDTO(userid, password, name, address, tel);
					
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
