package dao;

import java.sql.Connection;

import dto.Bbs;

public interface BoardDao {
	
	public Bbs selectByNo(Connection conn, Bbs bbs);
	
	public void updatebbs(Connection conn, Bbs updatebbs);
	
	public int write(Connection conn, Bbs write);

	public int insertNo(Connection conn, int user_no, String article_title, String article_content);

}
