package CH16;

interface C03Remocon {
	//필드(final static)
	int MAX_VOLUMN = 10;
	int MIN_VOLUMN = 0;
	//기능(추상 메서드)
	void turnOn();
	void turnOff();
	void setVolumn(int vol);
	
	default void test() { //원래라면 완성시키면 안되는데, 사용하다보니 필요하기도 해서 쓰기도 하더라
		
	}
}



class C03TV implements C03Remocon{
	
	int vol;
	
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
		
	}
	
	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다");
		
	}
	
	@Override
	public void setVolumn(int vol) {
		if(MAX_VOLUMN <= vol) {
			this.vol = MAX_VOLUMN;
		}
		else if (MIN_VOLUMN >= vol) {
			this.vol = MIN_VOLUMN;
		}
		else {
			this.vol = vol;
		}
		System.out.println("현재 Radio Volumn : " + this.vol );
		
	}
}

//다중상속 코드 추가
interface SearchURL {
	void Search(String url);
}

class C03SmartTV extends C03TV implements SearchURL {
	@Override
	public void Search(String url) {
		System.out.println(url + " 검색 시작합니다.");
		
	}
}


public class C03InterfaceMain {
	public static void TurnOn(C03Remocon controller) { // static : 객체 생성없이 메서드를 사용해야하니깐
		controller.turnOn();
	}
	public static void TurnOff(C03Remocon controller) {
		controller.turnOff();
	}
	public static void SetVol(C03Remocon controller, int num) {
		controller.setVolumn(num);
	}
	public static void Search(SearchURL product, String url) {
		product.Search(url);
	}
	
	public static void main(String[] args) {
		C03SmartTV tv = new C03SmartTV();
		TurnOn(tv);
		SetVol(tv, 5);
		Search(tv, "www.naver.com");
		TurnOff(tv);
		
		
		
		
	}

}
