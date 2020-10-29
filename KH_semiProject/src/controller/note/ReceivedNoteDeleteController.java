package controller.note;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.face.note.NoteService;
import service.impl.note.NoteServiceImpl;

/**
 * Servlet implementation class NoteDeleteController
 */
@WebServlet("/NoteDeleteController")
public class ReceivedNoteDeleteController extends HttpServlet {
	
	NoteService noteService = new NoteServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		int user_no = Integer.parseInt((String)session.getAttribute("user_no"));
		int note_no = Integer.parseInt((String)req.getParameter("note_no"));
		
		int result = noteService.deleteReceivedNote( req, user_no, note_no );
		
		if(result > 0) {
			//받은쪽지함으로 리다이렉트
		} else {
			//에러페이지로 이동
		}
	
	}
	
}
