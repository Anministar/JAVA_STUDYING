package CH08;

import java.util.Scanner;

class Sub {
	//속성
	
	Scanner sc = new Scanner(System.in);
	
	int sub1 (int x, int y)  {
		if(x>y) {
			return x-y;
		}
		else {
			return y-x;
		}
//		return x-y;
	}
	int sub2() {
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		return x-y;
		
	}
	void sub3() {
		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.printf("%d - %d = %d\n", x, y, (x-y));
		
	}
	void sub4(int x, int y) {
		System.out.printf("%d - %d = %d\n", x, y, (x-y));
	}
}


public class MethodTest {

	public static void main(String[] args) {
		//다음 코드를 실행할수 있는 Sub클래스를 만드세요
		
		Sub calc = new Sub();
		int r1 = calc.sub1(10,20);
		int r2 = calc.sub2();
		calc.sub3();
		calc.sub4(10,20);
		
	}

}
