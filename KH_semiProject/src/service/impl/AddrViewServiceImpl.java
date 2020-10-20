package service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplete;
import dao.face.addr.AddrViewDao;
import dao.impl.addr.AddrViewDaoImpl;
import dto.addr.AddrParam;
import dto.addr.AddrView;
import service.face.addr.AddrViewService;

public class AddrViewServiceImpl implements AddrViewService{
	
	AddrViewDao addrViewDao = new AddrViewDaoImpl();

	@Override
	public List<AddrView> viewUser(AddrParam addrParam) {
		
		List<AddrView> result = new ArrayList<>();
		
		Connection conn = JDBCTemplete.getConnection();
		result = addrViewDao.viewUser(conn, addrParam);
		
		
		return result;
		
	}

	
	
}
