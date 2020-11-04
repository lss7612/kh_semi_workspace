package dao.face.note;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.Paging;
import dto.note.NoteList;
import dto.note.NotePaging;

public interface NoteBinDao {

	public int selectCntSend(Connection conn, int user_no);

	public List<NoteList> getSendBinList(Connection conn, int user_no, NotePaging paging);

	public int selectCntReceived(Connection conn, int user_no);

	public List<NoteList> getReceivedList(Connection conn, int user_no, Paging paging);

}
