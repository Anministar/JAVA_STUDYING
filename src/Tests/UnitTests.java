package Tests;

import java.util.ArrayList;

import Controller.FrontController;
import Domain.MemberDTO;
import Service.MemberService;

public class UnitTests {

	public static void main(String[] args) {

		// 회원등록
		MemberService service = MemberService.getinstance();
//		boolean flag = service.RegisterMember(new MemberDTO(0, "member1", "1111", "이동하", "010-1111-1111", "대구광역시", "dlehdgk@gmail.com", 1));
//		if (flag) {
//			System.out.println("회원등록에 성공하셨습니다.");
//		}
//		else {
//			System.out.println("회원등록에 실패하셨습니다.");
//		}
		
//		boolean flag = service.RegisterMember(new MemberDTO(0, "member2", "2222", "조형준", "010-2222-2222", "거창", "Joooo@gmail.com", 1));
//		if (flag) {
//			System.out.println("회원등록에 성공하셨습니다.");
//		}
//		else {
//			System.out.println("회원등록에 실패하셨습니다.");
//		}
		
//		boolean flag = service.RegisterMember(new MemberDTO(0, "member3", "3333", "김동현", "010-3333-3333", "서울", "Donghyun@gmail.com", 1));
//		if (flag) {
//			System.out.println("회원등록에 성공하셨습니다.");
//		}
//		else {
//			System.out.println("회원등록에 실패하셨습니다.");
//		}
		
//		boolean flag = service.RegisterMember(new MemberDTO(0, "member4", "4444", "이주현", "010-4444-4444", "부산", "dlwngus@gmail.com", 1));
//		if (flag) {
//			System.out.println("회원등록에 성공하셨습니다.");
//		}
//		else {
//			System.out.println("회원등록에 실패하셨습니다.");
//		}

		
		// Owner 등록
//		boolean flag = service.RegisterOwner(new OwnerDTO(0, "갓킹식", "010-1000-1000"));
//		if (flag) {
//			System.out.println("Owner등록에 성공하셨습니다.");
//		} else {
//			System.out.println("Owner등록에 실패하셨습니다.");
//		}
		
		
		// Admin 등록
//		boolean flag = service.RegisterAdmin(new MemberDTO(3, "admin1", "0001", "오영서", "010-0001-0001", "서울", "That@gmail.com", 2));
//		if (flag) {
//			System.out.println("Admin등록에 성공하셨습니다.");
//		}
//		else {
//			System.out.println("Admin등록에 실패하셨습니다.");
//		}
		
		
		// 모든 회원 조회
//		FrontController controller = new FrontController();
//		ArrayList<MemberDTO> list = (ArrayList<MemberDTO>) controller.ExSubController("/member", 5, null);
//		for (MemberDTO dto : list) {
//			System.out.println(dto.toString());
//		}
		
		
		// 선택 회원 조회
//		FrontController controller = new FrontController();
//		MemberDTO jo = new MemberDTO(5, "MEM", "4444", "이주현", "010-4444-4444", "부산", "dlwngus@gmail.com", 1);
////		service.RegisterMember(jo);
//		MemberDTO res = (MemberDTO) controller.ExSubController("/member", 6, jo);
//		System.out.println(res.toString());
		
		// 회원 주소 수정하기
//		boolean flag = service.UpdateMember(jo.getMemId());
//		if (flag) {
//			System.out.println("회원수정 성공하셨습니다.");
//		}
//		else {
//			System.out.println("회원수정 실패하셨습니다.");
//		}
		
		
		// 회원 삭제
//		MemberDTO jo = new MemberDTO(5, "member4", "4444", "이주현", "010-4444-4444", "부산", "dlwngus@gmail.com", 1);
//		boolean flag = service.DeleteMember(jo);
//		if(flag) {
//			System.out.println("회원삭제 성공입니다.");
//		}
//		else {
//			System.out.println("회원삭제 실패입니다.");
//		}
		
	
		
		
		
	}

}
