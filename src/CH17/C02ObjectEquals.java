package CH17;

class C02Simple {
	int n;
	C02Simple(int n) {
		this.n = n;
	}
	@Override
	public boolean equals(Object obj) { //Object obj = ob2; 업캐스팅
		if (obj instanceof C02Simple) {	//받은 객체가 C02Simple 클래스형이 맞는지 확인
			C02Simple down = (C02Simple) obj;		// 확장된 멤버변수 n 에 접근하기 위한 다운캐스팅
			return this.n == down.n; // this == ob1, down == ob2
		}
		return false; //Simple객체가 아니면 false를 출력해준다.
	}
	//Simple 객체 안에 멤버변수가 같은지 확인하는거임.
	
	
}



public class C02ObjectEquals {

	public static void main(String[] args) {
		C02Simple ob1 = new C02Simple(10);
		C02Simple ob2 = new C02Simple(10);
		C02Simple ob3 = new C02Simple(14);
		System.out.println(ob1);
		System.out.println(ob2); //hashcode 값이 ob1과 ob2가 다름
		System.out.println(ob1.equals(ob2)); 			//기준 : ob1 대상 : ob2
		System.out.println(ob1.equals(ob3));
		
		//String 클래스
		String str1 = new String("HELLO WORLD");
		String str2 = new String("HELLO WORLD");
		System.out.println(str1.toString());  			//String 클래스는 toString() 재정의됨
		System.out.printf("%x\n", System.identityHashCode(str1));
		System.out.println(str1.equals(str2)); 			//String 클래스는 equals() 재정의
		

	}

}
