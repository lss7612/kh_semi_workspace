package service.face.note;

import java.util.List;

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

}
