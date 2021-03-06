package dao.impl.note;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import common.Paging;
import dao.face.note.NoteDao;
import dto.addr.AddrView;
import dto.note.NoteCreateData;
import dto.note.NoteList;
import dto.note.NotePaging;
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
		sql += " WHERE u.dept_no = ?";
		sql += " ORDER BY user_no";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
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
		sql += " WHERE u.dept_no = ?";
		sql += " ORDER BY user_no";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 2);
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
		sql += " WHERE u.dept_no = ?";
		sql += " ORDER BY user_no";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 3);
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
		sql += " WHERE u.dept_no = ?";
		sql += " ORDER BY user_no";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 4);
			
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
		sql += " WHERE u.dept_no = ?";
		sql += " ORDER BY user_no";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 5);
			
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
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
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
			
			ps.setInt(1, 1); //세션에서 유저값을 받아서 처리해야함
			ps.setString(2, params.getNote_title());
			ps.setString(3, params.getNote_article());
			ps.setInt(4, 60);
			ps.setString(5, params.getUser_ip()); 
			//서비스임플에서 아이피를 받아서 여기에서 처리하는거 (서비스임플에서 아이피를 세션에서 처리하는것이면 주석 지워도 됨)
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
	public List<NoteList> getReceivedList(Connection conn, HttpServletRequest req, Paging paging) {  
		
		
		
		List<NoteList> result = new ArrayList<NoteList>();
		
		String sql = "";
		sql += "SELECT * FROM (SELECT rownum rnum, j4.* FROM(";
		sql += " SELECT receiver_no, receiver_name, j2.isDelete, j2.note_no, j2.note_title, j2.send_date, j3.sender_no, j3.sender_name FROM";
		sql += " (SELECT receiver_no, receiver_name, isDelete, j1.note_no, n.note_title,TO_char(n.send_date,'YY/MM/DD HH24:MI:SS') send_date FROM(";
		sql += " SELECT r.user_no receiver_no, u.user_name receiver_name, isDelete, note_no FROM tb_receivednote r";
		sql += " INNER JOIN tb_user u";
		sql += " ON r.user_no = u.user_no";
		sql += " WHERE r.user_no = ?"; //이부분을 세션의 유저넘버값을 받아와야한다.
		sql += " AND isDelete = ?) j1"; 
		sql += " INNER JOIN tb_note n";
		sql += " ON j1.note_no = n.note_no";//)j2";
		sql += " ORDER BY send_date DESC) j2";
		sql += " INNER JOIN ";
		sql += " (SELECT s.note_no, s.user_no sender_no, u.user_name sender_name FROM tb_sendnote s";
		sql += " INNER JOIN tb_user u";
		sql += " ON s.user_no = u.user_no) j3";
		sql += " ON j2.note_no= j3.note_no";
		sql += ") j4)";
		sql += " WHERE rnum BETWEEN ? and ?";
		
		
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setInt(1, 12);
			ps.setInt(2, 0);
			ps.setInt(3, paging.getStartNo());
			ps.setInt(4, paging.getEndNo());
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				NoteList e = new NoteList();
				
				e.setIsDelete(rs.getInt("isDelete"));
				e.setNote_no(rs.getInt("note_no"));
				e.setNote_title(rs.getString("note_title"));
				e.setReceiver_name(rs.getString("receiver_name"));
				e.setReceiver_no(rs.getInt("receiver_no"));
				e.setSend_date(rs.getString("send_date"));
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
	public List<NoteList> getSendList(Connection conn, HttpServletRequest req, NotePaging paging) {

		List<NoteList> result = new ArrayList<NoteList>();
		
		String sql = "";
		  
		sql += "SELECT * FROM ";
		sql += " (SELECT rownum rnum, t1.*, u.user_name receiver FROM";
		sql += " (SELECT";
		sql += "    S.note_no ";
		sql += "    , S.user_no sender_no";
		sql += "    , TO_CHAR (N.send_date,'YY/MM/DD HH24:MI:SS') send_date ";
		sql += "    , ( SELECT min(user_no) FROM tb_receivedNote R WHERE S.note_no = R.note_no ) receiver_no";
		sql += "    , ( SELECT count(R.note_no) FROM tb_receivedNote R WHERE S.note_no = R.note_no ) cnt";
		sql += "	, S.isdelete";
		sql += "	, N.note_title";
		sql += " FROM tb_sendnote S";
		sql += " INNER JOIN tb_note N";
		sql += " 	ON S.note_no = N.note_no";
		sql += " 	WHERE s.user_no = ?";  //이부분을 세션의 유저넘버값을 받아와야한다.
		sql += " 	AND isDelete = ?"; //) t1";
		sql += "	 ) t1";
		sql += " INNER JOIN tb_user u";
		sql += "     ON t1.receiver_no = u.user_no";
		sql += "	ORDER BY send_date DESC";
		sql += " ) t2 WHERE t2.rnum BETWEEN ? AND ?";
		
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, 1);
				ps.setInt(2, 0);
				ps.setInt(3, paging.getStartNo());
				ps.setInt(4, paging.getEndNo());
				rs = ps.executeQuery();
				
				while(rs.next()) {
					NoteList e = new NoteList();
					
					e.setCntReceiver(rs.getInt("cnt"));
					e.setIsDelete(rs.getInt("isDelete"));
					e.setNote_no(rs.getInt("note_no"));
					e.setNote_title(rs.getString("note_title"));
					e.setReceiver_name(rs.getString("receiver"));
					e.setSend_date(rs.getString("send_date"));
					
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
	public int selectCntReceived(Connection conn) {

		int totalCnt= 0;
		
		String sql = "";
		sql += "SELECT count(*) FROM (";
		sql += " SELECT receiver_no, receiver_name, j2.isDelete, j2.note_no, j2.note_title, j2.send_date, j3.sender_no, j3.sender_name FROM";
		sql += " (SELECT receiver_no, receiver_name, isDelete, j1.note_no, n.note_title,n.send_date FROM(";
		sql += " SELECT r.user_no receiver_no, u.user_name receiver_name, isDelete, note_no FROM tb_receivednote r";
		sql += " INNER JOIN tb_user u";
		sql += " ON r.user_no = u.user_no";
		sql += " WHERE r.user_no = ?"; //이부분을 세션의 유저넘버값을 받아와야한다.
		sql += " AND isDelete = ?) j1"; 
		sql += " INNER JOIN tb_note n";
		sql += " ON j1.note_no = n.note_no)j2";
		sql += " INNER JOIN ";
		sql += " (SELECT s.note_no, s.user_no sender_no, u.user_name sender_name FROM tb_sendnote s";
		sql += " INNER JOIN tb_user u";
		sql += " ON s.user_no = u.user_no) j3";
		sql += " ON j2.note_no= j3.note_no";
		sql += " ORDER BY send_date DESC";
		sql += " )";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 12);
			ps.setInt(2, 0);
			rs= ps.executeQuery();
			while(rs.next()) {
				totalCnt=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		return totalCnt;
	}


	

	@Override
	public int selectCntSend(Connection conn) {

		int totalCnt= 0;

		int totalAllCnt = 0;
		
		String sql = "";
		sql += "SELECT count(*) FROM (";
		sql += " SELECT j2.note_no, j2.sender_no,j2.sender_name,j2.note_title,j2.send_date,j2.isDelete,j3.receiver_no, j3.receiver_name FROM";
		sql += " (SELECT j1.note_no, j1.sender_no, j1.sender_name,n.note_title,n.send_date,j1.isDelete FROM";
		sql += " (SELECT  s.note_no, s.user_no sender_no, u.user_name sender_name,s.isDelete FROM tb_sendnote s";
		sql += " INNER JOIN tb_user u";
		sql += " ON s.user_no = u.user_no";
		sql += " WHERE s.user_no = ?"; //이부분을 세션의 유저넘버값을 받아와야한다.
		sql += " AND s.isdelete=?)j1";
		sql += " INNER JOIN tb_note n";
		sql += " ON j1.note_no = n.note_no) j2";
		sql += " INNER JOIN";
		sql += " (SELECT r.note_no, r.user_no receiver_no, u.user_name receiver_name FROM tb_receivedNote r";
		sql += " INNER JOIN tb_user u";
		sql += " ON r.user_no = u.user_no) j3";
		sql += " ON j2.note_no = j3.note_no";
		sql += " ORDER BY send_date, note_no DESC";
		sql += " )";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setInt(2, 0);
			rs= ps.executeQuery();
			while(rs.next()) {
				totalAllCnt=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		if (totalAllCnt==0) { return totalAllCnt; }
		
		sql = "";
		sql += "SELECT j2.note_no, j2.sender_no,j2.sender_name,j2.note_title,j2.send_date,j2.isDelete,j3.receiver_no, j3.receiver_name FROM";
		sql += " (SELECT j1.note_no, j1.sender_no, j1.sender_name,n.note_title,n.send_date,j1.isDelete FROM";
		sql += " (SELECT  s.note_no, s.user_no sender_no, u.user_name sender_name,s.isDelete FROM tb_sendnote s";
		sql += " INNER JOIN tb_user u";
		sql += " ON s.user_no = u.user_no";
		sql += " WHERE s.user_no = ?)j1"; //이부분을 세션의 유저넘버값을 받아와야한다.
		sql += " INNER JOIN tb_note n";
		sql += " ON j1.note_no = n.note_no) j2";
		sql += " INNER JOIN";
		sql += " (SELECT r.note_no, r.user_no receiver_no, u.user_name receiver_name FROM tb_receivedNote r";
		sql += " INNER JOIN tb_user u";
		sql += " ON r.user_no = u.user_no) j3";
		sql += " ON j2.note_no = j3.note_no";
		sql += " ORDER BY send_date, note_no DESC";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
			rs = ps.executeQuery();
				
			int n1 = 0;
			int n2 = 0;
			
			totalCnt = totalAllCnt;
			while(rs.next()) {
				
				
				for(int i=0;i<totalAllCnt;i++) {
						n1 = rs.getInt("note_no");
					if(rs.next()) {
						n2 = rs.getInt("note_no");
					} else {
						n2 = 0;
					}
					//System.out.println("n1: "+n1+", n2 "+n2);
					
					if(n1==n2) totalCnt--;
				}
				
				break;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//System.out.println(totalCnt);
		
		return totalCnt;
	}

	
	
	@Override
	public int deleteReceivedNote(Connection conn,int user_no, int note_no) {

		int result = 0;
		
		String sql = "";
		sql += "UPDATE tb_receivednote SET isdelete = ?";
		sql += " WHERE user_no= ?";
		sql += " AND note_no = ?;";
	
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setInt(2, user_no);
			ps.setInt(3, note_no);
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
	public NoteList getNoteView(Connection conn, int note_no) {
		
		NoteList result = new NoteList();
		
		String sql = "";
		sql += " SELECT ";
		sql += " u.user_name sender_name";
		sql += " ,u.dept_no";
		sql += " ,(SELECT dept_name FROM tb_dept d WHERE u.dept_no = d.dept_no) dept_name";
		sql += " ,(SELECT position_name FROM tb_position p WHERE u.position_no = p.position_no) position_name";
		sql += " , t1.*";
		sql += " FROM";
		sql += " (SELECT note_no, user_no sender_no, note_title, note_article, TO_CHAR(send_date,'YY/MM/DD HH24:MI:SS') send_date FROM tb_note";
		sql += " WHERE note_no = ?) t1"; 
		sql += " INNER JOIN tb_user u";
		sql += " ON t1.sender_no = u.user_no";
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, note_no);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				result.setNote_article(rs.getString("note_article"));
				result.setNote_title(rs.getString("note_title"));
				result.setNote_no(rs.getInt("note_no"));
				result.setSender_name(rs.getString("sender_name"));
				result.setSend_date(rs.getString("send_date"));
				result.setSenderDept_name(rs.getString("dept_name"));
				result.setPosition(rs.getString("position_name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		return result;
		
	}

	@Override
	public List<AddrView> getReceivers(Connection conn, int note_no) {

		List<AddrView> result = new ArrayList<AddrView>();
		
		
		String sql = "";
		
		sql +="SELECT j1.*, d.dept_name";
		sql +=" ,(SELECT p.position_name FROM tb_position p WHERE j1.position_no = p.position_no) position_name";
		sql +=" FROM";
		sql +=" (SELECT r.note_no, u.user_name,u.position_no, u.user_no receiver, u.dept_no FROM tb_user u";
		sql +=" INNER JOIN tb_receivedNote r";
		sql +=" ON u.user_no =r.user_no";
		sql +=" WHERE r.note_no = ?";
		sql +=" ORDER BY note_no) j1";
		sql +=" INNER JOIN tb_dept d";
		sql +=" ON d.dept_no = j1.dept_no";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, note_no);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				AddrView e = new AddrView();
				
				e.setDept_name(rs.getString("dept_name"));
				e.setUser_no(rs.getInt("receiver"));
				e.setUser_name(rs.getString("user_name"));
				e.setPosition_name(rs.getString("position_name"));
				
				
				result.add(e);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		
		return result;
		
	}

	
	

}
