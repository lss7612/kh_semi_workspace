package dao.face.addr;

import java.sql.Connection;
import java.util.List;

import common.Paging;
import dto.addr.AddrParam;
import dto.addr.AddrView;

public interface AddrViewDao {

	public List<AddrView> viewUserAddr(Connection conn, AddrParam addrParam,Paging paging);

	public int selectCntAll(Connection conn);

}
