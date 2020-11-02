package dto.mbs;

public class MembersTb {
	
	private int user_no; 
	private String user_name;
	private int user_grade;
	private int dept_no;
	private int position_no;
	private String user_id;
	private int state_no;
	
	@Override
	public String toString() {
		return "GradeMem [user_no=" + user_no + ", user_name=" + user_name + ", user_grade=" + user_grade + ", dept_no="
				+ dept_no + ", position_no=" + position_no + ", user_id=" + user_id + ", state_no=" + state_no
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
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
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getState_no() {
		return state_no;
	}
	public void setState_no(int state_no) {
		this.state_no = state_no;
	}
	
	
	
	
	
	

}
