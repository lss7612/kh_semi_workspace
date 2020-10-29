package dao.face.note;

import java.sql.Connection;

public interface NoteDeleteDao {

	public int deleteNote(Connection conn, int note_no);

}
