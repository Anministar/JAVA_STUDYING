package CH19;


abstract class 재료 { // 재료로 객체를 만들면 안되고 참조변수로만 사용해야하기 때문에 abstract를 붙여줌
	//민트초코맛의 호빵은 만들면 안되기 때문임. == 맛없으니깐
	
}


class 팥 extends 재료 {
	String meterial;
	팥(String meterial) {
		this.meterial = meterial;
	}
	
	//toString 재정의
	@Override
	public String toString() {
		return "팥 [meterial=" + meterial + "]";
	}
}

class 야채 extends 재료 {
	String meterial;
	야채(String meterial) {
		this.meterial = meterial;
	}
	@Override
	public String toString() {
		return "야채 [meterial=" + meterial + "]";
	}
}

class 피자 extends 재료 {
	String meterial;
	피자(String meterial) {
		this.meterial = meterial;
	}
	@Override
	public String toString() {
		return "피자 [meterial=" + meterial + "]";
	}
	
	
}


class 민초 {
	String meterial;
	민초(String meterial) {
		this.meterial = meterial;
	}
	@Override
	public String toString() {
		return "민초 [meterial=" + meterial + "]";
	}
	
}


class 호빵<T extends 재료> {
	private T meterial;
	호빵(T meterial) {
		this.meterial = meterial;
	}
	void ShowInfo() {
		System.out.println(meterial.toString() + " 으로 만든 호빵!");
	}
}



public class C01Generic {

	public static void main(String[] args) {
		
		
		호빵<팥> ob1 = new 호빵<팥>(new 팥("단팥"));
		ob1.ShowInfo();
		
		호빵<야채> ob2 = new 호빵(new 야채("맛있는 야채")); //왼쪽과 오른쪽이 자료형이 같으면 오른쪽 제네릭 생략가능
		ob2.ShowInfo();
		
		호빵<피자> ob3 = new 호빵<피자>(new 피자("치즈피자"));
		ob3.ShowInfo();
		
//		호빵<민초> ob4 = new 호빵<민초>(new 민초("민트초코맛"));
//		ob3.ShowInfo();
		
		
		

	}

}
