package dto;

import java.sql.Timestamp;

public class Bbs {
	
	private int table_no;
	private int article_no;
	private String article_content;
	private String article_pw;
	private String article_title;
	private Timestamp revision_date;
	private int attfile_no;
	private int isdelete;
	private int user_ip;
	private int user_no;
	private int readcount;
	
	public int getTable_no() {
		return table_no;
	}
	public void setTable_no(int table_no) {
		this.table_no = table_no;
	}
	public int getArticle_no() {
		return article_no;
	}
	public void setArticle_no(int article_no) {
		this.article_no = article_no;
	}
	public String getArticle_content() {
		return article_content;
	}
	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}
	public String getArticle_pw() {
		return article_pw;
	}
	public void setArticle_pw(String article_pw) {
		this.article_pw = article_pw;
	}
	public String getArticle_title() {
		return article_title;
	}
	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}
	public Timestamp getRevision_date() {
		return revision_date;
	}
	public void setRevision_date(Timestamp revision_date) {
		this.revision_date = revision_date;
	}
	public int getAttfile_no() {
		return attfile_no;
	}
	public void setAttfile_no(int attfile_no) {
		this.attfile_no = attfile_no;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	public int getUser_ip() {
		return user_ip;
	}
	public void setUser_ip(int user_ip) {
		this.user_ip = user_ip;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	

	
	public void setUser_no(String parameter) {
		// TODO Auto-generated method stub
		
	}
	
}
