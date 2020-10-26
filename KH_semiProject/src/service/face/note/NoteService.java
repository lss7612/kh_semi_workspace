package service.face.note;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.note.NoteCreateData;
import dto.note.NoteList;
import dto.note.NoteReceiverView;

public interface NoteService {

	/**
	 * 
	 * @return 경영팀 인원을 리스트로 반환한다
	 */
	public List<NoteReceiverView> getManUser();
	/**
	 * 
	 * @return 회계팀
	 */
	public List<NoteReceiverView> getAccUser();

	/**
	 * 
	 * @return 인사팀
	 */
	public List<NoteReceiverView> getHrUser();

	/**
	 * 
	 * @return 개발팀
	 */
	public List<NoteReceiverView> getDevUser();

	/**
	 * 
	 * @return 영업팀
	 */
	public List<NoteReceiverView> getSalesUser();
	
	/**
	 * 
	 * @param req
	 * @return NoteCreateData INSERT할 param을 세팅한다.
	 */
	public NoteCreateData getNCDparams(HttpServletRequest req);
	
	/**
	 * 
	 * @param params
	 * @return 인서트완료되면 0보다 큰 값을 반환하고, 인서트에 실패하면 0을 반환한다
	 */
	public int insertNote(NoteCreateData params);
	
	/**
	 * 
	 * @param req(세션 정보를 얻기 위해 필요하다)
	 * @return 받은 쪽지함 화면에에 보여질 note를 list로 반환한다.
	 */
	public List<NoteList> getReceivedList(HttpServletRequest req);
	
	/**
	 * 
	 * @param req(세션 정보를 얻기 위해 필요하다)
	 * @return 보낸 쪽지함 화면에서 보여질 note를 list로 반환한다
	 */
	public List<NoteList> getSendList(HttpServletRequest req);

}
