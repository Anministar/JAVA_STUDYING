package CH11;

import java.util.Scanner;

public class C01ArrayBasie {

	public static void main(String[] args) {
		// 길이가 5인 int형 1차원 배열의 생성
		
		Scanner sc = new Scanner(System.in);
		
		int[] ar1 = new int[5];
		
		ar1[0] = sc.nextInt();
		ar1[1] = sc.nextInt();
		ar1[2] = sc.nextInt();
		ar1[3] = sc.nextInt();
		ar1[4] = sc.nextInt();
		
		//기존
		for (int i = 0; i < ar1.length; i++) {
			System.out.print(ar1[i]);
			
		}
		System.out.println();
		
		//추가(컬렉션에도 적용가능)
		for (int val : ar1) {
			System.out.print(val + " ");
		}
		System.out.println();
		
		
		
		
		// 길이가 7인 double형 1차원 배열의 생성
		double[] ar2 = new double[7];
		
		// 배열의 참조변수와 인스턴스 생성 분리
		float[] ar3;
		ar3 = new float[9];
		
		// 배열의 인스턴스 변수 접근
		System.out.println("배열 ar1 길이 : " + ar1.length);
		System.out.println("배열 ar2 길이 : " + ar2.length);
		System.out.println("배열 ar3 길이 : " + ar3.length);
		

	}

}
