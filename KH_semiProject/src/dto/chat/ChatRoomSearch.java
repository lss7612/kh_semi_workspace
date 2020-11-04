package dto.chat;

public class ChatRoomSearch {

	private int chatting_no;
	private int user_total;
	private int user_no;
	@Override
	public String toString() {
		return "ChatRoomSearch [chatting_no=" + chatting_no + ", user_total=" + user_total + ", user_no=" + user_no
				+ "]";
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
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
}
