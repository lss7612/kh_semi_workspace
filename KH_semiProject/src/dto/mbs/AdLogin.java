package dto.mbs;


public class AdLogin{
	private String user_id;
	private String user_pw;
	private String user_name;
	private int user_grade;
	
	 public AdLogin() {
		    super();
		    
	 }
	
	public AdLogin(String user_id, String user_pw, String user_name, int user_grade) {
		super();
	    this.user_id = user_id;
	    this.user_pw = user_pw;
	    this.user_name = user_name;
	    this.user_grade = user_grade;
	}
	
	
	
	@Override
	public String toString() {
		return "AdLogin [user_id=" + user_id 
				+ ", user_pw=" + user_pw 
				+ ", user_name=" + user_name 
				+ ",user_grade=" + user_grade + "]";
	}



	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getGrade_no() {
		return user_grade;
	}
	public void setGrade_no(int grade_no) {
		this.user_grade = grade_no;
	}
	


	
	
}
