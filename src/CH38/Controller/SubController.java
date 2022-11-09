package CH38.Controller;

import CH38.Domain.DTO;

public interface SubController {
	// 이 인터페이스는 FrontController에서 Map형태로 자료형을 지정할 때, Key와 Value의 자료형을 지정할 때 
	// Key : String, Value는 여러 Controller를 가져야 하니깐 여러 Controller의 상위 클래스, 인터페이스를 구현하여
	// 나중에 연결하게 된다면 모두 업캐스팅 형태로 연결할 수 있음.
	
	//int num : 세부서비스요청 정보
	//ex) 도서서비스(1 : 도서조회, 2 : 도서등록 , 3 : 도서 수정...)
	//ex) 멤버서비스(1 : 멤버가입, 2 : 멤버조회, 3 : 멤버 수정...)
	Object execute(int SN, DTO dto);
	
	
	
	//1 파라미터 받기
	
	//1) 회원등록 ,2) 회원수정 , 3) 회원 삭제
	
	
	//2 입력값 검증(Validation Check)
	
	//3 서비스 실행
	
	//4 View로 이동(내용전달 포함)
	
	
	
}
