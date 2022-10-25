package CH21EXEC;

import java.io.FileWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class C01Prac {
	// Key : 제목, Value : 내용
	private static Map<String,String> map = new HashMap();

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		int num;
		String subject = null;
		String contents = null;
		while (true) {
			System.out.println("-----------M E M O-----------");
			System.out.println("1 메모하기");
			System.out.println("2 불러오기");
			System.out.println("3 파일로 저장");
			System.out.println("4 종료");
			System.out.println("-----------M E M O-----------");
			System.out.print("번호 : ");
			num = sc.nextInt();
			switch (num) {
			case 1:
				System.out.print("제목 입력 : " ); //map의 key로 저장
				subject = sc.next();
				if (map.containsKey(subject)) { //동일 제목이 있을경우
					System.out.println("기존 제목과 동일한 제목이 있습니다.");
					break;
				}
				System.out.print("----내용----\n");//map의 value로 저장
				sc.nextLine(); // 버퍼 비우기
				while(true) {
					String tmp = sc.nextLine();
					if (tmp.contains("-1")) {
						break;
					}
					contents += tmp + "\n";
				}
				
				map.put(subject, contents);
				contents =null; //다음 제목에 그전의 값이 쌓여서 전달됨.
				//제목과 내용을 입력 받아서 map에 저장합니다
				//기존의 제목과 동일한 제목이 있으면 내용입력이 불가능하게 설정합니다
				
				break;
			case 2:
				
				System.out.print("제목 입력 : " );
				//제목을 입력하면 해당 제목의 내용일 출력되게 합니다.
				sc.nextLine();
				
				String title = sc.nextLine();
				while(true) {
					if (map.containsKey(title) == true) {
						System.out.println("이 제목의 내용은 " + map.get(title));
						break;
					}
					else {
						System.out.println("Map의 제목 List에 제목이 없습니다.");
						System.out.println("제목을 다시 입력하세요 >>> ");
						title = sc.nextLine();
						continue;
						
					}
				}
				
//				### 선생님 해답 ###
//				subject = sc.next();
//				contents = map.get(subject).substring(4); // 앞에 null이 들어감. (앞쪽 null값 자동 형성), 그래서 잘라냄.
//				if (contents == null) {
//					System.out.println("제목과 일치하는 내용이 없습니다.");
//				}
//				else {
//					System.out.println(contents);
//				}
				
				
				break;
			case 3:
				//map의 제목 리스트가 나오게 합니다
				//제목 리스트마다 번호를 부여해서 번호를 입력하면 파일로 저장되게 합니다
				//파일명도 제목명으로 해서 저장합니다.
				
//				### 선생님 해답 ###
//				System.out.println("저장할 제목을 선택하세요...");
//				Set<String> set = map.keySet();
//				int i = 1;
//				for (String key : set) {
//					System.out.println((i++) + " " + key);
//				}
//				System.out.print("제목 : " );
//				subject = sc.next();
//				contents = map.get(subject);
//				
//				Date now = new Date();
//				Writer out = new FileWriter("c:\\iotest\\" + subject + ".txt", true); // 예외처리
//				out.write("--------------------"+now+"-------------------\n");
//				out.write(contents.substring(4));
//				out.flush();
//				out.close();
				
				
				//issue 1 기존 파일명이 없을 때 -> 생성하기
				//issue 2 기존 파일명이 있을 때 -> 추가하기
				//issue 3 다른 파일명과 겹치는 문제 -> UUID값을 파일명에 붙이기
				//issue 4 파일명을 map 에 저장해야되는 문제 -> String 아니라 Memo 클래스 생성
				
				System.out.println("Map의 제목 리스트를 조회합니다.");
				Set <String> set = map.keySet();
				for (String key : set) {
					for (int i = 1; i <= set.size(); i++) {
						System.out.println(i + ". " + key);
					}
				}
				System.out.println("파일로 저장하고 싶은 제목의 번호를 입력하세요 >>> ");
				subject = sc.next();
				contents = map.get(subject);
				
				
				Writer out = new FileWriter("C:\\iotest\\" + subject + ".txt");
				out.write(contents.substring(4));
				out.flush();
				out.close();
				
				
				
				
				
				break;
			case 4:
				System.out.println("종료합니다.");
				System.exit(-1);
				
			default : 
				System.out.println("다시 입력하세요..");	

			}
		}

	}
}
