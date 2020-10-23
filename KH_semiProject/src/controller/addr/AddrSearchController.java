package controller.addr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.addr.AddrParam;
import service.face.addr.AddrViewService;
import service.impl.addr.AddrViewServiceImpl;

/**
 * Servlet implementation class AddrSearchController
 */
@WebServlet("/address/search")
public class AddrSearchController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private AddrViewService addrViewService = new AddrViewServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		AddrParam addrParam = new AddrParam();
		addrParam.setSearch(req.getParameter("keyword"));
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
}
