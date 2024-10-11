import java.sql.*;

public class DBConnection {
	public static Connection Ketnoi() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/QuanLySinhVien";
		String username = "root";
		String pass = "1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, pass);
			System.out.println("Káº¿t ná»‘i thÃ nh cÃ´ng");
			return conn;
		} catch (Exception e) {
			System.out.println("Lá»—i:" + e.getMessage());
		}
		return null;
	}
}