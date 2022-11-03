package CH32;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class C02DBInsert {

	public static void main(String[] args) {
		//연결관련 정보 저장용 변수
		String id = "SYSTEM"; // DB연결 id
		String pw = "1234"; // DB연결 pw
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //연결URL (DBMS마다 상이함)
				//jdbc 동일 : 오라클이면 달라짐 :// 현재위치(현재컴퓨터) : 포트번호
		
	
		//연결하기 try-with-resources(JAVA 7버젼 이상)

		try 
		(
				Connection conn = DriverManager.getConnection(url, id, pw);
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO a_tbl VALUES(atbl_seq.NEXTVAL, ?, ?)");
				
		) 
		
		{
			
			pstmt.setString(1, "홍길동"); //이름
			pstmt.setString(2, "대구대구"); //주소
			
			
			
			int result = pstmt.executeUpdate(); //Insert나 delete, Update의 개수를 반환
			if (result != 0) {
				System.out.println("INSERT 성공");
			}
			else {
				System.out.println("INSERT 실패");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
