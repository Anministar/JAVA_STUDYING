package CH27;

import java.io.DataInputStream;
import java.net.Socket;

public class ClientRecvThread implements Runnable {


	
	Socket client;			//수신작업을 위한 참조변수, 클라이언트 정보를 담기 위해서 있음
	DataInputStream Din;	//수신작업을 위한 스트림
	
	public ClientRecvThread(Socket client) {
		this.client = client;
	}
	
	@Override
	public void run() {
		try {
			Din = new DataInputStream(client.getInputStream()); // 보조스트림 생성해서 Din에 담아줌.
			String recv;
			while(true) {
				recv = Din.readUTF(); //클라이언트의 전달 메시지를 수신
				if(recv == null || recv.equals("q")) {
					System.out.println("프로그램을 종료합니다");
					System.exit(-1);
				}
				System.out.println("\r[Client] : " + recv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void main(String[] args) {


	}

}
