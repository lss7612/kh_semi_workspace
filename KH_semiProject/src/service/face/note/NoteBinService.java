package service.face.note;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.Paging;
import dto.note.NoteList;
import dto.note.NotePaging;

public interface NoteBinService {

	public NotePaging getSendPaging(HttpServletRequest req, int user_no);

	public List<NoteList> getSendList(int user_no, NotePaging paging);

	public Paging getReceivedPaging(HttpServletRequest req, int user_no);

	public List<NoteList> getReceivedList(int user_no, Paging paging);

}
