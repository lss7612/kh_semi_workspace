package controller.appr;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Paging_app;
import dto.appr.ApprMy;
import service.face.appr.ApprovalDoService;
import service.impl.appr.ApprovalDoServiceImpl;




@WebServlet("/approval/DoApproval")
public class DoApproval extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ApprovalDoService approvalDoService = new ApprovalDoServiceImpl();
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			Paging_app paging = approvalDoService.getPaging(req);
			 System.out.println("paging : "+paging);
	    	   //결재 전체 조회
	   			req.setAttribute("paging", paging);
	    	   List<ApprMy> list = approvalDoService.getList(req,resp,paging);
	    	   System.out.println("list : "+list);
	    	   req.setAttribute("list", list);
	    	   //승인 문서 조회
	    	   
	    	   req.getRequestDispatcher("/views/appovalViews/approveDo.jsp").forward(req, resp);
		}

}
