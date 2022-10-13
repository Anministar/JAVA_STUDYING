package CH08;

 class C10Person {
	 //속성(=필드, 멤버변수)
	 String name;
	 int age;
	 String addr;
	 
	 
	 void setPerson(String str) {
		 name = str;
	 }
	 void setPerson(String str, int a) {
		 name = str;
		 age = a;
	 }
	 void setPerson(String str, int a, String str1) {
		 name = str;
		 age = a;
		 addr = str1;
	 }
	 
//	 void SetPerson(String name) {
//		 this.name = name;
//		 
//	 }
//	 void setPerson (String name, int age) {
//		 this.name = name;
//		 this.age = age;
//	 }
//	 void setPerson (String name, int age, String addr) {
//		 this.name = name;
//		 this.age = age;
//		 this.addr = addr;
//	 }
	 // 선생님이 만든 방법.
	 
	 
	 
	 
	 //기능(멤버메서드)
	 void talk() {
		 System.out.println(name + "님이 말합니다.");
	 }
	 void walk() {
		 System.out.println(name + "님이 걷습니다.");
	 }
	 void ShowInfo() {
		 System.out.printf("이름 : %s 나이 : %d 주소 : %s\n", name, age, addr);
	 }
	 //void talk() : 헤더 부분, {} : 본체, 바디 부분
	 //반환형 함수명 매개변수
 }
 
public class C10PersonMain {

	public static void main(String[] args) {
		

		C10Person obj = new C10Person();
		obj.setPerson("홍길동"); //멤버변수 name에 "홍길동" 저장 
		obj.ShowInfo();
		
		obj.setPerson("서길동", 10); //멤버변수 name, age에 각각 저장
		obj.ShowInfo();
		
		obj.setPerson("강호동", 55, "서울"); //멤버변수 name, age, addr에 각각 저장
		obj.ShowInfo();
		
		
	}

}
