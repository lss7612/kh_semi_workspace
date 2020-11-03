package dao;

import java.sql.Connection;

public class CommentDao {
	
	private static CommentDao comDao = new CommentDao();
	private CommentDao() {}
	public static CommentDao getInstance() {
	 return comDao;
	}
	
	private Connection conn;
	public void SetConnection(Connection conn) {
		this.conn = conn;
	}
	
	
	
	
	
	
}
