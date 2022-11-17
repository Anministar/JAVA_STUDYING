package Service;

import Domain.MemberDAO;

public class AuthService {
	MemberDAO dao = MemberDAO.getinstance();
	
	private static AuthService instance;
	
	public static AuthService getinstance() {
		if(instance == null) {
			instance = new AuthService();
		}
		return instance;

	}
	

}
