package CH23EXEC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class C01Prac {
	
	//tbl_customer에 키보드로 입력한 내용을 저장해보세요~

	public static void main(String[] args) {
		//연결관련 정보 저장용 변수
		String id = "root"; // DB연결 id
		String pw = "1234"; // DB연결 pw
		String url = "jdbc:mysql://localhost:3306/shopdb"; //연결URL (DBMS마다 상이함)
				//jdbc 동일 : 오라클이면 달라짐 :// 현재위치(현재컴퓨터) : 포트번호
		//DB연결객체 관련 참조변수
		Connection conn = null;				//DB연결객체용 참조변수
		PreparedStatement pstmt = null;		//SQL쿼리 전송객체용 참조변수
		ResultSet rs = null;				//쿼리결과(Select결과) 수신용 참조변수
		
		
		
		//연결하기

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //DB 드라이버 로드 @ 클래스는 설계도면이지만, 도면이여도 종이는 있어야하지 않겠나.
													   //이런 드라이버가 있다고 알려주는거임.
													   //  메모리 공간에 드라이버 적재
			System.out.println("Driver Loading Success!!");
			conn = DriverManager.getConnection(url, id, pw); //DB Connection 객체 받기
			System.out.println("DB Connected...");
//			pstmt = conn.prepareStatement("SQL쿼리문");
			pstmt = conn.prepareStatement("INSERT INTO `shopdb`.`tbl_customer` VALUES (?, ?, ?, ?)");
			
			pstmt.setInt(1, 6);
			pstmt.setString(2, "이창범");
			pstmt.setString(3, "구미");
			pstmt.setString(4, "010-313-3131");
			
			
			
			int result = pstmt.executeUpdate(); //Insert나 delete, Update의 개수를 반환
			if (result != 0) {
				System.out.println("INSERT 성공");
			}
			else {
				System.out.println("INSERT 실패");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {pstmt.close();}catch(Exception e) {e.printStackTrace();}
			try {conn.close();}catch(Exception e) {e.printStackTrace();} //문제없이 finally로 왔다면 conn의 객체를 제거함. 여기서도 예외처리를 해준거고
		}
		
		
		
	}

}
