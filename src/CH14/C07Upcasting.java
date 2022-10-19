package CH14;

class C07Super {
	int num1;

	public void sound() {
		System.out.println("Sound()");
	}
}



class C07Sub extends C07Super {
	int num2; // 확장

	public void move() {
		System.out.println("Sub1 move()"); // 확장
	}
	
	public void sound() {
		System.out.println("Sub's Sound()"); // 재정의
	}

}


public class C07Upcasting {

	public static void main(String[] args) {
		
		C07Super ob = new C07Sub(); //확장된 num2에 접근가능?
									//확장된 move()를 사용할 수 있는지?
									//재정의된 sound()를 사용할 수 있는지?
		ob.num1 = 10; //Super's
//		ob.num2 = 20; //Sub's
//		ob.move();
		ob.sound(); //외우다시피해야함. 하위클래스에서 재정의된 메서드를 사용함. 재정의된 메서드에는 접근이 가능함. (정확하게 이해하려면 C++의 가산함수 공부해야함)
					//다운캐스팅이 필요없음. 이게 되게 편한 기능임.
		
		
		
		

	}

}
