package dao.face.note;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.note.NoteCreateData;
import dto.note.NoteList;
import dto.note.NoteReceiverView;

public interface NoteDao {

	public List<NoteReceiverView> getManUser(Connection conn);

	public List<NoteReceiverView> getAccUser(Connection conn);

	public List<NoteReceiverView> getHrUser(Connection conn);

	public List<NoteReceiverView> getDevUser(Connection conn);

	public List<NoteReceiverView> getSalesUser(Connection conn);

	public int insertNote(NoteCreateData params, Connection conn);

	public int insertSendNote(NoteCreateData params, Connection conn);

	public int insertReceivedNote(NoteCreateData params, Connection conn);

	public int getNextval(Connection conn);

	public List<NoteList> getReceivedList(Connection conn, HttpServletRequest req);

	public List<NoteList> getSendList(Connection conn, HttpServletRequest req);

}
