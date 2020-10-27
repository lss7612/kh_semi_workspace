package controller.sh;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Schdl;
import service.face.SchdlService;
import service.impl.SchdlServiceImpl;

/**
 * Servlet implementation class SemiTableSearch
 */
@WebServlet("/semi/Schdl")
public class SemiSchdl extends HttpServlet {
	
	//SchdlService 媛앹껜 �깮�꽦
	private SchdlService schdlService = new  SchdlServiceImpl();
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("SemiSchdl 寃�  �꽦怨�");
		
		
		//req.getRequestDispatcher("/WEB-INF/views/schdl/schdl.jsp");
		
		//Schdl�뀒�씠釉� �쟾泥� 議고쉶 SchdlService媛앹껜 �씠�슜
		List<Schdl> SchdlList = schdlService.list();
		
		for (Schdl e : SchdlList ) {
			System.out.println(e);
		}
		
		req.setAttribute("list", SchdlList);

		req.getRequestDispatcher("/WEB-INF/views/sh/schdl.jsp")
			.forward(req, resp);
		
	}

	
		
		
		
		
		
	
	
}
