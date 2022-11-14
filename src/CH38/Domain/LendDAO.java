package CH38.Domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LendDAO {
	// 연결관련 정보 저장용 변수
	String id = "root"; // DB연결 id
	String pw = "1234"; // DB연결 pw
	String url = "jdbc:mysql://localhost:3306/libdb"; // 연결URL (DBMS마다 상이함)
	// jdbc 동일 : 오라클이면 달라짐 :// 현재위치(현재컴퓨터) : 포트번호
	// DB연결객체 관련 참조변수
	Connection conn = null; // DB연결객체용 참조변수
	PreparedStatement pstmt = null; // SQL쿼리 전송객체용 참조변수
	ResultSet rs = null; // 쿼리결과(Select결과) 수신용 참조변수

	// 싱글톤 패턴 코드 추가
	private static LendDAO instance;

	public static LendDAO getInstance() {
		if (instance == null) {
			instance = new LendDAO();
		}
		return instance;
	}

	private LendDAO() {
		// CONN객체 연결
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("LEND DAO Connected...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 대여처리(트랜잭션 처리 x)
	public int Insert(LendDTO bdto) {
		// pstmt
		int result = 0;
		try {
//			throw new SQLException(); //SQL 예외발생!
			pstmt = conn.prepareStatement("INSERT INTO `libdb`.`tbl_Lend` VALUES(null, ?, ?, ?, ?)");
			pstmt.setInt(1, bdto.getBookcode());
			pstmt.setString(2, bdto.getMemId());
			pstmt.setString(3, bdto.getStartDate());
			pstmt.setString(4, bdto.getEndDate());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {pstmt.close();} catch(Exception e) {e.printStackTrace();}
		}

		return result;
	}
	
	//트랜젝션
	public int Insert(BookDTO bdto, LendDTO ldto) {
		// pstmt
		int result = 0;
		try {
			conn.setAutoCommit(false);

			// tbl_Book 의 도서 정보 수정
			pstmt = conn.prepareStatement("UPDATE `libdb`.`tbl_book` SET bookname =?, isLend = ? WHERE bookcode = ?");
			pstmt.setString(1, bdto.getBookName());
			if (bdto.isLend()) { // true - 대여가능
				pstmt.setInt(2, 1); // 1값을 넣음
			} else { // false - 대여불가
				pstmt.setInt(2, 0); // 0값을 넣음
			}
			pstmt.setInt(3, bdto.getBookCode());
			result = pstmt.executeUpdate();

			
			
			// tbl_lend 의 대여 정보 추가
			pstmt = conn.prepareStatement("INSERT INTO `libdb`.`tbl_Lend` VALUES(null, ?, ?, ?, ?)");
			pstmt.setInt(1, ldto.getBookcode());
			pstmt.setString(2, ldto.getMemId());
			pstmt.setString(3, ldto.getStartDate());
			pstmt.setString(4, ldto.getEndDate());
			result = pstmt.executeUpdate();
//			throw new SQLException(); //SQL 예외발생!!
			
			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
			result = 0; // 위에 쿼리문에서 이상없으면 result에 담고, 밑 쿼리문에서 이상이 생기면 catch구문으로 넘어와 result에 0을 담음.
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		} finally {
			try {pstmt.close();} catch(Exception e) {e.printStackTrace();}
		}
		return result;

		// 반남처리

	}
}
