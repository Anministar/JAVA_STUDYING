package CH14EXEC;

class Moonbanggu
{
	public static int SharpenCnt = 100;
	public static int PencilCnt = 100;
	 void write() {};
}
class Sharpen extends Moonbanggu
{
	//코드완성
	public Sharpen() {
		if(SharpenCnt>=1) {
			SharpenCnt--;
		}
		
	}
	
	@Override
	void write() {
		System.out.println("샤프로 씁니다");
	}
	
	
}
class Pencil extends Moonbanggu
{
	//코드 완성
	public Pencil() {
		if(PencilCnt>=1) {
			PencilCnt--;
		}
	}
	
	@Override
	void write() {
		System.out.println("연필로 씁니다");
	}
	
	
}
public class C04Prac {
	public static void Writing(Moonbanggu item) {
		item.write();
	}
	public static void ShowInfo() {
		System.out.printf("샤프재고량 : %d 연필 재고량 : %d\n", Moonbanggu.SharpenCnt, Moonbanggu.PencilCnt);
	}
	public static void main(String[] args) {
		Sharpen item1 = new Sharpen();
		Pencil item2 = new Pencil();
		Writing(item1);	//"샤프로 씁니다" 가 출력
		Writing(item2); //"연필로 씁니다" 가 출력 
		ShowInfo();
	}
}
