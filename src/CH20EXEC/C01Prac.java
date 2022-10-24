package CH20EXEC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C01Prac {
	public static void main(String[] args) {
		int num = 0;
		List<String> list = new ArrayList();
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("=======M E N U =======");
			System.out.println("1 이름 등록");
			System.out.println("2 이름 조회");
			System.out.println("3 이름 삭제");
			System.out.println("4 전체 조회");
			System.out.println("5 종료");
			System.out.println("=======M E N U =======");
			System.out.print("번호 : " );
			num = sc.nextInt();
			switch(num)
			{
			case 1:
				//이름 입력받아서 ArrayList 에  add
				System.out.println("등록하실 이름을 입력하세요 >>> ");
				String name = sc.next();
				list.add(name);
				break;
			case 2:
				//이름 입력받아서 조회(있다,없다로 조회) 이름이 있으면 "있다" 없으면 "없다"..
				System.out.println("조회하실 이름을 입력하세요 >>> ");
				String search = sc.next();
				if(list.contains(search)) {
					System.out.println(search + "님은 있습니다.");
				}
				else {
					System.out.println("조회하신" + search + "님은 없습니다.");
				}
					
				
			case 3:
				//이름 입력받아서 삭제.. 삭제되었으면 "삭제완료" 삭제할 이름 없으면 "삭제실패" 
				System.out.println("삭제하실 이름을 입력하세요 >>> ");
				String del = sc.next();
				if (list.contains(del)) {
					list.remove(del);
					System.out.println("삭제완료");
				}
				else {
					System.out.println("삭제하실 이름이 List에 없습니다.");
					System.out.println("삭제실패");
				}
				break;
			case 4:
				//전체 조회
				System.out.println("List 전체를 조회합니다.");
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i));
				}
				break;
			case 5:
				System.exit(-1);
			default:
				System.out.println("다시 입력...");
			}
		}
	}
}

