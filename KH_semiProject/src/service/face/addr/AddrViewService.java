package service.face.addr;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.Paging;
import dto.addr.AddrParam;
import dto.addr.AddrView;

public interface AddrViewService {

	
	/**
	 * 
	 * @param req HttpServletservletRequest ��ü�Դϴ�. 
	 * @return Paging�� ����ʵ带 �������ָ�, �� �������� ���� Paging ��ü�� ��ȯ���ݴϴ�. 
	 */
	public Paging getPaging(HttpServletRequest req);
	
	
	/**
	 * ������ User�� ����Ʈ�� ��ȯ�մϴ�.
	 * @param addrParam -- addrParam�� addrView�� ���ļ���(� ������ ��������, ASC���� DESC����)�� �����ϴ� dto�Դϴ�. 
	 * @param paging --Paging ������ ������ service Impl�� �����մϴ�.
	 * @return --addrParam�� ���� �ش��ϴ� User�� ����Ʈ�� ��ȯ�մϴ�.
	 */
	public List<AddrView> viewUserAddr(AddrParam addrParam,Paging paging);


}
