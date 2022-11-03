package CH32;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class C05DBSelect {

	public static void main(String[] args) {
		//연결관련 정보 저장용 변수
		String id = "root"; // DB연결 id
		String pw = "1234"; // DB연결 pw
		String url = "jdbc:mysql://localhost:3306/testdb"; //연결URL (DBMS마다 상이함)
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
			
			
//			pstmt = conn.prepareStatement("SELECT `분류`,`상호`,`도로명주소` from `testdb`.`tbl_meme`"); // *(와일드카드)를 사용하면 모든 내용을 볼 수 있음.
			pstmt = conn.prepareStatement("SELECT * from `testdb`.`tbl_meme`");
			pstmt.executeQuery(); // SELECT만 executeQuery임.
			
			rs = pstmt.executeQuery(); // SELECT한 결과물을 rs가 가리키고 있을꺼임.
			
			if(rs != null) {
				while(rs.next()) { //rs가 처음 가리키고 있는 행의 위치가 열 이름부분임, next()라는 메소드를 쓰면 한 행씩 내려감, 없을 때까지
					System.out.print(rs.getString("분류") + " ");
					System.out.print(rs.getString("상호") + " ");
					System.out.print(rs.getString("전화번호") + " ");
					System.out.print(rs.getString("도로명주소") + "\n");
					
//					System.out.print(rs.getString(1) + " ");
//					System.out.print(rs.getString(2) + " ");
//					System.out.print(rs.getString(3) + "\n"); //위 결과와 똑같음, 열의 순서와 상관없이 쓰고 싶으면 위에꺼 쓰면 됨.
					
				}
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {rs.close();}catch(Exception e) {e.printStackTrace();}
			try {pstmt.close();}catch(Exception e) {e.printStackTrace();}
			try {conn.close();}catch(Exception e) {e.printStackTrace();} //문제없이 finally로 왔다면 conn의 객체를 제거함. 여기서도 예외처리를 해준거고
		}
		
		
		
	}

}
