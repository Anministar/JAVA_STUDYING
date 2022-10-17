package CH11;

import java.util.Arrays;

public class C02ArrayCopy {

	public static void main(String[] args) {
		
		int [] arr1 = {10, 20, 30};
		//얕은 복사 (위치값 복사)
		int [] arr2 = arr1; //하나의 객체에다가 여러개의 참조변수를 연결할게 아니라면 실수하지 말라!
		
		
		int [] arr3 = new int[3];
		for (int i = 0; i < arr3.length; i++) {
			arr3[i] = arr1[i]; //깊은 복사 (데이터값 복사)
		}
		
		// 깊은 복사
		int [] arr4 = Arrays.copyOf(arr1, arr1.length); //복사원본, 얼만큼 복사할지 길이
		
		
		
		System.out.println("arr1 : " + arr1);
		System.out.println("arr2 : " + arr2);
		System.out.println("arr3 : " + arr3);
		System.out.println("arr4 : " + arr4);
		
		
		arr2[0] = 100;
		arr2[1] = 200;
		arr2[2] = 300;
		
		for (int n : arr1) {
			System.out.println(n);
		}
		
		
		for (int n : arr4) {
			System.out.println(n);
			
		}

	}

}
