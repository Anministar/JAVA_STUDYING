package CH34ClassDiagram;

public class Factory extends Building implements ICanFly {
	
	private FactoryAddOn extendOn;
	 
	void ExtendFactory() {
		extendOn = new FactoryAddOn();
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
