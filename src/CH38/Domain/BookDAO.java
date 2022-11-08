package CH38.Domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO {
	
	
	
	
	//연결관련 정보 저장용 변수
			String id = "root"; // DB연결 id
			String pw = "1234"; // DB연결 pw
			String url = "jdbc:mysql://localhost:3306/libdb"; //연결URL (DBMS마다 상이함)
					//jdbc 동일 : 오라클이면 달라짐 :// 현재위치(현재컴퓨터) : 포트번호
			//DB연결객체 관련 참조변수
			Connection conn = null;				//DB연결객체용 참조변수
			PreparedStatement pstmt = null;		//SQL쿼리 전송객체용 참조변수
			ResultSet rs = null;				//쿼리결과(Select결과) 수신용 참조변수
			
			//싱글톤 패턴 코드 추가
			private static BookDAO instance;
			
			public static BookDAO getInstance() {
				if( instance == null ) {
					instance = new BookDAO();
				}
				return instance;
			}
			
			
			private BookDAO() {
				// CONN객체 연결
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(url, id, pw);
					System.out.println("Connected...");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			// 전체 조회하기
			
			// 선택 조회하기
			
			// 등록하기
			public boolean Insert(BookDTO dto) {
				// pstmt
				int result = 0;
				try {
					pstmt = conn.prepareStatement("INSERT INTO `libdb`.`tbl_book` VALUES(?, ?, 1)"); // isLend == 1 == 대여가능, == 0 == 대여불가능 // 가정 : 책은 한권밖에 없음.
					pstmt.setInt(1, dto.getBookCode());
					pstmt.setString(2, dto.getBookName());
					result = pstmt.executeUpdate();
					
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (result > 0) {
					
					return true;
				}
				return false;
			}
			// 수정하기
			
			// 삭제하기
			
			
	
	
	
	
	
}
