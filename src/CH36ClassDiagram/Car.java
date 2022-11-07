package CH36ClassDiagram;

public class Car {
	
	private String carNumber;
	private String model;
	private Engine engine;	//포함관계, 속이 꽉 찬 다이아몬드
	private Radio radio;	//포함관계, 속이 꽉 찬 다이아몬드
	
	//속이 꽉 찬 다이아몬드는 외부에서 받는게 아니라, 안에서 만듦
	//private이라서 접근이 힘듦.
	public Car(String carNumber, String model) {
		super();
		this.carNumber = carNumber;
		this.model = model;
		this.engine = new Engine();
		this.radio = new Radio();
	}


	void move() {
		System.out.println("자동차가 움직입니다.");
	}
	
	
	
	
}
