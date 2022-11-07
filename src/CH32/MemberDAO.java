package CH32;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
		
		//연결관련 정보 저장용 변수
		String id = "SYSTEM"; // DB연결 id
		String pw = "1234"; // DB연결 pw
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //연결URL (DBMS마다 상이함)
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
				conn = DriverManager.getConnection(url, id, pw);
				System.out.println("Connected...");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// 멤버 가입하기
		boolean Insert(String email, String addr, String phone) {
			
			int result=0;
			try {
				pstmt = conn.prepareStatement("insert into tbl_member values(member_seq.NEXTVAL,?,?,?)");
				pstmt.setString(1, email);
				pstmt.setString(2, addr);
				pstmt.setString(3, phone);
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try{pstmt.close();}catch(Exception e) {e.printStackTrace();}
			}

			if (result > 0) {
				return true;
			}
			return false;

		}
		
		
		//멤버 가입하기
//		boolean Insert(이메일, 주소, 연락처) { DB 저장하기; }
		boolean Insert(MemberDTO dto) {
			int result = 0;
			try {
				pstmt = conn.prepareStatement("INSERT INTO tbl_member VALUES(member_seq.NEXTVAL, ?, ?, ?)");
				pstmt.setString(1, dto.getEmail());
				pstmt.setString(2, dto.getAddr());
				pstmt.setString(3, dto.getPhone());
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try{pstmt.close();}catch(Exception e) {e.printStackTrace();} // 자원 제거, 자원 제거를 적절하게 하지 않으면 메모리 공간을 계속 차지하면서 웹을 만들 때 문제가 됨.
			}
			
			if(result > 0) {
				return true;
			}
			return false;
		}
		
		//멤버 수정하기
//		boolean Update(이메일, 주소, 연락처) { DB 저장하기; }
		boolean Update(MemberDTO dto) {
			int result = 0;
			try {
				String sql = "Update tbl_member SET addr = ?, phone = ? WHERE email = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getAddr());
				pstmt.setString(2, dto.getPhone());
				pstmt.setString(3, dto.getEmail());
				result = pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {pstmt.close();}catch(Exception e) {e.printStackTrace();}
			}
			
			if(result > 0) {
				return true;
			}
			return false;
		}
		
		
		//멤버 삭제하기
//		boolean Delete(이메일) { DB 삭제하기; }
		
		//멤버 조회하기
//		boolean Search(이메일) { DB 조회하기; }
		
		//전체 조회하기
		List<MemberDTO> SearchAll() {
			
			List<MemberDTO> list = new ArrayList();
			MemberDTO dto = null;						//임시 참조변수
			
			try {
				pstmt = conn.prepareStatement("SELECT * FROM tbl_member");
				rs = pstmt.executeQuery();
				if(rs != null) {
					while(rs.next()) {
						dto = new MemberDTO();			//dto 객체 생성
						dto.setNo(rs.getInt(1));		//No 저장
						dto.setEmail(rs.getString(2));	//Email 저장
						dto.setAddr(rs.getString(3));	//Addr 저장
						dto.setPhone(rs.getString(4));	//Phone 저장
						list.add(dto);
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {rs.close();}catch(Exception e) {e.printStackTrace();}
				try {pstmt.close();}catch(Exception e) {e.printStackTrace();}    //스택 형태로 쌓이기 때문에 최근꺼부터 닫고 순서대로
						
			}
			
			return list;
		}
		
		
		
		
		
		
		//멤버 수 확인하기
		//자원 연결 해제하기
		
				
				
				
				

	

}
