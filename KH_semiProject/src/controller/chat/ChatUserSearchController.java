package controller.chat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Paging;
import dto.addr.AddrParam;
import dto.addr.AddrView;
import service.face.addr.AddrViewService;
import service.impl.addr.AddrViewServiceImpl;

@WebServlet("/chat/search")
public class ChatUserSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AddrViewService addrViewService = new AddrViewServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Paging paging = addrViewService.getSearchPaging(req); 
		req.setAttribute("paging", paging);
		
		AddrParam addrParam = new AddrParam();
		addrParam.setSearch(req.getParameter("keyword"));
		
		
		String classification = req.getParameter("classification");
		addrParam.setSearchCondition(classification);
		
		System.out.println("Controller에서 " + addrParam);
		
		
		List<AddrView> list = new ArrayList<>();
		
		list = addrViewService.search(addrParam, paging);
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/views/chat/chatSelect.jsp").forward(req, resp);
			
	}
		
}
