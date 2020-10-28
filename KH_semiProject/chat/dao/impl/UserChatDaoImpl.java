package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import dao.face.UserChatDao;
import dto.Chat;
import dto.ChatRoomSearch;
import dto.ChatUserInfo;
import dto.ChatUserList;

public class UserChatDaoImpl implements UserChatDao{
	PreparedStatement ps = null;
	ResultSet rs = null;

	int table_no = 30;
	@Override
	public ChatUserInfo bringInfo(Connection conn, String parameter) {
		
		String sql ="";
		
		sql += "select * from tb_user, tb_dept, tb_grade, tb_position, tb_state";
		sql += " where tb_user.dept_no = tb_dept.dept_no";
		sql += " and tb_user.user_grade = tb_grade.grade_no";
		sql += " and tb_user.position_no = tb_position.position_no";
		sql += " and tb_user.state_no = tb_state.state_no";
		sql += " and user_id = ?";
		
		ChatUserInfo user = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, parameter);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				user = new ChatUserInfo();
				
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
	public ChatUserInfo bringInfoByUserNo(Connection conn, int user1_no) {
		
		String sql ="";
		
		sql += "select * from tb_user, tb_dept, tb_grade, tb_position, tb_state";
		sql += " where tb_user.dept_no = tb_dept.dept_no";
		sql += " and tb_user.user_grade = tb_grade.grade_no";
		sql += " and tb_user.position_no = tb_position.position_no";
		sql += " and tb_user.state_no = tb_state.state_no";
		sql += " and user_no = ?";		
		
		ChatUserInfo user = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user1_no);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				user = new ChatUserInfo();
				
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
	public List<Chat> selectUserChatList(Connection conn, int user_no) {
		System.out.println("\n > > > 채팅 목록 조회 < < <");
		String sql ="";
		sql += "select c.chatting_no, c.user_total, u.user_no, us.user_name from tb_chatting c";
		sql += " inner join tb_chattinguser u";
	    sql += " 	on c.chatting_no = u.chatting_no";
		sql += " inner join tb_user us";
		sql += " 	on us.user_no = u.user_no";
		sql += " where c.chatting_no in(";
		sql += " 	select chatting_no from tb_chattinguser";
		sql += " 	where user_no = ?)";
		sql += " order by chatting_no";
		
		String sql2 ="";
		//리턴객체
		List<Chat> result = new ArrayList<>();
		//조회값 저장 객체
		try {
			ps= conn.prepareStatement(sql);
			ps.setInt(1, user_no);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Chat chat = new Chat();
				if( user_no == rs.getInt("user_no")) {
					continue;
				}
				chat.setChatting_no( rs.getInt("chatting_no"));
				chat.setUser_total( rs.getInt("user_total"));
				chat.setUser_no( rs.getInt("user_no"));
				chat.setUser_name(rs.getString("user_name"));
				
				result.add(chat);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		for(Chat c : result) {
			System.out.println(c);
		}
		System.out.println("\n > > >selectUserChatList메스도 종료 < < <");
		return result;
	}
	
	@Override
	public List<ChatUserList> getUserList(Connection conn, int user_no) {
		
		String sql ="";
		sql += "select u.user_no, u.user_name, u.dept_no, g.dept_name, u.position_no, p.position_name, u.cellphone_no, u.extenstion_no from tb_user u";
		sql += " inner join tb_position p";
		sql += " on u.position_no = p.position_no";
		sql += " inner join tb_dept g";
		sql += " on u.dept_no = g.dept_no";
		sql += " where u.user_no != ?";
		
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
				System.out.println(cul);
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
	public int selectRoom(Connection conn) {

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

		System.out.println("쿼리 수행");
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
		
		System.out.println("쿼리 수행 완료");
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
		
		
		return result;
	}
}
