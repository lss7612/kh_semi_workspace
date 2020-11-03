package dao.face.note;

import java.sql.Connection;

public interface NoteRestoreDao {

	public int restoreReceivedNote(Connection conn, int note_no, int user_no);

	public int restoreSendNote(Connection conn, int note_no, int user_no);

}
