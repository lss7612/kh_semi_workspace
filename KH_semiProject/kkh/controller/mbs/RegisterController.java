package controller.mbs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.mbs.Register;
import service.face.mbs.RegisterService;
import service.impl.mbs.RegisterServiceImpl;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/register/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// MemberService 객체 생성
	private RegisterService registerService = new RegisterServiceImpl();
       
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
			
			System.out.println("login - doget");
			req.getRequestDispatcher("/views/register/register.jsp")
			 .forward(req, resp);
			
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("login - dopost");
			//전달데이터 한글 인코딩 설정(UTF-8)
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html; charset=utf-8");
			
			Register param = registerService.getParam(req);
			
			Register result = registerService.join(param);
			
			req.setAttribute("result",result);
			System.out.println(result+"확인");
			
			req.getRequestDispatcher("/views/register/registerS.jsp").forward(req, resp);
			
			
	
			
			
			
		}
	}

	
