package dto;

public class ChatRoom {

	private int tabel_no = 30;
	private int chatting_no;
	private int user_total;

	@Override
	public String toString() {
		return "ChatRoom [tabel_no=" + tabel_no + ", chatting_no=" + chatting_no + ", user_total=" + user_total + "]";
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
	
	
	
}
