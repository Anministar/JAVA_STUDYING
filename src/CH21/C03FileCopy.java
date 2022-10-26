package CH21;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class C03FileCopy {

	public static void main(String[] args) throws Exception {
		Reader in = new FileReader("C:" + File.separator + "iotest" + File.separator + "original.txt"); // 원본 @ File.separator == 구분자 코드 == \\ 이거랑 동일하다고 보면 됨.
		Writer out = new FileWriter("C:\\iotest\\copyfile.txt");										// 복사본
		
		char buff[] = new char[200];
		
		while(true) { 
			int cnt = in.read(buff); //buff 크기만큼 읽어서 buff에 저장 한 뒤 읽은 개수를 cnt에 전달
									 //읽어야하는 개수가 442개라면 read() 라는 메소드 자체가 이미 0-441까지 읽어라는거고 결국에는 배열의 크기때문에 200까지 읽고
									 //내려가서 코드들을 실행 그리고 다시 올라와서 반복인데 cnt == -1 그러니깐 읽을게 없을 때까지 이걸 반복한다는거임.
			if (cnt == -1) { // 읽을게 없으면 -1 반환, 그래서 cnt가 -1이 되면 무한루프 종료
				break;
			}
			System.out.println("CNT : " + cnt);
			out.write(buff, 0, cnt); //배열 전달하면 배열을 그대로 전달 @ 0부터 cnt까지
			out.flush(); // 남아있는 스트림 버퍼 공간 제거
		}
		in.close();
		out.close();
	}

}
