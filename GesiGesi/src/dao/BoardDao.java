package dao;

import java.sql.Connection;

import dto.Bbs;

public interface BoardDao {
	
	public Bbs selectByNo(Connection conn, Bbs bbs);
	
	public void updatebbs(Connection conn, Bbs updatebbs);

}
