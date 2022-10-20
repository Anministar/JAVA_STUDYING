package CH17;

import java.util.Calendar;
import java.util.Date;

public class C07Date {

	public static void main(String[] args) {
		
		Date d1 = new Date();
		System.out.println(d1);
		System.out.println(d1.getYear());
		System.out.println(d1.getMonth() + 1);
		System.out.println(d1.getDay());
		System.out.println(d1.getHours());
		System.out.println(d1.getMinutes());
		System.out.println(d1.getSeconds()); // 비효율적, 이걸 쓰려면 매초마다 객체를 형성하고 지우고 해야하니깐
		
		Calendar cal = Calendar.getInstance(); //보통 이걸 씀. 한번만 날짜정보를 받을꺼면 위에꺼
		System.out.println(cal);
		System.out.println(cal.get(Calendar.YEAR));				//연
		System.out.println(cal.get(Calendar.MONTH) + 1);		//월			//월은 0부터 출력이기때문에 +1을 해줘야함.
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));		//일
		System.out.println(cal.get(Calendar.HOUR));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
		
		//이 밑으로 코드 더 있는데 그냥 강사님 깃에서 확인하셈.
		//요일 일 - 토, 1-7(일월화수목금토) ==> switch 케이스 
		
		
		
		

	}

}
