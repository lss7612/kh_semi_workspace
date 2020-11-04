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
import service.impl.addr.AddrViewServiceImpl;

@WebServlet("/address/view")
public class AddrViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AddrViewService addrViewService = new AddrViewServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Paging paging = addrViewService.getPaging(req); 
		req.setAttribute("paging", paging);
		
		System.out.println(req.getParameter("arrayCondition"));
		System.out.println(req.getParameter("isASC"));
		
		AddrParam addrParam = new AddrParam();
		if(req.getParameter("arrayCondition") !=null && req.getParameter("isASC")!=null){
			addrParam.setArrayCondition(req.getParameter("arrayCondition"));
			if(req.getParameter("isASC").equals("ASC")) {
				addrParam.setASC(true);
			} else {
				addrParam.setASC(false);
				
			}
		}
		
		List<AddrView> list = addrViewService.viewUserAddr(addrParam, paging);
		
		if(req.getParameter("arrayCondition") ==null || req.getParameter("isASC")==null){
			req.setAttribute("list", list);
			req.getRequestDispatcher("/views/addrViews/view.jsp").forward(req, resp);
		} else if(req.getParameter("arrayCondition") !=null || req.getParameter("isASC")!=null){
			req.setAttribute("list", list);
			req.getRequestDispatcher("/views/addrViews/view_ok.jsp");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Paging paging = addrViewService.getPaging(req); 
		req.setAttribute("paging", paging);
		
		
		AddrParam addrParam = new AddrParam();
		addrParam.setArrayCondition(req.getParameter("arrayCondition"));
		if(req.getParameter("isASC").equals("ASC")) {
			addrParam.setASC(true);
		} else {
			addrParam.setASC(false);
		}
		
		System.out.println(req.getParameter("arrayCondition"));
		System.out.println("asc" + req.getParameter("isASC"));
		
		List<AddrView> list = addrViewService.viewUserAddr(addrParam, paging);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("/views/addrViews/view_view_ok.jsp").forward(req, resp);

	}

	
	
}
