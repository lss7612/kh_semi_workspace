package service.face.note;

import java.util.List;

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

}
