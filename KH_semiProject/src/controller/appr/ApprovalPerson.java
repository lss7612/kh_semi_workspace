package controller.appr;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import common.JDBCTemplate;
import dao.face.appr.ApprovalPersonDao;
import dao.impl.appr.ApprovalPersonDaoImpl;
import dto.appr.Person;


/**
 * Servlet implementation class ApprovalPerson
 */
@WebServlet("/approval/person")
public class ApprovalPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doget okokok");
		HttpSession session = req.getSession();
		String user_id = (String)session.getAttribute("user_id");
		System.out.println(user_id);

		
		ApprovalPersonDao approvalPerson = new ApprovalPersonDaoImpl();
		
		
		List<Person> people = approvalPerson.selectDeptAndName(JDBCTemplate.getConnection());
		
		System.out.println(people);
		
		req.setAttribute("people", people);
		List<Person> dept_name = approvalPerson.selectDept(JDBCTemplate.getConnection());
		
		req.setAttribute("dept_name", dept_name);
		
		
		System.out.println(req.getHeader("referer"));
		String result = req.getHeader("referer").substring(req.getHeader("referer").lastIndexOf("/")+1);
		System.out.println("야이!"+result); 
		String res= req.getHeader("referer").substring(req.getHeader("referer").lastIndexOf("/")+1,req.getHeader("referer").lastIndexOf("/")+8);
		System.out.println("res!"+res); 
		
		if(result.equals("approvalWriteWork")) {
			
			req.getRequestDispatcher("/views/appovalViews/jquery-treeview/demo/tree2.jsp").forward(req,resp);
		}else if(result.equals("approvalWrite")){
			req.getRequestDispatcher("/views/appovalViews/jquery-treeview/demo/Tree.jsp").forward(req,resp);
		}else if(res.equals("modHoly")){
			req.getRequestDispatcher("/views/appovalViews/jquery-treeview/demo/tree3.jsp").forward(req,resp);
		}else {
			req.getRequestDispatcher("/views/appovalViews/jquery-treeview/demo/tree4.jsp").forward(req,resp);
		}
	}
}
