package dao.impl.appr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.JDBCTemplate;
import dao.face.appr.ApprovalMyDetailDao;
import dto.appr.Appr;


public class ApprovalMyDetailDaoImpl implements ApprovalMyDetailDao{

	private PreparedStatement ps = null;
	private ResultSet rs= null;
	
	@Override
	public List<Appr> selectByApprvlno(HttpServletRequest req, HttpServletResponse resp ,Appr appr){
		
		String sql="";
		
		sql+=" select a.mid_auth,a.final_auth,a.aprvl_no,a.user_no , a.holiday_start,a.holiday_end, a.aprvl_type,a.create_date,a.final_date, c.user_name,f.user_name as mid_auth_name ,g.user_name as fianl_auth_name ,a.aprvl_title,a.aprvl_article,d.dept_name, e.position_name,b.origin_name,b.file_addr,b.stored_name \r\n" + 
				"from tb_approval a, tb_approvalattdfile b ,tb_user c ,tb_dept d,tb_position e, tb_user f, tb_user g where a.user_no=c.user_no and a.aprvl_no=b.aprvl_no\r\n" + 
				" and  d.dept_no=c.dept_no and e.position_no=c.position_no and a.mid_auth = f.user_no and a.final_auth=g.user_no(+)  and a.aprvl_no=? ";
		
		
		List<Appr> list = new ArrayList<>();
		try {
			
			ps = JDBCTemplate.getConnection().prepareStatement(sql);
			
			ps.setInt(1, appr.getApprl_no());
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				Appr appr2=new Appr();
				appr2.setAprvl_type( rs.getString("aprvl_type") );
				appr2.setCreate_date(rs.getDate("create_date"));
				appr2.setFinal_date(rs.getDate("final_date"));
				appr2.setApprl_no(rs.getInt("aprvl_no"));
				appr2.setMid_auth(rs.getInt("mid_auth"));
				appr2.setFinal_auth(rs.getInt("final_auth"));
				appr2.setUser_no(rs.getInt("user_no"));
				appr2.setUser_name(rs.getString("user_name"));
				appr2.setMid_auth_name(rs.getString("mid_auth_name"));
				appr2.setFinal_auth_name(rs.getString("fianl_auth_name"));
				appr2.setAprvl_title(rs.getString("aprvl_title"));
				appr2.setAprvl_article(rs.getString("aprvl_article"));
				appr2.setHoliday_start(rs.getTimestamp("holiday_start"));
				appr2.setHoliday_end(rs.getTimestamp("holiday_end"));
				appr2.setFile_name(rs.getString("stored_name"));
				appr2.setFile_origin_name(rs.getString("origin_name"));
				appr2.setFile_path(rs.getString("file_addr"));
				
				list.add(appr2);
				
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
