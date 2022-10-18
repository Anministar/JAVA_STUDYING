package CH13;

class C01Simple {
	
	
	//-----------------
	//1 자바의 메모리 구조
	//-----------------
	//1) 스택영역 : {}내의 지역변수
	//{} 내에서 생성, 벗어나면 소멸
	
	//2) 클래스영역 : 공유메모리, static변수, 일반메서드, 생성자 메서드
	//프로그램 시작과 동시에 생성, 프로그램 종료시 소멸
	
	//3) 힙영역 : 객체 저장 공간,
	//new 예약어 사용시 생성, 소멸은 JVM의 가비지 컬렉터에 의해서 소멸
	
	//멤버 변수
	static int Num1 = 0; 	//공유변수
	int Num2;
	
	//멤버 함수
	void ShowNum() {
		System.out.printf("NUM1 : %d NUM2 : %d\n", Num1, Num2);
	}
}

public class C01Static {

	public static void main(String[] args) {
//		C01Simple obj1 = new C01Simple();
//		C01Simple obj2 = new C01Simple();
//		obj1.Num1 = 10;
//		obj1.Num2 = 20;
//		obj1.ShowNum();
//		obj2.ShowNum();
//		System.out.println();

		C01Simple.Num1 = 123;
		System.out.println(C01Simple.Num1);
		
		
		
		
		
		
	}

}
