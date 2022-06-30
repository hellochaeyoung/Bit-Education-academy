import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import threadex.ReadThread;

public class MainClass {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 1. 접속 해야 할 Server IP(주소)를 설정 -> Socket
		InetSocketAddress sockAddr = new InetSocketAddress("192.168.0.12", 9000); // 이 포트번호는 프로세스가 아닌 소켓을 구분하기 위한 포트번호!!
		
		// 2. Socket 생성
		Socket socket = new Socket();
		
		// 3. Connect
		try {
			socket.connect(sockAddr, 10000);
			
			InetAddress inetAddr;
			if((inetAddr = socket.getInetAddress()) != null) {
				System.out.println("서버 접속 성공!");
			}else {
				System.out.println("서버 접속 실패~");
			}
			
			new ReadThread(socket).start();
			
			while(true) {
				
				// 4. Packet(send, receive) 송수신
				System.out.println("[보낼 메시지]:");
				String str = sc.next();
				
				// 송신(send) 
				PrintWriter writer = new PrintWriter(socket.getOutputStream()); 
				writer.println(str);
				writer.flush();
				/*			
				// 수신(receive) 
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
				str = reader.readLine();
				System.out.println("server로부터 받은 메시지 : " + str);
				*/
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
