package CH08;


//생성자 Method
//객체 생성시에 호출되는 특수한 메서드
//객체 생성시에 1회 호출
//객체 생성시 필요한 초기값을 부여
//클래스 내에 생성자 함수가 명시되지(코드삽입x) 않을 경우
//디폴트 생성자가 자동으로 주입되어서 사용


//생성자 함수 특징
//생성자 함수 는 클래스 이름과 동일해야 한다

class C12Simple {
	//속성
	int x;		// 0
	double y;	// 0.0
	char z;		// ' '
	boolean b;  // false
	String str;	// null
	
	//디폴트 생성자
	public C12Simple() {
		System.out.println("디폴트 생성자 호출!!");
	}

	@Override
	public String toString() {
		return "C12Simple [x=" + x + ", y=" + y + ", z=" + z + ", b=" + b + ", str=" + str + "]";
	}
	
}


public class C12ConstructorMain {

	public static void main(String[] args) {
		
		C12Simple obj = new C12Simple(); //C11Simple() == 생성자 함수
		System.out.println(obj.toString());
		
		

	}

}
