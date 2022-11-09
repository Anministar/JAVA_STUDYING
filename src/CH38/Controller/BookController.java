package CH38.Controller;


import CH38.Domain.BookDTO;
import CH38.Domain.DTO;
import CH38.Service.BookService;

public class BookController implements SubController{

	//BookService 연결
	BookService service = new BookService();
	
	
	@Override
	public Object execute(int SN, DTO dto) {
		Object obj = null;
		boolean flag = false;
		
		
		switch(SN) {
		case 1: // 도서 등록
//			System.out.println("도서등록 서비스 요청");
			
			BookDTO down = (BookDTO) dto;
			flag = service.RegisterBook(down, 3); // DTO는 BookDTO의 부모클래스이기 때문에 자식 클래스에 접근할 수 없음 ==> 다운캐스팅
			System.out.println("[SYSTEM] 도서 등록 성공 여부 : " + flag); // console(SYSTEM)에 띄우는것, View가 메세지 창을 띄워서 확인할 수 있어야함.(Controller에게 전달해주기 위해, view에 전달하기 위해 obj정의) 
			if(flag) {
				obj = "도서 등록이 완료되었습니다."; // View로 전달
			}
			else {
				obj = "도서 등록이 되지 않았습니다.";
			}
			break;
		case 2: // 도서 조회
			System.out.println("도서조회 서비스 요청");
			break;
		case 3: // 도서 수정
			System.out.println("도서수정 서비스 요청");
			break;
		case 4: // 도서 삭제
			System.out.println("도서삭제 서비스 요청");
			break;
		default:
			System.out.println("잘못된 서비스 요청입니다.");
		}
		
		return obj;
		
	}
	
}
