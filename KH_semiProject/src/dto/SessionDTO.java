package dto;

public class SessionDTO {
	
	private int user_no;
	private String user_name;
	private String grade_name;
	private int grade_no;
	private String user_id;
	
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
	public String getGrade_name() {
		return grade_name;
	}
	public void setGrade_name(String grade_name) {
		this.grade_name = grade_name;
	}
	public int getGrade_no() {
		return grade_no;
	}
	public void setGrade_no(int grade_no) {
		this.grade_no = grade_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "SessionDTO [user_no=" + user_no + ", user_name=" + user_name + ", grade_name=" + grade_name
				+ ", grade_no=" + grade_no + ", user_id=" + user_id + "]";
	}
	
	

	
	

}
