package CH34ClassDiagram;

public class Rifle extends Gun{
	
	
	public Rifle() {
		//저장된 총의 개수
		//파워기본값
		bulletCnt = 20;
		power = 100;
	}
	
	
	@Override
	void fire(Unit unit) {
		if(bulletCnt - 1 < 0) {
			System.out.println("탄환 부족..");
			return ;
		}
		
		
		System.out.println("발사!");
//		unit.HP -= power;
		unit.UnderAttack(power);
		bulletCnt--;
	}
	
	@Override
	void reload() {
		System.out.println("재장전!");
	}
	
	
	
	
	
	
	

	public static void main(String[] args) {
		

	}

}
