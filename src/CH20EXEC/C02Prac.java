package CH20EXEC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class C02Prac {

	public static void main(String[] args) {
	
		int num = 0;
		//Map 만들기
		Map<String,String> map = new HashMap();
		Scanner sc = new Scanner(System.in);
		String id=null;
		String pw=null;
		while(true) {
			System.out.println("=======M E N U =======");
			System.out.println("1 ID/PW 등록");
			System.out.println("2 ID/PW 조회");
			System.out.println("3 Password 변경");
			System.out.println("4 ID/PW 삭제");
			System.out.println("5 전체조회");
			System.out.println("6 종료");
			System.out.println("=======M E N U =======");
			System.out.print("번호 : " );
			num = sc.nextInt();
			switch(num)
			{
			case 1:
				//map 에 ID/PW등록
				//단! 기존에 동일 ID가 있으면 등록불가(containsKey사용)
				System.out.println("등록하실 ID를 입력하세요 >>> ");
				String id1 = sc.next();
				while (true) {
					if(map.containsKey(id1)) {
						System.out.println("ID가 중복되어 등록할 수 없습니다.");
						System.out.println("다시 입력하세요 >>> ");
						id1 = sc.next();
						continue;
					}
					else {
						System.out.println("등록하실 PW를 입력하세요 >>> ");
						String pw1 = sc.next();
						map.put(id1, pw1);
						break;
					}
				}
	
				break;
			case 2:
				//ID를 받아서 map에 있는 동일한 Id/pw 를 출력
				System.out.println("조회하실 ID를 입력하세요 >>> ");
				String id2 = sc.next();
				if(map.containsKey(id2)) {
					System.out.println("조회하신 " + id2 + "이/가 있습니다.");
				}
				else {
					System.out.println("조회하신 " + id2 + "이/가 없습니다.");
				}
				
				break;
			case 3:
				//ID를 받아서 map에 있는 동일한 id의 password를 변경 
				
				System.out.println("변경하실 PW의 ID를 입력하세요 >>> ");
				String id3 = sc.next();
				while (true) {
					if (map.containsKey(id3)) {
						System.out.println("변경하실 PW를 입력하세요 >>> ");
						String pw1 = sc.next();
						map.put(id3, pw1);
						break;
					}
					else {
						System.out.println("ID가 불일치합니다.");
						System.out.println("다시 입력하세요.");
						id3 = sc.next();
						continue;
					}
				}
				break;
			case 4:
				//ID를 받아서 map에 있는 동일한 id/pw를 삭제
					
				break;
			case 5:
				//전체조회
				
				break;
			case 6:
				System.exit(-1);
			default:
				System.out.println("다시 입력...");
			}
		
		}
		
		
		
		
		
		
	}

}
