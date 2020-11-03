package hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/hello") //URL ������ �����Ѵ�
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		System.out.println("/hello - ���� ���� �Ϸ�");
	
		//���䵥������ ���� �����ϱ�
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = resp.getWriter()	;
		
		
		out.append("<h1> �������� </h1>")
			.append("<h3>�ߵǳ���???</h3>");
		
	}
}
