package service.face.appr;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Paging_app;
import dto.appr.ApprMy;

public interface ApprovalMyService {

	List<ApprMy> getList(HttpServletRequest req, HttpServletResponse resp);

	
	/**
	 * 페이징 객체 생성
	 * 
	 * @param req - 요청 정보 객체
	 * @return 페이징 계산이 완료된 객체
	 */
	public Paging_app getPaging(HttpServletRequest req);




	List<ApprMy> getList(HttpServletRequest req, HttpServletResponse resp, Paging_app paging);

	List<ApprMy> getApprovalCount(HttpServletRequest req, HttpServletResponse resp, Paging_app paging);


	Paging_app getApprovePaging(HttpServletRequest req);

}
