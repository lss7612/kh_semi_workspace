package dao.impl.appr;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import common.JDBCTemplate;
import dao.face.appr.LoginDao;
import dto.appr.Login;

public class LoginDaoImpl implements LoginDao{

	private PreparedStatement ps = null;
	private ResultSet rs= null;
	@Override
	public List<Login> selectList(Connection connection) {
		System.out.println("a");
		
		String sql = "";
		sql += "SELECT user_id,user_pw FROM TB_USER";
		
		List<Login> list = new ArrayList<>();
		try {
			
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Login login = new Login();
				login.setUser_id(rs.getString("user_id"));
				login.setUser_pw(rs.getString("user_pw"));
				
				list.add(login);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
			
		}
		
		
		return list;
	}
}
