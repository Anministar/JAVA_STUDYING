package CH11EXEC;

import java.util.Iterator;
import java.util.Scanner;

public class C02ArrayPrac {

	public static void main(String[] args) {
//		//문제
//		//5명의 학생의 국/영/수 정수를 입력받아 출력을 해봅시다
//		
//		
//		Scanner sc = new Scanner(System.in);
//		//이차원배열
//		//int score[5][3]
//		
//		int[][] score = new int[5][3];
//		
//		//반복문을 이용해서 값을 입력받기
//		for (int i = 0; i < score.length; i++) {
//			for (int j = 0; j < score[i].length; j++) {
//				score[i][j] = sc.nextInt();
//			}	
//		}
//		
//		//각 행의 합 과 전체 합 // 각행의 평균 전체 평균을 출력하세요
//				//출력예
//				//1 학생 점수입력(국/영/수 순서) : 100 70 60
//				//2 학생 점수입력(국/영/수 순서) : 99 98 66
//				//3 학생 점수입력(국/영/수 순서) : 99 88 77
//				//4 학생 점수입력(국/영/수 순서) : 100 55 66
//				//5 학생 점수입력(국/영/수 순서) : 55 66 77
//		
//		int i = 1;
//		for (int[] n : score) {
//			System.out.print(i+" 학생 점수입력(국/영/수 순서) : ");
//			for (int m : n) {
//				System.out.print(m + " ");
//			}
//			System.out.println();
//			i++;
//		}
//		
//		
//		//1 학생 총점 : ? 평균 ?
//		//2 학생 총점 : ? 평균 ?
//		//3 학생 총점 : ? 평균 ?
//		//4 학생 총점 : ? 평균 ?
//		//5 학생 총점 : ? 평균 ?
//		
//		int sum = 0;
//		double avg;
//		
//		int j = 1;
//		
//		for (int[] n : score) {
//			for (int m : n) {
//				sum += m;
//			}
//			avg = (double) sum / 3;
//			System.out.println(j + "학생 총점 : " + sum + "\t평균 : " + avg);
//			j++;
//		}
//		
//		//국어 총점 : ? 국어 평균 : ?
//		//영어 총점 : ? 영어 평균 : ?
//		//수학 총점 : ? 수학 평균 : ?
//		
//		int kall = 0;
//		int eall = 0;
//		int mall = 0;
//		
//		double kavg, eavg, mavg;
//		
//		for (int l = 0; l < score.length; l++) {
//			kall += score[l][0];
//			eall += score[l][1];
//			mall += score[l][2];
//		}
//		kavg = (double) kall / 5;
//		eavg = (double) eall / 5;
//		mavg = (double) mall / 5;
//		System.out.printf("국어 총점 : %d \t국어 평균 : %f\n", kall, kavg);
//		System.out.printf("영어 총점 : %d \t영어 평균 : %f\n", eall, eavg);
//		System.out.printf("수학 총점 : %d \t수학 평균 : %f", mall, mavg);
		
//		### 선생님 해답 ###
		
		int score [][] = new int[5][3];
		
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				score[i][j] = sc.nextInt();		//이차원배열 각 요소에 값넣기
			}
		}

		//학생별 총점 구하기
		int std[] = new int[5]; 
		
		int cnt = 0;
		for (int tmp[] : score) {
			
			for (int n : tmp) {
				std[cnt] += n;
			}
			cnt++;
		}
		for (int i = 0; i < std.length; i++) {
			System.out.println(i + " 번째 학생 총점 : " + std[i]);
		}
		
		//학생별 평균 구하기
		//생략
		
		//과목별 총점 구하기
		int subject[] = new int[3]; // 0번째 index : 국어 총점, 1번째 index : 영어 총점, 2번째 index : 수학총점
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < score.length; i++) {
				subject[j] = score[i][j];
			}
		}
		//과목별 평균 구하기
		//생략
		
		
		
		
		
		

	}

}
