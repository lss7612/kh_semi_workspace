package service.impl.appr;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.JDBCTemplate;

import common.Paging_app;
import dao.face.appr.ApprovalMyDao;
import dao.impl.appr.ApprovalMyDaoImpl;
import dto.appr.ApprMy;
import service.face.appr.ApprovalMyService;

public class ApprovalMyServiceImpl implements ApprovalMyService{

	private ApprovalMyDao approvalDao = new ApprovalMyDaoImpl();
	@Override
	public List<ApprMy> getList(HttpServletRequest req, HttpServletResponse resp) {
		
		ApprMy apprMy = new ApprMy();
		HttpSession session = req.getSession();
		String user_id = (String) session.getAttribute("user_id");
		System.out.println("현재 "+ user_id + "로 접속중이십니다.");
		apprMy.setUser_id(user_id);
		
		return approvalDao.selectList(JDBCTemplate.getConnection(),apprMy);
	}
	
	@Override
	public Paging_app getPaging(HttpServletRequest req) {
		ApprMy apprMy = new ApprMy();
		HttpSession session = req.getSession();
		String user_id = (String) session.getAttribute("user_id");
		apprMy.setUser_id(user_id);
		
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
	public Paging_app getApprovePaging(HttpServletRequest req) {
		ApprMy apprMy = new ApprMy();
		HttpSession session = req.getSession();
		String user_id = (String) session.getAttribute("user_id");
		apprMy.setUser_id(user_id);
		String str =req.getParameter("a");
		apprMy.setAprvl_state(Integer.parseInt(str));
		
		//전달파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		//Board 테이블의 총 게시글 수를 조회한다
		int totalCount = approvalDao.selectCntAllapprove(JDBCTemplate.getConnection(),apprMy);
		
		//Paging 객체 생성
		Paging_app paging = new Paging_app(totalCount, curPage); 
		
		//계산된 Paging 객체 반환
		return paging;
	}

	@Override
	public List<ApprMy> getList(HttpServletRequest req, HttpServletResponse resp,Paging_app paging) {
		
		ApprMy apprMy = new ApprMy();
		HttpSession session = req.getSession();
		String user_id = (String) session.getAttribute("user_id");
		System.out.println("현재 "+ user_id + "로 접속중이십니다.");
		apprMy.setUser_id(user_id);
		
		return approvalDao.selectList(JDBCTemplate.getConnection(),apprMy,paging);
		
	}

	@Override
	public List<ApprMy> getApprovalCount(HttpServletRequest req, HttpServletResponse resp, Paging_app paging) {
		ApprMy apprMy = new ApprMy();
		HttpSession session = req.getSession();
		String user_id = (String) session.getAttribute("user_id");
		apprMy.setUser_id(user_id);
		String str =req.getParameter("a");
		apprMy.setAprvl_state(Integer.parseInt(str));
		return approvalDao.selectApproveList(JDBCTemplate.getConnection(),apprMy,paging);
	}


}
