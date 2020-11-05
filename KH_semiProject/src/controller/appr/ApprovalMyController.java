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
import service.face.appr.ApprovalMyService;
import service.impl.appr.ApprovalMyServiceImpl;


@WebServlet("/approval/approvalmy")
public class ApprovalMyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ApprovalMyService approvalMyService = new ApprovalMyServiceImpl();
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	   
    	   Paging_app paging = approvalMyService.getPaging(req);
    	   System.out.println("paging : "+paging);
    	   //결재 전체 조회
   			req.setAttribute("paging", paging);
    	   List<ApprMy> list = approvalMyService.getList(req,resp,paging);
    	   System.out.println("list : "+list);
    	   req.setAttribute("list", list);

    	   req.getRequestDispatcher("/views/appovalViews/approvemy.jsp").forward(req, resp);
    	   
    	   
    }

}
