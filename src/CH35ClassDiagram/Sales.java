package CH35ClassDiagram;

public class Sales extends Regular {
	
	int acc;
	double percent;
	
	public Sales(String name, int age, int salary, int acc, double percent) {
		super(name, age, salary);
		this.acc = acc;
		this.percent = percent;
	}
	@Override
	double Pay() {
		salary += (acc * percent);
		return salary;
	}
	@Override
	void ShowInfo() {
		System.out.printf("이름 : %s, 나이 : %d, 수령액 : %.1f\n", name, age, Pay());
	}
}
