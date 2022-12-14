package CH38.Service;

import CH38.Domain.MemberDAO;
import CH38.Domain.MemberDTO;

public class MemberService {

	MemberDAO dao = MemberDAO.getInstance();

	// 싱글톤 패턴 코드 추가
	private static  MemberService instance;

	public static MemberService getInstance() {
		if (instance == null) {
			instance = new MemberService();
		}
		return instance;
	}

	private MemberService() {
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

}
