package dto;

import java.util.Date;

public class ChattingContent {

	private int chatting_no;
	private int msg_no;
	private int user_no;
	private String msg_content;
	private Date revision_date;
	private int user_ip;
	
	@Override
	public String toString() {
		return "ChattingContent [chatting_no=" + chatting_no + ", msg_no=" + msg_no + ", user_no=" + user_no
				+ ", msg_content=" + msg_content + ", revision_date=" + revision_date + ", user_ip=" + user_ip + "]";
	}
	public int getChatting_no() {
		return chatting_no;
	}
	public void setChatting_no(int chatting_no) {
		this.chatting_no = chatting_no;
	}
	public int getMsg_no() {
		return msg_no;
	}
	public void setMsg_no(int msg_no) {
		this.msg_no = msg_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getMsg_content() {
		return msg_content;
	}
	public void setMsg_content(String msg_content) {
		this.msg_content = msg_content;
	}
	public Date getRevision_date() {
		return revision_date;
	}
	public void setRevision_date(Date revision_date) {
		this.revision_date = revision_date;
	}
	public int getUser_ip() {
		return user_ip;
	}
	public void setUser_ip(int user_ip) {
		this.user_ip = user_ip;
	}
	
	
}
