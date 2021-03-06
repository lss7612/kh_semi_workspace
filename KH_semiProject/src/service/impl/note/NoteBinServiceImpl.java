package service.impl.note;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import common.Paging;
import dao.face.note.NoteBinDao;
import dao.impl.note.NoteBinDaoImpl;
import dto.note.NoteList;
import dto.note.NotePaging;
import service.face.note.NoteBinService;

public class NoteBinServiceImpl implements NoteBinService{
	
	NoteBinDao noteBinDao = new NoteBinDaoImpl();
	Connection conn = null;

	@Override
	public NotePaging getSendPaging(HttpServletRequest req) {
		
		NotePaging result = null;
		
		String param = req.getParameter("curPage");
		int curPage = 0;
		if(param!=null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		Connection conn = JDBCTemplate.getConnection();
		int totalCount = noteBinDao.selectCntSend(conn);
		
		
		int listCount = 15; //한페이지에 게시물이 최대 몇개를 쓸 수 있는지
		
		result = new NotePaging(totalCount, curPage, listCount);
		
		return result;
	}

	@Override
	public List<NoteList> getSendList(HttpServletRequest req, NotePaging paging) {

		List<NoteList> result = null;
		
		
		conn=JDBCTemplate.getConnection();
		result = noteBinDao.getSendBinList(conn, req, paging);
		
		
		return result;
	
	}

	@Override
	public Paging getReceivedPaging(HttpServletRequest req) {  
		
		Paging result = null;
		
		String param = req.getParameter("curPage");
		int curPage = 0;
		if(param!=null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		Connection conn = JDBCTemplate.getConnection();
		int totalCount = noteBinDao.selectCntReceived(conn);
		
		int listCount = 15; //한페이지에 게시물이 최대 몇개를 쓸 수 있는지
		
		result = new Paging(totalCount, curPage, listCount);
		
		return result;
	}

	@Override
	public List<NoteList> getReceivedList(HttpServletRequest req, Paging paging) {  

		List<NoteList> result = null;
		
		conn=JDBCTemplate.getConnection();
		result = noteBinDao.getReceivedList(conn, req, paging);
		
		return result;
	
	}
	
	

}
