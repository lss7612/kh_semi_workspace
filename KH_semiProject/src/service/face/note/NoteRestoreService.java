package service.face.note;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface NoteRestoreService {

	public List<Integer> getNoteNos(HttpServletRequest req);

	public int restoreReceivedNote(List<Integer> note_nos, int user_no);

	public int restoreSendNote(List<Integer> note_nos, int user_no);

}
