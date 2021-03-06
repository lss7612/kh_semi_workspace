package service.impl.note;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import common.Paging;
import dao.face.addr.AddrViewDao;
import dao.face.note.NoteDao;
import dao.impl.addr.AddrViewDaoImpl;
import dao.impl.note.NoteDaoImpl;
import dto.note.NoteCreateData;
import dto.note.NoteList;
import dto.note.NotePaging;
import dto.note.NoteReceiverView;
import service.face.note.NoteService;
import dto.addr.AddrView;

public class NoteServiceImpl implements NoteService{

	Connection conn = null;
	NoteDao noteDao = new NoteDaoImpl();
	AddrViewDao addrViewDao = new AddrViewDaoImpl();
	
	@Override
	public List<NoteReceiverView> getManUser() {
		
		List<NoteReceiverView> result = null;
		conn = JDBCTemplate.getConnection();
		
		result = noteDao.getManUser(conn);
		
		return result;
	}

	@Override
	public List<NoteReceiverView> getAccUser() {
		
		List<NoteReceiverView> result = null;
		conn = JDBCTemplate.getConnection();
		
		result = noteDao.getAccUser(conn);
		
		return result;
	}

	@Override
	public List<NoteReceiverView> getHrUser() {
		
		List<NoteReceiverView> result = null;
		conn = JDBCTemplate.getConnection();
		
		result = noteDao.getHrUser(conn);
		return result;
	}

	@Override
	public List<NoteReceiverView> getDevUser() {
		
		List<NoteReceiverView> result = null;
		conn = JDBCTemplate.getConnection();
		
		result = noteDao.getDevUser(conn);
		return result;
	}

	@Override
	public List<NoteReceiverView> getSalesUser() {
		
		List<NoteReceiverView> result = null;
		conn = JDBCTemplate.getConnection();
		
		result = noteDao.getSalesUser(conn);
		return result;
	}

	
	@Override
	public List<Integer> getSelectedUserList(HttpServletRequest req) {

		List<Integer> result = new ArrayList<>();
		
		for(int i=0; i < 15; i++) {//페이징최대수 15까지 가능
			
			if(req.getParameter("receiver_no"+i)==null) {
				continue;
			}
			
			result.add( Integer.parseInt( req.getParameter("receiver_no"+i) ));
			
		}
		
		System.out.println(result);
		
		return result;
	}
	

	@Override
	public List<String> getSelectedUserNameList(HttpServletRequest req) {

		List<String> result = new ArrayList<>();
		
		for(int i=0; i < 15; i++) {//페이징최대수 15까지 가능
			
			if(req.getParameter("receiver_name"+i)==null) {
				continue;
			}
			
			result.add(req.getParameter("receiver_name"+i));
			
		}
		
		System.out.println(result);
		
		return result;
	}
	
	
	
	@Override
	public NoteCreateData getNCDparams(HttpServletRequest req) {

		NoteCreateData result = new NoteCreateData();
		conn =JDBCTemplate.getConnection();
		
		
		int nextval = noteDao.getNextval(conn);
		
		result.setNote_no(nextval);
		result.setIsDelete(0);
		result.setNote_article(req.getParameter("article"));
		result.setNote_title(req.getParameter("title"));
		result.setSender(1);
		result.setTable_no(60);
		result.setUser_ip("1234.1234.1234.1234"); //세션에서 아이피를 받아야함
		
		
		int cnt = addrViewDao.selectCntAll(conn);
		
		
		List<Integer> receiver = new ArrayList<>();
		for(int i=-15; i < cnt; i++) {
			
			if(i<0) {
			
				if(req.getParameter("receiver"+i)==null) {
					continue;
				}
				
			} else {
				
				if(req.getParameter("receiver"+i)==null) {
					break;
				}
				
			}
			
			receiver.add( Integer.parseInt( req.getParameter("receiver"+i) ));
			
		}
		
		result.setReceiver(receiver);
		
		System.out.println(result);
		return result;
	
	}

	@Override
	public int insertNote(NoteCreateData params) {

		int result = 0;
		
		conn = JDBCTemplate.getConnection();
		int result1 = noteDao.insertNote(params, conn);
		
		int result2 = noteDao.insertSendNote(params,conn);
		
		int result3 = noteDao.insertReceivedNote(params,conn);
		
		
		
		if(result1 > 0 && result2 > 0 && result3 >0) {
			result=1;
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
			System.out.println("insertNote가 제대로 실행되지 않았습니다..");
		}
		
		return result;
		
	}

	@Override
	public List<NoteList> getReceivedList(HttpServletRequest req, Paging paging) {  

		List<NoteList> result = null;
		
		conn=JDBCTemplate.getConnection();
		result = noteDao.getReceivedList(conn, req, paging);
		
		return result;
	
	}

	@Override
	public List<NoteList> getSendList(HttpServletRequest req, NotePaging paging) {

		List<NoteList> result = null;
		
		
		conn=JDBCTemplate.getConnection();
		result = noteDao.getSendList(conn, req, paging);
		
		
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
		int totalCount = noteDao.selectCntReceived(conn);
		
		int listCount = 15; //한페이지에 게시물이 최대 몇개를 쓸 수 있는지
		
		result = new Paging(totalCount, curPage, listCount);
		
		return result;
	}

	@Override
	public NotePaging getSendPaging(HttpServletRequest req) {
		
		NotePaging result = null;
		
		String param = req.getParameter("curPage");
		int curPage = 0;
		if(param!=null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		Connection conn = JDBCTemplate.getConnection();
		int totalCount = noteDao.selectCntSend(conn);
		
		
		int listCount = 15; //한페이지에 게시물이 최대 몇개를 쓸 수 있는지
		
		result = new NotePaging(totalCount, curPage, listCount);
		
		return result;
	}

	@Override
	public int deleteReceivedNote(HttpServletRequest req, int user_no, int note_no) {

		int result = 0;
		
		conn=JDBCTemplate.getConnection();
		
		result = noteDao.deleteReceivedNote(conn, user_no, note_no);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		return result;
		
	}

	@Override
	public NoteList getNoteView(int note_no) {

		NoteList result = new NoteList();
		
		conn = JDBCTemplate.getConnection();
		List<AddrView> receivers = noteDao.getReceivers(conn, note_no);
		
		result = noteDao.getNoteView(conn, note_no);
		result.setReceivers(receivers);
		
		return result;
			
	}


	


}
