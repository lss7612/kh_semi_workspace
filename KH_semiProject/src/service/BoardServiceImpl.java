package service;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import com.sun.xml.internal.ws.Closeable;

import bbs.BbsDAO;
import common.JDBCTemplate;
import dao.BoardDao;
import dto.Bbs;

public class BoardServiceImpl implements BoardService {
	
	private BoardDao boardDao = new BbsDAO();
	
	@Override
	public Bbs detail(Bbs bbs) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Bbs res = boardDao.selectByNo(conn, bbs);
		
		return res;
		
	}

	
	
	@Override
	public Bbs noWrite(Bbs param) {

		Connection conn = JDBCTemplate.getConnection();
		
		int res = boardDao.write(conn, param);
		
		if(res==1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		return param;
		
	}



	@Override
	public void noWrite(int user_no, String article_title, String article_content) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int rese = boardDao.insertNo(conn, user_no, article_title, article_content);
		
		if(rese==1) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
	}




}
