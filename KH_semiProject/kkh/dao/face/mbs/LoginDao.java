package dao.face.mbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import dto.mbs.Login;

public class LoginDao{
   
   

   Connection conn = JDBCTemplate.getConnection(); 
    String user_name = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    int user_grade = 0;
    
   
   public ArrayList<Login> getListMember(){
      
      ArrayList<Login> list = new ArrayList<Login>();

      String sql = "";
      sql += "SELECT * FROM tb_user";
//      sql += "LEFT OUTER JOIN TB_GRADE B";
//      sql += " ON a.user_grade = B.GRADE_NO";
//      sql += " WHERE A.USER_GRADE=2";
      
      
      try {
          pstmt =conn.prepareStatement(sql);
               
            rs = pstmt.executeQuery();
            while(rs.next()) {
              
               
               String user_id = rs.getString("user_id");
               String user_pw = rs.getString("user_pw");
               String user_name = rs.getString("user_name");
               int user_grade = rs.getInt("user_grade");
               
               Login vo = new Login(user_id, user_pw, user_name, user_grade);
               
               list.add(vo);
            }
            
            return list;
            
          } catch (SQLException e) {
            e.printStackTrace();
            return null;
            
          } finally {
             JDBCTemplate.close(rs);
            JDBCTemplate.close(pstmt);
          }
            
            
      
   }
   

   

   public int gradeCheck(String user_id, String user_pw) {
      
      //로그인체크
      
         
       try {
         String SQL = "SELECT user_grade FROM tb_user WHERE user_id=? and user_pw=? ";
         pstmt = conn.prepareStatement(SQL);
         pstmt.setString(1, user_id);
         pstmt.setString(2, user_pw);
            
         rs = pstmt.executeQuery();
         if(rs.next()) {
            user_grade = rs.getInt("user_grade");
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
         
       return user_grade;
     }
   public String loginCheck(String user_id, String user_pw) {
	      
	      //로그인체크
	      
	         
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
	   
    public String loginCheck(String user_id, String user_pw, int user_grade) {
      
      //로그인체크
      
         
       try {
         String SQL = "SELECT user_name FROM tb_user WHERE user_id=? and user_pw=? and user_grade=?";
         pstmt = conn.prepareStatement(SQL);
         pstmt.setString(1, user_id);
         pstmt.setString(2, user_pw);
         pstmt.setInt(3, user_grade);
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