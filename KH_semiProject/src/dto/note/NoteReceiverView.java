package dto.note;

import java.util.List;

public class NoteReceiverView {
	
	private String dept_name;
	private String user_name;
	private int user_no;
	private List<Integer> addressBook;
	@Override
	public String toString() {
		return "NoteReceiverView [dept_name=" + dept_name + ", user_name=" + user_name + ", user_no=" + user_no
				+ ", addressBook=" + addressBook + "]";
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public List<Integer> getAddressBook() {
		return addressBook;
	}
	public void setAddressBook(List<Integer> addressBook) {
		this.addressBook = addressBook;
	}
	
	
}
