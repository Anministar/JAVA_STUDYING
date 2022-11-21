package Service;

import java.util.ArrayList;
import java.util.Scanner;

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

	// 1 회원 등록 & Admin 등록
	public boolean RegisterMember(MemberDTO dto) {
		if (dto.getPerm() == 1 | dto.getPerm() == 2) {
			int result = dao.Insert(dto);
			if (result > 0) {
				return true;
			}
			return false;
		}
		return false;
	}

	// 2 Owner 등록
	public boolean RegisterOwner(OwnerDTO dto) {
		int result = dao.Insert(dto);
		if (result > 0) {
			return true;
		}
		return false;
	}

	// 3 주소 수정

	public boolean UpdateMember(MemberDTO dto) {
		Scanner sc = new Scanner(System.in);
		System.out.println("[SYSTEM] : 회원정보를 변경할 회원 아이디를 입력해주세요 >>> ");
		String id = sc.nextLine();
		MemberDTO res = dao.Select(id);
		if (res != null) {
			String memid = sc.nextLine();
			dto.setMemId(memid);
			String pwd = sc.nextLine();
			dto.setPwd(pwd);
			String name = sc.nextLine();
			dto.setName(name);
			String phone = sc.nextLine();
			dto.setPhone(phone);
			String addr = sc.nextLine();
			dto.setAddr(addr);
			String email = sc.nextLine();
			dto.setEmail(email);
			
			int result = dao.Update(dto);
			if (result > 0) {
				return true;
			} else {
				return false;
			}	
		} else {
			return false;
		}
	}

	// 4 회원 삭제
	public boolean DeleteMember(MemberDTO dto) {

		int result = dao.Delete(dto);
		if (result > 0) {
			return true;
		}
		return false;
	}

	// 5 모든 멤버조회

	public ArrayList<MemberDTO> ShowAllMember() {
		return dao.SelectAll();
	}

	// 6 선택 멤버조회

	public MemberDTO ShowMember(String id) {
		return dao.Select(id);

	}

}
