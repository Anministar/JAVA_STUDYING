package CH34ClassDiagram;

public class Barrack extends Building implements ICanFly {
	Marine MakeMaring(String name) {
		return new Marine(new Rifle(), name);
		
	}
	Medic MakeMedic() {
		return new Medic();
		
	}
	
	
	@Override
	void Construct() {
		
		
	}
	@Override
	void UnderAttack(Unit unit) {
		
		
	}
	@Override
	public void Move() {
		
		
	}
	@Override
	public void Land() {
		
		
	}
	@Override
	public void Fly() {
		
		
	}
	
}
