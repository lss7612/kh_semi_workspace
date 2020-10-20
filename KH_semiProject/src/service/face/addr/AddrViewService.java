package service.face.addr;

import java.util.List;

import dto.addr.AddrParam;
import dto.addr.AddrView;

public interface AddrViewService {

	public List<AddrView> viewUser(AddrParam addrParam);

}
