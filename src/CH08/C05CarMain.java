package CH08;

class C05Car {
	String owner;
	int speed;
	int fuel;
	String model;

	// 기능
	// 가속함수
	void Accel() {
		//1 fuel 확인
		//2 speed 10증가
		//3 200km/h 제한
		//4 fuel 5 감소
		if(fuel - 5 <= 0) {
			fuel = 0;
			System.out.println("[ERR]가속불가 - 연료가 부족합니다.");
		}
		else {
			fuel -= 5;
			if ( speed + 10 >= 200) {
				speed = 200;
				System.out.println("[WARN]최대속도입니다. 200km/h");
			}
			else {
				speed += 10;
				System.out.println("[INFO]가속합니다. 현재속도 : " + speed + "km/h");
			}
		}
	}
	// 감속함수
	void Break() {
		//1 속도체크
		//2 속도감속(-5)
		if (speed-5 <= 0) {
			speed = 0;
			System.out.println("[INFO]감속불가 합니다. 현재속도 : 0km/h");
		}
		else {
			speed -= 5;
			System.out.println("[INFO]감속합니다. 현재속도 : " + speed + "km/h");
		}
	}
	//정보확인
	void ShowInfo() {
		
	}
}

public class C05CarMain {

	public static void main(String[] args) throws InterruptedException  {
		C05Car hong = new C05Car();
		hong.owner = "홍길동";
		hong.speed = 200;
		hong.fuel = 100;
		hong.model = "아반떼xd";
//		System.out.printf("차주 : %s 현재속도 : %d 연료량 : %d 차종 : %s\n", hong.owner, hong.speed, hong.fuel, hong.model);

		
		
		while (true) {
//			hong.Accel();
			hong.Break();
			Thread.sleep(500); // 예외처리가 안돼서 오류.(밑줄 커서 대고 Add throws declaration)
			
		}
	}

}
