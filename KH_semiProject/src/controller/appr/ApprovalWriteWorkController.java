package controller.appr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.face.appr.WorkService;
import service.impl.appr.WorkServiceImpl;


@WebServlet("/approval/approvalWriteWork")
public class ApprovalWriteWorkController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	private WorkService workService = new WorkServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/views/appovalViews/approveWriteWork.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("post 응답 완료");
		workService.fileupload(req,resp);
		
		
		resp.sendRedirect("/approval/approvalWriteWork");
	}

}
