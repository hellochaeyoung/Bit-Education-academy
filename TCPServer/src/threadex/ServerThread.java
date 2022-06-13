package threadex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class ServerThread extends Thread {

	Socket socket;
	List<Socket> list; // 접속한 또 다른 클라이언트들의 목록
	
	
	public ServerThread(Socket socket, List<Socket> list) {
		super();
		this.socket = socket;
		this.list = list;
	}


	@Override
	public void run() {
		super.run();
		
		try {
			
			while(true) {
				
				// 수신(receive) 
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
				String str = reader.readLine();
			
				System.out.println("client로부터 받은 메시지 : " + str);
				
			
				// 송신(send)
				for(Socket s : list) {
					if(socket != s) { // 자기 자신은 제외
						PrintWriter writer = new PrintWriter(s.getOutputStream()); 
						writer.println(str);
						writer.flush();
					}
					
				}
				
				Thread.sleep(300);
			
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("클라이언트 ip = " + socket.getInetAddress() + " is out.");
			list.remove(socket);
			
			// 접속 상태인 클라이언트 출력
			for(Socket s : list) {
				System.out.println("접속 되어 있는 IP : " + s.getInetAddress() + ", port 번호 : " + s.getPort());
			}
			
			try {
				socket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} 
		
	}
	
	
	
	
}
