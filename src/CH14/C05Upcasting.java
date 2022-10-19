package CH14;

//--------------------------------
//멤버변수의 동작방식
//--------------------------------
//클래스 영역에서의 저장 : static변수, static메서드,
//static은 객체 생성 전에 클래스영역에 저장
//일반메서드는 객체 1회이상 생성 시 클래스영역에 저장(재사용성)



class C05Super {
	int num1;

}

class C05Sub extends C05Super {
	int num2; // 확장

}

public class C05Upcasting {

	public static void main(String[] args) {
		//Nocasting
		C05Super ob1 = new C05Super();
		C05Sub ob2 = new C05Sub();
		
		//Upcasting(상위클래스 참조변수 = 하위객체)
		C05Super ob3 = new C05Sub();
		ob3.num1 = 10; //가능
//		ob3.num2 = 20; //불가 (참조변수가 num2를 찾지못함)
		
		//Downcasting
//		C05Sub down = ob3; //컴파일 에러 발생... 왜?
		C05Sub down = (C05Sub) ob3;
		down.num2 = 10;
		
	}

}
