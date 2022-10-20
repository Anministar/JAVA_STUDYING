package CH17;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

class C04Simple {
	int x;
	int y;
	C04Simple(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public int hashCode() {
		
		//JAVA 6버전 이하
//		int result = 17;
//		// 31은 소수로 사용되며 다음과 같이 더 나은 성능을 제공합니다.
//		// 31 * result == (result << 5) - result
//		result += 31 * result + x;
//		result += 31 * result + y;
//		return result;
		
		// JAVA 6버전 이상
		return Objects.hash(this.x, this.y); // Objects 클래스에서 hash라는 함수로 특정한 계산법을 통해서 출력 결과와 같은 값이 나옴.
		
//		return x + y;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof C04Simple) {
			C04Simple down = (C04Simple) obj;
			return this.x == down.x && this.y == down.y;
		}
		return false;
		
	}
	@Override
	public String toString() {
		
		return "[x = " + x + " y =  " + y + "]";
	}
}


public class C04ObjectHashCode {

	public static void main(String[] args) {
		C04Simple obj1 = new C04Simple(10, 20);
		C04Simple obj2 = new C04Simple(10, 20);
		
		System.out.println(obj1);
		System.out.println(obj2);
		
		System.out.println("----------------------------");
		System.out.printf("%x\n", obj1.hashCode());
		System.out.printf("%x\n", obj2.hashCode());
		System.out.println("----------------------------");
		System.out.printf("%x\n", System.identityHashCode(obj1));
		System.out.printf("%x\n", System.identityHashCode(obj2));
		
		
	}

}
