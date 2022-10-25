package CH21;

import java.io.FileInputStream;
import java.io.InputStream;

public class C05FileInputStream {

	public static void main(String[] args) throws Exception{
		InputStream in = new FileInputStream("c:\\iotest\\test.exe");
		
		while(true) {
			int data = in.read();
			if(data == -1) {
				break;
			}
			System.out.println((char)data + " "); // write할 때는 a,b,c 였지만 받을 때는 int data, int로 받았기 때문에 형 변환을 해줌.
		}
		
		
		
	}

}
