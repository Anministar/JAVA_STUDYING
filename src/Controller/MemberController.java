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
		case 1: // 회원 & Admin 등록
			if (dto instanceof MemberDTO) {
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
			if (dto instanceof OwnerDTO) {
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

		case 3: // 수정
			if (dto instanceof MemberDTO) {
				MemberDTO down = (MemberDTO) dto;
				flag = service.UpdateMember(down.getMemId());
			}
			System.out.println("[SYSTEM] : 회원 수정 서비스입니다.");
			if (flag) {
				obj = "수정 성공입니다.";
			}
			else {
				obj = "수정 실패입니다.";
			}
			break;
			
			
		case 4: // 회원 삭제
			if (dto instanceof MemberDTO) {
				MemberDTO down = (MemberDTO) dto;
				flag = service.DeleteMember(down);
			}
			System.out.println("[SYSTEM] : 회원삭제 서비스입니다.");
			if(flag) {
				obj = "삭제 성공입니다.";
			}
			else {
				obj = "삭제 실패입니다.";
			}
			
			break;
		case 5: // 모든 멤버조회 //Admin의 기능

			obj = service.ShowAllMember();
			System.out.println("[SYSTEM] : 모든 회원정보를 조회합니다.");
			

//			if (dto instanceof MemberDTO) {
//				MemberDTO down = (MemberDTO) dto;
//				if (down.getPerm() == 2) {
//					obj = service.ShowAllMember();
//					System.out.println("[SYSTEM] : Admin권한으로 모든 회원정보를 조회합니다.");
//				} else {
//					System.out.println("[SYSTEM] : 권한부족! 회원정보를 불러올 수 없습니다.");
//				}
//
//				if (dto instanceof OwnerDTO) {
//					OwnerDTO down1 = (OwnerDTO) dto;
//					obj = service.ShowAllMember();
//					System.out.println("[SYSTEM] : Owner권한으로 모든 회원정보를 조회합니다.");
//				}
//			}
			break;
		case 6: // 선택 멤버조회 //Owner와 Admin의 기능
			
			obj = service.ShowMember();
				if (obj != null) {
					System.out.println("회원정보 조회 성공");
					
				} else {
					System.out.println("회원정보 조회 실패");
					
				}
			break;
		default:
			System.out.println("잘못된 서비스 요청입니다.");
	}
		return obj;

	}

}
