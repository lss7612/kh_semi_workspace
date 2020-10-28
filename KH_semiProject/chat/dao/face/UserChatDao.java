package dao.face;

import java.sql.Connection;
import java.util.List;

import dto.Chat;
import dto.ChatUserInfo;
import dto.ChatUserList;

public interface UserChatDao {

	/**
	 * DB에서 ID를 통해 채팅에 필요한 유저 정보를 가져온다.
	 * @param conn - DB 연결객체
	 * @param parameter - userID
	 * @return ChatUserInfo형태의 반환값
	 */
	public ChatUserInfo bringInfo(Connection conn, String parameter);

	/**
	 * DB에서 회원번호를 통해 정보를 갖고온다.
	 * @param conn - DB연결 객체
	 * @param user1_no - 조회할 회원 번호
	 * @return
	 */
	public ChatUserInfo bringInfoByUserNo(Connection conn, int user1_no);
	
	/**
	 * 채팅에서 전달받은 msg를 db에 저장한다.
	 * @param conn - db연결 객체
	 * @param userno - msg를 보낸 회원의 번호
	 * @param message - 보낸msg
	 * @return - db에 성공적으로 입력되면 수행쿼 수 반환
	 */
	public int saveMsg(Connection conn, int userno, String message);

	/**
	 * 전달받은 회원 번호를 통해 해다 회원번호의 채팅목록을 가져온다.
	 * @param conn - db연결 객체
	 * @param user_no - 조회할 회원 번호
	 * @return 채팅 리스트
	 */
	public List<Chat> selectUserChatList(Connection conn, int user_no);

	/**
	 *  전달받은 회원 번호를 제외하고 목록을 가져온다.
	 * @param conn - db연결 객체
	 * @param user_no - 조회 제외할 회원 번호
	 * @return - 회원 목록
	 */
	public List<ChatUserList> getUserList(Connection conn, int user_no);

	/**
	 * 방 인원을 전달받아 방을 생성
	 * @param count - 방인원
	 */
	public int makeRoom(Connection conn, int count);
	
	/**
	 * 생성된 방 번호 찾기
	 * @param conn
	 * @return 방번호
	 */
	public int selectRoom(Connection conn);
	
	/**
	 * 방번호에 회원 넣기
	 * @param conn - db연결 객체
	 * @param user0_no - 대화 생성자
	 * @param user1_no - 대화 참여자
	 * @param roomNo - 방번호
	 */
	public void joinRoom(Connection conn, int user_no, int roomNo);

	/**
	 * db에 접속하여 두 회원이 1대1 대화방 이력이 있는지 검색한다.
	 * @param conn - db연결 객체
	 * @param user0_no - 대화 생성자
	 * @param user1_no - 대화 초대자
	 * @return - 대화 방
	 */
	public int searchChatNo(Connection conn, int user0_no, int user1_no);

	/**
	 * 채팅방의 대화를 가져온다.
	 * @param conn - db연결객체
	 * @param chatting_no - 방번호
	 * @return - 대화 목록
	 */
	public List<Chat> getUserChatList(Connection conn, int chatting_no);




	
}
