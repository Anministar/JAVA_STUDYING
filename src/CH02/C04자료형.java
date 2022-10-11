package CH02;

public class C04자료형 {

	public static void main(String[] args) {
		//---------------------------
		//정수
		//---------------------------
		//int : 4byte 정수, 기본자료형
		
		int n1 = 0b10101101;	//2진수
		int n2 = 173;			//10진수
		int n3 = 0255;			//8진수
		int n4 = 0xad;			//16진수
		System.out.printf("%d %d %d %d", n1, n2, n3, n4);
		System.out.println();
		System.out.println();
		
		// 컴퓨터는 저 값들을 다 10진수로 저장하고 있음.(INT)
		
		//byte	: 1byte 정수, 부호 o
		
		byte m1 = -128;
		byte m2 = -30;
		byte m3 = 30;
		byte m4 = 127;
		byte m5 = (byte) 128;	//ERROR.. Why??? @ 강제 형변환, 하면 들어가긴 하는데 부호를 지원하기 때문에 -128이 됨.
		
		//short vs char 비교
		//char 	: 2byte 정수 부호 x, 단일문자 저장용으로 주로 사용
		//short : 2byte 정수 부호 o
		
		char o1 = 65535;	//0 - 2^16	/ 0 ~ 65535
//		short o2 = 60000;	//??
		short o2 = 32767;	//-2^15 ~ (2^15-1)	/ -32768 ~ 32767
		
		char o3 = 60000;
		short o4 = (short) o3;	//ERROR, 강제 형변환, n3은 이제 음수가 되어버림
		System.out.println(o4);
		System.out.println(o3);
		// 01111111 11111111
		// 10000000 00000000 음수로 넘어감
		
		
		//long : 8byte 정수
		
		long a1 = 10;			//리터럴 접미사 x -> 기본자료형(int) @ long, int 자료형을 일치시켜주는 작업이 함(자동 형 변환 작업)
		long a2 = 20L;			//리터럴 접미사 L,l : long 자료형	@ long, long 자료형이 같아서 작업이 필요없음
		
//		long a3 = 10000000000;	//ERROR..why? @ 4byte는 대약 -21억 - 21억까지 저장가능한데 long, int 이기 때문에 4byte안에 100억을 넣을 순없음.
		long a4 = 10000000000L;
		
		//-------------------------------------------
		//실수
		//-------------------------------------------
		//float : 4byte 실수(6 - 9자리)
		//double : 8byte 실수(기본값)(15 - 18자리)
		
		float b1 = 3.14f;	//리터럴접미사 F,f : float 자료형
		double b2 = 3.14;	//리터럴접미사x -> 기본자료형(double)
		
		//정밀도 확인
		float b3 = 0.123456789123456789F;
		double b4 = 0.1234556789123456789;
		System.out.println(b3);
		System.out.println(b4);
		System.out.println();
		
		//지수형으로 표현
		double b5 = 3e6; //3* 10^6
		double b6 = 3e-4; //3* 10-4
		System.out.println(b5);
		System.out.println(b6);
		System.out.println();
		
		//----------------------------
		//단일문자
		//----------------------------
		//char 2byte 문자 저장 자료형
		
		char ch1 = 'A';
		char ch2 = '가';
		short ch3 = 'A';	//약 -30000~+30000
		short ch4 = (short) '가';	//범위
		System.out.println(ch1);
		System.out.printf("%c\n", ch1);
		System.out.printf("%d\n", (int)ch1);
		System.out.println(ch4);
		System.out.println((int)ch2);			//문자는 숫자로도 확인 가능하다
		
		int c1 = 44032;
		System.out.printf("%d %c\n", c1, c1);	// 숫자, 문자로 각각 표현
		System.out.printf("%c\n", '\uACA2');	// \\u : 유니코드 적용 서식문자
		
		//----------------------------
		//문자열 : String
		//----------------------------
		//String : 클래스자료형..- 객체지향 파트에서 다시 설명
		
		String name = "홍길동";	//참조변수 name에는
								//문자열이 저장된 위치값(메모리주소)가 저장
		String job = "프로그래머";
		
		System.out.println(name);
		System.out.printf("%x\n", System.identityHashCode(name)); //자바가 이해하는 위치값
		System.out.println(job);
		System.out.println();
		
		
		//----------------------------
		//boolean : 논리형(true/false 저장)
		//----------------------------
		//true(참)		: 0이 아닌 모든 값
		//false(거짓)	: 0
		
		boolean flag = true;
		if(flag)
		{
			System.out.println("참인경우 실행~");
		}
		else
		{
			System.out.println("거짓인경우 실행~");
		}
		System.out.println(flag);
		
	}

}
