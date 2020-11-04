package dto;

import java.sql.Timestamp;

public class Comment {
	
	private int user_no;
	private String cmt_pw;
	private String cmt_content;
	private Timestamp revision_date;
	private int isdelete;
	private int cmt_no;
	private int article_no;
	private int table_no;
	
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getCmt_pw() {
		return cmt_pw;
	}
	public void setCmt_pw(String cmt_pw) {
		this.cmt_pw = cmt_pw;
	}
	public String getCmt_content() {
		return cmt_content;
	}
	public void setCmt_content(String cmt_content) {
		this.cmt_content = cmt_content;
	}
	public Timestamp getRevision_date() {
		return revision_date;
	}
	public void setRevision_date(Timestamp revision_date) {
		this.revision_date = revision_date;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	public int getCmt_no() {
		return cmt_no;
	}
	public void setCmt_no(int cmt_no) {
		this.cmt_no = cmt_no;
	}
	public int getArticle_no() {
		return article_no;
	}
	public void setArticle_no(int article_no) {
		this.article_no = article_no;
	}
	public int getTable_no() {
		return table_no;
	}
	public void setTable_no(int table_no) {
		this.table_no = table_no;
	}
	
	@Override
	public String toString() {
		return "Comment [user_no=" + user_no + ", cmt_pw=" + cmt_pw + ", cmt_content=" + cmt_content
				+ ", revision_date=" + revision_date + ", isdelete=" + isdelete + ", cmt_no=" + cmt_no + ", article_no="
				+ article_no + ", table_no=" + table_no + "]";
	}
	
	

}
