package CH07;

import java.util.Scanner;

public class C01While {

	public static void main(String[] args) {
		
		// 탈출 요건
		
//		int i = 0; //1 탈출 변수
//		while ( i < 10 ) { //2 탈출 조건식
//			System.out.println("HELLO WORLD");
//			i++; //3 탈출 연산식
//		}
		
		// 1 부터 10까지 합
//		int i = 1; 							//1 탈출 변수
//		int sum = 0;						// 누적 합 저장 변수
//		while ( i <= 10 ) { 				//2 탈출 조건식
//			System.out.println("i : " + i);
//			sum = sum + i;					//sum += i;
//			i++; 							//3 탈출 연산식
//		}
//		System.out.println("종료 후 i : " + i);
//		System.out.println("1 부터 10까지 합 : " + sum);
		
		
		
		
		
		
		
		//문제
		// 1부터 입력한 정수(N)까지 합 구하기
		Scanner sc = new Scanner(System.in);
		
//		System.out.println("정수를 입력하세요 >>> ");
//		int n = sc.nextInt();
//		int j = 1;
//		int pls = 0;
//		while (j <= n ) {
//			pls += j;
//			j++;
//		}
//		System.out.printf("1부터 %d까지의 합은 %d입니다. ", n, pls);
//		System.out.println();
		
		
		//문제
		// N, M 을 입력받아서 N부터 M 까지의 합 구하기 ( N < M )  // 5,2 입력해도 2-5까지 합 구하도록 하기
		
//		System.out.println("정수1을 입력하세요 >>> ");
//		int num1 = sc.nextInt();
//		int num11 = num1;
//		
//		System.out.println("정수2를 입력하세요 >>> ");
//		int num2 = sc.nextInt();
//		int num21 = num2;
//		
//		int sum1 = 0;
//		
//		if (num2 > num1) {
//			while (num11 <= num2) {
//				sum1 += num11;
//				num11++;
//			}
//			System.out.printf("%d부터 %d까지의 합은 %d입니다.", num1, num2, sum1);
//		}
//		else if (num1 >= num2) {
//			while (num21 <= num1 ) {
//				sum1 += num21;
//				num21++;
//			}
//			System.out.printf("%d부터 %d까지의 합은 %d입니다.", num2, num1, sum1);
//		}
		
	
		//문제
		//구구단 2단 출력
		
//		int i = 2;
//		int j = 1;
//		
//		
//		System.out.println(i + "단 출력");
//		while (j < 10) {
//			int mul = i * j;
//			System.out.printf("%d x %d = %d\n", i, j, mul);
//			j++;
//		}
		
		
		//문제
		//구구단 2단 출력(역순출력)
		
		
//		int i = 2;
//		int j = 9;
//		
//		
//		System.out.println(i + "단 출력");
//		while (1 <= j) {
//			int mul = i * j;
//			System.out.printf("%d x %d = %d\n", i, j, mul);
//			j--;
//		}
		
		
		//문제
		//구구단 N단 출력(입력받기)
		
//		System.out.println("출력하고 싶은 N단을 입력하세요 >>> ");
//		int i = sc.nextInt();
//		int j = 1;
//		
//		
//		System.out.println(i + "단 출력");
//		while(j < 10) {
//			int mul = i * j;
//			System.out.printf("%d x %d = %d\n", i, j, mul);
//			j++;
//		}
		
		
		//문제
		//구구단 N단 출력(입력받기,역순출력) (별첨 ... 2<=N<=9)
		
//		System.out.println("출력하고 싶은 N단을 입력하세요 >>> ");
//		int i = sc.nextInt();
//		int j = 9;
//		
//		
//		System.out.println(i + "단 출력");
//		while(1 <= j) {
//			int mul = i * j;
//			System.out.printf("%d x %d = %d\n", i, j, mul);
//			j--;
//		}
		
		
		
		
//		### 선생님 해답 ###

//		1번
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		
//		int i = 1;
//		int sum = 0;
//		while (i <= n) {
//			
//			sum += i;		//sum = sum + i;
//			i++;
//		}
//		System.out.printf("1부터 %d까지의 합 : %d\n", n, sum);
		
		
//		2번
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//		
//		if(n > m) {
//			int tmp = n;
//			n = m;
//			m = tmp;
//		}
//		int i = n; //초기값
//		int sum = 0;
//		while (n <= m) {
//			sum += i;
//			i++;
//		}
//		System.out.printf("%d 부터 %d까지의 합 : %d\n", n, m, sum);
		
		
		
		
		//문제
		//프로그램 사용자로부터 양의 정수를 하나 입력 받은 다음, 그 수만큼 3의 배수를 출력하는
		//프로그램을 작성
		//ex. 5를 입력 받았다면 3, 6, 9, 12, 15 를 출력
		
//		System.out.println("양의 정수를 하나 입력하세요 >>> ");
//		int i = sc.nextInt();
//		int l = 1;
//		while ( l <= i) {
//			if(l == i) {
//				System.out.printf("%d", l*3);
//				break;
//			}
//			System.out.printf("%d, ", l*3);
//			l++;
//		}
		
		
		
		//문제
		//1부터 100까지 수중에 짝수의 합과 홀수의 합을 각각 구해서 출력하세요
//		int num = 1;
//		int w = 0;
//		int h = 0;
//		
//		while (num <= 100) {
//			if(num % 2 == 0) {
//				w += num;
//			}
//			else {
//				h += num;
//			}
//			num++;
//		}
//		System.out.printf("짝수의 합은 %d 입니다\n", w);
//		System.out.printf("홀수의 합은 %d 입니다\n", h);
		
		
		
		
		//문제
		//1부터 N까지 수중에 짝수의 합과 홀수의 합을 각각 구해서 출력하세요
		
//		System.out.println("정수 하나를 입력하세요 >>> ");
//		int num = sc.nextInt();
//		int n = 1;
//		int w = 0;
//		int h = 0;
//		
//		
//		while (n <= num) {
//			if (n % 2 == 0) {
//				w += n;
//			}
//			else {
//				h += n;
//			}
//			n++;
//		}
//		System.out.printf("짝수의 합은 %d 입니다\n", w);
//		System.out.printf("홀수의 합은 %d 입니다\n", h);
		
		
		
		//문제
		//1부터 100까지 수중에 3의 배수는 제외한 합을 구해서 출력해보세요
		
//		int sum = 0;
//		int num = 1;
//		
//		while (num <= 100) {
//			if (num % 3 != 0) {
//				sum += num;
//			}
//			num++;
//		}
//		System.out.printf("3읠 배수를 제외한 합은 %d 입니다", sum);
		
		
		
		//문제
		//문자열을 입력받아서 각 문자를 거꾸로 출력해봅시다 ( 같이 풉니다 )
		
//		System.out.println("문자열을 입력하세요 >>> ");
//		String word = sc.nextLine();
//		
//		String str = "";
//		char ch;
//		int order = word.length() - 1;
//		
//		while (true) {
//			ch = word.charAt(order);
//			str += String.valueOf(ch);
//			if(order == 0) {
//				break;
//			}
//			order--;
//			
//		}
//		System.out.printf("거꾸로 출력한 문자열은 %s 입니다", str);
		
		//2번 풀이
//		System.out.println("문자열을 입력하세요 >>> ");
//		String word = sc.nextLine();
//		
//		
//		String str = "";
//		char ch;
//		int order = word.length() - 1;
//		while (order >= 0) {
//			ch = word.charAt(order);
//			str += String.valueOf(ch);
//			order--;
//			
//		}
//		System.out.printf("거꾸로 출력한 문자열은 %s 입니다", str);
		
		
		
		
		
//		System.out.println("문자열을 입력하세요 >>> ");
//		String word = sc.nextLine();
//		
//		StringBuilder builder = new StringBuilder(word);
//		System.out.println("거꾸로 문자열은 " + builder.reverse() + "입니다");
		
		
		
		
		
//		### 선생님 해답 ###
//		1번
		
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int i = 1;
//		String stack = "";
//		
//		while(i<=n) {
//			
//			if(i < n) {
//				System.out.println(i * 3 + ",");
//			}
//			else {
//				System.out.println(i * 3);
//			}
//			
//			i++;
//		}
		
//		2번
//		Scanner sc = new Scanner(System.in);
//		int i = 1;
//		int evensum = 0;
//		int oddsum = 0;
//		while (i <= 100) {
//			if(i % 2 == 0) {
//				System.out.println("짝수 i = " + i);
//				evensum += i;			// evensum = evensum + i
//			}
//			else {
//				System.out.println("홀수 i = " + i);
//				oddsum += i;			// oddsum = oddsum + i
//			}
//			i++;
//		}
//		System.out.println("짝수 합 : " + evensum);
//		System.out.println("홀수 합 : " + oddsum);

		
//		3번
		
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		
//		int i = 1;
//		int evensum = 0;
//		int oddsum = 0;
//		while (i <= n) {
//			if(i % 2 == 0) {
//				System.out.println("짝수 i = " + i);
//				evensum += i;			// evensum = evensum + i
//			}
//			else {
//				System.out.println("홀수 i = " + i);
//				oddsum += i;			// oddsum = oddsum + i
//			}
//			i++;
//		}
//		System.out.println("짝수 합 : " + evensum);
//		System.out.println("홀수 합 : " + oddsum);
		
		
		
		
		
//		문자열 입력받아 출력하는 문제 풀이
//		
//		String str = "안녕?";
//		System.out.println(str);
//		
//		str = str + "나는 ";
//		System.out.println(str);
//		==>새로운 공간을 다시 만들어서 넣음, 이런 코드는 좋지 않음.
		
		
		
//		Scanner sc = new Scanner(System.in);
//		
//		String str1 = sc.nextLine();
//		String reverse = "";
//		int len = str1.length()-1;
//		System.out.println("길이 : " + len);
//		while(len >=0) {
//			System.out.println(str1.charAt(len));
//			reverse+= str1.charAt(len);
//			len--;
//		}
//		System.out.println(reverse);
		
		
		
		
		
	}

}
