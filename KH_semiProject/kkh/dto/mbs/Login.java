package dto.mbs;


public class Login {
		private String user_id;
		private String user_pw;
		private String user_name;
		

		@Override
		public String toString() {
			return "Login [user_id=" + user_id + ", user_pw=" + user_pw + ", user_name=" + user_name + "]";
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
		public String getUser_pw() {
			return user_pw;
		}
		public void setUser_pw(String user_pw) {
			this.user_pw = user_pw;
		}
		
		
		
		
}
