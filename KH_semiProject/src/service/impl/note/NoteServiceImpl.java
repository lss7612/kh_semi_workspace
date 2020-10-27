package service.impl.note;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import dao.face.addr.AddrViewDao;
import dao.face.note.NoteDao;
import dao.impl.addr.AddrViewDaoImpl;
import dao.impl.note.NoteDaoImpl;
import dto.note.NoteCreateData;
import dto.note.NoteList;
import dto.note.NoteReceiverView;
import service.face.note.NoteService;

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
		result.setUser_ip("1234.1234.1234.1234");
		
		
		int cnt = addrViewDao.selectCntAll(conn);
		
		
		List<Integer> receiver = new ArrayList<>();
		for(int i=0; i < cnt; i++) {
			//String str = "receiver" + i;
			//System.out.println(str);
			
			if(req.getParameter("receiver"+i)==null) {
				break;
			}
			
			receiver.add( Integer.parseInt( req.getParameter("receiver"+i) ));
			
		}
		
		//System.out.println(receiver);
		
		result.setReceiver(receiver);
		
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
			System.out.println("insertNote가 제대로 실행되지 않았습니다.");
		}
		
		return result;
		
	}

	@Override
	public List<NoteList> getReceivedList(HttpServletRequest req) {

		List<NoteList> result = null;
		
		conn=JDBCTemplate.getConnection();
		result = noteDao.getReceivedList(conn, req);
		
		return result;
	
	}

	@Override
	public List<NoteList> getSendList(HttpServletRequest req) {

		List<NoteList> result = null;
		
		conn=JDBCTemplate.getConnection();
		result = noteDao.getSendList(conn, req);
		
		return result;
	
	}

}
