package dto.chat;

public class ChatUserList {

	private int user_no;
	private String user_name;
	private int dept_no;
	private String dept_name;
	private int position_no;
	private String position_name;
	private String cellphone_no;
	private String extension_no;
	@Override
	public String toString() {
		return "ChatUserList [user_no=" + user_no + ", user_name=" + user_name + ", dept_no=" + dept_no + ", dept_name="
				+ dept_name + ", position_no=" + position_no + ", position_name=" + position_name + ", cellphone_no="
				+ cellphone_no + ", extension_no=" + extension_no + "]";
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
	public int getDept_no() {
		return dept_no;
	}
	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public int getPosition_no() {
		return position_no;
	}
	public void setPosition_no(int position_no) {
		this.position_no = position_no;
	}
	public String getPosition_name() {
		return position_name;
	}
	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}
	public String getCellphone_no() {
		return cellphone_no;
	}
	public void setCellphone_no(String cellphone_no) {
		this.cellphone_no = cellphone_no;
	}
	public String getExtension_no() {
		return extension_no;
	}
	public void setExtension_no(String extension_no) {
		this.extension_no = extension_no;
	}
}