package dao.impl.note;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import dao.face.note.NoteDao;
import dto.note.NoteCreateData;
import dto.note.NoteList;
import dto.note.NoteReceiverView;

public class NoteDaoImpl implements NoteDao {

	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	@Override
	public List<NoteReceiverView> getManUser(Connection conn) {

		List<NoteReceiverView> result = new ArrayList<NoteReceiverView>();
		
		String sql = "";
		sql += "SELECT * FROM tb_user u";
		sql += " LEFT OUTER JOIN tb_dept d";
		sql += " ON u.dept_no = d.dept_no";
		sql += " WHERE u.dept_no = 1";
		sql += " ORDER BY user_no";
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs= ps.executeQuery();
			while(rs.next()) {
				NoteReceiverView e = new NoteReceiverView();
				
				e.setDept_name(rs.getString("dept_name"));
				e.setUser_name(rs.getString("user_name"));
				e.setUser_no(rs.getInt("user_no"));
				
				result.add(e);
				
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

	@Override
	public List<NoteReceiverView> getAccUser(Connection conn) {

		List<NoteReceiverView> result = new ArrayList<NoteReceiverView>();
		
		String sql = "";
		sql += "SELECT * FROM tb_user u";
		sql += " LEFT OUTER JOIN tb_dept d";
		sql += " ON u.dept_no = d.dept_no";
		sql += " WHERE u.dept_no = 2";
		sql += " ORDER BY user_no";
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs= ps.executeQuery();
			while(rs.next()) {
				NoteReceiverView e = new NoteReceiverView();
				
				e.setDept_name(rs.getString("dept_name"));
				e.setUser_name(rs.getString("user_name"));
				e.setUser_no(rs.getInt("user_no"));
				
				result.add(e);
				
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

	@Override
	public List<NoteReceiverView> getHrUser(Connection conn) {

		List<NoteReceiverView> result = new ArrayList<NoteReceiverView>();
		
		String sql = "";
		sql += "SELECT * FROM tb_user u";
		sql += " LEFT OUTER JOIN tb_dept d";
		sql += " ON u.dept_no = d.dept_no";
		sql += " WHERE u.dept_no = 3";
		sql += " ORDER BY user_no";
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs= ps.executeQuery();
			while(rs.next()) {
				NoteReceiverView e = new NoteReceiverView();
				
				e.setDept_name(rs.getString("dept_name"));
				e.setUser_name(rs.getString("user_name"));
				e.setUser_no(rs.getInt("user_no"));
				
				result.add(e);
				
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

	@Override
	public List<NoteReceiverView> getDevUser(Connection conn) {

		List<NoteReceiverView> result = new ArrayList<NoteReceiverView>();
		
		String sql = "";
		sql += "SELECT * FROM tb_user u";
		sql += " LEFT OUTER JOIN tb_dept d";
		sql += " ON u.dept_no = d.dept_no";
		sql += " WHERE u.dept_no = 4";
		sql += " ORDER BY user_no";
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs= ps.executeQuery();
			while(rs.next()) {
				NoteReceiverView e = new NoteReceiverView();
				
				e.setDept_name(rs.getString("dept_name"));
				e.setUser_name(rs.getString("user_name"));
				e.setUser_no(rs.getInt("user_no"));
				
				result.add(e);
				
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

	@Override
	public List<NoteReceiverView> getSalesUser(Connection conn) {

		List<NoteReceiverView> result = new ArrayList<NoteReceiverView>();
		
		String sql = "";
		sql += "SELECT * FROM tb_user u";
		sql += " LEFT OUTER JOIN tb_dept d";
		sql += " ON u.dept_no = d.dept_no";
		sql += " WHERE u.dept_no = 5";
		sql += " ORDER BY user_no";
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs= ps.executeQuery();
			while(rs.next()) {
				NoteReceiverView e = new NoteReceiverView();
				
				e.setDept_name(rs.getString("dept_name"));
				e.setUser_name(rs.getString("user_name"));
				e.setUser_no(rs.getInt("user_no"));
				
				result.add(e);
				
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

	
	@Override
	public int getNextval(Connection conn) {
		
		int result= -1;
		
		String sql = "";
		sql += "SELECT tb_note_seq.nextval FROM dual";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result; 
	}
	
	@Override
	public int insertNote(NoteCreateData params, Connection conn) {

		int result = 0;
		
		String sql = "";
		sql += "INSERT INTO tb_note (user_no,note_title,note_article,send_date,table_no,user_ip, note_no)";
		sql += " VALUES(?,?,?,sysdate,?,?,?)";
		try {
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, 1); //session에서 userNo 받아와야함
			ps.setString(2, params.getNote_title());
			ps.setString(3, params.getNote_article());
			ps.setInt(4, 60);
			ps.setString(5, params.getUser_ip()); //serviceImpl의 params setting에서 userIp 받는 걸 다시 해야함
			ps.setInt(6, params.getNote_no());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}		
		
		return result;
		
	}

	@Override
	public int insertSendNote(NoteCreateData params, Connection conn) {

		int result=0;
		
		String sql = "";
		sql += "INSERT INTO tb_sendNote(user_no, note_no, isDelete)";
		sql += " VALUES(?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setInt(2, params.getNote_no());
			ps.setInt(3, params.getIsDelete());
			
			result=ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}		
		
		
		return result;
	}

	@Override
	public int insertReceivedNote(NoteCreateData params, Connection conn) {
		
		int result = 0;
		
		String sql = "";
		
		for(int i=0;i<params.getReceiver().size();i++) {
			sql = "";
			sql += "INSERT INTO tb_receivednote (user_no,note_no,isDelete)";
			sql += " VALUES (?,?,?)";
			
			try {
				ps=conn.prepareStatement(sql);
				
				ps.setInt(1, params.getReceiver().get(i));
				ps.setInt(2, params.getNote_no());
				ps.setInt(3, params.getIsDelete());
				
				int done = ps.executeUpdate();
				if(done>0) {
					result ++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(ps);
			}		
			
		}
		
		if(result == params.getReceiver().size()) result = 1;
		
		return result;
		
	}

	@Override
	public List<NoteList> getReceivedList(Connection conn, HttpServletRequest req) {
		
		
		
		List<NoteList> result = new ArrayList<NoteList>();
		
		String sql = "";
		sql += "SELECT receiver_no, receiver_name, j2.isDelete, j2.note_no, j2.note_title, j2.send_date, j3.sender_no, j3.sender_name FROM";
		sql += " (SELECT receiver_no, receiver_name, isDelete, j1.note_no, n.note_title,n.send_date FROM(";
		sql += " SELECT r.user_no receiver_no, u.user_name receiver_name, isDelete, note_no FROM tb_receivednote r";
		sql += " INNER JOIN tb_user u";
		sql += " ON r.user_no = u.user_no";
		sql += " WHERE r.user_no = 12";
		sql += " AND isDelete = 0) j1"; //이부분에 세션의 로그인한 user_no를 넣어야함 (req는 세션을 얻기 위해 가져옴)
		sql += " INNER JOIN tb_note n";
		sql += " ON j1.note_no = n.note_no)j2";
		sql += " INNER JOIN ";
		sql += " (SELECT s.note_no, s.user_no sender_no, u.user_name sender_name FROM tb_sendnote s";
		sql += " INNER JOIN tb_user u";
		sql += " ON s.user_no = u.user_no) j3";
		sql += " ON j2.note_no= j3.note_no";
		sql += " ORDER BY send_date DESC";
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				NoteList e = new NoteList();
				
				e.setIsDelete(rs.getInt("isDelete"));
				e.setNote_no(rs.getInt("note_no"));
				e.setNote_title(rs.getString("note_title"));
				e.setReceiver_name(rs.getString("receiver_name"));
				e.setReceiver_no(rs.getInt("receiver_no"));
				e.setSend_date(rs.getDate("send_date"));
				e.setSender_name(rs.getString("sender_name"));
				e.setSender_no(rs.getInt("sender_no"));
				
				result.add(e);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		return result;
		
	}

	@Override
	public List<NoteList> getSendList(Connection conn, HttpServletRequest req) {

		List<NoteList> result = new ArrayList<NoteList>();
		
		String sql = "";
		sql += "SELECT j2.note_no, j2.sender_no,j2.sender_name,j2.note_title,j2.send_date,j2.isDelete,j3.receiver_no, j3.receiver_name FROM";
		sql += " (SELECT j1.note_no, j1.sender_no, j1.sender_name,n.note_title,n.send_date,j1.isDelete FROM";
		sql += " (SELECT  s.note_no, s.user_no sender_no, u.user_name sender_name,s.isDelete FROM tb_sendnote s";
		sql += " INNER JOIN tb_user u";
		sql += " ON s.user_no = u.user_no";
		sql += " WHERE s.user_no = 18)j1"; //이부분에 세션의 로그인한 user_no를 넣어야함 (req는 세션을 얻기 위해 가져옴)
		sql += " INNER JOIN tb_note n";
		sql += " ON j1.note_no = n.note_no) j2";
		sql += " INNER JOIN";
		sql += " (SELECT r.note_no, r.user_no receiver_no, u.user_name receiver_name FROM tb_receivedNote r";
		sql += " INNER JOIN tb_user u";
		sql += " ON r.user_no = u.user_no) j3";
		sql += " ON j2.note_no = j3.note_no";
		sql += " ORDER BY send_date DESC";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				NoteList e =  new NoteList();
				
				e.setIsDelete(rs.getInt("isDelete"));
				e.setNote_no(rs.getInt("note_no"));
				e.setNote_title(rs.getString("note_title"));
				e.setReceiver_name(rs.getString("receiver_name"));
				e.setReceiver_no(rs.getInt("receiver_no"));
				e.setSend_date(rs.getDate("send_date"));
				e.setSender_name(rs.getString("sender_name"));
				e.setSender_no(rs.getInt("sender_no"));
				
				result.add(e);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return result;
	
	}

	

}
