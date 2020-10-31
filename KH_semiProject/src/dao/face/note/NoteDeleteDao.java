package dao.face.note;

import java.sql.Connection;
import java.util.List;

public interface NoteDeleteDao {

	public int deleteSendNote(Connection conn, int note_no, int user_no);

	public int deleteReceivedNote(Connection conn, int note_no, int user_no);




}
