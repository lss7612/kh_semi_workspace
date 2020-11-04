package controller.appr;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.JDBCTemplate;
import dao.face.appr.ApprovalDoUpdateDao;
import dao.impl.appr.ApprovalDoUpdateDaoImpl;
import dto.appr.ApprMy;
import dto.common.UserInfo;

/**
 * Servlet implementation class ApprovalDoUpdateController
 */
@WebServlet("/approval/update")
public class ApprovalDoUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int state;

	private ApprovalDoUpdateDao approvalUpdate = new ApprovalDoUpdateDaoImpl();
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("now : " +req.getParameter("now"));
		System.out.println("state : " +req.getParameter("state"));
		HttpSession session = req.getSession();

		
		UserInfo userinfo = (UserInfo)session.getAttribute("userinfo");
		int user_no = userinfo.getUser_no();
		System.out.println(user_no);
		

		

		if(req.getParameter("state").equals("yes")) {
			
			if (req.getParameter("now").equals("대기")) {
				if(Integer.toString(user_no).equals(req.getParameter("mid"))) {
					if(req.getParameter("final").equals("0")) {
	
						state=2;
						System.out.println("final이 없을 경우 바로 승인(2)= "+state);
					}else {
			
						state=4;
						System.out.println(state);
					}
				}
			}else if (req.getParameter("now").equals("1차승인")){
				
				state=2;
			}
		
		
		}else {
			state=3;
			System.out.println(state);
		}
		System.out.println("전역 state ="+state);
		ApprMy apprmy = new ApprMy();
		apprmy.setAprvl_state(state);
		apprmy.setAprvl_no(Integer.parseInt(req.getParameter("num")));
		
		Connection conn = JDBCTemplate.getConnection();
		
		int res=0;
		
		res=approvalUpdate.UpdateParam(conn,apprmy);
		
		if(res >=0) {
			JDBCTemplate.commit(conn);
			
		}else {
			JDBCTemplate.rollback(conn);
			
		}
		
		req.getRequestDispatcher("/approval/DoApproval").forward(req, resp);

	}
}
