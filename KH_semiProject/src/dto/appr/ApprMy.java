package dto.appr;

import java.util.Date;

public class ApprMy {

	private int aprvl_no;
	private int user_no;
	private String user_name;
	private String dept_name;
	private String position_name;
	private String aprvl_title;
	private String aprvl_type;
	private Date create_date;
	private int aprvl_state;
	private Date final_date;
	private String state_name;
	private String user_id;
	private String aprvl_article;
	private String final_auth_name;
	private String mid_auth_name;
	private int mid_auth;
	private int final_auth;
	@Override
	public String toString() {
		return "ApprMy [aprvl_no=" + aprvl_no + ", user_no=" + user_no + ", user_name=" + user_name + ", dept_name="
				+ dept_name + ", position_name=" + position_name + ", aprvl_title=" + aprvl_title + ", aprvl_type="
				+ aprvl_type + ", create_date=" + create_date + ", aprvl_state=" + aprvl_state + ", final_date="
				+ final_date + ", state_name=" + state_name + ", user_id=" + user_id + ", aprvl_article="
				+ aprvl_article + ", final_auth_name=" + final_auth_name + ", mid_auth_name=" + mid_auth_name
				+ ", mid_auth=" + mid_auth + ", final_auth=" + final_auth + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public int getAprvl_no() {
		return aprvl_no;
	}
	public void setAprvl_no(int aprvl_no) {
		this.aprvl_no = aprvl_no;
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
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getPosition_name() {
		return position_name;
	}
	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}
	public String getAprvl_title() {
		return aprvl_title;
	}
	public void setAprvl_title(String aprvl_title) {
		this.aprvl_title = aprvl_title;
	}
	public String getAprvl_type() {
		return aprvl_type;
	}
	public void setAprvl_type(String aprvl_type) {
		this.aprvl_type = aprvl_type;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public int getAprvl_state() {
		return aprvl_state;
	}
	public void setAprvl_state(int aprvl_state) {
		this.aprvl_state = aprvl_state;
	}
	public Date getFinal_date() {
		return final_date;
	}
	public void setFinal_date(Date final_date) {
		this.final_date = final_date;
	}
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getAprvl_article() {
		return aprvl_article;
	}
	public void setAprvl_article(String aprvl_article) {
		this.aprvl_article = aprvl_article;
	}
	public String getFinal_auth_name() {
		return final_auth_name;
	}
	public void setFinal_auth_name(String final_auth_name) {
		this.final_auth_name = final_auth_name;
	}
	public String getMid_auth_name() {
		return mid_auth_name;
	}
	public void setMid_auth_name(String mid_auth_name) {
		this.mid_auth_name = mid_auth_name;
	}
	public int getMid_auth() {
		return mid_auth;
	}
	public void setMid_auth(int mid_auth) {
		this.mid_auth = mid_auth;
	}
	public int getFinal_auth() {
		return final_auth;
	}
	public void setFinal_auth(int final_auth) {
		this.final_auth = final_auth;
	}
	
	
	
}
