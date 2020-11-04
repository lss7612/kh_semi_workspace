package dao.impl.appr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import common.Paging_app;
import dao.face.appr.ApprovalDoDao;
import dto.appr.ApprMy;

public class ApprovalDoDaoImpl implements ApprovalDoDao{

	
	private PreparedStatement ps = null;
	private ResultSet rs= null;
	
	@Override
	public List<ApprMy> selectList(Connection connection, ApprMy apprMy, Paging_app paging) {
		String sql="";
		sql+="SELECT * FROM (	SELECT rownum rnum, B.* FROM \r\n" + 
				"(select b.user_id, a.*, " + 
				"e.*,f.dept_name," + 
				"g.position_name," + 
				"b.user_name as user_name," + 
				"c.user_name as mid_auth_name," + 
				"d.user_name as final_auth_name" + 
				" from tb_approval a," + 
				"tb_user b," + 
				"tb_user c," + 
				"tb_user d," + 
				"tb_approvalstate e, tb_dept f," + 
				"tb_position g " + 
				"where a.user_no=b.user_no " + 
				"and a.aprvl_state=e.state_no " + 
				"and a.Mid_auth=c.user_no(+) " + 
				"and a.Final_auth=d.user_no(+) "+ 
				"and b.dept_no=f.dept_no " + 
				"and b.position_no=g.position_no " + 
				"and ((a.aprvl_state=1 and c.user_id=?) " + 
				"OR (a.aprvl_state=4 and d.user_id=?) ) )B ) BOARD WHERE rnum BETWEEN ? AND ? ";
			
		List<ApprMy> list = new ArrayList<>();
		
		try {
			ps = connection.prepareStatement(sql);
			
			ps.setString(1, apprMy.getUser_id());
			ps.setString(2, apprMy.getUser_id());
			ps.setInt(3, paging.getStartNo());
			
			ps.setInt(4, paging.getEndNo());
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
				apprMy2.setMid_auth(rs.getInt("mid_auth"));
				apprMy2.setFinal_auth(rs.getInt("final_auth"));
				apprMy2.setFinal_auth_name(rs.getString("final_auth_name"));
				apprMy2.setMid_auth_name(rs.getString("mid_auth_name"));
				
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
	
	public int selectCntAll(Connection connection, ApprMy apprMy) {
		
		String sql ="";
		sql+="select count(*) from (" + 
				"select b.user_id,a.*,\r\n" + 
				"e.*,\r\n" + 
				"b.user_name as user_name,\r\n" + 
				"c.user_name as mid_auth_name,\r\n" + 
				"d.user_name as final_auth_name \r\n" + 
				"from tb_approval a, \r\n" + 
				"tb_user b,\r\n" + 
				"tb_user c,\r\n" + 
				"tb_user d,\r\n" + 
				"tb_approvalstate e\r\n" + 
				"where a.user_no=b.user_no \r\n" + 
				"and a.aprvl_state=e.state_no\r\n" + 
				"and a.Mid_auth=c.user_no(+)\r\n" + 
				"and a.Final_auth=d.user_no(+)\r\n" + 
				"and ((a.aprvl_state=1 and c.user_id=?)\r\n" + 
				"OR (a.aprvl_state=4 and d.user_id=?)))";
		
		//결과 저장할 변수
		int totalCount = 0;
		
		try {
			ps = connection.prepareStatement(sql);
			
			
			ps.setString(1, apprMy.getUser_id());
			ps.setString(2, apprMy.getUser_id());
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

}
