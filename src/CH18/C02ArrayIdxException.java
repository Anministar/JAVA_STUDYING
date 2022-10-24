package CH18;

public class C02ArrayIdxException {

	public static void main(String[] args) {
		
		try {
			int arr[] = {10, 20, 30};
			
			for (int i = 0; i < 5; i++) {
				System.out.println(arr[i]); // for는 5번 반복, 배열은 3개뿐. ==> 예외 발생
			}
		} catch (ArrayIndexOutOfBoundsException e) { // Exception으로 받아도 됨. 왜냐하면 Exception이 상위클래스이므로 업캐스팅됨.
			
			e.printStackTrace();							// 프로그램 종료전 예외발생정보 출력
		}
		
	
		System.out.println("실행코드 1");
		System.out.println("실행코드 2");
		
		
		
		
		
		
		
		
		

	}

}
