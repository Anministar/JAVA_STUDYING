package VIEW;

import java.util.List;
import java.util.Scanner;

import Controller.FrontController;
import Domain.MemberDTO;
import Domain.OwnerDTO;



public class TUIView {
	// 멤버
	private boolean Loginstate = false;
	private String userid = null;
	private Integer perm = 0; // 0 : 비회원 1 : 회원 2 : 관리자(사서)
	
	private FrontController controller = new FrontController();
	
	
	Scanner sc = new Scanner(System.in);
	int n = 0;
	
	
	public TUIView() {
		mainview();
	}

	void mainview() {
		while (true) {
			System.out.println("------------------------------------------ M A I N -----------------------------------------");
			System.out.println("1 회원 등록");
			System.out.println("2 Owner 등록");
			System.out.println("3 회원 수정");
			System.out.println("4 회원 삭제");
			System.out.println("5 모든 회원 조회");
			System.out.println("6 선택 회원 조회");
			System.out.println("7 종료");
			System.out.println("------------------------------------------ M A I N -----------------------------------------");
			System.out.println("번호 : " );
			n = sc.nextInt();
			switch(n) {
			case 1: //회원 & Admin 등록
					System.out.println("회원가입하실 이용구분을 선택하세요 >>> ");
					System.out.println("1 Member");
					System.out.println("2 Admin");
					System.out.println("-----------------------------------------");
					System.out.println("번호 : ");
					int n = sc.nextInt();
					switch(n) {
					case 1:
						System.out.println("Member를 등록합니다.");
						MemberDTO dto = new MemberDTO();
						
						sc.nextLine();
						
						System.out.println("등록하실 아이디를 입력하세요 >>> ");
						String memid = sc.nextLine();
						dto.setMemId(memid);
						
						System.out.println("등록하실 패스워드를 입력하세요 >>> ");
						String pwd = sc.nextLine();
						dto.setPwd(pwd);
						
						System.out.println("등록하실 이름을 입력하세요 >>> ");
						String name = sc.nextLine();
						dto.setName(name);
						
						System.out.println("등록하실 핸드폰 번호를 입력하세요 >>> ");
						String phone = sc.nextLine();
						dto.setPhone(phone);
						
						System.out.println("등록하실 주소를 입력하세요 >>> ");
						String addr = sc.nextLine();
						dto.setAddr(addr);
						
						System.out.println("등록하실 이메일를 입력하세요 >>> ");
						String email = sc.nextLine();
						dto.setEmail(email);
						
						dto.setPerm(1);
						
						
						String msg = (String) controller.ExSubController("/member", 1, dto);
						System.out.println("[VIEW] : " + msg);
						break;
					case 2:
						
						sc.nextLine();
						System.out.println("Admin을 등록합니다.");
						MemberDTO dto1 = new MemberDTO();
						
						System.out.println("등록하실 아이디를 입력하세요 >>> ");
						String memid1 = sc.nextLine();
						dto1.setMemId(memid1);
						
						System.out.println("등록하실 패스워드를 입력하세요 >>> ");
						String pwd1 = sc.nextLine();
						dto1.setPwd(pwd1);
						
						System.out.println("등록하실 이름을 입력하세요 >>> ");
						String name1 = sc.nextLine();
						dto1.setName(name1);
						
						System.out.println("등록하실 핸드폰 번호를 입력하세요 >>> ");
						String phone1 = sc.nextLine();
						dto1.setPhone(phone1);
						
						System.out.println("등록하실 주소를 입력하세요 >>> ");
						String addr1 = sc.nextLine();
						dto1.setAddr(addr1);
						
						System.out.println("등록하실 이메일를 입력하세요 >>> ");
						String email1 = sc.nextLine();
						dto1.setEmail(email1);
						
						dto1.setPerm(2);
						String msg1 = (String) controller.ExSubController("/member", 1, dto1);
						System.out.println("[VIEW] : " + msg1);
						break;
					default:
						System.out.println("잘못된 접근입니다.");
					}
					break;
					
			case 2: //Owner 등록
				// 로그인 상태인지 확인
				// 권한이 맞는지
				sc.nextLine();
				
				System.out.println("Owner를 등록합니다.");
				
				OwnerDTO dto = new OwnerDTO();
				System.out.println("등록하실 이름을 입력하세요 >>> ");
				String name = sc.nextLine();
				dto.setOwnername(name);
				
				System.out.println("등록하실 핸드폰 번호를 입력하세요 >>> ");
				String phone = sc.nextLine();
				dto.setOwnerphone(phone);
				
				String msg = (String) controller.ExSubController("/member", 2, dto);
				System.out.println("[VIEW] : " + msg);
				break;
				
			case 3: //회원 수정
				MemberDTO dto3 = (MemberDTO) controller.ExSubController("/member", 6, null);
				String msg3 = (String) controller.ExSubController("/member", 3, dto3);
				
				System.out.println("[VIEW] : " + msg3);
				
				break;
			case 4: //회원 삭제
				MemberDTO dto4 = (MemberDTO) controller.ExSubController("/member", 6, null);
				String msg4 = (String) controller.ExSubController("/member", 4, dto4);
				
				System.out.println("[VIEW] : " + msg4);
				
				
				break;
			case 5: //모든 회원 조회
				List<MemberDTO> list = (List<MemberDTO>) controller.ExSubController("/member", 5, null);
				for (MemberDTO dto5 : list) {
					System.out.println("[VIEW] : " + dto5);
				}
				break;
			case 6: //선택 회원 조회
				MemberDTO dto6 = (MemberDTO) controller.ExSubController("/member", 6, null);
				if (dto6 != null) {
					System.out.println("[VIEW] : 회원 조회 성공");
				}
				else {
					System.out.println("[VIEW] : 회원 조회 실패");
				}
				
				
				break;
			case 7:
				System.out.println("[VIEW] : 종료합니다.");
				System.exit(-1);
				break;
			default:
				
			} // switch 끝
		} // while 끝
	} // mainview 끝

	void loginview() {
		while(true) {
			System.out.println("------------------------------------------ L O G I N -----------------------------------------");
			System.out.println("ID/PW 입력 : ");
			String id= sc.next();
			String pwd = sc.next();
//			Integer result = (Integer) controller.ExSubController("/auth", 1, new MemberDTO(id, pwd)); // null or role값(1 : 회원, 2 : 사서)
			// null값때문에 Integer로 result의 자료형 설정, Object로 반환되므로 Integer로 다운캐스팅
//			if (result != null) {
//				//권한 1, 2 를 획득
//				break;
//			}
//			else {
//				System.out.println("[VIEW-ERROR] : 로그인 실패!");
//				break;
//			}
		}
		
	}

	void lendview() {

	}
	
	
	public static void main(String[] args) {
		new TUIView();

	}

}
