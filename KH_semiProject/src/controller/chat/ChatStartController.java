package controller.chat;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Paging;
import dto.chat.ChatUserList;
import dto.common.UserInfo;
import dto.addr.AddrParam;
import dto.addr.AddrView;
import dto.chat.Chat;
import service.face.addr.AddrViewService;
import service.face.chat.UserChatService;
import service.impl.addr.AddrViewServiceImpl;
import service.impl.chat.UserChatServiceImpl;

@WebServlet("/chathome/start")
public class ChatStartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AddrViewService addrViewService = new AddrViewServiceImpl();

	private UserChatService userChatService = new UserChatServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("\n> > >/chathome/start [GET] 접속< < <");
		
		//세션 정보 얻어오기
		HttpSession session = req.getSession();
		//세션 정보에서 회원번호 가져오기
		UserInfo userinfo = (UserInfo)session.getAttribute("userinfo");
		int user_no = userinfo.getUser_no();
		
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
			req.getRequestDispatcher("/views/chat/chatSelect.jsp").forward(req, resp);
		} else if(req.getParameter("arrayCondition") !=null || req.getParameter("isASC")!=null){
			req.setAttribute("list", list);
			req.getRequestDispatcher("/views/chat/chatSelect_ok.jsp");
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" > > >/chathome/start [POST] 요청 완료 < < <");
		
		
	}
}
