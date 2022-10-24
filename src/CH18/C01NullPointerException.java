package CH18;




public class C01NullPointerException {

	public static void main(String[] args) {
		
		try {
			String str = null;
			System.out.println(str.toString()); // 없는 문자열을 보겠다니깐 예외 발생.
		} catch (NullPointerException e) { // e는 참조변수, 예외객체가 생성되고 주소번지가 100이라면 try에서 예외가 발생한 후 catch의 참조변수 e가 그 주소번지를 받아냄.
			
//			System.out.println("예외발생함!!!");
			System.out.println("-------e.getCause()---------");
			System.out.println(e.getCause()); 				// 원인 가져오기
			System.out.println("-------e.toString()---------");
			System.out.println(e.toString()); 				// 예외객체 정보
			System.out.println("-------e.getStackTrace()---------");
			System.out.println(e.getStackTrace()); 			// 예외객체 식별주소
			System.out.println("-------e.printStackTrace()---------");
			e.printStackTrace();							// 프로그램 종료전 예외발생정보 출력
			
			
		}
		
		
		System.out.println("실행코드1");
		System.out.println("실행코드2");
		
		
		
		
		

	}

}
