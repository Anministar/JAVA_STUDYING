package CH22;
// 보조스트림 사용방법
// 보조스트림 변수 = new 보조스트림(연결스트림)

//InputStreamReader  : 바이트스트림 -> 문자입력스트림(reader로변환)
//outputStreamWriter : 바이트스트림 -> 문자출력스트림(Writer로변환)
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class C01CharacterConvertStreamExample {
	public static void main(String[] args) throws Exception {
		String str = "문자 변환 스트림 사용";
		FileOutputStream fos = new FileOutputStream("C:/Temp/test1.txt");
//		fos.write(str); // @ 기본 스트림은 Byte단위로 처리됨. 그래서 문자형 스트림인 fos는 str을 받을 수 없음. (? 맞나? 찾아보기)
		Writer writer = new OutputStreamWriter(fos);	//문자전송 보조스트림 (스트림->문자형변환) @ 1Byte단위를 2Byte단위로 바꿔주는것.
		writer.write(str);
		writer.flush();
		writer.close();
		
		
		FileInputStream fis = new FileInputStream("C:/Temp/test1.txt");
		Reader reader = new InputStreamReader(fis);		
		char[] buffer = new char[100];
		while(true)
		{
			int readCharNum = reader.read(buffer);	//버퍼공간까지 한번에 읽고 읽은 바이트 수를 반환
			if(readCharNum==-1)
				break;
			System.out.println(buffer);
		}
		reader.close();
	}
}
