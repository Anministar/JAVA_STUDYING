package Domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class MemberDAO {
	String id = "root";
	String pwd = "1234";
	String url = "jdbc:mysql://localhost:3306/hotelreservation";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//싱글 톤 패턴
	private static MemberDAO instance;
	
	public static MemberDAO getinstance() {
		if(instance == null) {
			MemberDAO instance = new MemberDAO();
			return instance;
		}
		return instance;
	}
	
	private MemberDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pwd);
			System.out.println("MemberDAO Connected !!!");
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	// 회원 등록하기
	// Admin 등록하기
	
	public int Insert(MemberDTO dto) {
		int result = 0;
		try {
			pstmt = conn.prepareStatement("INSERT INTO `member` VALUES (0, ?, ?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, dto.getMemId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPhone());
			pstmt.setString(5, dto.getAddr());
			pstmt.setString(6, dto.getEmail());
			pstmt.setInt(7, dto.getPerm());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
		}
	// Owner 등록하기
	public int Insert(OwnerDTO dto) {
		int result = 0;
		try {
			pstmt = conn.prepareStatement("INSERT INTO `owner` VALUES (0, ?, ?)");
			pstmt.setString(1, dto.getOwnername());
			pstmt.setString(2, dto.getOwnerphone());
			
			
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
		}
	
	
	
	// 회원 주소 수정하기 (트랜젝션 사용)
	public int Update(MemberDTO dto) { 
		
		MemberDTO dto1 = null;
		int result = 0;
		
		try {
			
			
			conn.setAutoCommit(false);
			
			pstmt =  conn.prepareStatement("SELECT * FROM member where userid = ?");
			pstmt.setInt(1, dto.getUserId());
			rs = pstmt.executeQuery();
			
			
			pstmt = conn.prepareStatement("UPDATE member set memid = ?, pwd = ?, name = ?, phone = ?, addr = ?, email = ?, perm = ? WHERE userid = ?");
			pstmt.setInt(1, dto.getUserId());
			result = pstmt.executeUpdate();
			
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try{rs.close();}catch(Exception e) {e.printStackTrace();}
				try {pstmt.close();} catch(Exception e) {e.printStackTrace();}
			}
		return result;
		
}
	
	
	// 회원 삭제하기
	
	public int Delete(MemberDTO dto) {

		MemberDTO dto1 = null;
		int result = 0;
		try {
			
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement("SELECT * FROM member WHERE userid = ?");
			pstmt.setInt(1, dto.getUserId());
			rs = pstmt.executeQuery();
			if (rs != null) {
				while(rs.next()) {
					dto1 = new MemberDTO();
					dto1.setUserId(rs.getInt("userId"));
					dto1.setMemId(rs.getString("memId"));
					dto1.setPwd(rs.getString("pwd"));
					dto1.setName(rs.getString("name"));
					dto1.setPhone(rs.getString("phone"));
					dto1.setAddr(rs.getString("addr"));
					dto1.setEmail(rs.getString("email"));
					dto1.setPerm(rs.getInt("perm"));
				}
			}
		
			//멤버ID를 받아오는 작업한 후에 객체의 ID와 같다면 Update를 실행하는 로직 구현
			if (dto1.getUserId() == dto.getUserId()) {
			
			

				pstmt = conn.prepareStatement("DELETE FROM member where userid = ?");
				pstmt.setInt(1, dto.getUserId());
				
				result = pstmt.executeUpdate();
				
				conn.commit();
			}
			else {
				conn.rollback();
			}
			} catch (Exception e) {
				e.printStackTrace();
				result = 0;
				try {
					conn.rollback();
					System.out.println("회원정보를 찾을 수 없습니다.");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			} finally {
				try{rs.close();}catch(Exception e) {e.printStackTrace();}
				try {pstmt.close();} catch(Exception e) {e.printStackTrace();}
			}
		return result;
	}
	
	//모든 회원 조회

		public ArrayList<MemberDTO> SelectAll() {
			ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
			MemberDTO dto = null;
			try {
				pstmt = conn.prepareStatement("SELECT * FROM `member` where perm = 1");
				rs = pstmt.executeQuery();
				if(rs != null) {
					while(rs.next()) {
						dto = new MemberDTO();
						dto.setUserId(rs.getInt("userId"));
						dto.setMemId(rs.getString("memId"));
						dto.setPwd(rs.getString("pwd"));
						dto.setName(rs.getString("name"));
						dto.setPhone(rs.getString("phone"));
						dto.setAddr(rs.getString("addr"));
						dto.setEmail(rs.getString("email"));
						dto.setPerm(rs.getInt("perm"));
						list.add(dto);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try{rs.close();}catch(Exception e) {e.printStackTrace();}
				try {pstmt.close();} catch(Exception e) {e.printStackTrace();}
			}
			return list;
		}
		
		//선택 회원 조회
		
		public MemberDTO Select(String id) {
			// pstmt
			MemberDTO dto = null;
			try {
				pstmt = conn.prepareStatement("SELECT * FROM member WHERE memId = ?");
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if (rs != null) {
					while(rs.next()) {
						dto = new MemberDTO();
						dto.setUserId(rs.getInt("userId"));
						dto.setMemId(rs.getString("memId"));
						dto.setPwd(rs.getString("pwd"));
						dto.setName(rs.getString("name"));
						dto.setPhone(rs.getString("phone"));
						dto.setAddr(rs.getString("addr"));
						dto.setEmail(rs.getString("email"));
						dto.setPerm(rs.getInt("perm"));
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
	
	
	
	
}
