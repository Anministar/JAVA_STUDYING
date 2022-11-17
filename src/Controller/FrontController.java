package Controller;

import java.util.HashMap;
import java.util.Map;

import Controller.SubController;
import Domain.DTO;

public class FrontController {
	private Map<String, SubController> map = new HashMap();
	
	public FrontController() {
		init();
	}
	
	public void init() {
		map.put("/member", new MemberController());
		map.put("/hotel", new HotelController());
		map.put("/auth", new AuthController());
		map.put("/reserve", new ReserveController());
		
	}
	
	public Object ExSubController(String menu, int SN, DTO dto) {
		SubController sub = map.get(menu);
		Object obj = sub.execute(SN, dto);
		return obj;
	}
	
}
