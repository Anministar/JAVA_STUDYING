package CH35ClassDiagram;

public class Regular extends Employees {

	int salary;
	public Regular(String name, int age, int salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	@Override
	double Pay() {
		return salary;
	}

	@Override
	void ShowInfo() {
		System.out.printf("이름 : %s, 나이 : %d, 고정급 : %.1f\n", name, age, Pay());
		
	}

}
