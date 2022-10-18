package CH13EXEC;

//다음 2개의 static 가진 ArrayUtil 클래스를 만들어보자. 다음 코드의 실행 결과를 참고하여 concat()와 print()를 작성하여 ArrayUtil 클래스를 완성하라.

//class ArrayUtil {
//	public static int[] concat(int[] a, int[] b) {
//		/* 배열 a와 b를 연결한 새로운 배열 리턴 */
//		int [] c = new int [a.length + b.length];
//		for (int i = 0; i < a.length; i++) {
//			c[i] = a[i];
//		}
//		for (int i = 1; i < b.length; i++) {
//			c[a.length-1 + i] = b[i-1];
//		}
//		return c;
//	}
//
//	public static void print(int[] a) {
//		/* 배열 a 출력 */
//		for (int i = 0; i < a.length; i++) {
//			System.out.print(a[i] + " ");
//		}
//
//	}
//
//}

class ArrayUtil {
	public static int[] concat(int[] a, int[] b) {
		int len = a.length + b.length;
		int[] arr = new int[len];
		int i = 0;
		while (i < a.length) {
			arr[i] = a[i];
			i++;
		}
		while (i < len) {
			arr[i] = b[i-a.length];
			i++;
		}
		return arr;
	}

	public static void print(int[] a) {
		for (int t : a) {
			System.out.print(t + " ");
		}

	}
}

public class C01PRAC {

	public static void main(String[] args) {
		int[] array1 = { 1, 5, 7, 9 };
		int[] array2 = { 3, 6, -1, 100, 77 };
		int[] array3 = ArrayUtil.concat(array1, array2);
		ArrayUtil.print(array3);

	}

}
