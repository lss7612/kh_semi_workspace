package service.impl.appr;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.JDBCTemplate;

import common.Paging_app;
import dao.appr.ApprovalMyDao;
import dao.impl.appr.ApprovalMyDaoImpl;
import dto.appr.ApprMy;
import service.appr.ApprovalMyService;

public class ApprovalMyServiceImpl implements ApprovalMyService{

	private ApprovalMyDao approvalDao = new ApprovalMyDaoImpl();
	@Override
	public List<ApprMy> getList(HttpServletRequest req, HttpServletResponse resp) {
		
		ApprMy apprMy = new ApprMy();
		HttpSession session = req.getSession();
		String login_id = (String) session.getAttribute("loginid");
		System.out.println("현재 "+ login_id + "로 접속중이십니다.");
		apprMy.setUser_id(login_id);
		
		return approvalDao.selectList(JDBCTemplate.getConnection(),apprMy);
	}
	
	@Override
	public Paging_app getPaging(HttpServletRequest req) {
		ApprMy apprMy = new ApprMy();
		HttpSession session = req.getSession();
		String login_id = (String) session.getAttribute("loginid");
		apprMy.setUser_id(login_id);
		
		//전달파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		//Board 테이블의 총 게시글 수를 조회한다
		int totalCount = approvalDao.selectCntAll(JDBCTemplate.getConnection(),apprMy);
		
		//Paging 객체 생성
		Paging_app paging = new Paging_app(totalCount, curPage); 
		
		//계산된 Paging 객체 반환
		return paging;
	}

	@Override
	public List<ApprMy> getList(HttpServletRequest req, HttpServletResponse resp,Paging_app paging) {
		
		ApprMy apprMy = new ApprMy();
		HttpSession session = req.getSession();
		String login_id = (String) session.getAttribute("loginid");
		System.out.println("현재 "+ login_id + "로 접속중이십니다.");
		apprMy.setUser_id(login_id);
		
		return approvalDao.selectList(JDBCTemplate.getConnection(),apprMy,paging);
		
	}


}
