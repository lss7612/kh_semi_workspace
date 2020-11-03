package dto.note;

import java.util.Date;
import java.util.List;

import dto.addr.AddrView;

public class NoteList {
	
	private int sender_no;
	private String sender_name;
	private int note_no;
	private int isDelete;
	private int receiver_no;
	private int cntReceiver;
	private String senderDept_name;
	private String receiver_name;
	private String note_title;
	private String note_article;
	private String send_date;
	private List<AddrView> receivers;
	private String position;
	@Override
	public String toString() {
		return "NoteList [sender_no=" + sender_no + ", sender_name=" + sender_name + ", note_no=" + note_no
				+ ", isDelete=" + isDelete + ", receiver_no=" + receiver_no + ", cntReceiver=" + cntReceiver
				+ ", senderDept_name=" + senderDept_name + ", receiver_name=" + receiver_name + ", note_title="
				+ note_title + ", note_article=" + note_article + ", send_date=" + send_date + ", receivers="
				+ receivers + ", position=" + position + "]";
	}
	public int getSender_no() {
		return sender_no;
	}
	public void setSender_no(int sender_no) {
		this.sender_no = sender_no;
	}
	public String getSender_name() {
		return sender_name;
	}
	public void setSender_name(String sender_name) {
		this.sender_name = sender_name;
	}
	public int getNote_no() {
		return note_no;
	}
	public void setNote_no(int note_no) {
		this.note_no = note_no;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public int getReceiver_no() {
		return receiver_no;
	}
	public void setReceiver_no(int receiver_no) {
		this.receiver_no = receiver_no;
	}
	public int getCntReceiver() {
		return cntReceiver;
	}
	public void setCntReceiver(int cntReceiver) {
		this.cntReceiver = cntReceiver;
	}
	public String getSenderDept_name() {
		return senderDept_name;
	}
	public void setSenderDept_name(String senderDept_name) {
		this.senderDept_name = senderDept_name;
	}
	public String getReceiver_name() {
		return receiver_name;
	}
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}
	public String getNote_title() {
		return note_title;
	}
	public void setNote_title(String note_title) {
		this.note_title = note_title;
	}
	public String getNote_article() {
		return note_article;
	}
	public void setNote_article(String note_article) {
		this.note_article = note_article;
	}
	public String getSend_date() {
		return send_date;
	}
	public void setSend_date(String send_date) {
		this.send_date = send_date;
	}
	public List<AddrView> getReceivers() {
		return receivers;
	}
	public void setReceivers(List<AddrView> receivers) {
		this.receivers = receivers;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
	
	
	
}
