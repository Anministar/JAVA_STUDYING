package CH17;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class C08Date {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("YYYY/MM/DD 입력 : ");
		
		String str = sc.nextLine();
//		System.out.println(str);
		
		//포매터
		SimpleDateFormat fmtin = new SimpleDateFormat("yyyy/MM/dd"); // 대소문자 구분함 M : 월, m : 분
		SimpleDateFormat fmtout = new SimpleDateFormat("yyyy-MM-dd");		  // 출력용
		
		//문자열 -> Date
		Date tmp = fmtin.parse(str); //받은 문자열을 클래스형으로 변환
		
		//포맷설정 후 출력
		System.out.println(fmtout.format(tmp));	//Date -> fmtout의 format맞게 변환
		
		

		

	}

}
