package CH16;


// 일반 클래스간의 다중상속 X

//class A {}
//class B {}
//class C extends A, B {} //extends는 다중상속이 불가능


// 일반 클래스가 인터페이스 다중상속 O

//interface A {}
//interface B {}
//class C implements A, B {}	// 가능


// 인터페이스간 다중상속 O

//interface A {}
//interface B {}
//interface C extends A, B {}	// 가능


public class C02다중상속 {

	public static void main(String[] args) {
		//인터페이스는 다중 상속이 가능하다, 다중 상속을 하면 안좋긴 함 (가독성이 떨어지기 때문에)

	}

}
