package CH08;

class LocalVar {
	//속성(멤버변수)
	int num = 10;
	void Func1() {
		System.out.println("멤버변수 num = " + num);
		if(true) {
			int num = 100;		// if문 안에서만 사용되는 지역변수 num, if 벗어나면 소멸 @ 소멸되면 공간이 회수됨.
			System.out.println("if문 안의 지역변수 num = " + num);
		}
		System.out.println("멤버변수 num  = " + num);
		
	}
	void Func2() {
		int i = 1;
		int num = 6; //이건 Fun2가 끝날때까지 num = 5
		while (i <= 5) {
//			num = 5; //이거 생성하고 while문 한번 반복이 끝나면 소멸됨. 다시 올라와서 생성, 즉 생성소멸을 5번 반복
			System.out.println("num = " + (num++));
			i++;
		}
		System.out.println("While 벗어남 num = " + (num));
		System.out.println("멤버 변수 num = " + (this.num)); // 멤버 변수 num에 접근하고 싶으면 this.라는걸 붙여줌.
	}
	void Func3() {
		
	}
	
}

public class C08LocalVarTest {

	public static void main(String[] args) {
		LocalVar obj = new LocalVar();
//		obj.Func1();
		obj.Func2();
		

	}

}
