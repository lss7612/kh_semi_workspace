package dao.face.sh;

import java.sql.Connection;
import java.util.List;

import dto.sh.Schdl;

public interface SchdlDao {

	
	public List<Schdl> seletAll(Connection conn) ;

}
