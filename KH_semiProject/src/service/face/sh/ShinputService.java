package service.face.sh;

import javax.servlet.http.HttpServletRequest;

import dto.sh.Shinput;

public interface ShinputService  {

	public Shinput getParam(HttpServletRequest req);
	
	/**
	 *  ���޵� �����͸� �̿��Ͽ� ȸ�� ���� ó��
	 * @param param - Ŭ���̾�Ʈ�� ���� ���޵� ȸ�� ���� ��ü
	 * @return DB�� ���� �Ϸ�� ȸ�� ���� ��ü
	 */
	
	public Shinput join(Shinput param);
		

	
}
