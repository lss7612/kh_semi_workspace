package dao.face.appr;

import java.sql.Connection;

import dto.appr.Appr;
import dto.appr.ApprFile;


public interface FileDao {

	/**
	 * 전달파라미터 데이터 삽입
	 * @param connection - DB연결 객체
	 * @param paramData - 저장할 전달데이터 정보 객체
	 */
	int insertParam(Connection connection, Appr paramData);
	/**
	 * 파일 정보 삽입
	 * @param connection - DB연결 객체
	 * @param uploadFile - 저장할 파일 정보 객체
	 */
	int insertFile(Connection connection, ApprFile uploadFile);


	
}
