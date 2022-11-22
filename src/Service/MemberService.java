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

	public boolean UpdateMember(String mid) {
		Scanner sc = new Scanner(System.in);

		MemberDTO dto = dao.Select(mid);
		if (dto != null) {
			System.out.println("수정할 회원 아이디를 입력하세요 >>> ");
			String memid = sc.nextLine();
			dto.setMemId(memid);

			System.out.println("수정할 비밀번호를 입력하세요 >>> ");
			String pwd = sc.nextLine();
			dto.setPwd(pwd);

			System.out.println("수정할 이름을 입력하세요 >>> ");
			String name = sc.nextLine();
			dto.setName(name);

			System.out.println("수정할 핸드폰 번호를 입력하세요 >>> ");
			String phone = sc.nextLine();
			dto.setPhone(phone);

			System.out.println("수정할 주소를 입력하세요 >>> ");
			String addr = sc.nextLine();
			dto.setAddr(addr);

			System.out.println("수정할 이메일을 입력하세요 >>> ");
			String email = sc.nextLine();
			dto.setEmail(email);

			int result = dao.Update(dto);

			if (result > 0) {
				System.out.println("수정 성공!!");
				return true;
			} else {
				System.out.println("수정 실패!!");
				return false;
			}

		} else {
			return false;
		}
	}

	// 4 회원 삭제
	public boolean DeleteMember(MemberDTO dto) {

		if (dto != null) {
			int result = dao.Delete(dto);
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	// 5 모든 멤버조회

	public ArrayList<MemberDTO> ShowAllMember() {
		return dao.SelectAll();
	}

	// 6 선택 멤버조회

	public MemberDTO ShowMember() {
		Scanner sc = new Scanner(System.in);
		System.out.println("회원정보의 아이디를 입력하세요 >>> ");
		String id = sc.nextLine();
		if (dao.Select(id) != null) {
			System.out.println("조회하신 회원정보는 " + dao.Select(id).toString());
			return dao.Select(id);
		}
		else {
			return null;
		}
		
	}

}
