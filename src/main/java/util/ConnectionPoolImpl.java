package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class ConnectionPoolImpl implements ConnectionPool{
	private String driver;
	private String username;
	private String password;
	private String url;
	
	// Đối tượng lưu trữ kết nối
	private Stack<Connection> pool;
	
	public ConnectionPoolImpl() {
		//Xac dinh trinh dieu khien
		this.driver = "com.mysql.cj.jdbc.Driver";
		
		//Nap trinh dieu khien
		try {
			Class.forName(this.driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//Xac dinh tai khoan lam viec
		this.username = "quanweb";
		this.password = "Q0987035442.";
		
		//Xac dinh duong dan thuc thi
		this.url = "jdbc:mysql://localhost:3306/2024project_java";
		
		//Cap phat bo nho cho pool
		this.pool = new Stack<>();
	}
	
	@Override
	public Connection getConnection(String objectName) throws SQLException{
		if(this.pool.isEmpty()) {
			System.out.println(objectName + " đã khởi tạo một kết nối mới");
			return DriverManager.getConnection(this.url, this.username, this.password);
		} else {
			System.out.println(objectName + " đã lấy ra một kết nối.");
			return this.pool.pop();
		}
	}
	
	@Override
	public void releaseConnection(Connection con, String objectName) throws SQLException{
		System.out.println(objectName + " đã thu hồi một kết nối.");
		this.pool.push(con);
	}
	
	protected void finalize()throws Throwable{
		// Loại bỏ các kết nối trong Pool
		this.pool.clear();
		this.pool = null;
		
		System.out.println("CPool đã kết thúc để CPool mới ra đời.");
	}
}