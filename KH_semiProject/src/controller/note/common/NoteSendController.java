package controller.note.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.note.NoteCreateData;
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
		
		List<Integer> selectedUserList = noteService.getSelectedUserList(req);
		List<String> selectedUserNameList = noteService.getSelectedUserNameList(req);
		
		System.out.println(selectedUserList);
		req.setAttribute("selectedUserList", selectedUserList);
		req.setAttribute("selectedUserNameList", selectedUserNameList);
		
		List<NoteReceiverView> manUser = noteService.getManUser();
		List<NoteReceiverView> accUser = noteService.getAccUser();
		List<NoteReceiverView> hrUser = noteService.getHrUser();
		List<NoteReceiverView> devUser = noteService.getDevUser();
		List<NoteReceiverView> salesUser = noteService.getSalesUser();
		
		if(req.getAttribute("msg")!=null) {
			req.setAttribute("msg", req.getAttribute("msg"));
		}
		
		req.setAttribute("manUser", manUser);
		req.setAttribute("accUser", accUser);
		req.setAttribute("hrUser", hrUser);
		req.setAttribute("devUser", devUser);
		req.setAttribute("salesUser", salesUser);
		
		
		req.getRequestDispatcher("/views/noteViews/send.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		NoteCreateData params = noteService.getNCDparams(req);	
		System.out.println(params);
		
		//
		int result = noteService.insertNote(params);
		if(result > 0) {
			resp.sendRedirect("/note/sent");
		} if(result == 0) {
			String msg = "오류로 인해 쪽지가 보내지지 않았습니다.";
			req.setAttribute("msg", msg);
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
	
	}
	
}
