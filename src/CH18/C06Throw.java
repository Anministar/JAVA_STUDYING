package CH18;

public class C06Throw {

	public static void Ex1() {
		
		try {
			throw new ArithmeticException();
		} catch (Exception e) {
			System.out.println("Ex1의 예외처리");
		}
		System.out.println("Ex1에서의 코드");
		
	}

	public static void Ex2() throws ArithmeticException { //main에서 실행했으니깐 main에서 예외처리를 해줘야함.
		throw new ArithmeticException();
	}

	public static void Ex3() {

	}

	
	public static void main(String[] args) {
		Ex1();
		
		try {
			Ex2();
		} catch (Exception e) {
			System.out.println("MAIN에서 예외처리");
		}

	}

}
