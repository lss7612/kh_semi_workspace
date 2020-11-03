package controller.appr;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.face.appr.ApprovalMyDetailDao;
import dao.impl.appr.ApprovalMyDetailDaoImpl;
import dto.appr.Appr;

/**
 * Servlet implementation class ApproveMyDetailController
 */
@WebServlet("/approval/myDetail")
public class ApproveMyDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ApprovalMyDetailDao approvalMyDetailDao = new ApprovalMyDetailDaoImpl();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		
		
		
		String result=req.getParameter("b");
		System.out.println(result); 
	
		
		if(result.equals("휴가계")) {
			
			
			Appr appr = new Appr();
			
			
			appr.setApprl_no(Integer.parseInt(req.getParameter("a")));
			
			List<Appr> list = approvalMyDetailDao.selectByApprvlno(req, resp,appr);
			//디버깅
			System.out.println(list);
			req.setAttribute("list", list);
			req.getRequestDispatcher("/views/appovalViews/approveMy_detail_holy.jsp").forward(req, resp);
		}else {
			Appr appr = new Appr();
			
			appr.setApprl_no(Integer.parseInt(req.getParameter("a")));
			
			List<Appr> list = approvalMyDetailDao.selectByApprvlno(req, resp,appr);
			//디버깅
			System.out.println(list);
			
			req.setAttribute("list", list);
			req.getRequestDispatcher("/views/appovalViews/approveMy_detail.jsp").forward(req, resp);
		}
//		
//		
			
			
			
			
		}
	
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			System.out.println("응답완료!!");
			
			
		}
}
