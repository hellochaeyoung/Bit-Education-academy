package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Set;

import javax.swing.JCheckBox;

import view.ClientFrame;

public class RoomChattingReadThread extends Thread {

	Socket socket;
	ClientFrame cf;
	Set<String> userSet;

	public RoomChattingReadThread(Socket socket, ClientFrame cf, Set<String> userSet) {
		super();
		this.socket = socket;
		this.cf = cf;
		this.userSet = userSet;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		try {
			
			while(true) {
				
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				String str = br.readLine();
				System.out.println("UserReadThread>>>>" + str);
				
				if(str == null) {
					System.out.println("접속 끊김");
				}
				
				if(str.startsWith("userInfo/")) {
					String user = str.split("/")[1];
					
					// ClientFrame - userList 목록에 사용자 추가
					if(userSet.add(user)) {
						cf.listPanel.add(new JCheckBox(user, false));
						
						// 메시지 또 보내기
						cf.wc.sendUserJoinMessage(user);
					}
				}
				
				cf.listPanel.validate();
				
				Thread.sleep(300);
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
