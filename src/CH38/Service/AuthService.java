package CH38.Service;

import CH38.Domain.MemberDAO;
import CH38.Domain.MemberDTO;

public class AuthService {

	MemberDAO dao = MemberDAO.getInstance();

	// 싱글톤 패턴 코드 추가
	private static  AuthService instance;

	public static AuthService getInstance() {
		if (instance == null) {
			instance = new AuthService();
		}
		return instance;
	}

	private AuthService() {
	}

	
	//멤버 등록하기
	public boolean RegisterMember(MemberDTO dto, int permission) { // Service는 어떤걸 등록할껀지 세부적으로 접근하는게 좋다.

		boolean isRegisterOK = true;

		// 권한 체크(등록 가능한지 여부)
		if (permission >= 3) {

			int result = dao.Insert(dto);
			if (result > 0) {
				return true;
			}
			return false;
		}
		return false;
	}
	// (ID/PW 인증 이후 Role 전달)
	public Integer LoginCheck(String id, String pwd) {
		
		MemberDTO dto = null;
		dto = dao.Select(id);
		if(dto == null) {
			return null;
		}
		
		//ID 일치 PW일치여부 확인
		if(id.equals(dto.getMemId()) && pwd.equals(dto.getPwd())) {
			
			return dto.getRole();
		}
			
		//role 반환 (1 or 2 or Null)
		return null;
	}


}
