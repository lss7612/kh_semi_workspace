package dao.impl.addr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import common.Paging;
import dao.face.addr.AddrViewDao;
import dto.addr.AddrParam;
import dto.addr.AddrView;

public class AddrViewDaoImpl implements AddrViewDao{
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public List<AddrView> viewUserAddr(Connection conn, AddrParam addrParam, Paging paging) {

		List<AddrView> result = new ArrayList<AddrView>();
		
		String arrCon = addrParam.getArrayCondition();
		Boolean isASC = addrParam.isASC();
		
		String asc =" ASC";
		String desc =" DESC";
		String userid = " user_id";
		String username = " user_name";
		String dept =" dept_no";
		String position = " position_no";
		String sql ="";
		
		sql += "SELECT * FROM (SELECT rownum rnum, j2.* FROM ";
		sql += " (SELECT * FROM ";
		sql += " (SELECT * FROM tb_user u ";
		sql += " LEFT OUTER JOIN tb_dept d ";
		sql += " ON u.dept_no = d.dept_no) j1 ";
		sql += " LEFT OUTER JOIN tb_position t ";
		sql += " ON j1.position_no = t.position_no ";
		sql += " ORDER BY ";
		
		if(arrCon.equals("userid")) {
			sql += userid;
		} else if(arrCon.equals("username")) {
			sql += username;
		} else if(arrCon.equals("dept")) {
			sql += dept;
		} else if(arrCon.equals("position")) {
			sql += position;
		}
		if(isASC) {
			sql += asc;
		} else if(!isASC) {
			sql += desc;
		} else {
			
		}
		sql += ") j2)";
		sql += " WHERE rnum BETWEEN ? and ? ";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				AddrView e = new AddrView();
				
				e.setUser_no(rs.getInt("user_no"));
				e.setCellphone_no(rs.getString("cellphone_no"));
				e.setDept_name(rs.getString("dept_name"));
				e.setPosition_name(rs.getString("position_name"));
				e.setUser_id(rs.getString("user_id"));
				e.setUser_name(rs.getString("user_name"));
				
				System.out.println(e);
				
				result.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	
	}

	
	
