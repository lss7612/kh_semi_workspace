package service.face.addr;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.Paging;
import dto.addr.AddrParam;
import dto.addr.AddrView;

public interface AddrViewService {

	public List<AddrView> viewUserAddr(AddrParam addrParam,Paging paging);

	public Paging getPaging(HttpServletRequest req);

}
