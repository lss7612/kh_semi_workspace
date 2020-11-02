package dao.face.addr;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.Paging;
import dto.addr.AddrParam;
import dto.addr.AddrView;

public interface AddrViewDao {

	public List<AddrView> viewUserAddr(Connection conn, AddrParam addrParam,Paging paging);

	public int selectCntAll(Connection conn);

	public int selectSerchCntAll(Connection conn, HttpServletRequest req);
	
	public List<AddrView> search(Connection conn, AddrParam addrParam, Paging paging);


}
