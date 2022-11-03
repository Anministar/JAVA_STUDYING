package CH32;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class C03DBUpdate {

	public static void main(String[] args) {
		//연결관련 정보 저장용 변수
		String id = "SYSTEM"; // DB연결 id
		String pw = "1234"; // DB연결 pw
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //연결URL (DBMS마다 상이함)
		
		//연결하기
		try 
		(
				Connection conn = DriverManager.getConnection(url, id, pw); //DB Connection 객체 받기	
				PreparedStatement pstmt = conn.prepareStatement("UPDATE a_tbl SET name = ? WHERE no = ?"); 
				
		)
		
		
		{
			pstmt.setString(1, "정아무개");
			pstmt.setInt(2, 1);
			
			
			
			int result = pstmt.executeUpdate(); //Insert나 delete, Update의 개수를 반환
			if (result != 0) {
				System.out.println("UPDATE 성공");
			}
			else {
				System.out.println("UPDATE 실패");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		
	}

}
