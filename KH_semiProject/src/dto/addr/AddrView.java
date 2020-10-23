package dto.addr;

public class AddrView {
	
	private int user_no;
	private String user_id;
	private String user_name;
	private String dept_name;
	private String position_name;
	private String cellphone_no;
	@Override
	public String toString() {
		return "AddrView [user_no=" + user_no + ", user_id=" + user_id + ", user_name=" + user_name + ", dept_name="
				+ dept_name + ", position_name=" + position_name + ", cellphone_no=" + cellphone_no + "]";
	}
	public final int getUser_no() {
		return user_no;
	}
	public final void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public final String getUser_id() {
		return user_id;
	}
	public final void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public final String getUser_name() {
		return user_name;
	}
	public final void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public final String getDept_name() {
		return dept_name;
	}
	public final void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public final String getPosition_name() {
		return position_name;
	}
	public final void setPosition_name(String position_name) {
		this.position_name = position_name;
	}
	public final String getCellphone_no() {
		return cellphone_no;
	}
	public final void setCellphone_no(String cellphone_no) {
		this.cellphone_no = cellphone_no;
	}
	
	
	
	
		
}
