package CH06;

import java.util.Scanner;

public class C01IF {

	public static void main(String[] args) {

		// 단순 IF

//		int age = 7;
//		if(age >=8)
//		{
//			System.out.println("학교에 다닙니다");
//		}
//		System.out.println("첫번째 IF 블럭 종료");
//		
//		if(age <8)
//		{
//			System.out.println("학교에 다니지 않습니다");
//		}
//		System.out.println("두번째 IF 블럭 종료");
//		System.out.println("프로그램을 종료합니다");

//		int age = 10;
//		if (age >= 8) {
//			System.out.println("학교에 다닙니다");
//		}
//
//		else {
//			System.out.println("학교에 다니지 않습니다");
//		}
//		System.out.println("두번째 IF 블럭 종료");
//		System.out.println("프로그램을 종료합니다");
//		
		

		//문제
		//정수 한개값을 입력받아 3의 배수이면 해당 수를 출력하세요
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 하나를 입력하세요 >>> ");
		int num1 = sc.nextInt();
		if (num1 % 3 == 0) {
			System.out.println(num1);
		}
		else {
			System.out.println("3의 배수가 아닙니다.");
		}
		
		//문제
		//두수를 입력받아 두수 중에 큰수를 출력
		
		System.out.println("정수 하나를 입력하세요 >>> ");
		int num2 = sc.nextInt();
		System.out.println("두번째 정수 하나를 입력하세요 >>> ");
		int num3 = sc.nextInt();
		if (num2 > num3) {
			System.out.println(num2 + "가" + num3 + "보다 큽니다");
			
		}
		else {
			System.out.println(num3 + "가" + num2 + "보다 큽니다");
		}
		//문제
		//세개의 정수를 입력받아 해당수의 합과 평균을 출력
		
		System.out.println("첫번째 정수 하나를 입력하세요 >>> ");
		int numa = sc.nextInt();
		System.out.println("두번째 정수 하나를 입력하세요 >>> ");
		int numb = sc.nextInt();
		System.out.println("세번째 정수 하나를 입력하세요 >>> ");
		int numc = sc.nextInt();
		
		int sum = numa + numb + numc;
		
		int avg = sum / 3;
		
		System.out.println("세개의 정수 합 : " + sum);
		System.out.println("세개의 정수 평균 : " + avg);
		
		
		//문제
		//세 정수를 입력받아 세 정수 중에 가장 큰 수와 가장 작은 수를 출력
		
		System.out.println("첫번째 정수 하나를 입력하세요 >>> ");
		int numd = sc.nextInt();
		System.out.println("두번째 정수 하나를 입력하세요 >>> ");
		int nume = sc.nextInt();
		System.out.println("세번째 정수 하나를 입력하세요 >>> ");
		int numf = sc.nextInt();
		
		String result = (numd > nume)?
				((numd>numf)?
						"가장 큰 수는 " + numd:"가장 큰수는 " + numf):
							((nume>numf)?
									"가장 큰 수는 " + nume:"가장 큰 수는 " + numf);
		System.out.println(result);
		
		
//		### 선생님 해답 ####
		
//		1번
		
//		Scanner sc = new Scanner(System.in);
//		int num = sc.nextInt();
//		if(num%3 == 0) {
//			System.out.println("3의 배수 : " + num);
//		}
//		System.out.println("프로그램을 종료합니다.");

		
//		2번
		
//		Scanner sc = new Scanner(System.in);
//		int n1 = sc.nextInt();
//		int n2 = sc.nextInt();
//		if(n1 > n2) {
//			System.out.println("큰 수 : " + n1);
//		}
//		else { 
//			System.out.println("큰 수 : " + n2);
//		}
		
		
//		3번
		
//		Scanner sc = new Scanner(System.in);
//		int n1 = sc.nextInt(), n2 = sc.nextInt(), n3 = sc.nextInt();
//		int sum = n1 + n2 + n3;
//		double avg = (double) sum / 3;
//		System.out.printf("합 : %d 평균 : %.2f\n", sum, avg );
		
		
//		4번
		
//		Scanner sc = new Scanner(System.in);
//		int n1 = sc.nextInt();
//		int n2 = sc.nextInt();
//		int n3 = sc.nextInt();
//		
//		//n1이 제일 큰 경우
//		if(n1 >= n2 && n1 >= n3) {
//			System.out.println("큰 수 : " + n1);
//		}
//		//n2이 제일 큰 경우
//		if((n2 >= n1 && n2 >= n3) && ((n2 != n1) && (n2 != n3))) {
//			System.out.println("큰 수 : " + n2);
//		}
//		//n3이 제일 큰 경우
//		if((n3 >= n1 && n3 >= n2) && (n3 != n1)) {
//			System.out.println("큰 수 : " + n3);
//		}
		
		// 수가 같은 경우는 문제가 됨.
		// 그래서 뒤에 조건식을 붙여줌.
		
		//or
		
//		Scanner sc = new Scanner(System.in);
//		int n1 = sc.nextInt(), n2 = sc.nextInt(), n3 = sc.nextInt();
//		if(n1 >= n2 && n1 >= n3) {
//			System.out.println("큰 수 : " + n1);
//		}
//		else if (n2 >= n1 && n2 >= n3) {
//			System.out.println("큰 수 : " + n2);
//		}
//		else { 
//			System.out.println("큰 수 : " + n3);
//		}
		
		// 이렇게 대체가능함.
		
		
		
		
		
		
		// IF - ELSE
		/*
		 * if(age >=8) { System.out.println("학교에 다닙니다"); } else {
		 * System.out.println("학교에 다니지 않습니다"); }
		 */

		// 입력값 받기 + if

		/*
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * System.out.print("정수 1 입력 : "); int num = sc.nextInt();
		 * 
		 * if(num%2==0) //짝수이냐? { System.out.println("입력한 값은 짝수 입니다"); } else {
		 * System.out.println("입력한 값은 홀수 입니다"); }
		 */

		// 문제
		// 정수 한개값을 입력받아 3의 배수이면 해당 수를 출력하세요

		/*
		 * int num=0; Scanner sc = new Scanner(System.in); System.out.print("정수 입력:");
		 * num=sc.nextInt(); if(num%3==0)//3의 배수라면 { System.out.println(num +
		 * " 는 3의 배수 입니다"); }
		 */

		// 문제
		// 두수를 입력받아 두수 중에 큰수를 출력

		/*
		 * int num1,num2; Scanner sc = new Scanner(System.in);
		 * System.out.print("1 정수 입력 :"); num1=sc.nextInt();
		 * System.out.print("2 정수 입력 :"); num2=sc.nextInt(); if(num1>num2) {
		 * System.out.println("큰수 : " + num1); } else { System.out.println("큰수 : " +
		 * num2); } sc.close();
		 */

		// 문제
		// 세개의 정수를 입력받아 해당수의 합과 평균을 출력

		/*
		 * int num1,num2,num3; int sum=0; double avr=0.0; Scanner sc = new
		 * Scanner(System.in); System.out.println("세 수를 입력하세요 : "); num1=sc.nextInt();
		 * num2=sc.nextInt(); num3=sc.nextInt();
		 * 
		 * sum=num1+num2+num3; avr=(double)sum/3;
		 * 
		 * System.out.println("합 :" + sum + "평균 : " + avr);
		 */

	}

}
