package controller.note.restore;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.face.note.NoteDeleteService;
import service.face.note.NoteRestoreService;
import service.face.note.NoteService;
import service.impl.note.NoteDeleteServiceImpl;
import service.impl.note.NoteRestoreServiceImpl;
import service.impl.note.NoteServiceImpl;

/**
 * Servlet implementation class NoteDeleteController
 */
@WebServlet("/note/receivednoterestore")
public class ReceivedNoteRestoreController extends HttpServlet {
	

	NoteRestoreService noteRestoreService = new NoteRestoreServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("get"+req.getParameter("note_no0"));
		
		List<Integer> note_nos = noteRestoreService.getNoteNos(req);
		
		int user_no = 12;//이부분 세션에서 받아와야함
		
		int result = noteRestoreService.restoreReceivedNote(note_nos, user_no);
		
		if(result > 0) {
			resp.sendRedirect("/note/receivednotebin");
		} else {
			String msg = "복구가 정상적으로 처리되지 않았습니다.";
			req.setAttribute("mag", msg);
		}
	
	}
	
}
