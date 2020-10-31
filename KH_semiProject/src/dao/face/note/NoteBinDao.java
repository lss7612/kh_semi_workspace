package dao.face.note;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.Paging;
import dto.note.NoteList;
import dto.note.NotePaging;

public interface NoteBinDao {

	public int selectCntSend(Connection conn);

	public List<NoteList> getSendBinList(Connection conn, HttpServletRequest req, NotePaging paging);

	public int selectCntReceived(Connection conn);

	public List<NoteList> getReceivedList(Connection conn, HttpServletRequest req, Paging paging);

}
