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
import dao.face.note.NoteBinDao;
import dto.note.NoteList;
import dto.note.NotePaging;

public class NoteBinDaoImpl implements NoteBinDao{

	PreparedStatement ps = null;
	ResultSet rs = null;
	
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
			ps.setInt(2, 1);
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
	public List<NoteList> getSendBinList(Connection conn, HttpServletRequest req, NotePaging paging) {

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
		sql += " 	AND isDelete = ?) t1";
		sql += " INNER JOIN tb_user u";
		sql += "     ON t1.receiver_no = u.user_no";
		sql += "	 ORDER BY send_date DESC";
		sql += " ) t2 WHERE t2.rnum BETWEEN ? AND ?";
		
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, 1);
				ps.setInt(2, 1);
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
			ps.setInt(2, 1);
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
	public List<NoteList> getReceivedList(Connection conn, HttpServletRequest req, Paging paging) {  
		
		
		
		List<NoteList> result = new ArrayList<NoteList>();
		
		String sql = "";
		sql += "SELECT * FROM (SELECT rownum rnum, j4.* FROM(";
		sql += " SELECT receiver_no, receiver_name, j2.isDelete, j2.note_no, j2.note_title, j2.send_date, j3.sender_no, j3.sender_name FROM";
		sql += " (SELECT receiver_no, receiver_name, isDelete, j1.note_no, n.note_title,TO_char(n.send_date,'YY/MM/DD HH24:MI:SS') send_date FROM(";
		sql += " SELECT r.user_no receiver_no, u.user_name receiver_name, isDelete, note_no FROM tb_receivednote r";
		sql += " INNER JOIN tb_user u";
		sql += " ON r.user_no = u.user_no";
		sql += " WHERE r.user_no = 12"; //이부분을 세션의 유저넘버값을 받아와야한다.
		sql += " AND isDelete = ?) j1"; 
		sql += " INNER JOIN tb_note n";
		sql += " ON j1.note_no = n.note_no)j2";
		sql += " INNER JOIN ";
		sql += " (SELECT s.note_no, s.user_no sender_no, u.user_name sender_name FROM tb_sendnote s";
		sql += " INNER JOIN tb_user u";
		sql += " ON s.user_no = u.user_no) j3";
		sql += " ON j2.note_no= j3.note_no";
		sql += " ORDER BY send_date DESC";
		sql += ") j4)";
		sql += " WHERE rnum BETWEEN ? and ?";
		
		
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setInt(1, 1);
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
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

}
