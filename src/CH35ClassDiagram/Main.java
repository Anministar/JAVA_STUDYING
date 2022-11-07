package CH35ClassDiagram;

public class Main {

	public static void main(String[] args) {
		Temporary a = new Temporary("박치기", 21, 20, 90000);
		Regular b = new Regular("홍길동", 23, 1234000);
		Sales c = new Sales("한송이", 25, 2345000, 3000, 0.25);
		Manager d = new Manager("한국인", 27, 2555000);
		
		a.ShowInfo();
		b.ShowInfo();
		c.ShowInfo();
		d.ShowInfo();
		

	}

}
