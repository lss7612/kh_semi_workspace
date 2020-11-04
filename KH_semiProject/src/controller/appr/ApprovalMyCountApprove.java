package controller.appr;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.JDBCTemplate;
import common.Paging_app;
import dao.face.appr.ApprovalMyDao;
import dao.impl.appr.ApprovalMyDaoImpl;
import dto.appr.ApprMy;
import service.face.appr.ApprovalMyService;
import service.impl.appr.ApprovalMyServiceImpl;

/**
 * Servlet implementation class ApprovalMyCountApprove
 */
@WebServlet("/approval/countApproval")
public class ApprovalMyCountApprove extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ApprovalMyDao approvalDao = new ApprovalMyDaoImpl();
	
	private ApprovalMyService approvalMyService = new ApprovalMyServiceImpl();
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String val =req.getParameter("a");
		System.out.println("val ="+val);
		
		
		
		
		
		
		Paging_app paging = approvalMyService.getApprovePaging(req);
		System.out.println("paging : "+paging);
		 //승인 문서 조회
		req.setAttribute("paging", paging);
		List<ApprMy> list = approvalMyService.getApprovalCount(req,resp,paging);
		System.out.println("list : "+list);
		int totalCount= paging.getTotalCount();
		System.out.println("totalCount"+totalCount);
 	   req.setAttribute("list", list);
 	   req.setAttribute("totalCount",totalCount);
 	  req.getRequestDispatcher("/views/appovalViews/approvemy.jsp").forward(req, resp);
		
		}

}
