package controller.note.delete;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		int user_no = 1;//이부분 세션에서 받아와야함
		
		int result = noteDeleteService.deleteSendNote(note_nos, user_no);
		
		if(result > 0) {
			resp.sendRedirect("/note/sent");
		} else {
			String msg = "삭제가 정상적으로 처리되지 않았습니다.";
			req.setAttribute("mag", msg);
		}
	
	}
	
}
