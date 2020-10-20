package dto.addr;

public class AddrView {
	
	private String user_id;
	private String user_name;
	private int dept_no;
	private int position_no;
	private String cellphone_no;
	@Override
	public String toString() {
		return "AddrView [user_id=" + user_id + ", user_name=" + user_name + ", dept_no=" + dept_no + ", position_no="
				+ position_no + ", cellphone_no=" + cellphone_no + "]";
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
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
	
	
		
}
