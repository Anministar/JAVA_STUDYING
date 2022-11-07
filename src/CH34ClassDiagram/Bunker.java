package CH34ClassDiagram;

public class Bunker extends Building {
	
	public Unit member[];
	int idx = 0;
	public Bunker() {
		member = new Unit[4];
	}
	
	public void InsertMember(Unit unit) {
		if( idx == 4 ) {
			System.out.println("더이상 들어올 수 없습니다.");
		}
		member[idx++] = unit;
	}
	
	@Override
	void Construct() {
		
		
	}
	@Override
	void UnderAttack(Unit unit) {
		// HP --
		// Ammor --
		// Ammor가 0이 되고 나서야 HP가 깎이는 형식으로 생각해봐야함.
		
		
	}
	
	

}
