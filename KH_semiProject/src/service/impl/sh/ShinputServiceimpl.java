package service.impl.sh;

import java.util.Date;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;


import common.JDBCTemplate;
import dao.face.sh.ShinputDao;
import dao.impl.sh.ShinputDaoimpl;
import dto.sh.Shinput;
import service.face.sh.ShinputService;

public class ShinputServiceimpl implements ShinputService {

	private ShinputDao shinputDao = new ShinputDaoimpl();
	
	
	public Shinput getParam(HttpServletRequest req) {

		Shinput param = new Shinput(); //화물차 생성했으나 아무것도 넣지않고 그냥 차를 다시 돌려보낸거임.여기서아 햗형변환 그거 때문에 실패했는데
		
		
		
		int schdl_no = Integer.parseInt(req.getParameter("schdl_no"));
		param.setSchdl_no(schdl_no);
		int schdl_type = Integer.parseInt(req.getParameter("schdl_type"));//얘도 
		param.setSchdl_type(schdl_type);
		param.setSchdl_title(req.getParameter("schdl_title"));//파람안에 스케쥴타이틀 넣은거
		param.setSchdl_content(req.getParameter("schdl_content"));//원래 스트링타입인애들은 그냥 바로 넣으면되어서 타이틀하고 콘텐트는 그대로 넣은거에요 

		
		//Date타입이 어떻게 나오는지 보기
		System.out.println("Date타입은 어떻게 ? : "+ req.getParameter("schdl_start"));
		System.out.println("Date타입은 어떻게 ? : "+ req.getParameter("schdl_end"));
		//String으로 온 데이트를 Date로 바꾸기

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date schdl_start = null;
		Date schdl_end = null;
		try {
			schdl_start = transFormat.parse(req.getParameter("schdl_start"));
			schdl_end = transFormat.parse(req.getParameter("schdl_end"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println(schdl_start);//java.util.Date로 형변환 
		System.out.println(schdl_end);
		//java.sql.Date로 형변환 해야함 
		
		
		
//		param.setSchdl_start(schdl_start);
//		param.setSchdl_start(schdl_end);

		return param;
	}

	@Override
	public Shinput join(Shinput param) {
		
		//DB 연걸
		Connection conn = JDBCTemplate.getConnection();
		
		//1. 스케즐_seq의 다음 값을 조회하기
		int next = shinputDao.seletNextschdl_no();
		
		//2. 시퀀스 값을 param객체에 저장
		param.setSchdl_no(next);
		System.out.println("시컨스 넣기 여기까지 잘됨 ");
		//3. DB에 데이터 삽입
		int result = shinputDao.insert(conn, param);
		
		System.out.println("result 넣기  ");
		if(result > 0) {
			JDBCTemplate.commit(conn);//커밋
		}else {
			JDBCTemplate.rollback(conn);//커밋
		}
		
		//4. 결과 반환
		return param;
	}

}
