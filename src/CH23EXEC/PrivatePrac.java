package CH23EXEC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PrivatePrac {

	public static void main(String[] args) {
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/daegu";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			System.err.println("Driver Loading Success..!!");
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB connected...");
			
			pstmt = conn.prepareStatement("SELECT * FROM `daegu`.`restaurant`");
			pstmt.executeQuery();
			
			rs = pstmt.executeQuery();
			
			if(rs != null) {
				while(rs.next()) {
					System.out.println(rs.getString("업종명") + " ");
					System.out.println(rs.getString("업소명") + " ");
					System.out.println(rs.getString("소재지(도로명)") + " ");
					System.out.println(rs.getString("업태명") + " ");
				}
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {rs.close();} catch (Exception e) {e.printStackTrace();}
			try {pstmt.close();} catch (Exception e) {e.printStackTrace();}
			try {conn.close();} catch (Exception e) {e.printStackTrace();}
		}
		
		

	}

}
