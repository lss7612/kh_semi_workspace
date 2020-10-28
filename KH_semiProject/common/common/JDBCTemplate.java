package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTemplate {
	//OJDBC ?��?��?���?
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	
	//DB ?���? ?���?
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";
	
	//DB?���? 객체
	private static Connection conn = null;
	
	//private ?��?��?��
	private JDBCTemplate() {}
	
	//Connection 객체 반환 - ?���??�� ?��?��
	public static Connection getConnection() {
		
		if(conn == null) {
			
			try {
				Class.forName(DRIVER);
				conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
				//Auto Commit ?��?�� ?���?
				conn.setAutoCommit(false);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return conn;
	}
	
	public static void close(Connection conn) {
		
		
		try {
			if(conn!=null && !conn.isClosed()) 
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close (PreparedStatement ps) {
		
		
		try {
			if(ps != null && ps.isClosed()) ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public static void close (ResultSet rs) {
		
		
		try {
			if(rs != null && rs.isClosed()) rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public static void commit (Connection conn) {
		try {
			if(conn!=null && !conn.isClosed()) conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void rollback (Connection conn) {
		try {
			if(conn!=null && conn.isClosed()) conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}
