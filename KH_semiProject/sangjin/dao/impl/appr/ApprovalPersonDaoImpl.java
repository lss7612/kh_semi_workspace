package dao.impl.appr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;

import dao.appr.ApprovalPersonDao;
import dto.appr.Person;

public class ApprovalPersonDaoImpl implements ApprovalPersonDao {
	
	private PreparedStatement ps = null;
	private ResultSet rs= null;
	
	
	@Override
	public List<Person> selectDeptAndName(Connection connection){
		

		String sql = "";
		sql += "SELECT USER_NO,USER_NAME,USER_ID,DEPT_NAME FROM TB_USER A JOIN TB_DEPT B ON A.DEPT_NO=B.DEPT_NO";
		
		
		
		List<Person> list = new ArrayList<>();
		
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Person person = new Person();
				
				person.setDept_name(rs.getString("dept_name"));
				person.setUser_id(rs.getString("user_id"));
				person.setUser_name(rs.getString("user_name"));
				person.setUser_no(rs.getInt("user_no"));
				
				
				list.add(person);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
			
		}
		
		return list;
	}
	@Override
	public List<Person> selectDept(Connection connection){
		
		String sql = "";
		sql += "SELECT DEPT_NAME FROM TB_DEPT";
		
		
		
		List<Person> list = new ArrayList<>();
		
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Person dept_name = new Person();
				
				dept_name.setDept_name(rs.getString("dept_name"));
				
				
				
				
				list.add(dept_name);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
			
		}
		
		return list;
		
	}

}
