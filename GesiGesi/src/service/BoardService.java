package service;

import dto.Bbs;

public interface BoardService {
	
	/**
	 * 게시글 읽기
	 * @param bbs
	 * @return
	 */
	public Bbs detail(Bbs bbs);

}
