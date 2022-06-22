package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import net.WriteClass;

// 채팅 Form, 전체 채팅 화면
public class ClientFrame extends JFrame implements WindowListener, ActionListener {
	
	public Socket socket;
	public WriteClass wc;
	
	public JTextField textF = new JTextField(14); // 전체 채팅 메시지 입력 창
	public JTextArea textA = new JTextArea(); // 전체 채팅 메시지 목록
	
	// 사용자 전체 목록
	public JPanel listPanel = new JPanel();
	public JScrollPane scrPane2 = new JScrollPane(listPanel);
	
	public JTextField roomNameTextField = new JTextField(10); // 채팅방 이름 입력 창
	JButton makeRoomButton = new JButton("방만들기");
	
	JButton btnTransfer = new JButton("전송");
	JButton btnExit = new JButton("나가기");
	
	JPanel panel = new JPanel();
	
	public boolean isFirst = true; // 첫 번째 전송
	
	public List<JCheckBox> checkList = new ArrayList<>();
	
	public ClientFrame(Socket socket) {
		super("chatting");
		
		this.socket = socket;
		
		wc = new WriteClass(socket, this);
		
		new IdFrame(this, wc); //////////
		
		JScrollPane scrPane = new JScrollPane(textA);
		scrPane.setPreferredSize(new Dimension(200, 120));
		
		add("Center", scrPane);
		
		panel.add(textF);
		panel.add(btnTransfer);
		panel.add(roomNameTextField);
		panel.add(makeRoomButton);
		panel.add(btnExit);
		
		add("South", panel);
		
		scrPane2.setPreferredSize(new Dimension(200, 120));
		
		add("East", scrPane2);
			
		btnTransfer.addActionListener(this);
		makeRoomButton.addActionListener(this);
		btnExit.addActionListener(this);
		
		setBounds(200, 200, 700, 600);
		
		setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		if(obj == btnTransfer || obj == textF) {
			if(textF.getText().trim().equals("")) return;
			
			String id = IdFrame.tf.getText();
			
			textA.append("[" + id + "]" + textF.getText() + "\n");
			
			// server 전송
			wc.sendMessage();
			
			textF.setText("");
			
		}
		else if(obj == makeRoomButton) {
			
			// 채팅하고자 선택한 유저들 확인
			
			StringBuilder sb = new StringBuilder("enter/" + roomNameTextField.getText() + "/");

			/*
			for(JCheckBox box : checkList) {
				if(box.isSelected()) {
					sb.append(box.getText()).append("/");
				}
			}
			*/

			checkList.stream().filter(JCheckBox::isSelected).forEach(b -> sb.append(b.getText()).append("/"));
			
			// server 전송
			wc.sendEnterChattingRoomMessage(sb.toString());
			
			roomNameTextField.setText("");
			
			// 체크 해제
			/*
			for(JCheckBox box : checkList) {
				box.setSelected(false);
			}
			*/
			checkList.forEach(box -> box.setSelected(false));
			
		}
		else if(obj == btnExit) {
			
			wc.sendExitMainMessage();
			
			System.exit(0);
		}
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
