package CH21;


import java.io.FileReader;
import java.io.Reader;

public class C02Reader {

	public static void main(String[] args) throws Exception {
		
		Reader in = new FileReader("c:\\iotest\\test.txt"); //해당 위치에서 프로그램 방향으로 받아짐.
		System.out.println(in);
		while(true) {
			int data = in.read();
			if(data == -1) { //읽을게 없을 때 -1이 나오는데 -1이 된다면 무한루프를 빠져나오겠다.
				break;
			}
			System.out.print((char)data); // 유니코드의 값의 char 형변환을 해줌.
			
		}
		
		

	}

}
