package CH38.Domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
	
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
			private static MemberDAO instance;
			
			public static MemberDAO getInstance() {
				if( instance == null ) {
					instance = new MemberDAO();
				}
				return instance;
			}
			
			
			private MemberDAO() {
				// CONN객체 연결
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(url, id, pw);
					System.out.println("MEMBER DAO Connected...");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			// 전체 조회하기
			
			// 선택 조회하기
			
			// 등록하기
			public int Insert(MemberDTO dto) {
				// pstmt
				int result = 0;
				try {
					pstmt = conn.prepareStatement("INSERT INTO tbl_member VALUES(?, ?)");
					pstmt.setString(1, dto.getMemId());
					pstmt.setString(2, dto.getPwd());
					result = pstmt.executeUpdate();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				return result;
			}
			//조회하기
			
			public MemberDTO Select(String id) {
				// pstmt
				MemberDTO dto = null;
				try {
					pstmt = conn.prepareStatement("SELECT * FROM tbl_member WHERE memid = ?");
					pstmt.setString(1, id);
					rs = pstmt.executeQuery();
					if (rs != null) {
						while(rs.next()) {
							dto = new MemberDTO();
							dto.setMemId(rs.getString("memID"));
							dto.setPwd(rs.getString("pwd"));
							dto.setRole(rs.getInt("role"));
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try{rs.close();}catch(Exception e) {e.printStackTrace();}
					try {pstmt.close();} catch(Exception e) {e.printStackTrace();}
				}
				return dto;
			}
			
			// 수정하기
			
			// 삭제하기
			
			
	
	
	
	
	
}
