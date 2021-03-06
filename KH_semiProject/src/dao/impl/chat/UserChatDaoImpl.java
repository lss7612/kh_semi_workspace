package dao.impl.chat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import common.JDBCTemplate;
import common.Paging;
import dao.face.chat.UserChatDao;
import dto.chat.Chat;
import dto.chat.ChatRoomSearch;
import dto.chat.ChatUserList;
import dto.common.UserInfo;

public class UserChatDaoImpl implements UserChatDao{
	PreparedStatement ps = null;
	ResultSet rs = null;

	int table_no = 30;
	@Override
	public UserInfo bringInfo(Connection conn, String parameter, String userIp) {
		
		String sql ="";
		
		sql += "select * from tb_user, tb_dept, tb_grade, tb_position, tb_state";
		sql += " where tb_user.dept_no = tb_dept.dept_no";
		sql += " and tb_user.user_grade = tb_grade.grade_no";
		sql += " and tb_user.position_no = tb_position.position_no";
		sql += " and tb_user.state_no = tb_state.state_no";
		sql += " and user_id = ?";
		
		UserInfo user = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, parameter);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				user = new UserInfo();
				
				user.setUser_no(rs.getInt("user_no"));
				user.setUser_id( parameter);
				user.setUser_name(rs.getString("user_name"));
				user.setUser_grade( rs.getInt("user_grade"));
				user.setGrade_name(rs.getString("grade_name"));
				user.setDept_no( rs.getInt("dept_no"));
				user.setDept_name(rs.getString("dept_name"));
				user.setPosition_no( rs.getInt("position_no"));
				user.setPosition_name( rs.getString("position_name"));
				user.setState_no( rs.getInt("state_no"));
				user.setState_name( rs.getString("state_name"));
				user.setUser_ip( userIp );
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return user;
	}
	
	@Override
	public UserInfo bringInfoByUserNo(Connection conn, int user1_no) {
		
		String sql ="";
		
		sql += "select * from tb_user, tb_dept, tb_grade, tb_position, tb_state";
		sql += " where tb_user.dept_no = tb_dept.dept_no";
		sql += " and tb_user.user_grade = tb_grade.grade_no";
		sql += " and tb_user.position_no = tb_position.position_no";
		sql += " and tb_user.state_no = tb_state.state_no";
		sql += " and user_no = ?";		
		
		UserInfo user = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user1_no);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				user = new UserInfo();
				
				user.setUser_no(rs.getInt("user_no"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_grade( rs.getInt("user_grade"));
				user.setGrade_name(rs.getString("grade_name"));
				user.setDept_no( rs.getInt("dept_no"));
				user.setDept_name(rs.getString("dept_name"));
				user.setPosition_no( rs.getInt("position_no"));
				user.setPosition_name( rs.getString("position_name"));
				user.setState_no( rs.getInt("state_no"));
				user.setState_name( rs.getString("state_name"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return user;
	}
	
	@Override
	public int saveMsg(Connection conn, int userno, String message) {
		
		String sql ="";
		sql += "insert into tb_chattingContent(chatting_no, user_no, msg_content, revision_date, user_ip)";
		sql += " values(2, ?, ?, sysdate, ?)";
		
		
		int result=0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userno);
			ps.setString(2, message);
			ps.setString(3, "0:0:0:0:0:0:0:1");
			
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return result;
	}
	
	@Override
	public List<Chat> selectUserChatList(Connection conn, List rlist, int user_no) {
		System.out.println("\n > > > 채팅 목록 조회 < < <");
		
		//조회값 저장 객체
		List<Chat> result = new ArrayList<>();
		
		for (int i =0; i<rlist.size();i++) {
			String sql ="";

			sql += "select * from (";
			sql += " select rownum rnum, t.* from(";
			sql += " select us.user_no, us.user_name, c.chatting_no, max(cc.msg_no) over(partition by c.chatting_no order by cc.revision_date desc) msg_no, cc.msg_content";
			sql += " , cc.revision_date, cc.user_ip from tb_chatting c";
			sql += " inner join tb_chattinguser u";
			sql += " on c.chatting_no = u.chatting_no";
			sql += " inner join tb_user us"; 
			sql += " on us.user_no = u.user_no";
			sql += " inner join tb_chattingcontent cc";
			sql += " on c.chatting_no = cc.chatting_no";
			sql += " where c.chatting_no = ?";
			sql += " and us.user_no != ? ";
			sql += " )t";
			sql += " )tt";
			sql += " where rnum = 1";
			
			//조회값 저장 객체
			try {
				ps= conn.prepareStatement(sql);
				ps.setInt(1, (int) rlist.get(i));
				ps.setInt(2,  user_no);
				
				rs = ps.executeQuery();
				
				Date time = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String time2 = sdf.format(time);
				
				while(rs.next()) {
					Chat chat = new Chat();
					
					chat.setChatting_no( rs.getInt("chatting_no"));
					chat.setUser_no( rs.getInt("user_no"));
					chat.setUser_name(rs.getString("user_name"));
					chat.setMsg_content( rs.getString("msg_content"));
					//chat.setRevision_date( rs.getString("revision_date"));
					
					//메시지에 나타날 시간상태 설정하기
					//	시스템날짜와 저장된 날짜가 같으면 오늘
					//	시스템 날짜보다 1이 작으면 어제
					//	차이가 1보다 크면 날짜로 표현한다.
					//	24시간중 12시가 넘으면 오후로 나타낸다.
					String timeType="오후";
					String dateType="오늘";
					String date = rs.getString("revision_date").substring(0,10);
					String yearMonth = rs.getString("revision_date").substring(0,7);
					int day = Integer.parseInt(rs.getString("revision_date").substring(8,10));
					int hour = Integer.parseInt(rs.getString("revision_date").substring(11,13) );
					int min = Integer.parseInt( rs.getString("revision_date").substring(14,16) );
					if( date.equals(time2.substring(0,10)) ) {
						//오늘의 오전, 오후 설정하기
						if( hour >=12 ){
								if(hour >12 ) {
									//오늘 오후 : 13시부터 시에서 12를 빼준다
									hour -=12;
									chat.setRevision_date( dateType+" "+timeType+" "+hour+":"+min);
								} 
								chat.setRevision_date( dateType+" "+timeType+" "+hour+":"+min);
						} else {
							//오늘 오전 
							timeType="오전";
							chat.setRevision_date( dateType+" "+timeType+" "+hour+":"+min);
						}
					} else if( yearMonth.equals(time2.substring(0,7)) 
							|| Integer.parseInt(rs.getString("revision_date")) - day == 1 ) {
							//어제의 오전, 오후 경우
							dateType="어제";
							if( hour >=12 ){
								if(hour >12 ) {
									//어제 오후 : 13시부터 시에서 12를 빼준다
									hour -=12;
									chat.setRevision_date( dateType+" "+timeType+" "+hour+":"+min);
								} 
								chat.setRevision_date( dateType+" "+timeType+" "+hour+":"+min);
						} else {
							//오늘 오전 
							timeType="오전";
							chat.setRevision_date( dateType+" "+timeType+" "+hour+":"+min);
						}
					} else {
						if( hour >= 12) {
							if(hour >12) {
								hour -=12;
								chat.setRevision_date(date+" "+timeType+" "+hour+":"+min);
							}
							chat.setRevision_date(date+" "+timeType+" "+hour+":"+min);
						}
						dateType = "오전";
						chat.setRevision_date(date+" "+timeType+" "+hour+":"+min);
					}
					
					result.add(chat);
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(ps);
			}
			
		}
		
		for(Chat c : result) {
			System.out.println(c);
		}
		System.out.println("\n > > >selectUserChatList메스도 종료 < < <");
		return result;
	}
	
	@Override
	public List<Chat> getUserChatList(Connection conn, int chatting_no) {
		String sql ="";
		sql += "select * from tb_chattingcontent";
		sql += " where chatting_no = ?";
		sql += " order by msg_no asc";
		
		List<Chat> list = new ArrayList<>();
		Date time = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time2 = sdf.format(time);
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, chatting_no);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Chat chat = new Chat();
				chat.setChatting_no( rs.getInt("chatting_no"));
				chat.setMsg_no( rs.getInt("msg_no"));
				chat.setUser_no( rs.getInt("user_no"));
				chat.setMsg_content( rs.getString("msg_content"));
				//chat.setRevision_date( rs.getString("revision_date"));
				chat.setUser_ip( rs.getString("user_ip"));
				
				//메시지에 나타날 시간상태 설정하기
				//	시스템날짜와 저장된 날짜가 같으면 오늘
				//	시스템 날짜보다 1이 작으면 어제
				//	차이가 1보다 크면 날짜로 표현한다.
				//	24시간중 12시가 넘으면 오후로 나타낸다.
				String timeType="오후";
				String dateType="오늘";
				String date = rs.getString("revision_date").substring(0,10);
				String yearMonth = rs.getString("revision_date").substring(0,7);
				int day = Integer.parseInt(rs.getString("revision_date").substring(8,10));
				int hour = Integer.parseInt(rs.getString("revision_date").substring(11,13) );
				int min = Integer.parseInt( rs.getString("revision_date").substring(14,16) );
				if( date.equals(time2.substring(0,10)) ) {
					//오늘의 오전, 오후 설정하기
					if( hour >=12 ){
							if(hour >12 ) {
								//오늘 오후 : 13시부터 시에서 12를 빼준다
								hour -=12;
								chat.setRevision_date( dateType+" "+timeType+" "+hour+":"+min);
							} 
							chat.setRevision_date( dateType+" "+timeType+" "+hour+":"+min);
					} else {
						//오늘 오전 
						timeType="오전";
						chat.setRevision_date( dateType+" "+timeType+" "+hour+":"+min);
					}
				} else if( yearMonth.equals(time2.substring(0,7)) 
						|| Integer.parseInt(rs.getString("revision_date")) - day == 1 ) {
						//어제의 오전, 오후 경우
						dateType="어제";
						if( hour >=12 ){
							if(hour >12 ) {
								//어제 오후 : 13시부터 시에서 12를 빼준다
								hour -=12;
								chat.setRevision_date( dateType+" "+timeType+" "+hour+":"+min);
							} 
							chat.setRevision_date( dateType+" "+timeType+" "+hour+":"+min);
					} else {
						//오늘 오전 
						timeType="오전";
						chat.setRevision_date( dateType+" "+timeType+" "+hour+":"+min);
					}
				} else {
					if( hour >= 12) {
						if(hour >12) {
							hour -=12;
							chat.setRevision_date(date+" "+timeType+" "+hour+":"+min);
						}
						chat.setRevision_date(date+" "+timeType+" "+hour+":"+min);
					}
					dateType = "오전";
					chat.setRevision_date(date+" "+timeType+" "+hour+":"+min);
				}
				
				list.add(chat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		return list;
	}
	
	@Override
	public List<ChatUserList> getUserList(Connection conn, int user_no) {
		
		String sql ="";
//		sql += "select u.user_no, u.user_name, u.dept_no, g.dept_name, u.position_no, p.position_name, u.cellphone_no, u.extenstion_no from tb_user u";
//		sql += " inner join tb_position p";
//		sql += " on u.position_no = p.position_no";
//		sql += " inner join tb_dept g";
//		sql += " on u.dept_no = g.dept_no";
//		sql += " where u.user_no != ?";
		sql += "select * from (";
		sql += " select rownum rnum, u.* from(";
		sql += " select u.user_no, u.user_name, u.dept_no, g.dept_name, u.position_no, p.position_name, u.cellphone_no, u.extenstion_no from tb_user u";
		sql += " inner join tb_position p";
		sql += " on u.position_no = p.position_no";
		sql += " inner join tb_dept g";
		sql += " on u.dept_no = g.dept_no";
		sql += " where u.user_no != ?";
		sql += " order by user_no";
		sql += " )u";
		sql += " )ua";
		sql += " where rnum between ? and ?";
		
		List<ChatUserList> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user_no);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				ChatUserList cul = new ChatUserList();
				
				cul.setUser_no( rs.getInt("user_no"));
				cul.setUser_name( rs.getString("user_name"));
				cul.setDept_no( rs.getInt("dept_no"));
				cul.setDept_name( rs.getString("dept_name"));
				cul.setPosition_no( rs.getInt("position_no"));
				cul.setPosition_name( rs.getString("position_name"));
				cul.setCellphone_no( rs.getString("cellphone_no"));
				cul.setExtension_no( rs.getString("extenstion_no"));
				
				list.add(cul);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return list;
	}
	
@Override
	public List<ChatUserList> getUserList(Connection conn, int user_no, Paging paging) {
		
		String sql ="";
		sql += "select * from (";
		sql += " select rownum rnum, u.* from(";
		sql += " select u.user_no, u.user_name, u.dept_no, g.dept_name, u.position_no, p.position_name, u.cellphone_no, u.extention_no from tb_user u";
		sql += " inner join tb_position p";
		sql += " on u.position_no = p.position_no";
		sql += " inner join tb_dept g";
		sql += " on u.dept_no = g.dept_no";
		sql += " where u.user_no != ?";
		sql += " order by user_no";
		sql += " )u";
		sql += " )ua";
		sql += " where rnum between ? and ?";
		
		List<ChatUserList> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user_no);
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ChatUserList cul = new ChatUserList();
				
				cul.setUser_no( rs.getInt("user_no"));
				cul.setUser_name( rs.getString("user_name"));
				cul.setDept_no( rs.getInt("dept_no"));
				cul.setDept_name( rs.getString("dept_name"));
				cul.setPosition_no( rs.getInt("position_no"));
				cul.setPosition_name( rs.getString("position_name"));
				cul.setCellphone_no( rs.getString("cellphone_no"));
				cul.setExtension_no( rs.getString("extention_no"));
				
				list.add(cul);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	@Override
	public int makeRoom(Connection conn, int count) {
		
		String sql = "";
		sql += " insert into tb_chatting(table_no, user_total)";
		sql += " values(30, ?)";
		
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, count);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return result;
	}

	@Override
	public int getNextRoomNo(Connection conn) {

		String sql ="";
		sql += "select tb_chatting_SEQ.currval AS next from dual";
		
		int roomNo = 0;
		try {
			ps= conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			rs.next();
			
			roomNo = rs.getInt("next");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return roomNo;
	}

	@Override
	public void joinRoom(Connection conn, int user_no, int roomNo) {
		
		String sql ="";
		sql += "insert into tb_chattinguser(chatting_no, user_no)";
		sql += " values(?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, roomNo);
			ps.setInt(2, user_no);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
	}
	
	@Override
	public int searchChatNo(Connection conn, int user0_no, int user1_no) {

		String sql = "";
		sql += "select c.chatting_no, c.user_total, u.user_no from (tb_chattinguser u";
		sql += " inner join tb_chatting c";
		sql += " on u.chatting_no = c.chatting_no)";
		sql += " where c.user_total =2";
		sql += " and u.chatting_no in (";
		sql += " select c.chatting_no from tb_chatting c";
		sql += " inner join tb_chattinguser u";
		sql += " on u.chatting_no = c.chatting_no";
		sql += " where u.user_no = ?)";
		sql += " and u.chatting_no in (";
		sql += " select c.chatting_no from tb_chatting c";
		sql += " inner join tb_chattinguser u";
		sql += " on u.chatting_no = c.chatting_no";
		sql += " where u.user_no = ?)";
		sql += " order by c.chatting_no asc";
		
		int result = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user0_no);
			ps.setInt(2, user1_no);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ChatRoomSearch search = new ChatRoomSearch();
				
				search.setChatting_no(rs.getInt("chatting_no"));
				search.setUser_total( rs.getInt("user_total"));
				search.setUser_no( rs.getInt("user_no"));
				
				result = search.getChatting_no();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("두 회원의 채팅방 번호는 : "+result);
		return result;
	}
	
	@Override
	public int insertMsg(Connection conn, int chatting_no, int user0_no, String chatContent, String user_ip) {
		
		String sql = "";
		sql += "insert into tb_chattingcontent(chatting_no, user_no, msg_content,revision_date, user_ip)";
		sql += " values( ?, ?, ? , sysdate, ?)";
		
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, chatting_no);
			ps.setInt(2, user0_no);
			ps.setString(3, chatContent);
			ps.setString(4, user_ip);
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		return result;
	}
	
	@Override
	public int getMsgNum(Connection conn, int chatting_no) {
		
		String sql = "";
		sql += "select * from ("; 
		sql += " select rownum rnum, cc.* from("; 
		sql += " select msg_no from tb_chattingcontent";
		sql += " where chatting_no = ?";
		sql += " order by msg_no desc)cc";
		sql += " )ccc";
		sql += " where rnum = 1";
		
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, chatting_no);
			
			rs = ps.executeQuery();
			rs.next();
			result = rs.getInt("msg_no");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return result;
	}
	
	@Override
	public List getUserChatRoomList(Connection conn, int user_no) {
		
		String sql = "";
		sql += "select * from tb_chattinguser";
		sql += " where user_no= ? ";
		
		List rlist = new ArrayList();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user_no);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				rlist.add(rs.getInt("chatting_no"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return rlist;
	}
	
	
	@Override
	public int selectCntAll(Connection conn) {
		
		String sql = "";
		sql += "select count(*) from tb_user";
		
		int totalCount = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				totalCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return totalCount;
	}
	
}
