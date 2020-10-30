package controller.mbs;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.face.mbs.MembersTbDao;
import dto.mbs.MembersTb;

/**
 * Servlet implementation class MembersTb
 */
@WebServlet("/members/members")
public class MembersTbController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 // 요청한 URL
	    String url = req.getRequestURL().toString();
	    System.out.println(url);
			
	    // 컨텍스트 패스
	    String context = req.getContextPath();
			
	    MembersTbDao dao = new MembersTbDao();
			
	    if(url.indexOf("list.do") != -1) {	// list 를 요청한 경우
				
	      // Member의 각각의 정보를 list에 담습니다. 
	      List<MembersTb> list = dao.memberList();
				
	      // Member의 정보 list를 map에 한번에 묶어서 넣습니다.
	      Map<String, Object> map = new HashMap<String, Object>();
				
	      // map 에 저장합니다.
	      map.put("list", list);
	      map.put("count", list.size());
	      req.setAttribute("map", map);
	      System.out.println(map);
				
	      // Member List를 출력하여 보여주기 위해서 map 값을 member_list 로 전송시킵니다.  
	      String page = "/page/member_list.jsp";
	      RequestDispatcher rd = req.getRequestDispatcher(page);
	      rd.forward(req, resp);
	    } 
	  }
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			
		
		}
	

}
