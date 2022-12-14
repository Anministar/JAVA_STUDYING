package CH38.Controller;

import CH38.Domain.DTO;
import CH38.Domain.MemberDTO;
import CH38.Service.AuthService;

public class AuthController implements SubController {
	private AuthService service = AuthService.getInstance();
	
	
	@Override
	public Object execute(int SN, DTO dto) {
		// 1 로그인 2 로그아웃 3 권한검증...
		
		
		
		//1) 파라미터 받기
		//2) 입력값검증(Validation)
		//3) 서비스 요청
		//4) View 전달
		
		switch(SN) {
		case 1:
			MemberDTO down = (MemberDTO) dto;
			String id = down.getMemId();
			String pwd = down.getPwd();
			if(id != null && pwd != null) {
				 return service.LoginCheck(id, pwd); // null(id와 pw가 일치하지 않으면) or role값(일치하면)
			}
			 
			 
		case 2:
			break;
		case 3:
			break;
		}
		
		return null;
	}

}
