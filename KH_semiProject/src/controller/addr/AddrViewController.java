package controller.addr;

import java.io.IOException;
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
import service.impl.AddrViewServiceImpl;

@WebServlet("/address/view")
public class AddrViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AddrViewService addrViewService = new AddrViewServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		System.out.println("get");
		
//		Paging paging = addrViewService.getPaging(req); 
//		req.setAttribute("paging", paging);
//		
//		
//		AddrParam addrParam = new AddrParam();
//		List<AddrView> list = addrViewService.viewUserAddr(addrParam, paging);
//		System.out.println(list);
////		for(int i=0;i<list.size();i++) {
////			System.out.println(list.get(i));
////		}
//
//		req.setAttribute("list", list);
		req.getRequestDispatcher("/views/addrViews/view.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Paging paging = addrViewService.getPaging(req); 
		req.setAttribute("paging", paging);
		
		
		AddrParam addrParam = new AddrParam();
		List<AddrView> list = addrViewService.viewUserAddr(addrParam, paging);
//		for(int i=0;i<list.size();i++) {
//			System.out.println(list.get(i));
//		}

		req.setAttribute("list", list);
		req.getRequestDispatcher("/views/addrViews/view_ok.jsp").forward(req, resp);

	}

}
