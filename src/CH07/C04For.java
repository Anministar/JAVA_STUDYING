package CH07;

import java.util.Scanner;

class C04For {

	public static void main(String[] args) {
		
//		int i = 0;	//초기값
//		while ( i < 10 ) {	//조건식
//			System.out.println("HELLO WORLD");
//			i++;	//증감연산식
//		}
//		
//		System.out.println();
//
//		
//		for (int j = 0; j < 10; j++) {
//			System.out.println("HELLO WORLD");
//		}
		
		
		//1부터 10까지 합
		
//		int sum = 0;
//		for (int i = 0; i <= 10; i++) {
//			sum += i;
//		}
//		System.out.println("1부터 10까지의 합 : " + sum);
		
		
		//1부터 N까지 합
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("1부터 몇까지의 합이 궁금하신가요? >>> ");
//		int n = sc.nextInt();
//		int sum = 0;
//		
//		for (int i = 0; i <= n; i++) {
//			sum += i;
//		}
//		System.out.printf("1부터 %d까지의 합은 %d 입니다.", n, sum);
		
		
		
		//N부터 M까지 합
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("n부터 m까지의 합을 계산해드릴게요, 정수 두개를 입력하세요 >>> ");
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//		int sum = 0;
//		
//		if(n < m) {
//			for (int i = n; i <= m; i++) {
//				sum += i;
//			}
//			System.out.printf("%d부터 %d까지의 합은 %d입니다.", n, m, sum);
//		}
//		else {
//			for (int i = m; i <= n; i++) {
//				sum += i;
//			}
//			System.out.printf("%d부터 %d까지의 합은 %d입니다.", m, n, sum);
//		}
		
		
		//구구단 2단
		
//		System.out.println("구구단 2단을 출력할게요!");
//		
//		int n = 2;
//		for (int i = 1; i <= 9; i++) {
//			System.out.printf("%d x %d = %d\n", n, i, n*i);
//		}
		
		
		//구구단 N단
		
		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("구구단 몇 단을 출력할까요? >>> ");
//		int n = sc.nextInt();
//		
//		System.out.printf("구구단 %d단을 출력할게요!", n);
//		
//		for (int i = 1; i <= 9; i++) {
//			System.out.printf("%d x %d = %d\n", n, i, n*i);
//		}
		
		//구구단 전체
		
//		System.out.println("구구단 전체를 출력합니다.");
//		
//		
//		for (int i = 2; i <= 9 ; i++) {
//			System.out.printf("--- %d단 ---\n", i);
//			System.out.println();
//			for (int j = 1; j <= 9 ; j++) {
//				System.out.printf("%d x %d = %d\n", i, j, i*j);
//			}
//			System.out.println();
//		}
		
		
		
		
		//별찍기
		
		
		//1
		//*****
		//*****
		//*****
		//*****
		
//		for (int i = 1; i <= 4 ; i++) {
//			for (int j = 0; j < 5; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//			
//		}
		
		
		//2
		//*
		//**
		//***
		//****
		
		
//		for (int i = 0; i < 4; i++) {
//			for (int j = 0; j <= i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		
		//3
		//****
		//***
		//**
		//*
		
//		for (int i = 0; i < 4; i++) {
//			for (int j = 0; j < 4-i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		
		//4
		//   *
		//  ***
		// *****
		//*******
		
//		for (int i = 0; i < 4; i++) {
//			for (int j = 0; j < 3- i; j++) {
//				System.out.print(" ");
//			}
//			for (int j = 0; j < 2 * i + 1; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//			
//		}
		
		
		//5
		//*******
		// *****
		//  ***
		//   *
		
//		for (int i = 0; i < 4; i++) {
//			for (int j = 0; j < i; j++) {
//				System.out.print(" ");
//			}
//			for (int j = 0; j < 7 - 2 * i ; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		
		
		//6
		//   *
		//  ***
		// *****
		//*******
		// *****
		//  ***
		//   *
		
//		for (int i = 0; i < 4; i++) {
//			for (int j = 0; j < 3- i; j++) {
//				System.out.print(" ");
//			}
//			for (int j = 0; j < 2 * i + 1; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//	}
	
		
		//아직 덜 품 6번!
		
//		### 선생님 해답 ###
		
//		for (int i = 0; i < 7; i++) {
//			if (i < 4) {
//				//공백
//				for (int j = 0; j <= 2-i; j++) {
//					System.out.print(" ");
//				}
//				//별
//				for (int k = 0; k <= 2*i; k++) {
//					System.out.print("*");
//				}
//			}
//			
//			else {
//				//공백
//				for (int j = 0; j <= i-4; j++) {
//					System.out.print(" ");
//				}
//				//별
//				for (int k = 0; k <= 12-2*i; k++) {
//					System.out.print("*");
//				}
//			}
//			
//			System.out.println();
//		}
		
		
		
		
		
	}

}
