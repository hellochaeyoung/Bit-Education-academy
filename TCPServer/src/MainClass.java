import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import threadex.Client;
import threadex.ServerThread;

public class MainClass {

	public static void main(String[] args) {

		/*
		 * TCP : Transmission Control Protocol
		 * 
		 * Server : TCP, Web(tomcat), Database
		 * 
		 * 네트워크 : 클라이언트 끼리 통신하는 것인데 중간에서 서버가 통신되도록 처리함
		 * 
		 * 종단 시스템 : host pc, smart phone, Scanner, Printer
		 * 
		 * 라우터 : 호스트 - 인터넷을 이어주기 위한 중간 매개체, hardware host 간에 상호 데이터를 교환할 수 있도록 하는 장비
		 * 
		 * Inter Network : 포괄적인 통신망
		 * 
		 * 통신규약 TCP - Transmission Control Protocol 동기 통신 UDP - User Datagram Protocol
		 * 비동기 통신
		 * 
		 * 7 Layer 1계층 - Physical Layer 물리계층 2계층 - Data Link Layer 주소를 헤더에 첨부 3계층 -
		 * Network Layer 네트워크 IP -> Address 4계층 - Transport Layer 네트워크 Port 5계층 -
		 * Session Layer 6계층 - Presentation Layer 보안, 압축, 확장 7계층 - Application Layer
		 * 프로그램
		 * 
		 * TCP 신사적인 Protocol (신뢰할 수 있는 규약) 전화 -> 상대방 -> 연결 -> 통신 start 동기화 : send ->
		 * receive 처리 순서가 맞아야 한다. ( 한쪽은 보내야하고 한쪽은 받아야함) 데이터의 경계가 없다. 용량 제한이 없다 채팅,
		 * object 전송
		 * 
		 * 
		 * UDP 비연결형 프로토콜 편지, 지상파 방송 : 일단 전송하고 수신 여부에 대해 체크하지 않음 데이터의 경계가 있다. -> 용량의 제한이
		 * 있다 1 대 1 (unicast) 1 대 다 (broadcast) 다 대 다 (multicast)
		 * 
		 * Packet(묶음) 제어 정보, 데이터(문자열, object) 결합된 형태로 전송 IP, Port, String :
		 * 
		 * IP : Internet Protocol => 주소
		 * 
		 * IPv4 : xxx.xxx.xxx.xxx -> 0 ~ 255 IPv6 : xxx.xxx.xxx.xxx.xxx.xxx
		 * 
		 * 127.0.0.1 -> 자기 자신의 접속 주소
		 * 
		 * Port Number IP 주소는 인터넷에 존재하는 host(PC)를 식별할 수 있으나 최종 주체인 프로세스(프로그램)를 식별하지 못하기
		 * 때문에 프로세스를 구별하기 위해서 지정된 수치(0 ~ 1024) 외의 숫자를 지정한다.
		 * 
		 * Socket (IP TCP/UDP 정보를 가짐) 통신의 주체, 통신을 하기 위한 오브젝트
		 * 
		 * 통신 순서 Server Client 1. Socket 버전 확인 1. Socket 버전 확인 2. Binding -> IP, Port 3.
		 * Listener 4. Accept <--------------- 2. Connect 1) receive <-------------
		 * send(write) 2) send -------------> receive(read)
		 * 
		 * DNS(Domain Name System) Server
		 * 
		 */

		Socket clientSocket = null;
		
		Client client = null;

		try {

			// 문지기 소켓
			ServerSocket serverSocket = new ServerSocket(9000);
			// 버전 확인, binding, listen
			
			List<Client> list = new ArrayList<>();

			while(true) {
			
				System.out.println("접속 대기중...");
				clientSocket = serverSocket.accept();
				
				list.add(new Client(clientSocket)); // clientSocket 정보를 저장해야함, -> 다른 클라이언트 접속 시 저장해두지 않으면 정보가 없어지기 때문!
	
				// 접속 client 확인
				System.out.println("client IP : " + clientSocket.getInetAddress() + ", Port : " + clientSocket.getPort());
			
				
				/* 스레드가 담당해야 하는 부분
				// 수신(receive) 
				BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 
				String str = reader.readLine();
				System.out.println("client로부터 받은 메시지 : " + str);
				
				
				// 송신(send) 
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream()); 
				writer.println(str);
				writer.flush();
				*/
				
				new ServerThread(clientSocket, list).start();
				
			}
			// clientSocket.close();
			// serverSocket.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
