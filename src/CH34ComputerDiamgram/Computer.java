package CH34ComputerDiamgram;

public class Computer {

	private Mainboard mainboard;
	private CPU cpu;
	
	public Computer() {
		mainboard = new Mainboard();
		cpu = new CPU();				//이때 Mainboard와 CPU는 속이 꽉 찬 다이아몬드 형태, 집합 관계
	}
	
	
	
	public Mainboard getMainboard() {
		return mainboard;
	}

	public void setMainboard(Mainboard mainboard) {
		this.mainboard = mainboard;
	}
	public CPU getCpu() {
		return cpu;
	}

	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}
	// 부분적인 부품들을 교체할 수 있도록 만든 상태가 속이 빈 다이아몬드 형태
	// 메인보드나 CPU를 바꾼다던지.
	



	public static void main(String[] args) {


	}

}
