package threadex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ServerThread extends Thread {

	Socket socket;
	List<Client> list; // 접속한 또 다른 클라이언트들의 목록
	Set<String> roomNameSet;
	
	public ServerThread(Socket socket, List<Client> list, Set<String> roomNameSet) {
		super();
		this.socket = socket;
		this.list = list;
		this.roomNameSet = roomNameSet;
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
				
				// 사용자 접속 리스트 처리
				if(str.startsWith("userInfo")) {
					String id = str.split("/")[1];
					for(Client c : list) {
						if(c.getSocket() == socket) {
							c.setId(id);
						}
						
						Socket s = c.getSocket();
						PrintWriter writer = new PrintWriter(s.getOutputStream()); 
						System.out.println(">>>>>" + str);
						writer.println(str);
						writer.flush();
						
					}
					
				}
				// 채팅방 입장 처리
				else if(str.startsWith("enter")) {
					// [enter/방이름/사용자1/사용자2/---]
					String[] infos = str.split("/");
					
					if(!roomNameSet.add(infos[1])) {
						System.out.println("[roomNameSet]:" + roomNameSet.toString());
						PrintWriter writer = new PrintWriter(socket.getOutputStream());
						writer.println("Duplicated Room Name:" + "[" + infos[1] + "]");
						writer.flush();
						continue;
					}
					
					for(int i=2;i<infos.length;i++) {
						for(Client c : list) {
							
							c.getRoomList().add(infos[1]); // 각 클라이언트 채팅방 리스트에 채팅방 이름 추가
							
							// 선택한 유저들 이름으로 비교해 각 유저들의 소켓으로 입장 메시지를 보냄 -> 클라이언트는 메시지 수신 후 채팅방 생성	
							if(c.getId().equals(infos[i])) {
								
								PrintWriter writer = new PrintWriter(c.getSocket().getOutputStream()); 
								writer.println(str);
								writer.flush();
								
								break;
							}
						}
					}
					
				}
				// 채팅방 메시지 처리
				else if(str.startsWith("roomMsg")) {
					String[] info = str.split("/");
					
					String roomName = info[1];
					String id = info[2];
					String msg = info[3];
					
					for(Client c : list) {
						Socket s = c.getSocket();
						List<String> list = c.getRoomList();
						if(socket != s && list.contains(roomName)) { // 자기 자신은 제외 + 채팅방 리스트에 해당 채팅방이름 가지고 있으면
							System.out.println("send room message : " + c.getId() + "," + str);
							PrintWriter writer = new PrintWriter(s.getOutputStream()); 
							writer.println(str);
							writer.flush();
						}
					}
				}
				// 채팅방 나가기 처리
				else if(str.startsWith("roomExit")) {
					String[] info = str.split("/");
					
					String roomName = info[1];
					String id = info[2];
					
					// 채팅방의 모든 사용자가 나갔을 경우
					if(info.length > 3) {
						roomNameSet.remove(roomName);
					}
					
					for(Client c : list) {
						Socket s = c.getSocket();
						List<String> list = c.getRoomList();
						
						if(socket == s) {
							// 내 채팅방 목록에서 삭제
							c.getRoomList().remove(roomName);
						}
						
						// 채팅방 리스트에 해당 채팅방이름 가지고 있으면 exit 메시지 전송
						if(list.contains(roomName)) { 
							PrintWriter writer = new PrintWriter(s.getOutputStream()); 
							writer.println(str);
							writer.flush();
						}
					}
				}
				// 로비에서 나가기 처리
				else if(str.startsWith("mainExit")) {
					
					// System.out.println("mainExit>>>>" + str.split("/")[1]);
					for(Client c : list) {
						Socket s = c.getSocket();
						
						if(s != socket) {
							PrintWriter writer = new PrintWriter(s.getOutputStream()); 
							writer.println(str);
							writer.flush();
						}
					}
				}
				else {
					for(Client c : list) {
						Socket s = c.getSocket();
						if(socket != s) { // 자기 자신은 제외
							PrintWriter writer = new PrintWriter(s.getOutputStream()); 
							writer.println(str);
							writer.flush();
						}
					}
					
				}
				
				Thread.sleep(300);
			
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("클라이언트 ip = " + socket.getInetAddress() + " is out.");
			for(Client c : list) {
				if(c.getSocket() == socket) {
					list.remove(c);
					break;
				}
			}
			
			// 접속 상태인 클라이언트 출력
			for(Client c : list) {
				Socket s = c.getSocket();
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
