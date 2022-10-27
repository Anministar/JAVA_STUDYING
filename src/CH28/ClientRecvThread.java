package CH28;

import java.io.DataInputStream;
import java.net.Socket;

public class ClientRecvThread implements Runnable {

	
	Socket client;			//수신작업을 위한 참조변수, 클라이언트 정보를 담기 위해서 있음
	DataInputStream Din;	//수신작업을 위한 스트림
	CGUI gui;				//클라이언트가 주는 내용. 클라이언트한테 전달받은 내용을 ServerUI의 area로 줘야함.
	
	public ClientRecvThread(Socket client, CGUI gui) {
		this.client = client;
		this.gui = gui;
	}
	
	@Override
	public void run() {
		try {
			Din = new DataInputStream(client.getInputStream()); // 보조스트림 생성해서 Din에 담아줌.
			String recv;
			while(true) {
				recv = Din.readUTF(); //클라이언트의 전달 메시지를 수신
				if(recv == null || recv.equals("q")) {
					gui.area.append("서버와 연결을 종료합니다\n");
					System.exit(-1);
				}
//				System.out.println("\r[Client] : " + recv); 이전까지는 콘솔에 출력해줬지만 이제는 Swing에다가 출력해줘야함.
				gui.area.append("[Server] : " + recv + "\n"); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		

	}
}
