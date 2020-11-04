package controller.appr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApprovalWriteMyModController
 */
@WebServlet("/approvalMy/mod")
public class ApprovalMyModController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			System.out.println("mod 응답완료");
			req.getRequestDispatcher("/views/appovalViews/approvalMod.jsp").forward(req,resp);
			
		}
	
}
