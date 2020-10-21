package service.face.addr;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.Paging;
import dto.addr.AddrParam;
import dto.addr.AddrView;

public interface AddrViewService {

	
	/**
	 * 
	 * @param req HttpServletservletRequest 객체입니다. 
	 * @return Paging의 멤버필드를 설정해주며, 그 설정값을 가진 Paging 객체를 반환해줍니다. 
	 */
	public Paging getPaging(HttpServletRequest req);
	
	
	/**
	 * 보여질 User의 리스트를 반환합니다.
	 * @param addrParam -- addrParam은 addrView의 정렬설정(어떤 값으로 정렬할지, ASC인지 DESC인지)를 저장하는 dto입니다. 
	 * @param paging --Paging 설정을 가지고 service Impl에 전달합니다.
	 * @return --addrParam의 값에 해당하는 User의 리스트를 반환합니다.
	 */
	public List<AddrView> viewUserAddr(AddrParam addrParam,Paging paging);


}
