package service.impl.note;

import java.sql.Connection;
import java.util.List;

import common.JDBCTemplete;
import dao.face.note.NoteDao;
import dao.impl.note.NoteDaoImpl;
import dto.note.NoteReceiverView;
import service.face.note.NoteService;

public class NoteServiceImpl implements NoteService{

	Connection conn = null;
	NoteDao noteDao = new NoteDaoImpl();
	
	@Override
	public List<NoteReceiverView> getManUser() {
		
		List<NoteReceiverView> result = null;
		conn = JDBCTemplete.getConnection();
		
		result = noteDao.getManUser();
		
		return result;
	}

	@Override
	public List<NoteReceiverView> getAccUser() {
		
		List<NoteReceiverView> result = null;
		conn = JDBCTemplete.getConnection();
		
		result = noteDao.getAccUser();
		
		return result;
	}

	@Override
	public List<NoteReceiverView> getHrUser() {
		
		List<NoteReceiverView> result = null;
		conn = JDBCTemplete.getConnection();
		
		result = noteDao.getHrUser();
		return result;
	}

	@Override
	public List<NoteReceiverView> getDevUser() {
		
		List<NoteReceiverView> result = null;
		conn = JDBCTemplete.getConnection();
		
		result = noteDao.getDevUser();
		return result;
	}

	@Override
	public List<NoteReceiverView> getSalesUser() {
		
		List<NoteReceiverView> result = null;
		conn = JDBCTemplete.getConnection();
		
		result = noteDao.getSalesUser();
		return result;
	}

}
