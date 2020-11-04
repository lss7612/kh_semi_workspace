package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import common.Paging;
import dto.Bbs;

public class NoBoardDaoImpl implements NoBoardDao {
	
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public List<Bbs> selectList(Connection connection){
		
		String sql = "";
		sql += "select b.table_no, article_no, article_title, b.User_no, b.revision_date, article_content, Isdelete, u.user_name";
		sql += " from tb_board b, tb_user u";
		sql += " where b.user_no = u.user_no";
		sql += " and Isdelete = 1";
		sql += " and b.table_no = 30";
		sql += " order by article_no desc";
			
//		sql += "select * from";
//		sql += " (select article_no, article_title, User_no, revision_date, article_content, Isdelete from tb_board)";
//		sql += " order by article_no desc";
		
		//조회 결과를 저장할 List
		List<Bbs> list = new ArrayList<>();
		
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Bbs bbs = new Bbs();
				
				bbs.setArticle_no(rs.getInt("article_no"));;
				bbs.setArticle_title(rs.getString("article_title"));
				bbs.setUser_no(rs.getString("user_no"));
				bbs.setRevision_date(rs.getTimestamp("revision_date"));
				bbs.setArticle_content(rs.getString("article_content"));
				bbs.setIsdelete(rs.getInt("isdelete"));
				bbs.setUser_name(rs.getString("user_name"));
				
				list.add(bbs);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return list;
		
	}

	
	

	@Override
	public int selectCntAll(Connection connection) {

		String sql = "";
		sql += "select count(*) from tb_board";
		sql += " where table_no = 30";
		
		int totalCount = 0;
		
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				totalCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return totalCount;
		
	}
	
	
	

	@Override
	public List<Bbs> selectList(Connection connection, Paging paging) {
		
		String sql = "";
		sql += "select * from(";
		sql += " select rownum rnum, b.* from (";
		sql += "  select";
		sql += "	b.table_no, article_no, article_title, b.User_no, b.revision_date, article_content, Isdelete, u.user_name";
		sql += "	 from tb_board b, tb_user u";
		sql += "	    where b.user_no = u.user_no";
		sql += "    order by article_no desc";
		sql += "	)B";
		sql += "  )tb_board";
		sql += " where rnum between ? and ?";
		sql += " and isdelete=1";
		sql += " and table_no = 30";
		
		//결과 저장할 List
		List<Bbs> boardList = new ArrayList<>();
		
		try {
			ps = connection.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				Bbs b = new Bbs();
				
				//결과값 한 행 처리
				b.setArticle_no(rs.getInt("article_no"));
				b.setArticle_title(rs.getString("article_title"));
				b.setUser_no(rs.getString("user_no"));
				b.setRevision_date(rs.getTimestamp("revision_date"));
				b.setArticle_content(rs.getString("article_content"));
				b.setIsdelete(rs.getInt("isdelete"));
				b.setUser_name(rs.getString("user_name"));
				
				//리스트에 결과값 저장
				boardList.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return boardList;
		
	}
	
	
	
	@Override
	public int anselectCntAll(Connection connection) {

		String sql = "";
		sql += "select count(*) from tb_board";
		sql += " where table_no = 20";
		
		int totalCount = 0;
		
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				totalCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return totalCount;	

	}
	
	
	
	@Override
	public List<Bbs> anselectList(Connection connection, Paging paging) {
		String sql = "";
		sql += "select * from(";
		sql += " select rownum rnum, b.* from (";
		sql += "  select";
		sql += "	b.table_no, article_no, article_title, article_pw, b.revision_date, article_content, Isdelete";
		sql += "	 from tb_board b, tb_user u";
		sql += "	    where b.user_no = u.user_no";
		sql += "    order by article_no desc";
		sql += "	)B";
		sql += "  )tb_board";
		sql += " where rnum between ? and ?";
		sql += " and isdelete=1";
		sql += " and table_no = 20";
		
		//결과 저장할 List
		List<Bbs> boardList = new ArrayList<>();
		
		try {
			ps = connection.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				Bbs b = new Bbs();
				
				//결과값 한 행 처리
				b.setArticle_no(rs.getInt("article_no"));
				b.setArticle_title(rs.getString("article_title"));
				b.setRevision_date(rs.getTimestamp("revision_date"));
				b.setArticle_content(rs.getString("article_content"));
				b.setIsdelete(rs.getInt("isdelete"));
				b.setArticle_pw(rs.getString("article_pw"));
				
				//리스트에 결과값 저장
				boardList.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return boardList;
	}

}
