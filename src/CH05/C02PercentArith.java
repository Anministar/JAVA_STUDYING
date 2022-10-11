package CH05;

import java.util.Random;
import java.util.Scanner;

public class C02PercentArith {

	public static void main(String[] args) throws InterruptedException {
		
		// %연산자
		
		// 01 홀수/짝수
		
		//Scanner 객체 생성 후
		//정수를 num1 에 저장 다음
		//짝홀수 확인하세요
		
		Scanner de = new Scanner(System.in);
		
//		System.out.println("정수를 입력하세요 : ");
//		int num1 = de.nextInt();
//		
//		String result = (num1%2 == 0)?"짝수입니다":"홀수입니다";
//		System.out.println("결과 : " + result);
		
		
		
		
//		if(num1%2==0)
//			System.out.println("짝수입니다");
//		else
//			System.out.println("홀수입니다");
		
		
		// 02 배수 구하기
		
		// 세 정수를 받아서 세 수의 합이 5의 배수인 경우
		// 5의 배수입니다 를 출력
		// 아닌 경우 5의 배수가 아닙니다 를 출력
		
//		System.out.println("정수를 입력하세요 >>> ");
//		int num10 = de.nextInt();
//		System.out.println("정수를 입력하세요 >>> ");
//		int num11 = de.nextInt();
//		System.out.println("정수를 입력하세요 >>> ");
//		int num12 = de.nextInt();
//		
//		String result1 = ((num10+num11+num12) % 5 == 0)?"5의 배수입니다":"5의 배수가 아닙니다";
//		System.out.println("RESULT : " + result1);
		
		
//		int num1 = 12;
//		
//		String result = (num1%3 == 0)?"3의 배수입니다":"3의 배수가 아닙니다";
//		System.out.println("RESULT : " + result);
		
		
		
//		int num1=12;
//		
//		if(num1%3==0)
//			System.out.println("3의배수입니다");
//		else
//			System.out.println("3의배수가 아닙니니다");
		
		
		
		// 03 수의범위
		/*
			수%3 = 0 ~ 2
			수%4 = 0 ~ 3
			수%100 = 0 ~99
		*/
		
		//난수생성
		//01 Random rnd = new Random();
		
//		Random rnd = new Random();
//		while(true) {
//			System.out.println(rnd.nextInt(5)); //N%5과 동일
//			Thread.sleep(500);
//		}
		
		
		
		
		//02 Math.random();
//		while (true) {
//			System.out.println( ((int)(Math.random()*100)) %16 ); // * 100 : 두자리가 나옴, %16 : 0-15까지 숫자가 나옴.
//			Thread.sleep(500);
//		}
		
		
	
		// 04 끝자리수
		
		
		int num = 56789;
		
		System.out.println("오른쪽 끝 1자리 : "+(num % 10));
		System.out.println("오른쪽 끝 2자리 : "+(num % 100));
		System.out.println("오른쪽 끝 3자리 : "+(num % 1000));
		System.out.println("오른쪽 끝 4자리 : "+(num % 10000));
		System.out.println();
		System.out.println("왼쪽 끝 1자리 : "+(num / 10000));
		System.out.println("왼쪽 끝 2자리 : "+(num / 1000));
		System.out.println("왼쪽 끝 3자리 : "+(num / 100));
		System.out.println("왼쪽 끝 4자리 : "+(num / 10));
		
		//정수 하나를 입력받아 거꾸로 저장해보세요(반복문법 이후 풀어보기) % , /연산 동시 이용할것
		//예
//		입력: 1234
//		저장
//		int reverse = 4321;
//		출력 : 4321
		

	}

}
