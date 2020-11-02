package controller.appr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import service.appr.FileService;
import service.impl.appr.FileServiceImpl;





@WebServlet("/approval/approvalWrite")
public class ApprovalWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private FileService fileService = new FileServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		 System.out.println(session.getAttribute("loginid"));

		
		req.getRequestDispatcher("/views/appovalViews/approveWrite.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		System.out.println("응답완료");
//		System.out.println("시작날짜 :" + req.getParameter("startday") + "끝날짜:" + req.getParameter("endday"));


		fileService.fileupload(req,resp);
		resp.sendRedirect("/approval/approvalWrite");
	}

}
