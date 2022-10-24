package CH20;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class C06_1Map {

	// 저장멤버 MAP
	private static Map<String, Integer> map = new HashMap(); // 객체와 무관하게 쓰려고 static을 붙임

	public static void Insert(String k, Integer v) {
		if (!map.containsKey(k)) { // key가 map에 없다고 value도 중복되지 않는다면 @ 기존에 키값이 저장되어 있는지 확인하는것임.(! == 키가 없다면 )
			map.put(k, v); // key, value 저장
		} else {
			System.out.println("동일한 key가 존재합니다.");
		}
	}

	public static void ShowInfo() {
		// 조회
		Set<String> set = map.keySet(); // map안의 모든 key를 Set형태로 반환
		for (String key : set) {
			int value = map.get(key);
			System.out.println("KEY : " + key + " VALUE : " + value);
		}
	}
	public static void Remove(String key) {
		Integer result = map.remove(key);
		
		if(result == null) {
			System.out.println("삭제실패...");
		}
		else {
			System.out.println("삭제성공!!");
		}
		
	}
	public static void Remove(Integer value) {
		// 동일한 value을 가지는 모든 요소를 삭제
		Set <String> set = map.keySet();
		List <String> list = new ArrayList(set);
		
		for (String n : list) {
			if(map.get(n).equals(value)) {
				map.remove(n);
			}
		}
		System.out.println("동일한 " + value + "을 값으로 가지는 모든 요소를 삭제했습니다.");
		
		
		
		
//		Collection <Integer> collection = map.values();
//		List <Integer> list = new ArrayList();
//		
//		for (Integer value1 : collection) {
//			list.add(value1);
//			if(value1.equals(value)) {
//				list.remove(value1);
//			}	
//		}
//		for (int i = 0; i < list.size(); i++) {
//			list.get(i);
//		}
	}
	public static void main(String[] args) {
		Insert("aaa", 1234);
		Insert("bbb", 2222);
		Insert("ccc", 3333);
		Insert("ddd", 4444);
		Insert("ddd", 1234); // 중복 key가 들어가는 경우
		Insert("fff", 1234); // 중복 value가 들어가는 경우
		Insert("bvkj", 1234);
		Insert("dla", 1234);
		Insert("dlehdgk", 1234);
		System.out.println("----------------------------");
		

		// 개수
//		System.out.println("저장 수 : " + map.size());
		
		// 조회
		ShowInfo();
		
		// 삭제
//		Remove("aaa"); //삭제성공
//		Remove("abc"); //삭제실패
		
		//개수
		System.out.println("저장 수 : " + map.size());
		System.out.println("-----------------------------");

		Remove(1234);	//value전달 삭제
	
		ShowInfo();
		
		
	}

}
