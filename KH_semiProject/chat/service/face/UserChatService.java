package service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.Paging;
import dto.Chat;
import dto.ChatUserInfo;
import dto.ChatUserList;

public interface UserChatService {

	/**
	 * 회원 id를 통해 Chat에 필요한 유저 정보 가져오기
	 * @param parameter - userId
	 * @return - ChatUserInfo형태의 회원 값
	 */
	public ChatUserInfo  infoById(String parameter);

	/**
	 * 회원번호를 전달받아 회원 정보를 저장한다.
	 * @param user1_no 전달된 회원 번호
	 * @return 회원정보
	 */
	public ChatUserInfo infoByUserNo(int user1_no);
	
	/**
	 * webSocket에서 전달받은 회원번호와 메세지를 dao에 전달
	 * @param userno - 메시지를 보낸 회원의 번호
	 * @param message - 회원이 보낸 메시지
	 */
	public void insertMsg(int userno, String message);

	/**
	 * userno를 통해 유저의 대화를 List화 하기
	 * @param user_no
	 */
	public List<Chat> userChatList(List rlist, int user_no);

	/**
	 * 채팅 상대를 선택할 목록을 가져온다.
	 * @param user_no - 내 회원번호를 제외하고 조회한다.
	 * @return 전체 회원의 목록을 가져온다.
	 */
	public List<ChatUserList> userList(int user_no);

	/**
	 * 채팅에 참여할 회원 번호와, 회원수를 전달받아 채팅방을 개설한다.
	 * @param user0_no - 생성한 회원
	 * @param user1_no - 초대받은 회원
	 * @param count - 방 인원
	 */
	public int createRoom(int user0_no, int user1_no, int count);

	/**
	 * 대화 선택시 기존에 1대1 대화방이 있는지 검색한다.
	 * @param user0_no 대화생성자
	 * @param user1_no 대화 초대자
	 * @return chatting_no반환
	 */
	public int searchRoom(int user0_no, int user1_no);

	/**
	 * 두 회원간의 대화를 가져온다.
	 * @param user0_no - 회원1 
	 * @param user1_no - 회원2
	 * @param chatting_no - 방번호
	 * @return 대화 리스트
	 */
	public List<Chat> getChatList(int user0_no, int user1_no, int chatting_no);

	/**
	 * 전달받은 메세지를 채팅창에 입력한다.
	 * @param chatting_no - 방번호
	 * @param user0_no - 메세지 보낸 유저번호
	 * @param chatContent - 내용
	 */
	public void insertMsg(int chatting_no, int user0_no, String chatContent, String user_ip);

	/**
	 * 채팅방의 최신 메시지 번호를 가져온다.
	 * @param chatting_no - 방번호
	 * @return - 메시지 번호
	 */
	public int getLeastMsgNum(int chatting_no);

	/**
	 * 회원번호가 속해있는 채팅방 번호를 갖고온다.
	 * @param user_no - 조회할 회원 번호
	 * @return - 방 리스트
	 */
	public List getUserChatRoom(int user_no);


	/**
	 * 회원 목록을 페이징 처리한다.
	 * @param user_no : 접속한회원 번호
	 * @return : 페이징
	 */
	public Paging getPaging(HttpServletRequest req);

	
	public List<ChatUserList> userList(int user_no, Paging paging);


	

}
