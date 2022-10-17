package CH10;

class Customer {
	//속성
	int myMoney;		//보유금액
	int colaCnt;		//콜라보유개수
	//기능
	//구매하기
	void pay(Store store, int money) {
		//1 내 보유금액에서 money 차감
		myMoney -= money;
		//2 지정된 store 에 money 를 전달
		int cnt = store.returnCola(money);
		//3 콜라개수를 누적
		colaCnt += cnt;
	}
	@Override
	public String toString() {
		return "Customer [myMoney=" + myMoney + ", colaCnt=" + colaCnt + "]";
	}
	
	public Customer(int myMoney, int colaCnt) {
		super();
		this.myMoney = myMoney;
		this.colaCnt = colaCnt;
	}
	
	
}

class Store {
	//속성
	int savedMoney;		//보유금액
	int colaCnt;		//콜라재고량
	int price;			//콜라가격
	//기능
	int returnCola(int money) {
		//1 보유금액에 받은 금액 추가
		savedMoney += money;
		//2 받은 금액만큼 콜라재고량 감소
		int cnt = money / price;
		colaCnt -= cnt;
		//3 콜라 개수 리턴
		return cnt;
	}
	@Override
	public String toString() {
		return "Store [savedMoney=" + savedMoney + ", colaCnt=" + colaCnt + ", price=" + price + "]";
	}
	
	public Store(int savedMoney, int colaCnt, int price) {
		super();
		this.savedMoney = savedMoney;
		this.colaCnt = colaCnt;
		this.price = price;
	}
	
	
	
}

public class C02StoreMain {

	public static void main(String[] args) {
		//고객 객체
		Customer hong = new Customer(10000, 0);
		Customer jung = new Customer(20000, 0);
		//편의점 객체
		Store GS감삼 = new Store(100000, 100, 1000); //보유금액, 콜라개수, 콜라가격
		Store GS반월 = new Store(100000, 100, 1000); //보유금액, 콜라개수, 콜라가격
		//구매하기
		hong.pay(GS감삼, 2000);
		jung.pay(GS반월, 3000);
		//확인
		System.out.println("------------------ 고객 정보 확인 -----------------");
		System.out.println(hong);
		System.out.println(jung + "\n");
		System.out.println("------------------ 편의점 정보 확인 -----------------");
		System.out.println(GS감삼);
		System.out.println(GS반월);
		
		
		
		
		
		
		
		
		
		

	}

}
