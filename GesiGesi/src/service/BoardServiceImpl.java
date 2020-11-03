package service;

import java.sql.Connection;

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

}
