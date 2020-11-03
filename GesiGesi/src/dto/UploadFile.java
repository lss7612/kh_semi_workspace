package dto;

public class UploadFile {
	
	 private int file_no;
	 private int article_no;
	 private int table_no;
	 private String file_addr;
	 private String origin_name;
	 private String stored_name;
	public int getFile_no() {
		return file_no;
	}
	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}
	public int getArticle_no() {
		return article_no;
	}
	public void setArticle_no(int article_no) {
		this.article_no = article_no;
	}
	public int getTable_no() {
		return table_no;
	}
	public void setTable_no(int table_no) {
		this.table_no = table_no;
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
	@Override
	public String toString() {
		return "FileUpload [file_no=" + file_no + ", article_no=" + article_no + ", table_no=" + table_no
				+ ", file_addr=" + file_addr + ", origin_name=" + origin_name + ", stored_name=" + stored_name + "]";
	}
	 
	 

}
