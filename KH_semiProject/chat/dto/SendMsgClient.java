package dto;

public class SendMsgClient {

	private String winfo;
	private String msgContent;
	private String chatTime;
	
	@Override
	public String toString() {
		return "SendMsgClient [winfo=" + winfo + ", msgContent=" + msgContent + ", chatTime=" + chatTime + "]";
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
}
