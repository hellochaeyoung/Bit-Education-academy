package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JCheckBox;

import view.ChattingRoomFrame;
import view.ClientFrame;
import view.IdFrame;
import view.PopUpFrame;

public class ReadThread extends Thread {

	Socket socket;
	ClientFrame cf;
	Set<String> userSet;
	
	List<ChattingRoomFrame> roomFrameList = new ArrayList<>();
	
	ChattingRoomFrame rf;
	
	public ReadThread(Socket socket, ClientFrame cf, Set<String> userSet) {
		this.socket = socket;
		this.cf = cf;
		this.userSet = userSet;
	}

	@Override
	public void run() {
		super.run();
		
		try {
			// 메시지가 언제 올지 모르기 때문에 항상 수신하려 대기
			while(true) {
				
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				String str = br.readLine();
				
				if(str == null) {
					continue;
				}
				
				
				if(str.startsWith("userInfo") ) {
					
					// ClientFrame - userList 목록에 사용자 추가
					String user = str.split("/")[1];
					
					System.out.println("userInfo : " + str);
					if(userSet.add(user)) {
						System.out.println(IdFrame.tf.getText() + "의 유저 목록 : " + userSet.toString());
						JCheckBox checkBox = new JCheckBox(user, false); 
						
						cf.listPanel.add(checkBox);
						cf.checkList.add(checkBox);
						
						// 메시지 또 보내기
						cf.wc.sendUserJoinMessage(IdFrame.tf.getText());
					}
					
				}
				else if(str.startsWith("Duplicated")) {
					
					new PopUpFrame(str);
					
				}
				else if(str.startsWith("enter")) {
					String[] infos = str.split("/");
					
					String roomName = infos[1];
					
					StringBuilder sb = new StringBuilder();
					for(int i=2;i<infos.length;i++) {
						sb.append(infos[i]).append(",");
					}
					
					String totalName = sb.toString();
					totalName = totalName.substring(0, totalName.length()-1);
					
					// 채팅방 생성
					rf = new ChattingRoomFrame(roomName, cf.wc, totalName);
					
					// 사용자 당 채팅방 목록에 추가
					roomFrameList.add(rf);
					
				}
				else if(str.startsWith("roomMsg")) {
					
					String[] infos = str.split("/");
					
					String room = infos[1];
					String id = infos[2];
					String msg = infos[3];
					
					System.out.println(">>>ReadThread, roomMsg, id, msg " + id + "," + msg);

					/*
					for(ChattingRoomFrame rf : roomFrameList) {
						if(rf.name.equals(room)) {
							rf.msgTextArea.append("[" + id + "]" + msg + "\n");
						}
					}
					*/
					roomFrameList.stream().filter(rf -> rf.name.equals(room)).forEach(rf -> rf.msgTextArea.append("[" + id + "]" + msg + "\n"));
					
				}
				else if(str.startsWith("roomExit")) {
					
					String[] infos = str.split("/");
					
					String room = infos[1];
					String id = infos[2];
					/*
					for(ChattingRoomFrame rf : roomFrameList) {
						if(rf.name.equals(room)) {
							rf.msgTextArea.append("[" + id + "]" + " is exit." + "\n");
							roomFrameList.remove(rf);
							break;
						}
					}*/

					roomFrameList.stream().filter(rf -> rf.name.equals(room)).findAny().ifPresent(rf -> {
						rf.msgTextArea.append("[" + id + "]" + " is exit." + "\n");
						roomFrameList.remove(rf);
					});
					
				}
				else if(str.startsWith("mainExit")) {
					
					String id = str.split("/")[1];
					
					cf.textA.append("[" + id + "]" + " is exit." + "\n");

					/*
					for(JCheckBox box : cf.checkList) {
						if(box.getText().equals(id)) {
							userSet.remove(box.getText());
							cf.checkList.remove(box);
							cf.listPanel.remove(box);
							
							break;
						}
					}
					*/

					cf.checkList.stream().filter(box -> box.getText().equals(id)).findAny().ifPresent(box -> {
						userSet.remove(box.getText());
						cf.checkList.remove(box);
						cf.listPanel.remove(box);
					});

				}
				else {
					cf.textA.append(str + "\n");
				}
				
				cf.listPanel.validate();
				cf.listPanel.repaint();
				
				Thread.sleep(300);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
