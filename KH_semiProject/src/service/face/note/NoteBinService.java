package service.face.note;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.Paging;
import dto.note.NoteList;
import dto.note.NotePaging;

public interface NoteBinService {

	public NotePaging getSendPaging(HttpServletRequest req);

	public List<NoteList> getSendList(HttpServletRequest req, NotePaging paging);

	public Paging getReceivedPaging(HttpServletRequest req);

	public List<NoteList> getReceivedList(HttpServletRequest req, Paging paging);

}
