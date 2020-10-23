package dto.note;

import java.util.List;

public class NoteReceiverView {
	
	private String dept_name;
	private String user_name;
	private List<Integer> addressBook;
	
	@Override
	public String toString() {
		return "NoteRecieverView [dept_name=" + dept_name + ", user_name=" + user_name + ", addressBook=" + addressBook
				+ "]";
	}
	public final String getDept_name() {
		return dept_name;
	}
	public final void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public final String getUser_name() {
		return user_name;
	}
	public final void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public final List<Integer> getAddressBook() {
		return addressBook;
	}
	public final void setAddressBook(List<Integer> addressBook) {
		this.addressBook = addressBook;
	}
	
	
	
	

}
