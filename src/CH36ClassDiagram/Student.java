package CH36ClassDiagram;

import java.util.ArrayList;
import java.util.List;
public class Student extends Person	{

	private Long studentID;
	private String major;
	private List<Lecture> subjectList;
	
	public Student(
			String name, 
			int age, 
			String address,
			Long ID,
			String major
			) {
		super(name, age, address);
		this.studentID = ID;
		this.major = major;
		this.subjectList = new ArrayList();
	}
	
	public void study() {}
	public void addSubject(Lecture lec) {
		subjectList.add(lec);		//subjectList Lecture 추가
		lec.addStudent(this);		// Lecture에 student 추가
	}

	@Override
	public String toString() {
		return "[studentID=" + studentID + "]";
	}
	//toString()을 재정의할 때 ArrayList()를 넣으면 오류가 발생함.

	
	
	
}
