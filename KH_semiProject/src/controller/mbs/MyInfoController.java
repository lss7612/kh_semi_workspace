<<<<<<< HEAD
<<<<<<< HEAD:KH_semiProject/src/controller/mbs/MyInfoController.java
package controller.mbs;
=======
package controller.chat;
>>>>>>> 7a13f31a859a4f639173617afb5bd976e58d4cdc:KH_semiProject/src/controller/chat/LoginController.java
=======
package controller.mbs;
>>>>>>> 7a13f31a859a4f639173617afb5bd976e58d4cdc

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberInfoController
 */
@WebServlet("/myinfo")
public class MyInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setHeader("Cache-Control","no-store");
		req.getRequestDispatcher("/views/members/myInfo.jsp").forward(req, resp);



		
		System.out.println("myinfo호출");
	}
	




}
