package CH38.Controller;

import CH38.Domain.DTO;

public class MemberController implements SubController {

	@Override
	public Object execute(int SN, DTO dto) {
		
		switch(SN) {
		case 1: // 도서 등록
			System.out.println("회원등록 서비스 요청");
			break;
		case 2: // 도서 조회
			System.out.println("회원조회 서비스 요청");
			break;
		case 3: // 도서 수정
			System.out.println("회원수정 서비스 요청");
			break;
		case 4: // 도서 삭제
			System.out.println("회원삭제 서비스 요청");
			break;
		default:
			System.out.println("잘못된 서비스 요청입니다.");
		}
		return null;
		
	}

}
