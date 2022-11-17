package Controller;

import Domain.DTO;
import Domain.HotelDTO;
import Service.HotelService;

public class HotelController implements SubController {

	HotelService service = new HotelService();

	public Object excute(int SN, DTO dto) {
		Object obj = null;
		boolean flag = false;
		switch (SN) {
		case 1:
			HotelDTO down = (HotelDTO) dto;
			flag = service.RegisterHotel(down, 3);
			System.out.println("[System] 호텔 수정 성공 여부 : " + flag);
			if (flag) {
				obj = "호텔 수정이 완료 되었습니다.";
			} else {
				obj = "호텔 수정이 되지 않았습니다.";
			}
			break;
		case 2:
			System.out.println("호텔조회 서비스 요청");
			break;
		case 3:
			System.out.println("호텔삭제 서비스 요청");
			break;
		default:
			System.out.println("잘못된 서비스 요청 입니다.");

		}
		return obj;
	}

	@Override
	public Object execute(int SN, DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}