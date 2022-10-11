package CH05;

public class C01basic {
	public static void main(String[] args) {
////	기본 산술 연산자
//		int a = 10, b = 20, c;
//		System.out.println("a+b="+ (a + b));
//		System.out.println("a-b="+ (a - b));
//		System.out.println("a*b="+ (a * b));
//		System.out.println("b/a="+ (b / a));	//나누기 - 몫
//		System.out.println("a%b="+ (a % b));	//나누기 - 나머지(1.짝홀수 구분 2.배수구분 3.자리수제한 4.끝자리구하기)
//		System.out.println("-a="+ -a); // 앞에 - 를 붙인다고 해서 음수가 되는게 X 

		//문제	
//		두수를 입력 받아 두수의 합/차/곱을 출력하는 프로그램을 만들어보세요
//		Scanner 를 사용합니다
		
		//대입연산자
		//LV = RV;
		//공간 = 값(우선 처리);
	
		////복합대입 연산자(산술+대입)
//		int a = 10;
//		a += 10;	//a = a + 10;
//		a -= 5;		//a = a-5;
//		a *= 3;		//a = a*3;
//		System.out.println("a="+a);

		
		
		
		////비교연산자
//		int a =10;
//		int b=20;
//		System.out.println("A == B : "+ (a == b));
//		System.out.println("A  > B : "+ (a > b));
//		System.out.println("A  < B : "+ (a < b));
//		System.out.println("A >= B : "+ (a >= b));
//		System.out.println("A <= B : "+ (a <= b));
//		System.out.println("A != B : "+ (a != b));
		
		
		//한개만 물어보는거, 빨래 했어? 했어 or 안했어
		
		
		////논리연산자 
		//AND 연산자 &&	: (조건식) && (조건식), (true)&&(true) = true , 그외는 거짓
		//- &&기호를 기준으로 왼/오른쪽 둘다 true 이면 true
		//OR 연산자 ||	: (조건식) || (조건식), t||t = t, t||f = t, f||t = t, f||f = f
		//- ||기호를 기준으로 왼/오른쪽 중 하나만 true 이면 true
		//! 연산자
		//- true이면 false, false 이면 true
		
		//여러개 조건식 비교, 빨래랑 방청소 했어? 
		
		int a = 10; int b = 20;
		
		//왼쪽이 false라면 오른쪽 연산은 하지도 않음.
		
		System.out.println((a>=b)&&(a>5));
		System.out.println((a!=b)&&(b>15));
		
		//왼쪽이 true라면 오른쪽으로 넘어가서 연산처리를 할 수밖에 없음.
		
		
		System.out.println((a>=b)||(a>5));
		System.out.println((a!=b)||(b>15));
		System.out.println((a==b)||(a<=5));
		
		//똑같이 왼쪽이 먼저 true라면 오른쪽은 연산하지도 않음.
		
		
//		System.out.println("false AND false = " + (true && true));
//		System.out.println("false AND true = " + (false && true));
//		System.out.println("true AND false = " + (true && false));
//		System.out.println("true AND true =  " + (false && false));

		
		
		////논리부정연산자
//		boolean play = true;
//		System.out.println(play);
//
//		play = !play;			//false
//		System.out.println(play);
//
//		play = !play;			//true
//		System.out.println(play);
		
		//코드의 가독성을 위해서 종종 쓺. 로그인 창 아이디에 아무것도 안적거나 하면 false값을 주기위해?
		



	
		////증감연산자
		//++a(--a) : 전치 연산자 : 먼저 값 1증가(1감소) 이후 다른 연산자 처리
		//a++(a--) : 후치 연산자 : 다른 연산자 처리 먼저 한 수 1증가(1감소)
		
//		int a = 10, b = 10, c, d;
//		c = --a;
//		d = a--;
//		System.out.printf("a=%d , b=%d , c=%d, d=%d", a, b, c, d);
		
	
				
		////삼항연산자
		// (조건식)? 참인경우 실행코드 : 거짓인경우 실행코드;
		
//		int score = 85;
//		char grade = (score > 90) ? 'A' : ((score > 80) ? 'B' : 'C');
//		System.out.println(score + "점은 " + grade + "등급입니다.");
	}
}





