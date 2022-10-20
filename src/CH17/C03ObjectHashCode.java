package CH17;

public class C03ObjectHashCode {

	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		System.out.println(obj1);
		System.out.println(obj2);
		
		System.out.println("----------------------------");
		System.out.printf("%x\n", obj1.hashCode());
		System.out.printf("%"
				+ "---------------------------");
		System.out.printf("%x\n", System.identityHashCode(obj1));
		System.out.printf("%x\n", System.identityHashCode(obj2));
		
		
	}

}
