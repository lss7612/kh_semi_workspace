package dto.sh;

import java.util.Date;

public class Schdl {

	private int schdl_no;
	private int schdl_type;
	private int user_no;
	private String schdl_title;
	private String schdl_content;
	private Date schdl_start;
	private Date schdl_end;
	private Date revision_date;
	private int table_no;
	
	@Override
	public String toString() {
		return "Schdl [schdl_no=" + schdl_no + ", schdl_type=" + schdl_type + ", user_no=" + user_no + ", schdl_title="
				+ schdl_title + ", schdl_content=" + schdl_content + ", schdl_start=" + schdl_start + ", schdl_end="
				+ schdl_end + ", revision_date=" + revision_date + ", table_no=" + table_no + "]";
	}

	public int getSchdl_no() {
		return schdl_no;
	}

	public void setSchdl_no(int schdl_no) {
		this.schdl_no = schdl_no;
	}

	public int getSchdl_type() {
		return schdl_type;
	}

	public void setSchdl_type(int schdl_type) {
		this.schdl_type = schdl_type;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getSchdl_title() {
		return schdl_title;
	}

	public void setSchdl_title(String schdl_title) {
		this.schdl_title = schdl_title;
	}

	public String getSchdl_content() {
		return schdl_content;
	}

	public void setSchdl_content(String schdl_content) {
		this.schdl_content = schdl_content;
	}

	public Date getSchdl_start() {
		return schdl_start;
	}

	public void setSchdl_start(Date schdl_start) {
		this.schdl_start = schdl_start;
	}

	public Date getSchdl_end() {
		return schdl_end;
	}

	public void setSchdl_end(Date schdl_end) {
		this.schdl_end = schdl_end;
	}

	public Date getRevision_date() {
		return revision_date;
	}

	public void setRevision_date(Date revision_date) {
		this.revision_date = revision_date;
	}

	public int getTable_no() {
		return table_no;
	}

	public void setTable_no(int table_no) {
		this.table_no = table_no;
	}

	
	
	
	
	
	
}
