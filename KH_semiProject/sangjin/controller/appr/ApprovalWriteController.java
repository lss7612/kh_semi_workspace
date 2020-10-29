package controller.appr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.appr.FileService;
import service.impl.appr.FileServiceImpl;





@WebServlet("/approval/approvalWrite")
public class ApprovalWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private FileService fileService = new FileServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



		
		req.getRequestDispatcher("/views/appovalViews/approveWrite.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		System.out.println("응답완료");
//		System.out.println("시작날짜 :" + req.getParameter("startday") + "끝날짜:" + req.getParameter("endday"));
//		System.out.println("조퇴,반차,연차 : " + req.getParameterValues("r"));
//		System.out.println("제목 : " + req.getParameter("title"));
//		System.out.println("사유 : " + req.getParameter("reason"));
//		System.out.println("upfile : " + req.getParameter("upfile"));
//		
		fileService.fileupload(req,resp);
		resp.sendRedirect("/approval/approvalWrite");
	}

}
