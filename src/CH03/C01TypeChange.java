package CH03;

public class C01TypeChange {
	public static void main(String[] args) {
		// (자료)형변환
		// 특정 자료형이 다른 자료형으로 변환되어지거나 강제로 변환시키는 작업
		// 데이터 손실의 최소화가 목적
		
		// 형변환 종류
		// 자동형변환(암시적) : 컴파일러에 의해 자동 형변환
		// 강제형변환(명시적) : 프로그래머에 의해 강제 형변환
		
		//자 동 형 변 환
		//범위가 넓은 공간에 작은값이 대입되는경우
		//컴파일러에 의한 자동형변환
		//byte < short < int< long < float < double  - 데이터 손실을 최소화
		
		byte byteValue = 10;
		int intValue = byteValue;
		System.out.println("intValue: " + intValue);

		char charValue = '가';
		intValue = charValue;
		System.out.println("가 의 유니코드: " + intValue);
		
		intValue = 50;
		long longValue = intValue;;
		System.out.println("longValue: " + longValue);	
		
		longValue = 100;
		float floatValue = longValue; 
		System.out.println("floatValue: " + floatValue);
		
		floatValue = 100.5F;
		double doubleValue = floatValue;
		System.out.println("doubleValue: " + doubleValue);
		
		
	} 
}

