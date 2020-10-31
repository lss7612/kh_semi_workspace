package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dto.ChatUserInfo;

public class CheckUserRoom {

	int user0_no = 0;
	int user1_no = 0;
	
	
	public CheckUserRoom(HttpServletRequest req) {
		HttpSession session = getSession(req);
		getUserInfo(req,session);
	}
	
	public HttpSession getSession(HttpServletRequest req) {
		HttpSession session = req.getSession();
		return session;
	}
	
	public ChatUserInfo getUserInfo(HttpServletRequest req, HttpSession session) {
		ChatUserInfo userinfo = (ChatUserInfo)session.getAttribute("userinfo");
		return userinfo;
	}
	
}
