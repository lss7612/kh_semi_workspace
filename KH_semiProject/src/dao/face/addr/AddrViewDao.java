package dao.face.addr;

import java.sql.Connection;
import java.util.List;

import dto.addr.AddrParam;
import dto.addr.AddrView;

public interface AddrViewDao {

	public List<AddrView> viewUser(Connection conn, AddrParam addrParam);

}
