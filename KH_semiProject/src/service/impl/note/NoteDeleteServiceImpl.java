package service.impl.note;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import dao.face.note.NoteDeleteDao;
import dao.impl.note.NoteDeleteDaoImpl;
import service.face.note.NoteDeleteService;

public class NoteDeleteServiceImpl implements NoteDeleteService{

	NoteDeleteDao noteDeleteDao = new NoteDeleteDaoImpl();
	
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
	public int deleteSendNote(List<Integer> note_nos, int user_no) { 

		int result = 0;
		int cnt = 0;
		conn = JDBCTemplate.getConnection();
		
		
		for(int i = 0; i < note_nos.size(); i++) {
			
			int note_no = note_nos.get(i);
			System.out.println("notenosgetI: "+ note_nos.get(i));
			result = noteDeleteDao.deleteSendNote(conn, note_no, user_no);
			
			
			if(result == 0) {
				
				System.out.println(i+"번쨰 노트 지울때 오류 발생");
				break;
				
			}
			cnt++;
		}
		
		
		if(result>0) {
			JDBCTemplate.commit(conn);
			System.out.println(cnt+"줄 인서트 완료");
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		
		return result;
	}




	@Override
	public int deleteReceivedNote(List<Integer> note_nos, int user_no) {

		int result = 0;
		int cnt = 0;
		conn = JDBCTemplate.getConnection();
		
		
		for(int i = 0; i < note_nos.size(); i++) {
			
			int note_no = note_nos.get(i);
			System.out.println("notenosgetI: "+ note_nos.get(i));
			result = noteDeleteDao.deleteReceivedNote(conn, note_no, user_no);
			
			
			if(result == 0) {
				
				System.out.println(i+"번쨰 노트 지울때 오류 발생");
				break;
				
			}
			cnt++;
		}
		
		
		if(result>0) {
			JDBCTemplate.commit(conn);
			System.out.println(cnt+"줄 인서트 완료");
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		
		return result;
	}


}
