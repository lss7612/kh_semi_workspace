package dto.appr;

import java.sql.Date;
import java.sql.Timestamp;

public class Appr {

	private int apprl_no;
	private int user_no;
	private int mid_auth;
	private int final_auth;
	private int aprvl_state;
	private Date create_date;
	private Date final_date;
	private String aprvl_type;
	private String aprvl_title;
	private String aprvl_article;
	private int table_no;
	private int send_user_no;
	private Timestamp holiday_start;
	private Timestamp holiday_end;
	private String appr_holi_kind;
	
	//추가해줌내가 ..유저아이디값받아올려고
	private String User_id;
	
	//ApprovalMyDetail용
	private String mid_auth_name;
	private String final_auth_name;
	private String file_name;
	private String file_origin_name;
	private String file_path;
	private String User_name;
	@Override
	public String toString() {
		return "Appr [apprl_no=" + apprl_no + ", user_no=" + user_no + ", mid_auth=" + mid_auth + ", final_auth="
				+ final_auth + ", aprvl_state=" + aprvl_state + ", create_date=" + create_date + ", final_date="
				+ final_date + ", aprvl_type=" + aprvl_type + ", aprvl_title=" + aprvl_title + ", aprvl_article="
				+ aprvl_article + ", table_no=" + table_no + ", send_user_no=" + send_user_no + ", holiday_start="
				+ holiday_start + ", holiday_end=" + holiday_end + ", appr_holi_kind=" + appr_holi_kind + ", User_id="
				+ User_id + ", mid_auth_name=" + mid_auth_name + ", final_auth_name=" + final_auth_name + ", file_name="
				+ file_name + ", file_origin_name=" + file_origin_name + ", file_path=" + file_path + ", User_name="
				+ User_name + "]";
	}
	public int getApprl_no() {
		return apprl_no;
	}
	public void setApprl_no(int apprl_no) {
		this.apprl_no = apprl_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
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
	public int getAprvl_state() {
		return aprvl_state;
	}
	public void setAprvl_state(int aprvl_state) {
		this.aprvl_state = aprvl_state;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getFinal_date() {
		return final_date;
	}
	public void setFinal_date(Date final_date) {
		this.final_date = final_date;
	}
	public String getAprvl_type() {
		return aprvl_type;
	}
	public void setAprvl_type(String aprvl_type) {
		this.aprvl_type = aprvl_type;
	}
	public String getAprvl_title() {
		return aprvl_title;
	}
	public void setAprvl_title(String aprvl_title) {
		this.aprvl_title = aprvl_title;
	}
	public String getAprvl_article() {
		return aprvl_article;
	}
	public void setAprvl_article(String aprvl_article) {
		this.aprvl_article = aprvl_article;
	}
	public int getTable_no() {
		return table_no;
	}
	public void setTable_no(int table_no) {
		this.table_no = table_no;
	}
	public int getSend_user_no() {
		return send_user_no;
	}
	public void setSend_user_no(int send_user_no) {
		this.send_user_no = send_user_no;
	}
	public Timestamp getHoliday_start() {
		return holiday_start;
	}
	public void setHoliday_start(Timestamp holiday_start) {
		this.holiday_start = holiday_start;
	}
	public Timestamp getHoliday_end() {
		return holiday_end;
	}
	public void setHoliday_end(Timestamp holiday_end) {
		this.holiday_end = holiday_end;
	}
	public String getAppr_holi_kind() {
		return appr_holi_kind;
	}
	public void setAppr_holi_kind(String appr_holi_kind) {
		this.appr_holi_kind = appr_holi_kind;
	}
	public String getUser_id() {
		return User_id;
	}
	public void setUser_id(String user_id) {
		User_id = user_id;
	}
	public String getMid_auth_name() {
		return mid_auth_name;
	}
	public void setMid_auth_name(String mid_auth_name) {
		this.mid_auth_name = mid_auth_name;
	}
	public String getFinal_auth_name() {
		return final_auth_name;
	}
	public void setFinal_auth_name(String final_auth_name) {
		this.final_auth_name = final_auth_name;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_origin_name() {
		return file_origin_name;
	}
	public void setFile_origin_name(String file_origin_name) {
		this.file_origin_name = file_origin_name;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getUser_name() {
		return User_name;
	}
	public void setUser_name(String user_name) {
		User_name = user_name;
	}


	


	
	
	
	
}
