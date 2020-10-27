package bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;

import dto.Bbs;

public class BbsDAO {
	
	private Connection conn;
	private ResultSet rs;
	
	public BbsDAO() {
		try {
			String URL = "jdbc:oracle:thin:@localhost:1521:xe";
			String USERNAME = "scott";
			String PASSWORD = "tiger";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//시간 가져오기
	public String getDate() {
		String sql = "";
		sql += "select sysdate FROM tb_board";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "삐용삐용"; //데이터베이스 오류
	}
	
	
	public int getNext() {
		String sql = "";
		sql += "select article_no from tb_board";
		sql += " order by article_no desc";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1)+1;
			}
			return 1; //첫번째 게시물인 경우
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;// 데이터베이스 오류
	}
	
	
	public int write(String article_title, int user_no, String article_content) {
		String sql = "";
		sql += "insert into tb_board(table_no, article_no, user_no, article_title, article_content, revision_date, isDelete)";
		sql += " values('1', article_no_sq, ?, ?, ?, ?, ?)";
		
//		String to = Integer.toString(user_no);
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user_no);
			ps.setString(2, article_title);
			ps.setString(3, article_content);
			ps.setString(4, getDate());
			ps.setInt(5, 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	
	//글 목록 가져오기
	public ArrayList<Bbs> getList(int pageNumber){
		String sql = "";
//		sql += "select * from (select * from tb_board WHERE article_no <? and isDelete=1 ORDER BY article_no DESC) WHERE ROWNUM<=10";
		
		sql += "select * from";
		sql += " (select article_no, article_title, User_no, revision_date, article_content, Isdelete from tb_board";
	    sql += " WHERE article_no <? and isDelete=1 ORDER BY article_no DESC) WHERE ROWNUM<=10";
		
		ArrayList<Bbs> list = new ArrayList<Bbs>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, getNext() - (pageNumber -1) * 10);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Bbs bbs = new Bbs();
				bbs.setArticle_no(rs.getInt("article_no"));;
				bbs.setArticle_title(rs.getString("article_title"));
				bbs.setUser_no(rs.getString("user_no"));
				bbs.setRevision_date(rs.getTimestamp("revision_date"));
				bbs.setArticle_content(rs.getString("article_content"));
				bbs.setIsdelete(rs.getInt("isdelete"));
				list.add(bbs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public boolean nextPage(int pageNumber) {
		
		String sql = "";
		sql += "select * from (select * from tb_board WHERE article_no <? and isDelete=1 ORDER BY article_no DESC) where rownum<=10";
		
		ArrayList<Bbs> list = new ArrayList<Bbs>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, getNext() - (pageNumber-1) * 10);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	//글 내용 가져오기
	public Bbs getBbs(int article_no) {
		String sql = "";
		sql += "select article_no, article_title, User_no, revision_date, article_content, Isdelete from tb_board";
		sql += " where article_no = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, article_no);
//			System.out.println("에러있나요?");
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Bbs bbs = new Bbs();
				bbs.setArticle_no(rs.getInt(1));;
				bbs.setArticle_title(rs.getString(2));
				bbs.setUser_no(rs.getInt(3));
				bbs.setRevision_date(rs.getTimestamp(4));
				bbs.setArticle_content(rs.getString(5));
				bbs.setIsdelete(rs.getInt(6));
				return bbs;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
//	//수정 
//	public int update(int user_id, String article_title, String article_content) {
//		String sql = "";
//		sql += "update tb_board set article_title = ?, article_content = ? where article_no = ?";
//		try {
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, article_title);
//			ps.setString(2, article_content);
//			ps.setInt(3, article_no);
//			return ps.executeUpdate();
//
//		} catch (Exception e) {
//				e.printStackTrace();
//		}
//		
//		return -1; // 데이터베이스 오류
//	}
	
	

}
