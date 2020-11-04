package dto.appr;

public class Person {
	 private int user_no;
	 private String user_name;
	 private String user_id;
	 private String dept_name;
	@Override
	public String toString() {
		return "Tree [user_no=" + user_no + ", user_name=" + user_name + ", user_id=" + user_id + ", dept_name="
				+ dept_name + "]";
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
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	 
	 
}
