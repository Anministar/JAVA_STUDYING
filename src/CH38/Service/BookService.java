package CH38.Service;

import CH38.Domain.BookDAO;
import CH38.Domain.BookDTO;

public class BookService {
	
	
	BookDAO dao = BookDAO.getInstance();
	
	
	
	
	
	// 도서 조회하기
	
	// 도서 등록하기
	// (권한 확인 후 도서 등록하기) 								// 사서라면 우리는 도서를 등록할꺼임.
	public boolean RegisterBook(BookDTO dto, int permission) { 				// Service는 어떤걸 등록할껀지 세부적으로 접근하는게 좋다.
		
		boolean isRegisterOK = true;
		// 권한 체크(등록 가능한지 여부)
		
		if(permission >= 3) {
			return dao.Insert(dto);
		}
		return false;
	}
	
	// 도서 수정하기
	
	// 도서 삭제하기
	
	// 기타..
}
