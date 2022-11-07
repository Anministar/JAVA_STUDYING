package CH35ClassDiagram;

public class Temporary extends Employees {

	int ilsu;
	int ildang;
	
	public Temporary(String name, int age, int ilsu, int ildang) {
		this.name = name;
		this.age = age;
		this.ilsu = ilsu;
		this.ildang = ildang;
	}
	
	
	@Override
	double Pay() {
		int res = ilsu * ildang;
		return res;
	}

	@Override
	void ShowInfo() {
		System.out.printf("이름 : %s, 나이 : %d, 월 급 : %.1f\n", name, age, Pay());
		
	}
	

}
