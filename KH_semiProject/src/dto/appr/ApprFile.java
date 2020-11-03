package dto.appr;

public class ApprFile {

	private int file_no;
	private String table_no;
	private int aprvl_no;
	private String file_addr;
	private String origin_name ;
	private String stored_name;
	@Override
	public String toString() {
		return "ApprFile [file_no=" + file_no + ", table_no=" + table_no + ", aprvl_no=" + aprvl_no + ", file_addr="
				+ file_addr + ", origin_name=" + origin_name + ", stored_name=" + stored_name + "]";
	}
	public int getFile_no() {
		return file_no;
	}
	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}
	public String getTable_no() {
		return table_no;
	}
	public void setTable_no(String table_no) {
		this.table_no = table_no;
	}
	public int getAprvl_no() {
		return aprvl_no;
	}
	public void setAprvl_no(int aprvl_no) {
		this.aprvl_no = aprvl_no;
	}
	public String getFile_addr() {
		return file_addr;
	}
	public void setFile_addr(String file_addr) {
		this.file_addr = file_addr;
	}
	public String getOrigin_name() {
		return origin_name;
	}
	public void setOrigin_name(String origin_name) {
		this.origin_name = origin_name;
	}
	public String getStored_name() {
		return stored_name;
	}
	public void setStored_name(String stored_name) {
		this.stored_name = stored_name;
	} 
	
	
}
