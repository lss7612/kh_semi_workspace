package service.impl.note;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import dao.face.note.NoteRestoreDao;
import dao.impl.note.NoteRestoreDaoImpl;
import service.face.note.NoteRestoreService;

public class NoteRestoreServiceImpl implements NoteRestoreService{
	
	NoteRestoreDao noteRestoreDao = new NoteRestoreDaoImpl();
	
	Connection conn = null;

	@Override
	public List<Integer> getNoteNos(HttpServletRequest req) {

		List<Integer> result = new ArrayList<>();
		
		for(int i = 0; i < 15; i++) { //한페이지 최대 게시물(15개)기준
			
			String str = "note_no" + i;
			
			
			if(req.getParameter(str)!=null) {
				result.add(Integer.parseInt(req.getParameter(str)));
				
			} else {
				continue;
				
			}
			
		}
		return result;
		
	}

	@Override
	public int restoreReceivedNote(List<Integer> note_nos, int user_no) {

		int result = 0;
		int cnt = 0;
		conn = JDBCTemplate.getConnection();
		
		
		for(int i = 0; i < note_nos.size(); i++) {
			
			int note_no = note_nos.get(i);
			System.out.println("notenosgetI: "+ note_nos.get(i));
			result = noteRestoreDao.restoreReceivedNote(conn, note_no, user_no);
			
			
			if(result == 0) {
				
				System.out.println(i+"번쨰 노트 복구할 때 오류 발생");
				break;
				
			}
			cnt++;
		}
		
		
		if(result>0) {
			JDBCTemplate.commit(conn);
			System.out.println(cnt+"줄 업데이트 완료");
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		
		return result;
	}

	@Override
	public int restoreSendNote(List<Integer> note_nos, int user_no) { 

		int result = 0;
		int cnt = 0;
		conn = JDBCTemplate.getConnection();
		
		
		for(int i = 0; i < note_nos.size(); i++) {
			
			int note_no = note_nos.get(i);
			System.out.println("notenosgetI: "+ note_nos.get(i));
			result = noteRestoreDao.restoreSendNote(conn, note_no, user_no);
			
			
			if(result == 0) {
				
				System.out.println(i+"번쨰 노트 복구할 때 오류 발생");
				break;
				
			}
			cnt++;
		}
		
		
		if(result>0) {
			JDBCTemplate.commit(conn);
			System.out.println(cnt+"줄 업데이트 완료");
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		
		return result;
	}

}
