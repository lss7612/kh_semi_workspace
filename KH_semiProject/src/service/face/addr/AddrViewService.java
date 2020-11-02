package service.face.addr;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.Paging;
import dto.addr.AddrParam;
import dto.addr.AddrView;

public interface AddrViewService {

	
	public Paging getPaging(HttpServletRequest req);
	
	public List<AddrView> viewUserAddr(AddrParam addrParam,Paging paging);

	public Paging getSearchPaging(HttpServletRequest req);
	
	public List<AddrView> search(AddrParam addrParam, Paging paging);



}
