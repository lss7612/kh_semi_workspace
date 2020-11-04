package controller.note.binCont;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Paging;
import dto.common.UserInfo;
import dto.note.NoteList;
import service.face.note.NoteBinService;
import service.impl.note.NoteBinServiceImpl;

/**
 * Servlet implementation class ReceivedNoteBinController
 */
@WebServlet("/note/receivednotebin")
public class ReceivedNoteBinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	NoteBinService noteBinService = new NoteBinServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
	
		HttpSession session = req.getSession();
		UserInfo user = (UserInfo)session.getAttribute("userinfo");
		int user_no = user.getUser_no();
		System.out.println(user_no);
		
		Paging paging = noteBinService.getReceivedPaging(req, user_no);
		req.setAttribute("paging", paging);
		
		List<NoteList> list = noteBinService.getReceivedList(user_no, paging);
		req.setAttribute("list", list);
		
		System.out.println(list);
		
		req.getRequestDispatcher("/views/noteViews/receivedNoteBinList.jsp").forward(req, resp);
	
	}
	
}