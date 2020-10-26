package service.face.note;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.note.NoteCreateData;
import dto.note.NoteList;
import dto.note.NoteReceiverView;

public interface NoteService {

	/**
	 * 
	 * @return �濵�� �ο��� ����Ʈ�� ��ȯ�Ѵ�
	 */
	public List<NoteReceiverView> getManUser();
	/**
	 * 
	 * @return ȸ����
	 */
	public List<NoteReceiverView> getAccUser();

	/**
	 * 
	 * @return �λ���
	 */
	public List<NoteReceiverView> getHrUser();

	/**
	 * 
	 * @return ������
	 */
	public List<NoteReceiverView> getDevUser();

	/**
	 * 
	 * @return ������
	 */
	public List<NoteReceiverView> getSalesUser();
	
	/**
	 * 
	 * @param req
	 * @return NoteCreateData INSERT�� param�� �����Ѵ�.
	 */
	public NoteCreateData getNCDparams(HttpServletRequest req);
	
	/**
	 * 
	 * @param params
	 * @return �μ�Ʈ�Ϸ�Ǹ� 0���� ū ���� ��ȯ�ϰ�, �μ�Ʈ�� �����ϸ� 0�� ��ȯ�Ѵ�
	 */
	public int insertNote(NoteCreateData params);
	
	/**
	 * 
	 * @param req(���� ������ ��� ���� �ʿ��ϴ�)
	 * @return ���� ������ ȭ�鿡�� ������ note�� list�� ��ȯ�Ѵ�.
	 */
	public List<NoteList> getReceivedList(HttpServletRequest req);
	
	/**
	 * 
	 * @param req(���� ������ ��� ���� �ʿ��ϴ�)
	 * @return ���� ������ ȭ�鿡�� ������ note�� list�� ��ȯ�Ѵ�
	 */
	public List<NoteList> getSendList(HttpServletRequest req);

}
