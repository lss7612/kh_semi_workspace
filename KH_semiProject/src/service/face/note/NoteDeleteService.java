package service.face.note;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


public interface NoteDeleteService {

	public List<Integer> getNoteNos(HttpServletRequest req);

	public int deleteSendNote(List<Integer> note_nos, int user_no);

	public int deleteReceivedNote(List<Integer> note_nos, int user_no);
	
}
