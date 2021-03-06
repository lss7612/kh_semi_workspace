package service.face.note;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.Paging;
import dto.note.NoteCreateData;
import dto.note.NoteList;
import dto.note.NotePaging;
import dto.note.NoteReceiverView;

public interface NoteService {

	public List<NoteReceiverView> getManUser();

	public List<NoteReceiverView> getAccUser();

	public List<NoteReceiverView> getHrUser();

	public List<NoteReceiverView> getDevUser();

	public List<NoteReceiverView> getSalesUser();
	
	public NoteCreateData getNCDparams(HttpServletRequest req);
	
	public int insertNote(NoteCreateData params);
	
	public List<NoteList> getReceivedList(HttpServletRequest req, Paging paging);
	
	public List<NoteList> getSendList(HttpServletRequest req, NotePaging paging);
	
	public Paging getReceivedPaging(HttpServletRequest req);

	public NotePaging getSendPaging(HttpServletRequest req);

	public int deleteReceivedNote(HttpServletRequest req, int user_no, int note_no);

	public NoteList getNoteView(int note_no);

	public List<Integer> getSelectedUserList(HttpServletRequest req);

	public List<String> getSelectedUserNameList(HttpServletRequest req);


}
