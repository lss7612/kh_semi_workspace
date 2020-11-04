package dto.chat;

public class SendMsgClient {

	private String winfo;
	private String msgContent;
	private String chatTime;
	private String profile_img;
	private int user_no;

	@Override
	public String toString() {
		return "SendMsgClient [winfo=" + winfo + ", msgContent=" + msgContent + ", chatTime=" + chatTime + ", profile_img="
				+ profile_img + ", user_no=" + user_no + "]";
	}
	public String getWinfo() {
		return winfo;
	}
	public void setWinfo(String winfo) {
		this.winfo = winfo;
	}
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	public String getChatTime() {
		return chatTime;
	}
	public void setChatTime(String chatTime) {
		this.chatTime = chatTime;
	}
	public String getProfile_img() {
		return profile_img;
	}
	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
}