package CH34ClassDiagram;

public class Medic extends Unit {
	
	
	private int RP;
	
	Medic() {
		RP = 5;
	}
	@Override
	void move() {
		System.out.println(name + " 이 이동합니다.");
	}
	
	void Healing(Unit unit) {
		if(isalive) {
			unit.HP += RP;
			System.out.println(unit.name + "체력이 증가합니다");
		}	
	}

	public static void main(String[] args) {
		

	}

}
