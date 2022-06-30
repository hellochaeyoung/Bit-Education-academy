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

	public void send(String msg) {

		try {
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			pw.println(msg);
			pw.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void sendMessage() {

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

		send(msg);
	}
	
	public void sendUserJoinMessage(String name) {

		String msg = "userInfo/" + name;
		System.out.println("WriteClass sendUserJoinMessage : " + msg + "@@@@");

		send(msg);
	}
	
	// 채팅방 입장 메시지 전송 메소드
	public void sendEnterChattingRoomMessage(String userNames) {
		send(userNames);
	}
	
	// 채팅방 메시지 전송 메소드
	public void sendRoomChattingMessage(String roomName, String id, String msg) {

		sb = new StringBuilder();
		sb.append("roomMsg/").append(roomName).append("/").append(id).append("/").append(msg);

		send(sb.toString());
	}
	
	// 채팅방 퇴장 메시지 전송 메소드
	public void sendExitChattingRoomMessage(String roomName, int size) {

		String id = IdFrame.tf.getText();

		sb = new StringBuilder();
		sb.append("roomExit/").append(roomName).append("/").append(id);

		if(size == 0) {
			sb.append("/end");
		}

		send(sb.toString());

	}
	
	// 로비 퇴장 메시지 전송 메소드
	public void sendExitMainMessage() {

		String id = IdFrame.tf.getText();

		sb = new StringBuilder();
		sb.append("mainExit/").append(id);

		send(sb.toString());
		
	}
}
