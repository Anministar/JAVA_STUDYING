package CH35ClassDiagram;

public class Manager extends Regular {
	
	double incentive;
	
	public Manager(String name, int age, int salary) {
		super(name, age, salary);
	}
	
	
	@Override
	double Pay() {
		if(salary >= 2500000) {
			incentive = 0.6;
			salary += salary * incentive;
		}
		else if (salary >= 2000000) {
			incentive = 0.5;
			salary += salary * incentive;
		}
		else {
			incentive = 0.4;
			salary += salary * incentive;
		}
		return salary;
	}
	@Override
	void ShowInfo() {
		System.out.printf("이름 : %s, 나이 : %d, 수령액 : %.1f\n", name, age, Pay());
		
		
	}
	
}
