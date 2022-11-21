package Service;


import Domain.MemberDAO;
import Domain.MemberDTO;

public class AuthService {
	MemberDAO dao = MemberDAO.getinstance();
	
	private static AuthService instance;
	
	public static AuthService getinstance() {
		if(instance == null) {
			instance = new AuthService();
		}
		return instance;

	}
	
	
public Integer LoginCheck(String id, String pwd) {
		
		MemberDTO dto = null;
		dto = dao.Select(id);
		if(dto == null) {
			return null;
		}
		
		//ID 일치 PW일치여부 확인
		if(id.equals(dto.getMemId()) && pwd.equals(dto.getPwd())) {
			
			return dto.getPerm();
		}
			
		//role 반환 (1 or 2 or Null)
		return null;
	}
	

}
