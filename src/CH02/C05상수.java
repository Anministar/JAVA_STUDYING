package CH02;

public class C05상수 {

	public static void main(String[] args) {
		
		
		//상수
		//항 '상' 같은 '수'
		
		//리터럴 상수 : 이름부여 X, 상수Pool에 저장, 수치, 값
		//심볼릭 상수 : 이름부여 O, fianl 예약어 사용
		
		//리터럴 접미사 : 리터럴값의 자료형 지정
		//l,L : long 자료형
		//f,F : float 자료형
		
		//심볼링 상수 예제
		int n1 = 100;
		final int n2 = 200;
		
		n1 = 300; //가능
//		n2 = 400; //불가능
		final double PI = 3.14;
		double result = PI*4*4; //r * r * 3.14
		
		
		//문제
		
		
//		정수 타입 		: byte,short,int ,long
//		char 타입 	: ' ' 
//		String 타입 	: " "
//		실수 타입 		: double , float
//		논리 타입 		: boolean
	//
	//
//		확인 문제1
	//
//		정수타입 
//		1byte : byte
//		2byte : short
//		4byte : int
//		8byte : long
	//
//		실수타입
//		4byte : float
//		8byte : double
	//
//		논리타입
//		1byte : boolean
	//
	//
//		확인문제2
	//
//		맞는 코드인지 틀린 코드인지 확인 
//		byte var = 200;							(x	) //127까진가 저장가능함
//		char var='AB';							(x	) //단일문자만 가능
//		char var=65;							(o	)
//		long var=50000000000;					(x	) // -2^31 ~ 2^31 (21억 초과되는 값), 뒤에 L 붙이면 가능
//		float var = 3.14						(x	) // double이 기본, float, double
//		double var = 100.0						(o	)
//		String var = "나의직업은 "개발자" 입니다.";	(x	) // \를 붙여야함
//		boolean var = 0;						(x	) // true and false
//		int v2 = le2;							(x	)
//		float =1e2f;							(x	)
		
		
		
		
		
	}

}
