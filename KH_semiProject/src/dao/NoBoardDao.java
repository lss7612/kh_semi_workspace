package dao;

import java.sql.Connection;
import java.util.List;

import common.Paging;
import dto.Bbs;

public interface NoBoardDao {
	
	/**
	 * 게시글 전체 목록 조회
	 * @param connection - DB연결 객체
	 * @return 조회된 게시글 목록
	 */
	public List<Bbs> selectList(Connection connection);

	/**
	 * 총 게시글 수 조회
	 * 
	 * @return 전체 게시글 수
	 */
	public int selectCntAll(Connection connection);

	/**
	 * 페이징 대상 게시글 목록 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return 조회된 게시글 목록
	 */
	public List<Bbs> selectList(Connection connection, Paging paging);
	
	
	
	public int anselectCntAll(Connection connection);

	/**
	 * 페이징 대상 게시글 목록 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return 조회된 게시글 목록
	 */
	public List<Bbs> anselectList(Connection connection, Paging paging);

}
