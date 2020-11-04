package controller.sh;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.sh.Shinput;
import service.face.sh.ShinputService;
import service.impl.sh.ShinputServiceimpl;



@WebServlet("/semi/SchdlInput")		
public class shinputcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ShinputService shinputService = new ShinputServiceimpl();
	
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("스케줄 인풋 겟 요청");
		
		//뷰 지정하고 응답하기
		req.getRequestDispatcher("/views/sh/shInputForm.jsp")
			.forward(req, resp);
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		System.out.println("스케줄 인풋 포스트 요청");
		
		//1. 포스트 데이터 한글 인코딩
		req.setCharacterEncoding("UTF-8");
		
		//2. 전달 파라미터 스케줄 객체에 저장 - ShinputService 이용
		
		Shinput param = shinputService.getParam(req);
		
		
		System.out.println("전달 객체 확인");
		
						
		 req.getRequestDispatcher("/views/sh/shinputFormPost.jsp")
		 	.forward(req, resp);
		 
		
		//3. 스케줄 객체 데이터 베이스 입력
		 Shinput result = shinputService.join(param);
		 System.out.println("스케줄 컨트롤러 리절트" + result);
		 
		//4. db에 입력된 값 뷰에 전달
		req.setAttribute("result", result);
		 
		 
		//5. 뷰를 지정하고 응답하기
		req.getRequestDispatcher("/WEB-INF/views/sh/result.jsp");
		
		
	}


	
 

}
