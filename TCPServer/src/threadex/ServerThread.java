package threadex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import impl.HandlerServerExceptionConsumer;
import interfaces.HandlerExceptionConsumer;

public class ServerThread extends Thread {

	Socket socket;
	List<Client> list; // 접속한 또 다른 클라이언트들의 목록
	Set<String> roomNameSet;
	
	HandlerServerExceptionConsumer consumer = new HandlerServerExceptionConsumer();
	
	public ServerThread(Socket socket, List<Client> list, Set<String> roomNameSet) {
		super();
		this.socket = socket;
		this.list = list;
		this.roomNameSet = roomNameSet;
	}


	@Override
	public void run(){
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
					
					/* 1. 람다 함수형 인터페이스 accept 함수 바로 구현하여 사용
					HandlerExceptionConsumer<Socket, String> consumer = (socket, msg) -> {
						PrintWriter writer = new PrintWriter(socket.getOutputStream());
						System.out.println(">>>>>" + msg);
						writer.println(msg);
						writer.flush();
					};*/
					
					
					// 2. 인터페이스 구현체 이용하여 람다식 try-catch 처리
					list.forEach(c -> {
						Socket s = c.getSocket();
						if(s == socket) {
							c.setId(id);
						}
						
						consumer.accept(s, str);
					});
					
					/* 3. 기존 for문 사용하여 구현
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
					*/
				}
				// 채팅방 입장 처리
				else if(str.startsWith("enter")) {
					// [enter/방이름/사용자1/사용자2/---]
					String[] infos = str.split("/");
					
					// 방 제목 중복 처리
					if(!roomNameSet.add(infos[1])) {
						System.out.println("[roomNameSet]:" + roomNameSet.toString());

						String msg = "Duplicated Room Name:" + "[" + infos[1] + "]";
						consumer.accept(socket, msg);
						continue;
					}
					
					// 각 클라이언트 채팅방 목록에 이름 추가
					list.forEach(c -> c.getRoomList().add(infos[1]));
					
					List<String> userList = Arrays.asList(Arrays.copyOfRange(infos, 2, infos.length));
					userList.forEach(user -> {
						list.stream().filter(c -> c.getId().equals(user)).findFirst().ifPresent(u -> consumer.accept(u.getSocket(), str));
					});
					
					/*
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
						
					}*/
					
				}
				// 채팅방 메시지 처리
				else if(str.startsWith("roomMsg")) {
					String[] info = str.split("/");
					
					String roomName = info[1];
					// String id = info[2];
					// String msg = info[3];

					/* 1. for문 사용
					for(Client c : list) {
						Socket s = c.getSocket();
						List<String> list = c.getRoomList();
						if(socket != s && list.contains(roomName)) { // 자기 자신은 제외 + 채팅방 리스트에 해당 채팅방이름 가지고 있으면
							System.out.println("send room message : " + c.getId() + "," + str);
							PrintWriter writer = new PrintWriter(s.getOutputStream()); 
							writer.println(str);
							writer.flush();
						}
					}*/

					// 2. 람다 및 스트림 사용
					list.stream()
							.filter(c -> socket != c.getSocket() && c.getRoomList().contains(roomName))
							.forEach(client -> consumer.accept(client.getSocket(), str));
					
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
					/* 1. for문
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
					}*/

					// 2. 람다, 스트림 사용

					// 본인 채팅방 목록에서 삭제
					list.stream().filter(client -> socket == client.getSocket()).findAny().ifPresent(client -> client.getRoomList().remove(roomName));

					// 해당 채팅방에 속해있었던 유저들에게 exit 메시지 전송
					list.stream().filter(client -> client.getRoomList().contains(roomName)).forEach(c -> consumer.accept(c.getSocket(), str));

				}
				// 로비에서 나가기 처리
				else if(str.startsWith("mainExit")) {
					
					// System.out.println("mainExit>>>>" + str.split("/")[1]);
					/*
					for(Client c : list) {
						Socket s = c.getSocket();

						if(s != socket) {
							PrintWriter writer = new PrintWriter(s.getOutputStream());
							writer.println(str);
							writer.flush();
						}
					}
					*/

					list.stream().filter(c-> c.getSocket() != socket).forEach(client -> consumer.accept(client.getSocket(), str));

				}
				else {
					/*
					for(Client c : list) {
						Socket s = c.getSocket();
						if(socket != s) { // 자기 자신은 제외
							PrintWriter writer = new PrintWriter(s.getOutputStream()); 
							writer.println(str);
							writer.flush();
						}
					}
					*/

					list.stream().filter(c -> c.getSocket() != socket).forEach(client -> consumer.accept(client.getSocket(), str));
					
				}
				
				Thread.sleep(300);
			
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("클라이언트 ip = " + socket.getInetAddress() + " is out.");

			/*
			for(Client c : list) {
				if(c.getSocket() == socket) {
					list.remove(c);
					break;
				}
			}
			*/

			list.stream().filter(client -> socket == client.getSocket()).findAny().ifPresent(c -> list.remove(c));
			
			/*
			for(Client c : list) {
				Socket s = c.getSocket();
				System.out.println("접속 되어 있는 IP : " + s.getInetAddress() + ", port 번호 : " + s.getPort());
			}
			*/

			// 접속 상태인 클라이언트 출력
			list.forEach(c -> System.out.println("접속 되어 있는 IP : " + c.getSocket().getInetAddress() + ", port 번호 : " + c.getSocket().getPort()));
			
			try {
				socket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} 
		
	}
	
}
