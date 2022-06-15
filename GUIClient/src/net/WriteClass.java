package net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import view.ClientFrame;
import view.IdFrame;

public class WriteClass {

	Socket socket;
	ClientFrame cf;
	
	StringBuilder sb;
	//String id = "";
	
	public WriteClass(Socket socket, ClientFrame cf) {
		super();
		this.socket = socket;
		this.cf = cf;
		
	}
	
	public void sendMessage() {
		
		try {
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			
			String msg = "";
			String id = IdFrame.tf.getText();
			
			// 첫 번째 전송
			if(cf.isFirst) {
				InetAddress iaddr = socket.getLocalAddress();
				String ip = iaddr.getHostAddress(); // 첫 번째 전송일 땐 ip를 보낸다.
				
				msg = "userInfo/" + id;
				System.out.println("WriteClass>>>" + msg);
				
				
			}
			// 그 외 전송
			else {
				msg = "[" + id + "]" + cf.textF.getText();
			}
			
			// server로 전송
			pw.println(msg);
			pw.flush();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendUserJoinMessage(String name) {
		
		try {
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			
			String msg = "userInfo/" + name;
			System.out.println("WriteClass sendUserJoinMessage : " + msg + "@@@@");
			
			// server로 전송
			pw.println(msg);
			pw.flush();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 채팅방 입장 메시지 전송 메소드
	public void sendEnterChattingRoomMessage(String userNames) {
		
		try {
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			
			// server로 전송
			pw.println(userNames);
			pw.flush();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 채팅방 메시지 전송 메소드
	public void sendRoomChattingMessage(String roomName, String id, String msg) {
		
		try {
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			
			// String id = IdFrame.tf.getText();
			
			sb = new StringBuilder();
			sb.append("roomMsg/").append(roomName + "/").append(id + "/").append(msg);
			
			// server로 전송
			pw.println(sb.toString());
			pw.flush();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 채팅방 퇴장 메시지 전송 메소드
	public void sendExitChattingRoomMessage(String roomName, int size) {
		
		try {
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			
			String id = IdFrame.tf.getText();
			
			sb = new StringBuilder();
			sb.append("roomExit/").append(roomName + "/").append(id);
			
			if(size == 0) {
				sb.append("/end");
			}
			
			// server로 전송
			pw.println(sb.toString());
			pw.flush();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 로비 퇴장 메시지 전송 메소드
	public void sendExitMainMessage() {
		
		try {
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			
			String id = IdFrame.tf.getText();
			
			sb = new StringBuilder();
			sb.append("mainExit/").append(id);
			
			// server로 전송
			pw.println(sb.toString());
			pw.flush();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
