package dto;

import java.util.Date;

public class Chat {

	private int tabel_no = 30;
	private int chatting_no;
	private int user_total;
	private int idx;
	private int user_no;
	private String user_name;
	private int msg_no;
	private String msg_content;
	private String revision_date;
	private String user_ip;
	
	@Override
	public String toString() {
		return "Chat [tabel_no=" + tabel_no + ", chatting_no=" + chatting_no + ", user_total=" + user_total + ", idx="
				+ idx + ", user_no=" + user_no + ", user_name=" + user_name + ", msg_no=" + msg_no + ", msg_content="
				+ msg_content + ", revision_date=" + revision_date + ", user_ip=" + user_ip + "]";
	}
	public int getTabel_no() {
		return tabel_no;
	}
	public void setTabel_no(int tabel_no) {
		this.tabel_no = tabel_no;
	}
	public int getChatting_no() {
		return chatting_no;
	}
	public void setChatting_no(int chatting_no) {
		this.chatting_no = chatting_no;
	}
	public int getUser_total() {
		return user_total;
	}
	public void setUser_total(int user_total) {
		this.user_total = user_total;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getMsg_no() {
		return msg_no;
	}
	public void setMsg_no(int msg_no) {
		this.msg_no = msg_no;
	}
	public String getMsg_content() {
		return msg_content;
	}
	public void setMsg_content(String msg_content) {
		this.msg_content = msg_content;
	}
	public String getRevision_date() {
		return revision_date;
	}
	public void setRevision_date(String revision_date) {
		this.revision_date = revision_date;
	}
	public String getUser_ip() {
		return user_ip;
	}
	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}
	
}