	@Override
	public int selectCntAll(Connection conn) {

		int totalCnt= 0;
		
		String sql = "";
		sql += "SELECT count(*) FROM tb_user";
		
		try {
			ps = conn.prepareStatement(sql);
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
	public List<AddrView> search(Connection conn, AddrParam addrParam, Paging paging) {

		List<AddrView> result = new ArrayList<AddrView>();
		
		String arrCon = addrParam.getArrayCondition();
		String searchCondition = addrParam.getSearchCondition();
		String search = addrParam.getSearch();
		
		Boolean isASC = addrParam.isASC();
		
		String asc =" ASC";
		String desc =" DESC";
		String userid = " user_id";
		String username = " user_name";
		String dept =" dept_no";
		String position = " position_no";
		
		String sql ="";
		sql += "SELECT * FROM (SELECT rownum rnum, j2.* FROM ";
		sql += " (SELECT * FROM ";
		sql += " (SELECT u.*, d.dept_name FROM tb_user u ";
		sql += " LEFT OUTER JOIN tb_dept d ";
		sql += " ON u.dept_no = d.dept_no) j1 ";
		sql += " LEFT OUTER JOIN tb_position t ";
		sql += " ON j1.position_no = t.position_no ";
		
		String search_userid=" WHERE user_id = ?";
		String search_username=" WHERE user_name = ?";
		String search_dept=" WHERE j1.dept_no = ?";
		String search_position=" WHERE j1.position_no = ?";
		String search_cellphone=" WHERE cellphone_no = ?";
		
		if(searchCondition.equals("userid")) {
			sql += search_userid;
		} else if(searchCondition.equals("username")) {
			sql += search_username;
		} else if(searchCondition.equals("dept")) {
			
			sql += search_dept;
			if(search.equals("경영")) {
				search="1";
			} else if(search.equals("회계")){
				search="2";
			} else if(search.equals("인사")){
				search="3";
			} else if(search.equals("개발")){
				search="4";
			} else if(search.equals("영업")){
				search="5";
			} else {
				search="0";
			}
			
		} else if(searchCondition.equals("position")) {
			
			sql += search_position;
			if(searchCondition.equals("사장")) {
				search="1";
			} else if(search.equals("부장")){
				search="2";
			} else if(search.equals("과장")){
				search="3";
			} else if(search.equals("대리")){
				search="4";
			} else if(search.equals("사원")){
				search="5";
			} else {
				search="0";
			}
			
		} else if(searchCondition.equals("cellphone")) {
			sql += search_cellphone;
		}
		
		sql += " ORDER BY ";
		
		if(arrCon.equals("userid")) {
			sql += userid;
		} else if(arrCon.equals("username")) {
			sql += username;
		} else if(arrCon.equals("dept")) {
			sql += dept;
		} else if(arrCon.equals("position")) {
			sql += position;
		}
		if(isASC) {
			sql += asc;
		} else if(!isASC) {
			sql += desc;
		} else {
			
		}
		
		
		sql += ") j2)";
		
		
		sql += " WHERE rnum BETWEEN ? and ? ";
		
		try {
			ps = conn.prepareStatement(sql);
			
			if(searchCondition.equals("userid") || searchCondition.equals("username") || searchCondition.equals("cellphone")) {
				ps.setString(1, search);
			} else {
				ps.setInt(1, Integer.parseInt(search));
			}
			
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			System.out.println(sql);
			System.out.println(search);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				AddrView e = new AddrView();
				
				e.setUser_no(rs.getInt("user_no"));
				e.setCellphone_no(rs.getString("cellphone_no"));
				e.setDept_name(rs.getString("dept_name"));
				e.setPosition_name(rs.getString("position_name"));
				e.setUser_id(rs.getString("user_id"));
				e.setUser_name(rs.getString("user_name"));
				
				System.out.println(e);
				
				result.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	
	}



	@Override
	public int selectSerchCntAll(Connection conn, HttpServletRequest req) {

		int totalCnt= 0;
		
		String userid = " WHERE user_id = ?";
		String username = " WHERE user_name = ?";
		String dept = " WHERE dept_no = ?";
		String position = " WHERE position_no = ?";
		String cellphone = " WHERE cellphone_no = ?";
		
		String classification = req.getParameter("classification");
		
		String keyword = null;
		
		String sql = "";
		sql += "SELECT count(*) FROM tb_user";
		
		System.out.println("AddrViewDaoImpl에서 classification () : "+classification);
		
		if(classification.equals("userid")) {
			sql += userid;
			keyword = req.getParameter("keyword");
		} else if(classification.equals("username")) {
			sql += username;
			keyword = req.getParameter("keyword");
		} else if(classification.equals("dept")) {
			
			sql += dept;
			
			if(req.getParameter("keyword").equals("경영")) {
				keyword="1";
			} else if(req.getParameter("keyword").equals("회계")){
				keyword="2";
			} else if(req.getParameter("keyword").equals("인사")){
				keyword="3";
			} else if(req.getParameter("keyword").equals("개발")){
				keyword="4";
			} else if(req.getParameter("keyword").equals("영업")){
				keyword="5";
			} else {
				keyword="0";
			}
			
		} else if(classification.equals("position")) {
			
			sql += position;
			
			if(req.getParameter("keyword").equals("사장")) {
				keyword="1";
			} else if(req.getParameter("keyword").equals("부장")){
				keyword="2";
			} else if(req.getParameter("keyword").equals("과장")){
				keyword="3";
			} else if(req.getParameter("keyword").equals("대리")){
				keyword="4";
			} else if(req.getParameter("keyword").equals("사원")){
				keyword="5";
			} else {
				keyword="0";
			}
			
		} else if(classification.equals("cellphone")) {
			sql += cellphone;
			keyword = req.getParameter("keyword");
		}
		
		sql += " ORDER BY user_no ASC";
		
		
		System.out.println("cnt에서 classification은 " + classification);
		try {
			ps = conn.prepareStatement(sql);
			
			if(classification.equals("userid") || classification.equals("username") || classification.equals("cellphone")) {
				ps.setString(1, keyword);
			} else {
				ps.setInt(1, Integer.parseInt(keyword));
			}
			
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

}
