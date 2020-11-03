package dao.impl.appr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;

import common.Paging_app;
import dao.appr.ApprovalMyDao;
import dto.appr.Appr;
import dto.appr.ApprMy;

public class ApprovalMyDaoImpl implements ApprovalMyDao {

	private PreparedStatement ps = null;
	private ResultSet rs= null;
	
	
	@Override
	public List<ApprMy> selectList(Connection connection, ApprMy apprMy) {
		
		String sql = "";
		sql += "select  \r\n" + 
				"b.aprvl_no,\r\n" + 
				"a.user_no,\r\n" + 
				"a.user_name,\r\n" + 
				"a.dept_name,\r\n" + 
				"a.position_name,\r\n" + 
				"b.aprvl_title,\r\n" + 
				"b.aprvl_type,\r\n" + 
				"b.aprvl_article,\r\n"+
				"b.create_date,\r\n" + 
				"b.aprvl_state,\r\n" + 
				"b.final_date,\r\n" + 
				"c.state_name from \r\n" + 
				"(select a.user_no,a.user_name,c.dept_name,b.position_name,a.user_id from tb_user a,tb_position b, tb_dept c \r\n" + 
				"where a.dept_no=c.dept_no and a.position_no=b.position_no) a, \r\n" + 
				"(select a.aprvl_no,a.aprvl_state,a.user_no,b.user_name,a.create_date,a.final_date,a.aprvl_title, a.aprvl_article, a.aprvl_type from tb_approval a,tb_user b where a.user_no=b.user_no) b \r\n" + 
				",tb_approvalstate c\r\n" + 
				"where a.USER_no=b.USER_no and b.aprvl_state=c.state_no and a.user_id=?";

		
		List<ApprMy> list = new ArrayList<>();
		
		
		try {
			ps = connection.prepareStatement(sql);
			
			ps.setString(1, apprMy.getUser_id());
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				ApprMy apprMy2 = new ApprMy();
				
				apprMy2.setAprvl_no(rs.getInt("aprvl_no"));
				apprMy2.setUser_name(rs.getString("user_name"));
				apprMy2.setDept_name(rs.getString("dept_name"));
				apprMy2.setPosition_name(rs.getString("position_name"));
				apprMy2.setAprvl_title(rs.getString("aprvl_title"));
				apprMy2.setAprvl_type(rs.getString("aprvl_type"));
				apprMy2.setCreate_date(rs.getDate("create_date"));
				apprMy2.setAprvl_state(rs.getInt("aprvl_state"));
				apprMy2.setFinal_date(rs.getDate("final_date"));
				apprMy2.setAprvl_article(rs.getString("aprvl_article"));
				apprMy2.setState_name(rs.getString("state_name"));
				
				list.add(apprMy2);
			}
			
			
		}catch (Exception e) {
			System.out.println("파라미터 인서트 오류");
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		

		return list;
	}


	@Override
	public int selectCntAll(Connection connection, ApprMy apprMy) {
		// TODO Auto-generated method stub
		
		String sql ="";
		sql+="select count(*) from\r\n" + 
				"(select  \r\n" + 
				"b.aprvl_no,\r\n" + 
				"a.user_no,\r\n" + 
				"a.user_name,\r\n" + 
				"a.dept_name,\r\n" + 
				"a.position_name,\r\n" + 
				"b.aprvl_title,\r\n" + 
				"b.aprvl_type,\r\n" + 
				"b.create_date,\r\n" + 
				"b.aprvl_state,\r\n" + 
				"b.final_date,\r\n" + 
				"c.state_name from \r\n" + 
				"(select a.user_no,a.user_name,c.dept_name,b.position_name,a.user_id from tb_user a,tb_position b, tb_dept c \r\n" + 
				"where a.dept_no=c.dept_no and a.position_no=b.position_no) a, \r\n" + 
				"(select a.aprvl_no,a.aprvl_state,a.user_no,b.user_name,a.create_date,a.final_date,a.aprvl_title,a.aprvl_type from tb_approval a,tb_user b where a.user_no=b.user_no) b\r\n" + 
				",tb_approvalstate c\r\n" + 
				"where a.USER_no=b.USER_no and b.aprvl_state=c.state_no and a.user_id=? order by b.aprvl_no desc)";
		
		//결과 저장할 변수
		int totalCount = 0;
		
		try {
			ps = connection.prepareStatement(sql);
			
			
			ps.setString(1, apprMy.getUser_id());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				totalCount = rs.getInt(1);
			}
			
			}catch (Exception e) {
				System.out.println("파라미터 인서트 오류");
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(ps);
			}
		
		return totalCount;
	}


	@Override
	public List<ApprMy> selectList(Connection connection, ApprMy apprMy, Paging_app paging) {


		//SQL 작성
		String sql="";
		sql+="SELECT * FROM (	SELECT rownum rnum, B.* FROM (select  \r\n" + 
				"b.aprvl_no,\r\n" + 
				"a.user_no,\r\n" + 
				"a.user_name,\r\n" + 
				"a.dept_name,\r\n" + 
				"a.position_name,\r\n" + 
				"b.aprvl_title,\r\n" + 
				"b.aprvl_article,\r\n" + 
				"b.aprvl_type,\r\n" + 
				"b.create_date,\r\n" + 
				"b.aprvl_state,\r\n" + 
				"b.final_date,\r\n" + 
				"c.state_name from \r\n" + 
				"(select a.user_no,a.user_name,c.dept_name,b.position_name,a.user_id from tb_user a,tb_position b, tb_dept c \r\n" + 
				"where a.dept_no=c.dept_no and a.position_no=b.position_no) a, \r\n" + 
				"(select a.aprvl_no,a.aprvl_state,a.user_no,b.user_name,a.create_date,a.aprvl_article,a.final_date,a.aprvl_title,a.aprvl_type from tb_approval a,tb_user b where a.user_no=b.user_no) b\r\n" + 
				",tb_approvalstate c\r\n" + 
				"where a.USER_no=b.USER_no and b.aprvl_state=c.state_no and a.user_id=? order by b.aprvl_no desc\r\n" + 
				"		) B\r\n" + 
				"		 ) BOARD\r\n" + 
				"		 WHERE rnum BETWEEN ? AND ?";
		
		
		List<ApprMy> list = new ArrayList<>();
		
		System.out.println("디버깅1 :"+ paging.getStartNo());
		System.out.println("디버깅2 :"+ paging.getEndNo());
		System.out.println("디버깅3 :"+ apprMy.getUser_id());
		
		try {
			
			ps = connection.prepareStatement(sql);
			
			ps.setString(1, apprMy.getUser_id());
			ps.setInt(2, paging.getStartNo());
			
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			while(rs.next()) {
				
			ApprMy apprMy2 = new ApprMy();
			apprMy2.setAprvl_no(rs.getInt("aprvl_no"));
			apprMy2.setUser_name(rs.getString("user_name"));
			apprMy2.setDept_name(rs.getString("dept_name"));
			apprMy2.setPosition_name(rs.getString("position_name"));
			apprMy2.setAprvl_title(rs.getString("aprvl_title"));
			apprMy2.setAprvl_type(rs.getString("aprvl_type"));
			apprMy2.setCreate_date(rs.getDate("create_date"));
			apprMy2.setAprvl_state(rs.getInt("aprvl_state"));
			apprMy2.setFinal_date(rs.getDate("final_date"));
			apprMy2.setState_name(rs.getString("state_name"));
			apprMy2.setAprvl_article(rs.getString("aprvl_article"));
			//리스트에 저장
			list.add(apprMy2);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		return list;
	}
}
