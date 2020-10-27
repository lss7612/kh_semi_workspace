package controller.sh;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.sh.Schdl;
import service.face.sh.SchdlService;
import service.impl.sh.SchdlServiceImpl;


/**
 * Servlet implementation class SemiTableSearch
 */
@WebServlet("/semi/Schdl")
public class SemiSchdl extends HttpServlet {
	
	private SchdlService schdlService = new  SchdlServiceImpl();
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("SemiSchdl get");
		
		
		List<Schdl> SchdlList = schdlService.list();
		
		for (Schdl e : SchdlList ) {
			System.out.println(e);
		}
		
		req.setAttribute("list", SchdlList);

		req.getRequestDispatcher("/views/sh/schdl.jsp")
			.forward(req, resp);
		
	}

	
		
		
		
		
		
	
	
}
