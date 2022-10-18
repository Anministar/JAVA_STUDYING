package CH13;

class C02Simple {
	int n1;
	static int n2;
	
	void Func1 () {
		n1 = 10;
		n2 = 20;
	}
	static void Func2() {
//		n1 = 10; // 문제발생.. 왜?? ==> 객체를 만들고 접근 가능한게 n1인데 static은 객체가 없어도 부를수 있어야함.
		n2 = 20;
		int num = 10; // 지역변수 num은 당연히 사용가능함.
	}
}


public class C02Static {

	public static void main(String[] args) {
		
		
		
		
	}

}