package CH25;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class C01Server {

	public static void main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(5050); // 192.168.5.200 : 5050, Server 객체를 만듦, 포트번호는 5050
		System.out.println("Server Start!!..");
		
		
		while(true) {
			
		
		Socket client = server.accept(); // Client가 서버를 받음.
		
		System.out.println(client.getInetAddress() + " 에서 접속하셨습니다.");
		OutputStream out = client.getOutputStream(); // Server에서 어떤 메세지를 전달하기 위해서 outputStream()사용
		DataOutputStream Dout = new DataOutputStream(out);
		Dout.writeUTF("Server 접속이 확인되었습니다.");
		Dout.flush();
		client.close();
		}
		
		
	}

}
