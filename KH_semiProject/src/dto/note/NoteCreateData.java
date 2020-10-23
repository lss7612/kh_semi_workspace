package dto.note;

import java.util.Date;
import java.util.List;

public class NoteCreateData {

	private int note_no;
	private int user_no;
	private String note_title;
	private String note_article;
	private Date send_date;
	private int table_no;
	private int isDelete;
	private List<Integer> receiver;
	private int sender;
	
	@Override
	public String toString() {
		return "NoteCreateData [note_no=" + note_no + ", user_no=" + user_no + ", note_title=" + note_title
				+ ", note_article=" + note_article + ", send_date=" + send_date + ", table_no=" + table_no
				+ ", isDelete=" + isDelete + ", receiver=" + receiver + ", sender=" + sender + "]";
	}
	public final int getNote_no() {
		return note_no;
	}
	public final void setNote_no(int note_no) {
		this.note_no = note_no;
	}
	public final int getUser_no() {
		return user_no;
	}
	public final void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public final String getNote_title() {
		return note_title;
	}
	public final void setNote_title(String note_title) {
		this.note_title = note_title;
	}
	public final String getNote_article() {
		return note_article;
	}
	public final void setNote_article(String note_article) {
		this.note_article = note_article;
	}
	public final Date getSend_date() {
		return send_date;
	}
	public final void setSend_date(Date send_date) {
		this.send_date = send_date;
	}
	public final int getTable_no() {
		return table_no;
	}
	public final void setTable_no(int table_no) {
		this.table_no = table_no;
	}
	public final int getIsDelete() {
		return isDelete;
	}
	public final void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public final List<Integer> getReceiver() {
		return receiver;
	}
	public final void setReceiver(List<Integer> receiver) {
		this.receiver = receiver;
	}
	public final int getSender() {
		return sender;
	}
	public final void setSender(int sender) {
		this.sender = sender;
	}
	
}
