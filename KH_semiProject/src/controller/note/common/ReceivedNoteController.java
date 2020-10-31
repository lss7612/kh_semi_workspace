package controller.note.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.note.NoteList;
import common.Paging;
import service.face.note.NoteService;
import service.impl.note.NoteServiceImpl;

/**
 * Servlet implementation class NoteVIewController
 */
@WebServlet("/note/received")
public class ReceivedNoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	NoteService noteService = new NoteServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
	
		Paging paging = noteService.getReceivedPaging(req);
		req.setAttribute("paging", paging);
		
		List<NoteList> list = noteService.getReceivedList(req, paging);
		req.setAttribute("list", list);
		
		System.out.println(list);
		
		req.getRequestDispatcher("/views/noteViews/receivedList.jsp").forward(req, resp);
	
	}
	
}
