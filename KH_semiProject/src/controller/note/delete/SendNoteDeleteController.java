package controller.note.delete;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.common.UserInfo;
import service.face.note.NoteDeleteService;
import service.impl.note.NoteDeleteServiceImpl;

/**
 * Servlet implementation class NoteDeleteController
 */
@WebServlet("/note/sendnotedelete")
public class SendNoteDeleteController extends HttpServlet {
	
	NoteDeleteService noteDeleteService = new NoteDeleteServiceImpl(); 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("get"+req.getParameter("note_no0"));		
		
		List<Integer> note_nos = noteDeleteService.getNoteNos(req);
		
		HttpSession session = req.getSession();
		UserInfo user = (UserInfo)session.getAttribute("userinfo");
		int user_no = user.getUser_no();
		System.out.println(user_no);
		
		int result = noteDeleteService.deleteSendNote(note_nos, user_no);
		
		if(result > 0) {
			resp.sendRedirect("/note/sent");
		} else {
			String msg = "삭제가 정상적으로 처리되지 않았습니다.";
			req.setAttribute("mag", msg);
		}
	
	}
	
}
