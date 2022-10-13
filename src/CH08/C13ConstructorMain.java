package CH08;


//생성자 Method
//객체 생성시에 호출되는 특수한 메서드
//객체 생성시에 1회 호출
//객체 생성시 필요한 초기값을 부여
//클래스 내에 생성자 함수가 명시되지(코드삽입x) 않을 경우
//디폴트 생성자가 자동으로 주입되어서 사용


//생성자 함수 특징
//생성자 함수 는 클래스 이름과 동일해야 한다

class C13Simple {
	//속성
	int x;		// 0
	double y;	// 0.0
	char z;		// ' '
	boolean b;  // false
	String str;	// null
	
	//디폴트 생성자
	public C13Simple() {
		System.out.println("디폴트 생성자 호출!!");
	}
	//생성자 함수 오버로딩
	C13Simple(int x) {
		this.x=x;
		System.out.println("C13Simple(int) 생성자 호출!");
	}

	C13Simple(int x, double y) {
		this.x=x;
		this.y=y;
		System.out.println("C13Simple(int, double) 생성자 호출!");
	}
	
	
	@Override
	public String toString() {
		return "C13Simple [x=" + x + ", y=" + y + ", z=" + z + ", b=" + b + ", str=" + str + "]";
	}
	
}


public class C13ConstructorMain {

	public static void main(String[] args) {
		
		C13Simple obj = new C13Simple(); 		// 디폴트생성자	@ C11Simple() == 생성자 함수
		System.out.println(obj.toString());
		C13Simple obj2 = new C13Simple(10);		// int받는 생성자
		System.out.println(obj2.toString());
		C13Simple obj3 = new C13Simple(10, 10.2);
		System.out.println(obj3.toString());	// int, double 받는 생성자
		
		

	}

}
