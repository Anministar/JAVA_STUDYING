package CH08;

import java.util.Scanner;

class Sum {
	//속성
	Scanner sc = new Scanner(System.in);
	//기능
	//반환 o 매개변수 o
	int sum1(int x, int y) {
		return x+y;
	}
	//반환 o 매개변수 x
	int sum2() {
		int x = sc.nextInt();
		int y = sc.nextInt();
		return x+y;
	}
	//반환 x 매개변수 o
	void sum3(int x, int y) {
		System.out.println("sum3(x, y) = " + (x+y));
	}
	//반환 x 매개변수 x
	void sum4() {
		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.println("sum4() = " + (x+y));
	}
}


public class C07SimpleMethodTest {

	public static void main(String[] args) {
		
		Sum calc = new Sum(); //Sum객체 생성 이후 calc 참조변수에 연결
		
		int r1 = calc.sum1(10, 20); //calc객체의 sum1함수를 실행
		System.out.println("sum1(x, y) = " + r1);
		
		int r2 = calc.sum2();
		System.out.println("sum2() = " + r2);
		
		
		calc.sum3(12, 34);
		calc.sum4();
		System.out.println("프로그램을 종료합니다");
		
		
		
		

	}

}
