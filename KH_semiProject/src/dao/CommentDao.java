package dao;

import java.sql.Connection;
import java.sql.SQLException;

import dto.Comment;

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
	
	public Comment getOne(int cmt_no) throws SQLException{
		Comment comment = new Comment();
		String sql = "";

		
		
		return null;
		
	}
	
	
	
	
	
	
}
