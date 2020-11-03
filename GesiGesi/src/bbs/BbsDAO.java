package bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.JDBCTemplate;
import dao.BoardDao;
import dto.Bbs;

public class BbsDAO implements BoardDao {
	
	private static BbsDAO bbsDao = new BbsDAO();
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
	
	
	public int write(int user_no, String article_title, String article_content) {
		String sql = "";
		sql += "insert into tb_board(table_no, article_no, user_no, article_title, article_content, revision_date, isDelete)";
		sql += " values(21, ?, ?, ?, ?, ?, ?)";
		
//		Integer.toString(user_no);
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, getNext());
			ps.setInt(2, user_no);
			ps.setString(3, article_title);
			ps.setString(4, article_content);
			ps.setString(5, getDate());
			ps.setInt(6, 1);
			
			return ps.executeUpdate();
			
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
	    sql += " WHERE article_no <? and isDelete = 1 ORDER BY article_no DESC) WHERE ROWNUM<=10";
		
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
//	public Bbs getBbs(int article_no) {
//		String sql = "";
//		sql += "select article_no, article_title, User_no, revision_date, article_content, Isdelete from tb_board";
//		sql += " where article_no = ?";
//		
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		Bbs bbs = null;
//		
//		try {
//			conn = JDBCTemplate.getConnection();
//			ps = conn.prepareStatement(sql);
////			ps.setInt(1, Integer.parseInt(article_no));
//			ps.setInt(1, article_no);
////			System.out.println("에러있나요?");
//			rs = ps.executeQuery();
//			
//			if(rs.next()) {
//				bbs = new Bbs();
//				bbs.setArticle_no(rs.getInt("article_no"));;
//				bbs.setArticle_title(rs.getString("article_title"));
//				bbs.setUser_no(rs.getInt("user_no"));
//				bbs.setRevision_date(rs.getTimestamp("revision_date"));
//				bbs.setArticle_content(rs.getString("article_content"));
//				bbs.setIsdelete(rs.getInt("isdelete"));
//				
//			}
//			
////			System.out.println("문제있나요?");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			JDBCTemplate.close(conn);
//		}
//		return bbs;
////		return null;
//	}
	
	
	@Override
	public Bbs selectByNo(Connection conn, Bbs bbs) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
//		System.out.println("BbsDAO selectByNo - " + bbs);
		String sql = "";
		sql += "select article_no, article_title, User_no, revision_date, article_content, Isdelete from tb_board";
		sql += " where article_no = ?";
		
		Bbs res = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bbs.getArticle_no());
//			System.out.println("에러있나요?");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				res = new Bbs();
				res.setArticle_no(rs.getInt("article_no"));;
				res.setArticle_title(rs.getString("article_title"));
				res.setUser_no(rs.getInt("user_no"));
				res.setRevision_date(rs.getTimestamp("revision_date"));
				res.setArticle_content(rs.getString("article_content"));
				res.setIsdelete(rs.getInt("isdelete"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return res;
	}
	
	
//	int user_id, String article_title, String article_content
	//수정 
//	public int updatebbs(Bbs bbs) {
//		int rowCount = 0;
//		Connection conn = null;
//		PreparedStatement ps = null;
//		String sql = "";
//		sql += "update tb_board set article_title = ?, article_content = ? where article_no = ?";
//		try {
//			conn = JDBCTemplate.getConnection();
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, bbs.getArticle_title());
//			ps.setString(2, bbs.getArticle_content());
//			ps.setInt(3, bbs.getArticle_no());
//			rowCount = ps.executeUpdate();
//
//		} catch (Exception e) {
//				e.printStackTrace();
//		} finally {
//			JDBCTemplate.close(ps);
//			JDBCTemplate.close(conn);
//		}
//		
//		return rowCount;
//
//	}
	
	
	//삭제
//	public int deleteBoard(int article_no) {
//		String sql = "";
//		sql += "update tb_board set isDelete = 0";
//		sql += " where article_no = ?";
//		
//		try {
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, article_no);
//			return ps.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
//		
//		return -1;
//	}
	
	public int update(Connection conn, Bbs bbs) {
		PreparedStatement ps = null;
		String sql = "";
		sql += "update tb_board set article_title = ?, article_content = ? where article_no = ?";
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, bbs.getArticle_title());
			ps.setString(2, bbs.getArticle_content());
			ps.setInt(3, bbs.getArticle_no());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		return result;
	}
	
	
	
	
	public static BbsDAO getInstance() {
		return bbsDao;
	}
	
	
	


@Override
public void updatebbs(Connection conn, Bbs updatebbs) {
	// TODO Auto-generated method stub
	
}



	

}
