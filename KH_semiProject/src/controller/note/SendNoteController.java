package controller.note;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.note.NoteList;
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

		
		List<NoteList> list = noteService.getSendList(req);
		req.setAttribute("list", list);
		System.out.println(list);
		
		req.getRequestDispatcher("/views/noteViews/sendList.jsp").forward(req, resp);
	
	}
	
}
