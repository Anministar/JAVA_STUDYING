package CH21;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class C01Writer {

	public static void main(String[] args) throws IOException {
		
		Writer out = new FileWriter("C:\\iotest\\test.txt", true); //기본은 false == 기존내용 버려지고 새로 쓰기(덮어쓰기), true == 추가하기(내용 추가)
		out.write("apple\n");
		out.write("pineapple\n");
		out.write("watermelon\n");
		
//		out.write("오늘점심\n"); //이대로 적으면 덮어쓰기가 됨.
//		out.write("국밥\n");
//		out.write("돈까스\n");
		
		out.flush();  // 버퍼 초기화
		out.close();  // 스트림 제거
		
		
		
		
	}

}
