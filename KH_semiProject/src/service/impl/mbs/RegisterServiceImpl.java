package service.impl.mbs;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import dao.face.mbs.RegisterDao;
import dao.impl.mbs.RegisterDaoImpl;
import dto.mbs.Register;
import service.face.mbs.RegisterService;

public class RegisterServiceImpl implements RegisterService{
	
	private RegisterDao registerDao = new RegisterDaoImpl(); 

	@Override
	public Register getParam(HttpServletRequest req) {

	Register param = new Register();
		param.setUser_id(req.getParameter("user_id"));
		param.setUser_pw(req.getParameter("user_pw"));
		param.setUser_name(req.getParameter("user_name"));
		param.setUser_identify(req.getParameter("identify"));
		param.setCellphone_no(req.getParameter("cellphone_no"));
		param.setUser_addr(req.getParameter("user_addr"));		
		param.setUser_notice(req.getParameter("user_notice"));
		param.setUser_addr2(req.getParameter("user_addr2"));
		param.setUser_addr3(req.getParameter("user_addr3"));
		
		return param;
	}
	
	@Override
	public Register join(Register param) {

		Connection conn = JDBCTemplate.getConnection(); //DB연결객체
		
		//1.member_seq의 다음 값(nextval)을 조회하기
		int next = registerDao.selectNextUserno(conn);
		//2.시퀀스 값을 param객체에 저장
		param.setUser_no(next);
		//3.DB에 데이터 삽입
		int result =registerDao.insert(conn,param); //DB에 데이터 삽입
		
		if(result>0) {
			JDBCTemplate.commit(conn); //커밋
			
			
		} else {
			JDBCTemplate.rollback(conn);//롤백
		}
		
		
		//4.결과 반환
		
		return param;
	}
	

}
