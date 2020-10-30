package dto.mbs;

import java.sql.Date;


public class Register {
	private int user_no;
	private String user_name;
	private int user_grade;
	private String user_addr;
	private String user_identify;
	private int dept_no;
	private int position_no;
	private String cellphone_no;
	private String user_id;
	private String user_pw;
	private String user_notice;
	private int state_no;
	private String user_ip;
	private Date  revision_date; 
	private int table_no = 10;
	private String user_addr2;
	private String user_addr3;
	
	public String getUser_addr2() {
		return user_addr2;
	}

	public void setUser_addr2(String user_addr2) {
		this.user_addr2 = user_addr2;
	}

	public String getUser_addr3() {
		return user_addr3;
	}

	public void setUser_addr3(String user_addr3) {
		this.user_addr3 = user_addr3;
	}
		

	@Override
	public String toString() {
		return "Register [user_no=" + user_no + ", user_name=" + user_name + ", user_grade=" + user_grade
				+ ", user_addr=" + user_addr + ", user_identify=" + user_identify + ", dept_no=" + dept_no
				+ ", position_no=" + position_no + ", cellphone_no=" + cellphone_no + ", user_id=" + user_id
				+ ", user_pw=" + user_pw + ", user_notice=" + user_notice + ", state_no=" + state_no + ", user_ip="
				+ user_ip + ", revision_date=" + revision_date + ", table_no=" + table_no + ", user_addr2=" + user_addr2
				+ ", user_addr3=" + user_addr3 + "]";
	}

	public Date getRevision_date() {
		return revision_date;
	}

	public void setRevision_date(Date revision_date) {
		this.revision_date = revision_date;
	}

	

	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getUser_grade() {
		return user_grade;
	}
	public void setUser_grade(int user_grade) {
		this.user_grade = user_grade;
	}
	public String getUser_addr() {
		return user_addr;
	}
	public void setUser_addr(String user_addr) {
		this.user_addr = user_addr;
	}
	public String getUser_identify() {
		return user_identify;
	}
	public void setUser_identify(String user_identify) {
		this.user_identify = user_identify;
	}
	public int getDept_no() {
		return dept_no;
	}
	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}
	public int getPosition_no() {
		return position_no;
	}
	public void setPosition_no(int position_no) {
		this.position_no = position_no;
	}
	public String getCellphone_no() {
		return cellphone_no;
	}
	public void setCellphone_no(String cellphone_no) {
		this.cellphone_no = cellphone_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_notice() {
		return user_notice;
	}
	public void setUser_notice(String user_notice) {
		this.user_notice = user_notice;
	}
	public int getState_no() {
		return state_no;
	}
	public void setState_no(int state_no) {
		this.state_no = state_no;
	}
	public String getUser_ip() {
		return user_ip;
	}
	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}
	public int getTable_no() {
		return table_no;
	}
	public void setTable_no(int table_no) {
		this.table_no = table_no;
	}

	
	
}
