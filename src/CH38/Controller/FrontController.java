package CH38.Controller;

import java.util.HashMap;
import java.util.Map;

import CH38.Domain.DTO;

public class FrontController {
	
	//요청정보-하위컨트롤러 Mapping 저장 필요
	private Map<String, SubController> map = new HashMap();
	
	//생성자실행 시 init함수 호출
	public FrontController() {
		init();
	}
	
	//요청 서비스별 처리 Controller를 저장 보관 하기 위한 함수
	private void init() {
		map.put("/member", new MemberController()); //회원서비스에 대한 MemberController (회원에 관한 요청)
		map.put("/book", new BookController());     //책서비스에   대한 BookController (책에 관한 요청)
		map.put("/auth", new AuthController());
	}
	
	//사용자로부터 요청서비스명, 서비스번호(SN)를 받아 요청처리 Controller를 실행
	public Object ExSubController(String menu, int SN, DTO dto) {
		
		//서비스 선별
		SubController sub = map.get(menu); // 업캐스팅, map.get(menu)하면 Controller가 꺼내짐, 키에 해당하는 Value값을 꺼내옴.
		//SN 전달 execute
		Object obj = sub.execute(SN, dto);
		return obj;
	}
}
