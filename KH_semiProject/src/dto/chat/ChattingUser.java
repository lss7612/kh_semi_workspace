package dto.chat;

public class ChattingUser {

	private int idx;
	private int chatting_no;
	private int usre_no;
	@Override
	public String toString() {
		return "ChattingUser [idx=" + idx + ", chatting_no=" + chatting_no + ", usre_no=" + usre_no + "]";
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getChatting_no() {
		return chatting_no;
	}
	public void setChatting_no(int chatting_no) {
		this.chatting_no = chatting_no;
	}
	public int getUsre_no() {
		return usre_no;
	}
	public void setUsre_no(int usre_no) {
		this.usre_no = usre_no;
	}
	
	
}
