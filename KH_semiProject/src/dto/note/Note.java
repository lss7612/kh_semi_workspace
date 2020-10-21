package dto.note;

import java.util.Date;

public class Note {

	private int note_no;
	private int user_no;
	private String note_title;
	private String note_article;
	private Date send_date;
	private int table_no;
	private int isDelete;
	
	@Override
	public String toString() {
		return "Note [note_no=" + note_no + ", user_no=" + user_no + ", note_title=" + note_title + ", note_article="
				+ note_article + ", send_date=" + send_date + ", table_no=" + table_no + ", isDelete=" + isDelete + "]";
	}
	public int getNote_no() {
		return note_no;
	}
	public void setNote_no(int note_no) {
		this.note_no = note_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
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
	public Date getSend_date() {
		return send_date;
	}
	public void setSend_date(Date send_date) {
		this.send_date = send_date;
	}
	public int getTable_no() {
		return table_no;
	}
	public void setTable_no(int table_no) {
		this.table_no = table_no;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	
	
	
}
