package service.impl.note;

import java.sql.Connection;

import common.JDBCTemplate;
import dao.face.note.NoteDeleteDao;
import dto.note.NoteDeleteDaoImpl;
import service.face.note.NoteDeleteService;

public class NoteDeleteServiceImpl implements NoteDeleteService{

	NoteDeleteDao noteDeleteDao = new NoteDeleteDaoImpl();
	
	Connection conn = null;
	
	@Override
	public int deleteNote(int note_no) {

		conn = JDBCTemplate.getConnection();
		
		int result = noteDeleteDao.deleteNote(conn, note_no);
		
		
		return result;
	}

}
