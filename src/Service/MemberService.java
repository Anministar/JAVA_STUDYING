package Service;

import java.util.ArrayList;
import java.util.Scanner;

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

	// 1 회원 등록 & Admin 등록
	public boolean RegisterMember(MemberDTO dto) {
		if (dto.getPerm() == 1) {
			int result = dao.Insert(dto);
			if (result > 0) {
				return true;
			}
			return false;
		} else {
			return false;
		}
	}

	// 2 Owner 등록
	public boolean RegisterOwner(OwnerDTO dto) {
		int result = dao.Insert(dto);
		if (result > 0) {
			return true;
		}
		return false;
	}

	// 3 Admin 등록
	public boolean RegisterAdmin(MemberDTO dto) {
		if (dto.getPerm() == 2) {
			int result = dao.Insert(dto);
			if (result > 0) {
				return true;
			}
			return false;
		} else {
			return false;
		}
	}
	// 4 주소 수정

	public boolean UpdateMember(MemberDTO dto) {
		dto.setAddr("서울");
		int res = dao.Select(dto);
		if(res >0) {
			return true;
		}
		else {
			return false;
		}
		
		
		int result = dao.Update(dto);
		
		
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	// 5 회원 삭제
	public boolean DeleteMember(MemberDTO dto) {

		int result = dao.Delete(dto);
		if (result > 0) {
			return true;
		}
		return false;
	}

	// 6 모든 멤버조회

	public ArrayList<MemberDTO> ShowAllMember() {
		return dao.SelectAll();
	}

	// 7 선택 멤버조회

	public MemberDTO ShowMember(String id) {
		return dao.Select(id);

	}

}
