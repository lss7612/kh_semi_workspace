package controller.note.common;

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
import dto.note.NotePaging;
import service.face.note.NoteService;
import service.impl.note.NoteServiceImpl;

/**
 * Servlet implementation class SendNoteController
 */
@WebServlet("/note/sent")
public class SendNoteController extends HttpServlet {
	
	NoteService noteService = new NoteServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		UserInfo user = (UserInfo)session.getAttribute("userinfo");
		int user_no = user.getUser_no();
		System.out.println(user_no);
		
		
		NotePaging paging = noteService.getSendPaging(req, user_no);
		req.setAttribute("paging", paging);
		
		
		List<NoteList> list = noteService.getSendList(user_no, paging);
		req.setAttribute("list", list);
		System.out.println(list);
		
		req.getRequestDispatcher("/views/noteViews/sendList.jsp").forward(req, resp);
	
	}
	
}
