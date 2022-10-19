package CH14EXEC;

class TV1 {
	String name;
	int age;
	int size;
	public TV1(String name, int age, int size) {
		this.name = name;
		this.age = age;
		this.size = size;
	}
	
	void show()	 {
		System.out.printf("%s에서 만든 %d년형 %d인치 TV", name, age, size);
	}
}

public class PrivatePrac {

	public static void main(String[] args) {
		
		TV1 myTV = new TV1("LG", 2017, 32); //LG에서 만든 2017년 32인치
		myTV.show();
		// LG에서 만든 2017년형 32인치 TV

	}

}
