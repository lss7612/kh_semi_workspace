package dao.impl.note;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import dao.face.note.NoteDeleteDao;

public class NoteDeleteDaoImpl implements NoteDeleteDao{

	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public int deleteSendNote(Connection conn, int note_no, int user_no) { 
		
		System.out.println("impl get : " + note_no);
		
		//noteView.jsp의 삭제 전달값을 note_no0으로 해야함
		//SendNoteList의 삭제 전달값은 note_no0, note_no1, note_no2,... 으로 해야함
		//sql을 짤 차례
		
		int result=0;
		
		String sql = "";
		sql += "UPDATE tb_sendNote";
		sql += " SET isDelete = ?";
		sql += " WHERE note_no = ?";
		sql += " AND user_no = ?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setInt(2, note_no);
			ps.setInt(3, user_no);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		System.out.println("result : "+ result);
		
		return result;
		
	}

	@Override
	public int deleteReceivedNote(Connection conn, int note_no, int user_no) {    
		
		System.out.println("impl get : " + note_no);
		
		//noteView.jsp의 삭제 전달값을 note_no0으로 해야함
		//SendNoteList의 삭제 전달값은 note_no0, note_no1, note_no2,... 으로 해야함
		//sql을 짤 차례
		
		int result=0;
		
		String sql = "";
		sql += "UPDATE tb_receivedNote";
		sql += " SET isDelete = ?";
		sql += " WHERE note_no = ?";
		sql += " AND user_no = ?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setInt(2, note_no);
			ps.setInt(3, user_no);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		System.out.println("result : "+ result);
		
		return result;
		
	}

}
