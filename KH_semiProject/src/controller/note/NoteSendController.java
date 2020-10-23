package controller.note;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.note.NoteReceiverView;
import service.face.note.NoteService;
import service.impl.note.NoteServiceImpl;

/**
 * Servlet implementation class NoteSendController
 */
@WebServlet("/note/send")
public class NoteSendController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	NoteService noteService = new NoteServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//부서별 사원을 옵션으로 돌려주기 위한 리스트
		List<NoteReceiverView> manUser = noteService.getManUser();
		List<NoteReceiverView> accUser = noteService.getAccUser();
		List<NoteReceiverView> hrUser = noteService.getHrUser();
		List<NoteReceiverView> devUser = noteService.getDevUser();
		List<NoteReceiverView> salesUser = noteService.getSalesUser();
		
		req.setAttribute("manUser", manUser);
		req.setAttribute("accUser", accUser);
		req.setAttribute("hRUser", hrUser);
		req.setAttribute("devUser", devUser);
		req.setAttribute("salesUser", salesUser);
		
		
		req.getRequestDispatcher("/views/noteViews/send.jsp").forward(req, resp);
	
	}
	
}
