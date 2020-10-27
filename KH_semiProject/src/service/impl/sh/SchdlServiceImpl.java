package service.impl.sh;

import java.sql.Connection;
import java.util.List;

import common.JDBCTemplate;
import dao.face.SchdlDao;
import dao.impl.SchdlDaoImpl;
import dto.Schdl;
import service.face.SchdlService;

public class SchdlServiceImpl implements SchdlService{

	
	//Dao 媛앹껜 �깮�꽦
	private SchdlDao schdlDao = new SchdlDaoImpl();
	
	
	@Override
	public List<Schdl> list() {
		System.out.println("�뒪耳�伊� �꽌鍮꾩뒪 由ъ뒪�듃 �샇異�");
		
		//conn媛앹껜 �깮�꽦
		Connection conn = JDBCTemplate.getConnection()	;
		
		//�뒪耳�以� �쟾泥� 議고쉶 - SchdlDao 媛앹껜 �씠�슜
		List<Schdl> SchdlList  = schdlDao.seletAll(conn);
		
		
		//議고쉶 寃곌낵 諛섑솚
		return SchdlList;
	}

	
	
}
