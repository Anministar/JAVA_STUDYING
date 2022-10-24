package Ch99;

import java.util.Scanner;

class C01Buyer {
	// 클래스 속성
	private int MyMoney;
	private int AppleCnt;
	
	// 생성자
	public C01Buyer(int myMoney, int appleCnt) {
		super();
		MyMoney = myMoney;
		AppleCnt = appleCnt;
	}
	
	// 기능
	void Payment(C01Seller seller01, int money) {
		//MyMoney 의 금액 차감
		MyMoney -= money;
		
		//Seller01의 Receive(money) 전달
		int cnt = seller01.Receive(money);
		
		//리턴되는 사과개수를 appleCnt에 누적
		AppleCnt += cnt;
		
	}
	
	
	// getter 메서드들
	int getMoney() {
		return MyMoney;
	}
	int getAppleCnt() {
		return AppleCnt;
	}
	
	// 기능
	void ShowInfo() {
		System.out.println("보유금액 : " + getMoney());
		System.out.println("사과개수 : " + getAppleCnt());
		
	}
	
}

class C01Seller {
	// 클래스 속성
	private int MyMoney;
	private int AppleCnt;
	private int Price;
	
	// 생성자
	public C01Seller(int myMoney, int appleCnt, int price) {
		super();
		MyMoney = myMoney;
		AppleCnt = appleCnt;
		Price = price;
	}
	
	// 기능
	int Receive(int money) {
		//MyMoney 의 금액 누적증가
		MyMoney += money;
		//AppleCnt에 받은 금액만큼의 사과개수 차감
		int cnt = money / Price;
		AppleCnt -= cnt;
		
		//사과개수 리턴
		return cnt;
		
	}
	// getter 메서드들
	int getMoney() {
		return MyMoney;
	}
	
	int getAppleCnt() {
		return AppleCnt;
	}
	int getPrice() {
		return Price;
	}
	
	// 기능
	void ShowInfo() {
		System.out.println("보유금액 : " + getMoney());
		System.out.println("사과개수 : " + getAppleCnt());
		System.out.println("개당가격 : " + getPrice());
	}
	
}

public class test {

	public static void main(String[] args) {
		
		C01Seller seller = new C01Seller(100000, 100, 1000);
		C01Buyer buyer01 = new C01Buyer(10000,0);
		C01Buyer buyer02 = new C01Buyer(20000,0);
		C01Buyer buyer03 = new C01Buyer(30000,0);
		buyer01.Payment(seller, 2000);
		buyer02.Payment(seller, 5000);
		buyer03.Payment(seller, 3000);
		System.out.println("---판매자 정보---");
		seller.ShowInfo();
		System.out.println("---구매자 정보---");
		System.out.println("-buyer01-");
		buyer01.ShowInfo();
		System.out.println("-buyer02-");
		buyer02.ShowInfo();
		System.out.println("-buyer03-");
		buyer03.ShowInfo();
		
		
		
		
		
		
			
	}

}
