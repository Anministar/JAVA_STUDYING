package CH21;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class C08Jsoup {

	public static void main(String[] args) throws Exception {

		// URL과 연결된 Jsoup.connection
//		Connection conn = Jsoup.connect("https://www.naver.com");
		Connection conn = Jsoup.connect("https://www.daum.net/");

		System.out.println(conn);

		// DOM객체를 꺼내와 저장
		Document document = conn.get(); // get의 설명보면 Document의 클래스에서 가져옴.
		System.out.println(document);

		// DOM객체 안에서 img태그요소만 추출
		Elements elements = document.getElementsByTag("img"); //태그요소를 찾아내는것.
//		System.out.println(elements); //img태그 출력
		
		
		// DOM 객체는 페이지의 정보를 저장하고 있음 객체임.
		// 그래서 DOM객체에서 정보를 받아와서 이미지태그를 가져와서 elements에 저장.
		
		

		for (int i = 0; i < elements.size(); i++) { //하나씩 접근해서

			if (elements.get(i).toString().contains("https")) { //https를 포함하는 걸 찾아서

				/// " "을 기준으로 요소 안의 내용을 문자열로 바꾼 뒤 잘라내기
				String str[] = elements.get(i).toString().split(" "); // " " 기준으로 자름.
//			System.out.println(str[1]); // 0, 1, 2, 등의 숫자 넣어보기

				int start = str[1].indexOf("\"");  
				int end = str[1].lastIndexOf("\""); // 앞뒤가 "이걸로 끝나는 애들을 찾아내기위한 코드
				String imgUrl = str[1].substring(start + 1, end);  //이미지 url을 잘라서 넣어줌.
				System.out.println("https:\\" + imgUrl); // @ 일단 https:\\을 넣었는데 아닐 수도 있음.
				

				// URL연결
				URL url = new URL(imgUrl);
				InputStream in = url.openStream();
				BufferedInputStream bin = new BufferedInputStream(in);
				String filename = "ImageFile";
				OutputStream out = new FileOutputStream("c:\\iotest\\" + filename + i + ".png");
				int data = 0;
				while (true) {
					data = bin.read();
					if (data == -1) {
						break;
					}
					out.write(data);
					out.flush();
				}
			}
		}

	}

}
