import java.util.Scanner;

public class Prc2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("문자열을 입력하세요 >>> ");
		String word = sc.nextLine();
		
		
		
		String str = "";
		char ch;
		int order = word.length() - 1;
		while (true) {
			ch = word.charAt(order);
			str += String.valueOf(ch);
			if(order == 0) {
				break;
			}
			order--;
			
		}
		System.out.printf("거꾸로 출력한 문자열은 %s 입니다", str);
	}

}
