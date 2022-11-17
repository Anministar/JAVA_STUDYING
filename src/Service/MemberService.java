package Service;

import java.util.ArrayList;

import CH38.Domain.BookDTO;
import Domain.MemberDAO;
import Domain.MemberDTO;
import Domain.OwnerDTO;

public class MemberService {

	MemberDAO dao = MemberDAO.getinstance();

	private static MemberService instance;

	public static MemberService getinstance() {
		if (instance == null) {
			instance = new MemberService();
		}
		return instance;
	}

	private MemberService() {
		
	}
	
	//1 회원 등록
	public boolean RegisterMember(MemberDTO dto) {
		if (dto.getPerm() == 1) {
			int result = dao.InsertMember(dto);
			if (result > 0) {
				return true;
			}
			return false;
		}
		else {
			return false;
		}
	}
	//2 Owner 등록
	public boolean RegisterOwner(OwnerDTO dto) {
			int result = dao.Insertowner(dto);
			if (result > 0) {
				return true;
			}
			return false;
		}
	
	//3 Admin 등록
	public boolean RegisterAdmin(MemberDTO dto) {
		if (dto.getPerm() == 2) {
			int result = dao.InsertAdmin(dto);
			if (result > 0) {
				return true;
			}
			return false;
		}
		else {
			return false;
		}
	}
	//4 주소 수정
	//5 회원 삭제
	//6 모든 멤버조회

	public ArrayList<MemberDTO> ShowAllMember() {
			return dao.SelectAll();
		
		
		
		
		
		
	}
	
	
}
