package CH09;




public class C03StringClass {

	public static void main(String[] args) {
		//1
		String str1 = "java";
		String str2 = "java";
		//2
		String str3 = new String("java");
		String str4 = new String("java");
		
		//1과 2의 저장 방식이 다름
		
		System.out.println("str1 = str2 : "  + (str1 == str2));
		System.out.println("str3 = str4 : "  + (str3 == str4));
		System.out.println("str1 = str3 : "  + (str1 == str3));
		System.out.println("str1 = str4 : "  + (str1 == str4));
		//equals 메서드 사용하여 문자열 자체 비교하기
		System.out.println("--------------------------------------");
		System.out.println("str1 = str2 : "  + (str1.equals(str2)));
		System.out.println("str3 = str4 : "  + (str3.equals(str4)));
		System.out.println("str1 = str3 : "  + (str1.equals(str3)));
		System.out.println("str1 = str4 : "  + (str1.equals(str4)));
		
		
		
	}

}
