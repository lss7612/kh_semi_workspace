package service.impl.sh;

import java.sql.Connection;
import java.util.List;

import common.JDBCTemplate;
import dao.face.sh.SchdlDao;
import dao.impl.sh.SchdlDaoImpl;
import dto.sh.Schdl;
import service.face.sh.SchdlService;


public class SchdlServiceImpl implements SchdlService{

	
	private SchdlDao schdlDao = new SchdlDaoImpl();
	
	
	@Override
	public List<Schdl> list() {
		System.out.println("");
		
		Connection conn = JDBCTemplate.getConnection()	;
		
		List<Schdl> SchdlList  = schdlDao.seletAll(conn);
		
		
		return SchdlList;
	}

	
	
}
