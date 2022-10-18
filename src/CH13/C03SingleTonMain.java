package CH13;

//디자인 패턴

//상품 제작시 사전에 발견되었던 문제들을 해결하고 정형화 시켜놓은 작업패턴
//디자인 패턴은 제작자들간의 의사소통 수단의 일종이다
//ex) 의류를 디자인을 할때 일반적으로 알려진 패턴대로 재단을 한다(~소재는 미싱은 어떻게어떻게해야~잘뜯어지지않는다)
//ex) 그렇게 하지 않을때 품질에 이상발생 가능성 높다 

//프로그래밍언어의 디자인 패턴
//프로그램 제작시 사전에 발견되었던 문제들을 해결하고 정형화 시켜놓은 작업패턴 


//싱글톤 패턴
//하나의 객체를 생성하여 다수의 클라이언트가 접속하여 사용하는 형태
//ex) DB Connection Pool 생성시 사용


class C03Company {
	
	//멤버변수
	int x;
	int y;
	private static C03Company instance = null; // 객체 생성을 하지 않아도 사용할 수 있음. 
											   //아니면 C03Company instance; 이렇게 만들어둬도 됨.
	
	//생성자
	private C03Company() {
		x = 10;
		y = 20;
		
	} // 다른 위치에서 이 생성자를 쓸 수 없다. == 이 클래스 안에서만 만들 수 있음.
	
	//멤버함수
	public static C03Company getInstance() {
		if (instance == null) {
			instance = new C03Company();
		}
		return instance;
	}
}



public class C03SingleTonMain {

	public static void main(String[] args) {
		C03Company myCompany1 = C03Company.getInstance(); //스택에 있는 myCompany1에 100번지가 return - 공책참조
		C03Company myCompany2 = C03Company.getInstance();
		System.out.println(myCompany1 == myCompany2);
		System.out.println("myCompany1 : " + myCompany1.x);
		System.out.println("myCompany1 : " + myCompany2.x);
	
		
		
	}

}
