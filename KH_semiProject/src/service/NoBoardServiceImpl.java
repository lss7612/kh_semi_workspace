package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import common.Paging;
import dao.NoBoardDao;
import dao.NoBoardDaoImpl;
import dto.Bbs;

public class NoBoardServiceImpl implements NoBoardService {
	
	private NoBoardDao noBoardDao = new NoBoardDaoImpl();

	@Override
	public List<Bbs> getList() {
		return noBoardDao.selectList(JDBCTemplate.getConnection());
	}
	

	@Override
	public Paging getPaging(HttpServletRequest req) {
		//전달파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
				
		//Board 테이블의 총 게시글 수를 조회한다
		int totalCount = noBoardDao.selectCntAll(JDBCTemplate.getConnection());
				
		//Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage); 
				
		//계산된 Paging 객체 반환
		return paging;
	}

	
	@Override
	public List<Bbs> getList(Paging paging) {
		return noBoardDao.selectList(JDBCTemplate.getConnection(), paging);
	}
	
	

}
