package dao.face.note;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.Paging;
import dto.addr.AddrView;
import dto.note.NoteCreateData;
import dto.note.NoteList;
import dto.note.NotePaging;
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

	public List<NoteList> getReceivedList(Connection conn, int user_no, Paging paging);

	public List<NoteList> getSendList(Connection conn, int user_no,NotePaging paging);

	public int selectCntReceived(Connection conn, int user_no);

	public int selectCntSend(Connection conn, int user_no);

	public int deleteReceivedNote(Connection conn, int user_no, int note_no);

	public NoteList getNoteView(Connection conn, int note_no);

	public List<AddrView> getReceivers(Connection conn, int note_no);



}
