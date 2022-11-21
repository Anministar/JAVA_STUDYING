package VIEW;

import java.util.List;
import java.util.Scanner;


import Controller.FrontController;
import Domain.MemberDTO;



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
			System.out.println("------------------------------------------ M A I N -----------------------------------------");
			System.out.println("번호 : " );
			n = sc.nextInt();
			switch(n) {
			case 1: //회원 & Admin 등록
				controller.ExSubController("/member", 1, );
				
				break;
			case 2: //Owner 등록
				// 로그인 상태인지 확인
				
				// 권한이 맞는지
					
				
				break;
			case 3: //회원 수정
				while (true) {
					int n;
					System.out.println("변경하실 회원정보를 입력하세요 >>> ");
					System.out.println("1 비밀번호");
					System.out.println("2 이름");
					System.out.println("3 핸드폰 번호");
					System.out.println("4 주소");
					System.out.println("5 이메일");
					System.out.println("-----------------------------------------");
					System.out.println("번호 : " );
					n = sc.nextInt();
					switch(n) {
					case 1:
						System.out.println("");
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						break;
					case 6:
						break;
					case 7:
						break;
					default:
					}
					
				}
			case 4: //회원 삭제
				System.out.println("[VIEW] : 종료합니다.");
				System.exit(-1);
				break;
			case 5: //모든 회원 조회
				List<MemberDTO> list = (List<MemberDTO>) controller.ExSubController("/member", 6, null);
				for (MemberDTO dto : list) {
					
					System.out.println("[VIEW] : " + dto);
				}
				break;
			case 6: //선택 회원 조회
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
