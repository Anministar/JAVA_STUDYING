package CH20;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class C03Set {

	public static void main(String[] args) {
		
		Set<String> set = new HashSet();
	
		
		//추가
		set.add("JAVA");				
		set.add("JDBC");				
		set.add("OracleDB");		
		set.add("JSP");				
		set.add("Servlet");			
		set.add("SpringFrameWork");		
		set.add("JAVA");				//중복 허용 x ... 총개수는 6개
		
		//확인(저장 수)
		
		System.out.println("총 개체수 : " + set.size());
		
		//조회 (간편)
		for(String tmp : set) {
			System.out.println(tmp);
		}
		System.out.println("------------------------");
		
		
		//조회 (복잡)
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) { //가져올 객체가 있으면 true를 반환, 가져올 객체가 없으면 false를 반환
			String tmp = iter.next(); // next(); ==> 컬렉션에서 하나의 객체를 가져옴.
			System.out.println(tmp);	
			
		}
		
		set.remove("JAVA"); // Set 컬렉션에서 객체를 하나 삭제
		//확인(저장 수)
		System.out.println("총 개체수 : " + set.size());
		
		
		
		
		
	}

}
