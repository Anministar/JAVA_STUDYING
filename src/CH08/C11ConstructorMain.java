package CH08;


//생성자 Method
//객체 생성시에 호출되는 특수한 메서드
//객체 생성시에 1회 호출
//객체 생성시 필요한 초기값을 부여
//클래스 내에 생성자 함수가 명시되지(코드삽입x) 않을 경우
//디폴트 생성자가 자동으로 주입되어서 사용


//생성자 함수 특징
//생성자 함수 는 클래스 이름과 동일해야 한다

class C11Simple {
	//속성
	int x;
	int y;
	//디폴트 생성자
	public C11Simple() {
		System.out.println("디폴트 생성자 호출!!");
		this.x=100;
		this.y=100;
	}
	
}


public class C11ConstructorMain {

	public static void main(String[] args) {
		
		C11Simple obj = new C11Simple(); //C11Simple() == 생성자 함수
		System.out.printf("x = %d y = %d\n", obj.x, obj.y); 
		
		

	}

}
