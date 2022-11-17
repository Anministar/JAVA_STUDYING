package Controller;

import Domain.DTO;
import Domain.MemberDTO;
import Domain.OwnerDTO;
import Service.MemberService;

public class MemberController implements SubController {

	MemberService service = MemberService.getinstance();

	@Override
	public Object execute(int SN, DTO dto) {
		Object obj = null;
		Boolean flag = null;
		switch (SN) {
		case 1: // 회원 등록
			if (dto instanceof DTO) {
				MemberDTO down = (MemberDTO) dto;
				flag = service.RegisterMember(down);
			}

			System.out.println("[SYSTEM] : Member등록 여부 : " + flag);
			if (flag) {
				obj = "등록 성공입니다.";
			} else {
				obj = "등록 실패입니다.";
			}

			break;

		case 2: // Owner 등록
			if (dto instanceof DTO) {
				OwnerDTO down = (OwnerDTO) dto;
				flag = service.RegisterOwner(down);
			}
			System.out.println("[SYSTEM] : Owner등록 여부 : " + flag);
			if (flag) {
				obj = "등록 성공입니다.";
			} else {
				obj = "등록 실패입니다.";
			}
			break;

		case 3: // Admin 등록
			if (dto instanceof DTO) {
				MemberDTO down = (MemberDTO) dto;
				flag = service.RegisterAdmin(down);
			}

			System.out.println("[SYSTEM] : Admin등록 여부 : " + flag);
			if (flag) {
				obj = "등록 성공입니다.";
			} else {
				obj = "등록 실패입니다.";
			}
			break;
		case 4: // 주소 수정
			System.out.println("회원수정 서비스입니다.");
			break;
		case 5: // 회원 삭제
			System.out.println("회원삭제 서비스입니다.");
			break;
		case 6: // 모든 멤버조회 //Admin의 기능
			obj = service.ShowAllMember();
			System.out.println("[SYSTEM] : 모든 회원정보를 조회합니다.");
			
			
//			if (dto instanceof DTO) {
//				MemberDTO down = (MemberDTO) dto;
//				if(down.getPerm() == 2) {
//					obj = service.ShowAllMember();
//					System.out.println("[SYSTEM] : Admin권한으로 모든 회원정보를 조회합니다.");
//				}
//				else {
//					System.out.println("[SYSTEM] : 회원정보를 불러올 수 없습니다.");
//				}
//				
//			}
			break;
		default:
			System.out.println("잘못된 서비스 요청입니다.");
		}
		return obj;

	}

}
