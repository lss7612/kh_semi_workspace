package controller.note.binCont;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.note.NoteList;
import service.face.note.NoteService;
import service.impl.note.NoteServiceImpl;

/**
 * Servlet implementation class ReceivedNoteBinView
 */
@WebServlet("/note/receivedNoteBinView")
public class ReceivedNoteBinViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	NoteService noteService = new NoteServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {   

		
		int note_no = Integer.parseInt(req.getParameter("note_no"));
		System.out.println(note_no);
		
		NoteList noteList = noteService.getNoteView(note_no);
		System.out.println(noteList);
		req.setAttribute("noteList", noteList);
		
		req.getRequestDispatcher("/views/noteViews/receivedNoteBinView.jsp").forward(req, resp);
	
	}
	
}
