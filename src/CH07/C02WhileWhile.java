package CH07;

import java.util.Scanner;

public class C02WhileWhile {

	public static void main(String[] args) {
		
		//전체 구구단(2단-9단) 출력하기
		
//		dan = 2		i = 1
//		dan++		i++
//		dan <= 9	i <= 9
		
		
		
//		int dan = 2;
//		int i;
//		
//		while(dan <= 9) {
//			i = 1;
//			while(i <= 9) {
//				 System.out.printf("%d x %d = %d\n", dan, i, dan*i);
//				i++;
//			}
//			System.out.println();
//			dan++;
//		}
		
		//N부터 9단까지 전체 출력
//		Scanner sc = new Scanner(System.in);
//		System.out.println("단을 입력하세요 >>> ");
//		int dan = sc.nextInt();
//		
//		
//		int num;
//		
//		while (dan <= 9) {
//			num = 1;
//			while(num <= 9) {
//				System.out.printf("%d x %d = %d\n", dan, num, dan * num);
//				num++;
//			}
//			System.out.println();
//			dan++;
//		}
		
		
		
		
		
		//전체 구구단(2단-9단) 출력하기 (단만 역순출력)
		
//		dan = 2		i = 9
//		dan++		i--
//		dan <= 9	i >= 1
		
		
//		int dan = 2;
//		int i;
//		
//		while(dan <= 9) {
//			i = 9;
//			while(i >= 1) {
//				 System.out.printf("%d x %d = %d\n", dan, i, dan*i);
//				i--;
//			}
//			System.out.println();
//			dan++;
//		}
		
		
		
		//전체 구구단(2단-9단) 출력하기 (전체 역순출력)
		
		
//		int dan = 9;
//		int i;
//		
//		while(dan >= 2) {
//			i = 9;
//			while(i >= 1) {
//				 System.out.printf("%d x %d = %d\n", dan, i, dan*i);
//				i--;
//			}
//			System.out.println();
//			dan--;
//		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//1
		//*****
		//*****
		//*****
		//*****
		
//		### 선생님 해답 ####
		
//		int i = 0;
//		int j = 0;
//		while(i < 4) {
//			j=0;
//			while(j < 5) {
//				System.out.println("*");
//				j++;
//			}
//			System.out.println();
//			i++;
//		}
		
		
//		### 내 해답 ###
		
//		int i = 0;
//		int j = 0;
//		while (i < 4 ) {
//			while( j < 5) {
//				System.out.print("*");
//				j++;
//			}
//			System.out.println();
//			j = 0;
//			i++;
//		}
		
		
		//높이 : n
		//*****
		//*****
		//*****
		//*****
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("높이 : ");
//		int n = sc.nextInt();
//		
//		int i = 0;
//		int j = 0;
//		while (i < n ) {
//			while( j < n) {
//				System.out.print("*");
//				j++;
//			}
//			System.out.println();
//			j = 0;
//			i++;
//		}
		
		
		
		//2
		//*
		//**
		//***
		//****
		
//		### 선생님 해답 ###
		
//		int i = 0;
//		int j = 0;
//		while ( i < 4 ) {
//			j=0;
//			while( j <= i ) {
//				System.out.print("*");
//				j++;
//			}
//			System.out.println();
//			i++;
//		}
		
		
//		### 내 해답 ###
		
//		int i = 1;
//		int j = 1;
//		while (i < 5 ) {
//			while( j <= i) {
//				System.out.print("*");
//				j++;
//			}
//			System.out.println();
//			j = 0;
//			i++;
//		}
		
		//높이 : 4
		//*
		//**
		//***
		//****
		
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		
//		
//		int i = 0;
//		int j = 0;
//		while ( i < n ) {
//			j=0;
//			while( j <= i ) {
//				System.out.print("*");
//				j++;
//			}
//			System.out.println();
//			i++;
//		}
		
		
		
		
		//3
		//****
		//***
		//**
		//*
		
		
		
//		### 선생님 해답 ###
		
//		int i = 0;
//		int j = 0;
//		
//		while(i < 4) {
//			j = 0;
//			while( j <= 3- i  ) {
//				System.out.print("*");
//				j++;
//			}
//			
//			System.out.println();
//			i++;
//		}
		
		
		
		
		
//		### 내 해답 ###
		
//		int i = 4;
//		int j = 0;
//		while (i > 0 ) {
//			while( j < i) {
//				System.out.print("*");
//				j++;
//			}
//			System.out.println();
//			j = 0;
//			i--;
//		}
		
		
		
		//높이 : 4
		//****
		//***
		//**
		//*
		
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		
//		int i = 0;
//		int j = 0;
//		
//		while(i < n) {
//			j = 0;
//			while( j <= (n-1) - i  ) {
//				System.out.print("*");
//				j++;
//			}
//			
//			System.out.println();
//			i++;
//		}
		
		
		
		
		//4
		//   *
		//  ***
		// *****
		//*******
		
		

		
//		### 선생님 해답 ###
		
//		int i = 0;		//행
//		int j = 0;		//공백
//		int k = 0;		//별
//		
//		while( i < 4 ) {
//			
//			//공백
//			j = 0;
//			while (j <= 2-i) {
//				System.out.print(" ");
//				j++;
//			}
//			
//			k = 0;
//			
//			while (k <= 2*i) {
//				System.out.print("*");
//				k++;
//			}			
//			System.out.println();
//			i++;
//		}
		
		
		
//		### 내 해답 ###

		
//		int i = 0;
//		int j = 0;
//		int k = 0;
		
//		while (i < 4) {
//			j = 0;
//			k = 0;
//			while(k < 3-i ) {
//				System.out.print(" ");
//				k++;
//			}
//			
//			while(j < 2 * i + 1 ) {
//				System.out.print("*");
//				j++;
//			}
//			System.out.println();
//			i++;
//		}
		
		
		//높이 : n
		//   *
		//  ***
		// *****
		//*******
		
		
//		### 선생님 해답 ###
		
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();		//높이
//		int i = 0;		//행
//		int j = 0;		//공백
//		int k = 0;		//별
//		
//		
//		while(i < n) {
//			//공백
//			j = 0;
//			while (j <= (n-2)-i) {
//				System.out.print(" ");
//				j++;
//			}
//			//별
//			k = 0;
//			while ( k <= 2*i) {
//				System.out.print("*");
//				k++;
//			}
//			System.out.println();
//			i++;
//		}
		
		
//		### 내 해답 ###
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("높이를 입력하세요 >>> ");
//		int n = sc.nextInt();
//		
//		int i = 0;
//		int j = 0;
//		int k = 0;
//		
//		while (i < n) {
//			j = 0;
//			k = 0;
//			while(k < (n-1)-i ) {
//				System.out.print(" ");
//				k++;
//			}
//			
//			while(j < 2 * i + 1 ) {
//				System.out.print("*");
//				j++;
//			}
//			System.out.println();
//			i++;
//		}
		

		
		
		
		
		//5
		//*******
		// *****
		//  ***
		//   *
		
//		### 선생님 해답 ###
//		int i = 0;
//		int j = 0;
//		int k = 0;
//		
//		
//		while (i < 4) {
//			//공백
//			j=0;
//			while(j<=i-1) {
//				System.out.print(" ");
//				j++;
//			}
//			//별
//			k = 0;
//			while (k<=6-2*i) {
//				System.out.print("*");
//				k++;
//			}
//			System.out.println();
//			i++;
//		}
		
		
		
//		### 내 해답 ###
		
//		int i = 0;
//		int j = 0;
//		int k = 0;
//		
//		while (i < 4 ) {
//			j = 0;
//			k = 0;
//			while(k < i  ) {
//				System.out.print(" ");
//				k++;
//			}
//			
//			while(j > 2 * i - 7 ) {
//				System.out.print("*");
//				j--;
//			}
//			System.out.println();
//			i++;
//		}
		
		//높이 : n
		//*******
		// *****
		//  ***
		//   *
		
//		### 선생님 해답 ###
		
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
		
//		int i = 0;		//행
//		int j = 0;		//공백
//		int k = 0;		//별
//		
//		while( i < n ) {
//			
//			//공백
//			j = 0;
//			while (j <= i-1) {
//				System.out.print(" ");
//				j++;
//			}
//			
//			k = 0;
//			
//			while (k <= (n-1)*2 -2*i) {
//				System.out.print("*");
//				k++;
//			}			
//			System.out.println();
//			i++;
//		}
		
		
		
		
		
		//6
		//   *
		//  ***
		// *****
		//*******
		// *****
		//  ***
		//   *
		
//		### 선생님 해답 ###
		
//		int i = 0;
//		int j = 0;
//		int k = 0;
//		
//		while(i < 7) {
//			
//			if (i < 4) {
//				
//				//공백
//				j = 0;
//				while(j<=2-i) {
//					System.out.print(" ");
//					j++;
//				}
//				//별
//				k = 0;
//				while(k<=2*i) {
//					System.out.print("*");
//					k++;
//				}
//			}
//			else {
//				//공백
//				j = 0;
//				while (j<=i-4) {
//					System.out.print(" ");
//					j++;
//				}
//				//별
//				k = 0;
//				while (k<=12 -2*i) {
//					System.out.print("*");
//					k++;
//				}
//			}
//			System.out.println();
//			i++;
//		}
		
		
		
		
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		while (i < 7) {
			j = 0;
			k = 0;
			
			
//			if(i >= 4) {
//				while (k < i - 3) {
//					System.out.print(" ");
//					k++;
//				}
//				
//				while(j > 2 * i - 13) {
//					System.out.print("*");
//					j--;
//				}
//			}
			
			
			while(k < 3-i ) {
				System.out.print(" ");
				k++;
			}
			
			while(j < 2 * i + 1 ) {
				if(i >= 4) {
					break;
				}
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
		}
		
		
		
		
		
		// 높이 : n ( n == 홀수 )
		//   *
		//  ***
		// *****
		//*******
		// *****
		//  ***
		//   *
		
//		### 선생님 해답 ###
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int i = 0;
//		int j = 0;
//		int k = 0;
//		
//		while(i < n) {
//		
//		if (i < (n/2 + 1)) {
//			
//			//공백
//			j = 0;
//			while(j<=(n/2-1) -i) {
//				System.out.print(" ");
//				j++;
//			}
//			//별
//			k = 0;
//			while(k<=2*i) {
//				System.out.print("*");
//				k++;
//			}
//		}
//		else {
//			//공백
//			j = 0;
//			while (j<=i-(n/2)+1) {
//				System.out.print(" ");
//				j++;
//			}
//			//별
//			k = 0;
//			while (k<=(n-1)*2 -2*i) {
//				System.out.print("*");
//				k++;
//			}
//		}
//		System.out.println();
//		i++;
//	}
		
		
		
		
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
		
		
//		int i = 0;
//		int j = 0;
//		int k = 0;
//		
//		while (i < n) {
//			j = 0;
//			k = 0;
//			if(i >= (n/2 + 1)) {
//				while (k < i - (n/2)) {
//					System.out.print(" ");
//					k++;
//				}
//				
//				while(j > 2 * i - 2* n + 1) {
//					System.out.print("*");
//					j--;
//				}
//			}
//			
//			while(k < (n/2)-i ) {
//				System.out.print(" ");
//				k++;
//			}
//			
//			while(j < 2 * i + 1 ) {
//				if(i >= (n/2 +1)) {
//					break;
//				}
//				System.out.print("*");
//				j++;
//			}
//			System.out.println();
//			i++;
//		}

		
	
		
		

	}

}
