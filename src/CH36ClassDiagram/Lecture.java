package CH36ClassDiagram;

import java.util.ArrayList;
import java.util.List;

public class Lecture {
	private long LectureID;
	private String LectureName;
	private List<Student> studentList;
	
	// Student와 Subject는 다 대 다 관계이기 때문에 중간에 관계 테이블을 만들어도 Okay, But 여기서는 만들지 않음
	
	public Lecture(long lectureID, String lectureName) {
		super();
		LectureID = lectureID;
		LectureName = lectureName;
		this.studentList = new ArrayList();
	}
	
	public void addStudent(Student std) {
		// 학생을 studentList에 추가
		studentList.add(std);
	}

	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer();
		for (Student std : studentList) {
			buff.append(std);
		}
		return
				"[과목ID : " + LectureID + "\t|과목명 : " + LectureName + "\t|수강신청 학생 : " + buff + "]";
	}

	
}
