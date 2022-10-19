package CH16;

interface C01Remocon {
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



class  TV implements C01Remocon{
	
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
class Radio implements C01Remocon{
	
	int vol;
	
	@Override
	public void turnOn() {
		System.out.println("라디오를 켭니다.");
		
	}
	
	@Override
	public void turnOff() {
		System.out.println("라디오를 끕니다");
		
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
		System.out.println("현재 TV Volumn : " + this.vol );
		
	}
	
	
	
	
}


public class C01InterfaceMain {
	public static void TurnOn(C01Remocon controller) { // static : 객체 생성없이 메서드를 사용해야하니깐
		controller.turnOn();
	}
	public static void TurnOff(C01Remocon controller) {
		controller.turnOff();
	}
	public static void SetVol(C01Remocon controller, int num) {
		controller.setVolumn(num);
	}
	
	public static void main(String[] args) {
		TV tv = new TV();
		Radio radio = new Radio();
		TurnOn(tv);
		TurnOn(radio);
		TurnOff(tv);
		TurnOff(radio);
		SetVol(tv, 7);
		SetVol(radio, 11);
		
		
		
	}

}
